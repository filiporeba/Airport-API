import React, { Component } from 'react';
import axios from 'axios';

class DeleteForm extends Component {
    constructor(props) {
        super(props);

        this.state = {
            id: '',
        }        
    }

    changeHandler = e => {
        this.setState({ [e.target.id]: e.target.id })
    }
    
    submitHandler = e => {
        e.preventDefault()
        console.log(this.state)
        axios
            .delete('http://localhost:8080/tourist/{id}', this.state) 
            .then( response => {
                console.log(response)
            })
            .catch( error => {
                console.log(error)
            })
    }

    render() {
        const { id } = this.state
        return (
            <div>
                <form onSubmit={this.submitHandler}>
                    <div>
                    Tourist number:    <input type="text" name="id" value={id} onChang={this.changeHandler}/>
                    </div>
                    <button type="submit">Remove Tourist</button>
                </form>
                
            </div>
        );
    }
}

export default DeleteForm;