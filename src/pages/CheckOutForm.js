import React, { Component } from 'react';
import { Link } from 'react-router-dom';
import axios from  'axios';

class CheckOutForm extends Component {
    constructor() {
        super();

        this.state = {
            email: '',
            password: '',
            student: [],
            books: [],
            checkoutSaved: false

        };


        this.handleChange = this.handleChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
    }

    componentDidMount = () => {
        axios.get('/students')
            .then(res => {
                this.setState({student:res.data});
            })
        axios.get('/books')
            .then(res => {
                this.setState({books:res.data});
            })    
    }

    handleChange(e) {
        let target = e.target;
        let value = target.value;
        let name = target.name;
        

        this.setState({
          [name]: value
        });
    }

    handleSubmit(e) {
        e.preventDefault();

        console.log('The form was submitted with the following data:');
        console.log(this.state);

        axios.post("/period", {
            "student": {"studentId":this.state.chosenStudent},
            "book":{"bookId":this.state.chosenBook}
        })
        .then(res => {
            console.log(res.data);
            this.setState({checkoutSaved : true});    
        })
    }

    refreshState = () => {
        this.setState({checkoutSaved : false});
    }

    render() {
        if(this.state.checkoutSaved){
            return (
            <div>
                <p>Book Checked Out, Due Back In 4 Weeks.</p>
                <button className="FormField__Button mr-20" onClick={this.refreshState}> Check Out A Book </button>
            </div>)
        };
        return (
        <div className="FormCenter">
            <h2>Select Student To Check Out A Book:</h2>
            <form onSubmit={this.handleSubmit} className="FormFields">
            <select name="chosenStudent" onChange={this.handleChange} className="FormField__Select">
                <option value="">Please Choose A Student</option>
                {this.state.student.map(student => {
                return <option value={student.studentId} key={student.studentId}>{student.firstName} {student.lastName} </option>;
            })}
            </select>
            {this.state.books.map(book => {
                return <p key={book.bookId}>{book.title} by {book.authorFirstName} {book.authorLastName}
                <input className="BookSelect__Checkbox" type="radio" name="chosenBook" value={book.bookId} onChange={this.handleChange} /></p>;
            })}
            
            <div className="FormField">
                <label className="FormField__Label" htmlFor="email">E-Mail Address</label>
                <input type="email" id="email" className="FormField__Input" placeholder="Enter your email" name="email" value={this.state.email} onChange={this.handleChange} />
              </div>

              <div className="FormField">
                <label className="FormField__Label" htmlFor="password">Password</label>
                <input type="password" id="password" className="FormField__Input" placeholder="Enter your password" name="password" value={this.state.password} onChange={this.handleChange} />
              </div>

              <div className="FormField">
                  <button type="submit" className="FormField__Button mr-20"> Check Out A Book </button> <Link to="/" className="FormField__Link">Create an account</Link>
              </div>
            </form>
          </div>
        );
    }
}

export default CheckOutForm;

