/**
 * This version only shows a list of all pokemons
 */

import React from 'react';
import sortBy from 'sort-by';

import { fetchAllPokemons } from '../services/pokeapi';

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
    await this.handlePopulatePokemons();
  }

  async handlePopulatePokemons() {
    try {
      this.setState({ isLoading: true });
      const pokemons = await fetchAllPokemons();
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
    const { image, id, name } = this.props;

    return (
      <div style={{ textAlign: 'center', width: '100px', border: '1px dashed black', margin: '5px', padding: '10px' }}>
        <img src={image}/>
        <p>(#{id}) {name}</p>
      </div>
    );
  }
}

export default App;
