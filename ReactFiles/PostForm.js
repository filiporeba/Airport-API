import React, { Component } from 'react';
import axios from 'axios';

class PostForm extends Component {
    constructor(props) {
        super(props);

        this.state = {
            id: '',
            name: '',
            surname: '',
            sex: '',
            country: '',
            note: '',
            birthDate: '',
            flightId: ''
        }        
    }

    changeHandler = e => {
        this.setState({ [e.target.name]: e.target.value })
    }
    
    submitHandler = e => {
        e.preventDefault()
        console.log(this.state)
        axios
            .post('http://localhost:8080/tourist/add', this.state) 
            .then( response => {
                console.log(response)
            })
            .catch( error => {
                console.log(error)
            })
    }

    render() {
        const { id, name, surname, sex, country, note, birthDate, flightId } = this.state
        return (
            <div>
                <form onSubmit={this.submitHandler}>
                    <div>
                    Id:    <input type="text" name="id" value={id} onChang={this.changeHandler}/>
                    </div>
                    <div>
                    Name:    <input type="text" name="name" value={name} onChang={this.changeHandler}/>
                    </div>
                    <div>
                    Surname:    <input type="text" name="surname" value={surname} onChang={this.changeHandler}/>
                    </div>
                    <div>
                    Sex:    <input type="text" name="sex" value={sex} onChang={this.changeHandler}/>
                    </div>
                    <div>
                    Country:    <input type="text" name="country" value={country} onChang={this.changeHandler}/>
                    </div>
                    <div>
                    Note:    <input type="text" name="note" value={note} onChang={this.changeHandler}/>
                    </div>
                    <div>
                    Birth Date:    <input type="text" name="birthDate" value={birthDate} onChang={this.changeHandler}/>
                    </div>
                    <div>
                    Flight Nr:    <input type="text" name="flightId" value={flightId} onChang={this.changeHandler}/>
                    </div>
                    <button type="submit">Add Tourist</button>
                </form>
                
            </div>
        );
    }
}

export default PostForm;