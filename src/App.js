import React, { Component } from 'react';
import { HashRouter as Router, Route, NavLink } from 'react-router-dom';
import LoanedBooksForm from './pages/LoanedBooksForm';
import CheckOutForm from './pages/CheckOutForm';

import './App.css';



class App extends Component {
  render() {
    return (
      <Router basename="/react-auth-ui/">
        <div className="App">
          <div className="App__Aside">
          
          </div>
          <div className="App__Form">
            <div className="PageSwitcher">
                <NavLink to="/check-out" activeClassName="PageSwitcher__Item--Active" className="PageSwitcher__Item">Check Out</NavLink>
                <NavLink exact to="/" activeClassName="PageSwitcher__Item--Active" className="PageSwitcher__Item">Books On Loan</NavLink>
              </div>

              <div className="FormTitle">
                  <NavLink to="/check-out" activeClassName="FormTitle__Link--Active" className="FormTitle__Link">Check Out</NavLink> | 
                  <NavLink exact to="/" activeClassName="FormTitle__Link--Active" className="FormTitle__Link">Books On Loan</NavLink>
              </div>


              <Route exact path="/" component={LoanedBooksForm}>
              </Route>
              <Route path="/check-out" component={CheckOutForm}>
              </Route>
          </div>

        </div>
      </Router>
    );
  }
}

export default App;
