/**
 * This adds async fetching of selected pokemon details
 */

import React from 'react';
import sortBy from 'sort-by';
import { capitalize } from 'lodash';

import {
  fetchAllPokemons,
  fetchPokemonsByType,
  fetchPokemonTypes,
  fetchPokemonById,
} from '../services/pokeapi';

class App extends React.Component {
  constructor(props) {
    super(props);

    this.state = {
      isLoadingPokemons: true,
      pokemons: [],
      isLoadingTypes: true,
      types: [],
      error: null,
      sortByKey: 'id',
      selectedPokemonId: undefined,
    };
  }

  async componentDidMount() {
    await this.handlePopulatePokemonTypes();
    await this.handlePopulateAllPokemons();
  }

  async handlePopulatePokemonTypes() {
    try {
      this.setState({ isLoadingTypes: true });
      const types = await fetchPokemonTypes();
      this.setState({ types, isLoadingTypes: false });
    } catch (error) {
      this.setState({ error });
    }
  }

  async handlePopulateAllPokemons() {
    try {
      this.setState({ isLoadingPokemons: true });
      const pokemons = await fetchAllPokemons();
      this.setState({ pokemons, isLoadingPokemons: false });
    } catch (error) {
      this.setState({ error });
    }
  }

  async handlePopulatePokemonsByType(type) {
    try {
      this.setState({ isLoadingPokemons: true });
      const pokemons = await fetchPokemonsByType(type);
      this.setState({ pokemons, isLoadingPokemons: false });
    } catch (error) {
      this.setState({ error });
    }
  }

  handleSort(field, event) {
    event.preventDefault();

    this.setState({
      sortByKey: field
    });
  }

  handleSelectPokemon(id) {
    this.setState({
      selectedPokemonId: id
    });
  }

  render() {
    const {
      isLoadingPokemons,
      pokemons,
      isLoadingTypes,
      types,
      error,
      sortByKey,
      selectedPokemonId,
    } = this.state;

    const pokemonElements = pokemons
    .slice()
    .sort(sortBy(sortByKey))
    .map((pokemon) => (
      <Pokemon
        key={pokemon.id}
        onSelect={this.handleSelectPokemon.bind(this, pokemon.id)}
        {...pokemon}
      />
    ));

    const typeElements = types
    .map((type) => {
      return (
        <button key={type.id} onClick={this.handlePopulatePokemonsByType.bind(this, type.id)}>
          {capitalize(type.name)}
        </button>
      )
    });

    if (error) {
      return (
        <div>Error: {error.message}</div>
      );
    }

    return (
      <div>
        <h1>Pokemon!</h1>
        <div>
          <h3>Sort them:</h3>
          <button onClick={this.handleSort.bind(this, 'name')}>
            Sort by name
          </button>
          <button onClick={this.handleSort.bind(this, 'id')}>
            Sort by id
          </button>
        </div>
        <div>
          {isLoadingTypes ? (
            <div>Loading types...</div>
          ) : (
            <React.Fragment>
              <h3>Filter them:</h3>
              <button onClick={this.handlePopulateAllPokemons.bind(this)}>
                All
              </button>
              {typeElements}
            </React.Fragment>
          )}
        </div>
        <div style={{ display: 'flex', flexWrap: 'wrap' }}>
          {isLoadingPokemons ? (
            <div>Loading pokemons...</div>
          ) : (
            pokemonElements
          )}
        </div>
        {selectedPokemonId && (
          <PokemonDetails
            pokemonId={selectedPokemonId}
            onClose={this.handleSelectPokemon.bind(this, undefined)}
          />
        )}
      </div>
    );
  }
};

class Pokemon extends React.Component {
  render() {
    const {
      image,
      id,
      name,
      type,
      onSelect,
    } = this.props;

    const containerStyles = {
      textAlign: 'center',
      width: '100px',
      border: '1px dashed black',
      margin: '5px',
      padding: '10px'
    };

    return (
      <div onClick={onSelect} style={containerStyles}>
        <img src={image}/>
        <p>(#{id}) {name}</p>
        <p>{type}</p>
      </div>
    );
  }
}

class PokemonDetails extends React.Component {
  constructor(props) {
    super(props);

    this.state = {
      isLoading: true,
      pokemon: undefined,
      error: null,
    };
  }

  async componentDidMount() {
    await this.handlePopulatePokemon();
  }

  async handlePopulatePokemon() {
    const { pokemonId } = this.props;

    try {
      this.setState({ isLoading: true });
      const pokemon = await fetchPokemonById(pokemonId);
      this.setState({ pokemon, isLoading: false });
    } catch (error) {
      this.setState({ error });
    }
  }

  handleClose(event) {
    if (event.target !== event.currentTarget) {
      return;
    }

    const { onClose } = this.props;
    onClose();
  }

  render() {
    const {
      isLoading,
      error,
      pokemon,
    } = this.state;

    const {
      images,
      id,
      name,
    } = pokemon || {};

    const overlayStyles = {
      position: 'fixed',
      left: 0,
      top: 0,
      width: '100vw',
      height: '100vh',
      backgroundColor: 'rgb(0, 0, 0, 0.3)',
    }

    const modalStyles = {
      backgroundColor: 'white',
      borderRadius: '5px',
      maxWidth: '200px',
      height: '300px',
      margin: '0 auto',
      marginTop: '50px',
      padding: '10px',
      textAlign: 'center',
    };

    if (error) {
      return (
        <div>Unable to load pokemon</div>
      );
    }

    if (isLoading) {
      return (
        <div>Loading pokemon...</div>
      );
    }

    return (
      <div onClick={this.handleClose.bind(this)} style={overlayStyles}>
        <div style={modalStyles}>
          {images.map((image) => <img src={image}/>)}
          <p>(#{id}) {name}</p>
          <button onClick={this.handleClose.bind(this)}>Close</button>
        </div>
      </div>
    );
  }
}

export default App;
