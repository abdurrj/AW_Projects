import React from 'react';
import './App.css';

class App extends React.Component {
  constructor(props) {
    super(props);

    this.state = {
      pokemons: [],
      filters:["", "fire", "water", "electric", "poison"],
      activeFilter: undefined
    }
  }

  async getPokemons(){
    let response = await fetch('https://pokeapi.co/api/v2/pokemon?limit=151')
    let pokemons = await response.json();

    let pokemonUrl = pokemons.results.map(pokemons => pokemons.url)
    let res = await Promise.all(pokemonUrl
      .map(url=>fetch(url)))
    let detailedList = await Promise.all(res.map(r=>r.json()))

    this.setState({
      pokemons: detailedList
    })
  }

  componentDidMount() {
    this.getPokemons();
  }



  displayResult(){
    let detailedList = this.state.pokemons
    let filter = this.state.activeFilter
    return(
      this.filteredList(detailedList, filter)
        .map((pokemon, index)=>{
        return(
        <div className="pokeDiv">
          <p  className="pokeImage"><img src={pokemon.sprites.front_default}/></p>
          <p className="pokeName">{pokemon.name}</p>
        </div>
        )
      })
    )
  }

  filteredList(detailedList, filter) {
    return detailedList.filter(
      pokemon => {
        let pokeTypes = pokemon.types
        let pass = false
        for (let t of pokeTypes) {
          if (t.type.name === filter || filter===undefined) {
            pass = true;
            break;
          }
        }
        return pass;
      }
    );
  }

  filterTypes(event){
    let newValue = undefined;
    if (event.target.value!==""){
      newValue = event.target.value
    }
    this.setState({
      activeFilter: newValue
    })
  }

  displayFilter(){
    return (
      <select id="typeFilter" value={this.state.activeFilter} onChange={this.filterTypes.bind(this)}>
        {this.state.filters.map(filter=>{
          return <option value={filter}>{filter}</option>
          }
        )}
      </select>
    )
  }



  render(){
    return (
      <div >
        <div className="filterfunksjon">
          filter: {this.displayFilter()}
        </div>
        <div className="main">
          {this.displayResult()}
        </div>
      </div>
    )
  }
}


export default App;
