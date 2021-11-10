/**
 * Test data only in this version
 */

import React from 'react';
import sortBy from 'sort-by';

import pokemons from '../test-data/pokemons';

class App extends React.Component {
  constructor(props) {
    super(props);

    this.state = {
      pokemons: [...pokemons],
      sortByKey: 'id',
      filterByType: '',
    };
  }

  handleSort(field, event) {
    event.preventDefault();

    this.setState({
      sortByKey: field
    });
  }

  handleFilter(type, event) {
    event.preventDefault();

    this.setState({
      filterByType: type
    });
  }

  render() {
    const {
      pokemons,
      filterByType,
      sortByKey,
    } = this.state;

    const pokemonElements = pokemons
    .slice()
    .filter((pokemon) => filterByType ? pokemon.type === filterByType : true)
    .sort(sortBy(sortByKey))
    .map((pokemon) => (
      <Pokemon
        {...pokemon}
      />
    ));

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
          <button onClick={this.handleFilter.bind(this, '')}>
            All
          </button>
          <button onClick={this.handleFilter.bind(this, 'fire')}>
            Fire
          </button>
          <button onClick={this.handleFilter.bind(this, 'grass')}>
            Grass
          </button>
          <button onClick={this.handleFilter.bind(this, 'bug')}>
            Bug
          </button>
          <button onClick={this.handleFilter.bind(this, 'flying')}>
            Flying
          </button>
          <button onClick={this.handleFilter.bind(this, 'normal')}>
            Normal
          </button>
        </div>
        <div style={{ display: 'flex', flexWrap: 'wrap' }}>
          {pokemonElements}
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
