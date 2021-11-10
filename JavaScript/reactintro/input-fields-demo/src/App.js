import React from "react";

class App extends React.Component {
  constructor(props) {
    super(props);

    this.state = {
      inputFieldValue: "hallo"
    }

    // this.interval = null;
  }

  handleInputChange(event) {
    if (event.target.value.includes('@')) {
      return;
    }

    this.setState({
      inputFieldValue: event.target.value
    });
  }

  // componentDidMount() {
  //   this.interval = setInterval(() => {
  //     this.setState({
  //       inputFieldValue: this.state.inputFieldValue + "!"
  //     })
  //   }, 1000);
  // }

  render() {
    const inputStyles = {
      backgroundColor: this.state.inputFieldValue.length > 10 ? "red" : "white"
    }

    return (
      <div>
        <label>
          Skriv noe her:
          <input
            style={inputStyles}
            value={this.state.inputFieldValue}
            onChange={(event) => this.handleInputChange(event)}
            type="text"
          />
        </label>
      </div>
    )
  }
}

export default App;
