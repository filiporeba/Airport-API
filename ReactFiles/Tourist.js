import React, { Component } from 'react';

class Tourist extends Component {


  render() {
    return (
      <div>
        
        {this.props.info.id}  {this.props.info.name}  {this.props.info.surname}  {this.props.info.sex}  {this.props.info.country}  {this.props.info.note} {this.props.info.birthDate}  {this.props.info.flightId} 
      <br /> <br />          
      </div>
    )
  }



}

export default Tourist;