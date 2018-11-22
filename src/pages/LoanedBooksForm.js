import React, { Component } from 'react';
import { Link } from 'react-router-dom';
import axios from  'axios';

class LoanedBooksForm extends Component {
    constructor() {
        super();

        this.state = {
            email: '',
            password: '',
            name: '',
            hasAgreed: false,
            books: [],
            bookSelect: true,
            periods: []
        };

        
        this.handleChange = this.handleChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
    }

    componentDidMount = () => {
        axios.get('/periods')
            .then(res => {console.log(res.data)
                this.setState({periods:res.data});
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

        <h2>Books Checked Out:</h2>
            
        {this.state.periods.map(period => {
                return <p key={period.transactionId}>{period.book.title} checked out by {period.student.firstName} {period.student.lastName}</p>
            
            })}

              <div className="FormField">
                  <button className="FormField__Button mr-20">Check Out</button>
              </div>
            
          </div>
        );
    }
}

export default LoanedBooksForm;

