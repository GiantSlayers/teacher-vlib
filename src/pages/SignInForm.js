import React, { Component } from 'react';
import { Link } from 'react-router-dom';
import axios from  'axios';

class SignInForm extends Component {
    constructor() {
        super();

        this.state = {
            email: '',
            password: '',
            student: [],
            studentSelect: true

        };


        this.handleChange = this.handleChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
    }

    componentDidMount = () => {
        axios.get('/students')
            .then(res => {
                this.setState({student:res.data});
            })
    }

    handleChange(e) {
        let target = e.target;
        let value = target.type === 'checkbox' ? target.checked : target.value;
        let name = target.name;

        this.setState({
          [name]: value
        });
    }

    handleSubmit(e) {
        e.preventDefault();

        console.log('The form was submitted with the following data:');
        console.log(this.state);
    }

    render() {
        return (
        <div className="FormCenter">
            <h2>Select Student To Check Out A Book:</h2>
            
            {this.state.student.map(student => {
                return <p key={student.studentId}>{student.firstName} {student.lastName}
                <input className="StudentSelect__Radio" type="radio" name="studentSelect" value={this.state.studentSelect} onChange={this.handleChange} /></p>;
            })}
            <form onSubmit={this.handleSubmit} className="FormFields" onSubmit={this.handleSubmit}>
            <div className="FormField">
                <label className="FormField__Label" htmlFor="email">E-Mail Address</label>
                <input type="email" id="email" className="FormField__Input" placeholder="Enter your email" name="email" value={this.state.email} onChange={this.handleChange} />
              </div>

              <div className="FormField">
                <label className="FormField__Label" htmlFor="password">Password</label>
                <input type="password" id="password" className="FormField__Input" placeholder="Enter your password" name="password" value={this.state.password} onChange={this.handleChange} />
              </div>

              <div className="FormField">
                  <Link to="/" type="button" className="FormField__Button mr-20">Check Out A Book </Link> <Link to="/" className="FormField__Link">Create an account</Link>
              </div>
            </form>
          </div>
        );
    }
}

export default SignInForm;

