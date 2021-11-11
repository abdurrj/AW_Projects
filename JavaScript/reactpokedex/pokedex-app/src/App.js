import React from 'react';
import './App.css';

class App extends React.Component {
  constructor(props) {
    super(props);

    this.state = {
      pokemons: [],
      filters:["Any", "normal", "fire", "water", "grass", "electric", "ice", "fighting", "poison", "ground", "flying", "psychic", "bug", "rock", "ghost", "dark", "dragon", "steel", "fairy"],
      activeFilter: undefined,
      limitValue:151,
      offsetValue:0,
      namefilter:""
    }
  }

  async getPokemons(){

    let response = await fetch('https://pokeapi.co/api/v2/pokemon?limit=2000&offset=0')
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
    let detailedList = this.state.pokemons.slice(this.state.offsetValue, this.state.limitValue)
    let filter = this.state.activeFilter
    return(
      this.filteredList(detailedList, filter)
        .map((pokemon, index)=>{
        return(
        <div className="pokeDiv">
          <img className="pokeImage" id={pokemon.name + "-"+index} src={pokemon.sprites.front_default}/>
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
    ).filter(pokemon => {
      if (this.state.namefilter==="" || pokemon.name.includes(this.state.namefilter)){
        return true;
      }
      }
    )
      ;
  }

  filterTypes(event){
    let newValue = undefined;
    if (event.target.value!=="Any"){
      newValue = event.target.value
    }
    this.setState({
      activeFilter: newValue
    })
  }

  filterOffset(event){
    this.setState({
      offsetValue: event.target.value-1
    })
  }

  filterLimit(event){
    this.setState({
      limitValue: event.target.value
    })
  }

  filterName(event){
    let name = ""
    console.log(event.target.value)
    if (event.target.value!==""){
      name = event.target.value;
    }
    this.setState({
      namefilter:name
    })
  }

  displayFilter(){
    return (
      <div id="filters">
        <div id="typeFilter" className="filterClass">
          <label for="typeFilter">Type: </label>
          <select
              id="typeFilter"
              value={this.state.activeFilter}
              onChange={this.filterTypes.bind(this)}
          >
                {this.state.filters.map(filter=>{
                  return <option value={filter}>{filter}</option>
                  })
                }
          </select>
        </div>
        <div className="filterClass">
          <label for="startFrom">From: </label>
            <input
                id="startFrom"
                type="number"
                min="1"
                max={this.state.limitValue}
                defaultValue={this.state.offsetValue+1}
                onChange={this.filterOffset.bind(this)}
            />
        </div>
        <div className="filterClass">
          <label for="limitView">To: </label>
            <input
                id="limitView"
                type="number"
                min={this.state.offsetValue+1}
                max={this.state.pokemons.length}
                defaultValue={151}
                onChange={this.filterLimit.bind(this)}
            />
        </div>
        <div className="filterClass">
          <label for="nameSearch">Name: </label>
          <input
            id="nameSearch"
            type="text"
            onChange={this.filterName.bind(this)}
          />
        </div>
      </div>
    )
  }



  render(){
    return (
      <div className="main">
        {this.displayFilter()}
        <div className="pokeList">
          {this.displayResult()}
        </div>
      </div>
    )
  }
}


export default App;
