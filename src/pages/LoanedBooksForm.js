import React, { Component } from 'react';
import axios from  'axios';

class LoanedBooksForm extends Component {
    constructor() {
        super();

        this.state = {
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
                this.setState({periods:res.data.reverse().slice(0,10)});
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
    
        <ol>
            {this.state.periods.map(period => {
                return <li> 
                    <p key={period.transactionId}>{period.book.title} <em> 
                    Checked Out By: {period.student.firstName} {period.student.lastName}</em> </p> 
                    </li>
            
            })}
        </ol>
            
          </div>
        );
    }
}

export default LoanedBooksForm;

