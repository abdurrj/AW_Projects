import React from "react";

function wait(ms) {
  return new Promise((resolve, reject) => {
    setTimeout(() => {
      resolve();
    }, ms);
  })
}

class App extends React.Component {
  constructor(props) {
    super(props);

    this.state = {
      pokemons: [],
      isLoading: false,
      error: null,
    };
  }

  async populatePokemons() {
    this.setState({
      isLoading: true,
      error: null,
    });

    try {
      await wait(2000);
      //throw Error('Unable to fetch');
      const response = await fetch('https://pokeapi.co/api/v2/pokemon?limit=10');
      const result = await response.json();
      
      this.setState({
        pokemons: result.results,
        isLoading: false
      });
    } catch (error) {
      this.setState({
        error: error
      });
    }
  }

  componentDidMount() {
    this.populatePokemons();
  }

  render() {
    if (this.state.error) {
      return (
        <div>
          <p>Something bad happened: {this.state.error.message}</p>
          <button onClick={() => this.populatePokemons()}>
            Retry
          </button>
        </div>
      );
    }
  
    if (this.state.isLoading) {
      return (
        <div>Loading pokemons...</div>
      );
    }

    const pokemons = this.state.pokemons;

    const pokemonElements = pokemons.map((pokemon) => {
      return (
        <li key={pokemon.name}>
          {pokemon.name}
        </li>
      );
    })

    return (
      <ul>{pokemonElements}</ul>
    );
  }
}

export default App;
