/**
 * This adds sorting of pokemons
 */

import React from 'react';
import sortBy from 'sort-by';
import { capitalize } from 'lodash';

import {
  fetchAllPokemons,
  fetchPokemonsByType,
  fetchPokemonTypes,
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

  render() {
    const {
      isLoadingPokemons,
      pokemons,
      isLoadingTypes,
      types,
      error,
      sortByKey,
    } = this.state;

    const pokemonElements = pokemons
    .slice()
    .sort(sortBy(sortByKey))
    .map((pokemon) => (
      <Pokemon
        key={pokemon.id}
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
    })

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
      </div>
    );
  }
};

class Pokemon extends React.Component {
  render() {
    const { image, id, name, type } = this.props;

    return (
      <div style={{ textAlign: 'center', width: '100px', border: '1px dashed black', margin: '5px', padding: '10px' }}>
        <img src={image}/>
        <p>(#{id}) {name}</p>
        <p>{type}</p>
      </div>
    );
  }
}

export default App;
