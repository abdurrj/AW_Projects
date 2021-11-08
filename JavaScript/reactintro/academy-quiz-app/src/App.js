import React from 'react';
import './App.css';

class App extends React.Component{

  constructor(props){
    super(props);

    this.state = {
      count:0
    };

  }
  
  handleIncrement(){
    this.setState={
      count: this.state.count +1
    }
  }

  handleDecrement(){
    this.setState={
      count: this.state.count-1
    }
  }


  render(){
    return (
      <div>
        <div>Counter: {this.state.count}</div>
        <button onClick={()=>this.handleIncrement()}>Increment</button>
        <button onClick={()=>this.handleDecrement()}>Decrement</button>
      </div>
    )
  }
}

export default App;
