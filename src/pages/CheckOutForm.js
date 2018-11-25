import React, { Component } from 'react';
import axios from  'axios';

class CheckOutForm extends Component {
    constructor() {
        super();

        this.state = {
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
                <p>Book Checked Out, Due Back In 2 Weeks.</p>
                <button className="FormField__Button" onClick={this.refreshState}> Check Out A Book </button>
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
            <h2>Select Book To Check Out:</h2>
            <ol>
            {this.state.books.map(book => {
                return <li> <p key={book.bookId}>{book.title}  <em> by {book.authorFirstName} {book.authorLastName} </em>
                <input className="BookSelect__Checkbox" type="radio" name="chosenBook" value={book.bookId} onChange={this.handleChange} /></p> </li>;
            })}
            </ol>
              <div className="FormField">
                  <button type="submit" className="FormField__Button"> Check Out A Book </button>
              </div>
            </form>
          </div>
        );
    }
}

export default CheckOutForm;

