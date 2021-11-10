/**
 * This adds filtering by type (uses type id - not type name)
 */

import React from 'react';
import sortBy from 'sort-by';

import {
  fetchAllPokemons,
  fetchPokemonsByType,
} from '../services/pokeapi';

class App extends React.Component {
  constructor(props) {
    super(props);

    this.state = {
      isLoading: true,
      error: null,
      pokemons: [],
      sortByKey: 'id',
    };
  }

  async componentDidMount() {
    await this.handlePopulateAllPokemons();
  }

  async handlePopulateAllPokemons() {
    try {
      this.setState({ isLoading: true });
      const pokemons = await fetchAllPokemons();
      this.setState({ pokemons, isLoading: false });
    } catch (error) {
      this.setState({ error });
    }
  }

  async handlePopulatePokemonsByType(type) {
    try {
      this.setState({ isLoading: true });
      const pokemons = await fetchPokemonsByType(type);
      this.setState({ pokemons, isLoading: false });
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
      isLoading,
      error,
      pokemons,
      sortByKey,
    } = this.state;

    const pokemonElements = pokemons
    .slice()
    .sort(sortBy(sortByKey))
    .map((pokemon) => (
      <Pokemon
        {...pokemon}
      />
    ));

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
          <h3>Filter them:</h3>
          <button onClick={this.handlePopulateAllPokemons.bind(this)}>
            All
          </button>
          <button onClick={this.handlePopulatePokemonsByType.bind(this, '10')}>
            Fire
          </button>
          <button onClick={this.handlePopulatePokemonsByType.bind(this, '12')}>
            Grass
          </button>
          <button onClick={this.handlePopulatePokemonsByType.bind(this, '7')}>
            Bug
          </button>
          <button onClick={this.handlePopulatePokemonsByType.bind(this, '3')}>
            Flying
          </button>
          <button onClick={this.handlePopulatePokemonsByType.bind(this, '1')}>
            Normal
          </button>
        </div>
        <div style={{ display: 'flex', flexWrap: 'wrap' }}>
          {isLoading ? (
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
