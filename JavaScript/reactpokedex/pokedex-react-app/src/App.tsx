import React from 'react';
import './App.css';

class App extends React.Component {
    constructor(props) {
        super(props);

        this.state = {
            pokemons: ["hei", "på", "deg"]
        }
    }

    render(){
        return (
            <div>
                {this.state.pokemons}
            </div>
        )
    }
}

export default App;
