import React, { Component } from 'react';
import Tourist from "./Tourist"
import PostForm from './PostForm';
import DeleteForm from './DeleteForm';

class App extends Component {

  state = {
    name: "filip",
    data: [],

    size: ["adam","ewa"]
  }

  componentDidMount() {
    fetch('http://localhost:8080/tourist/all')
    .then(respone => respone.json())
    .then(data => {
      console.log(data);
      this.setState({ data })
    });
  }

  render() {
    return (
      <div>
        <div>{this.state.data.map(tourist => <Tourist info={tourist}/>)}</div>
        <div><PostForm /></div>
        <br />
        <div><DeleteForm /></div>
      </div>
    );
  }


}

export default App;

