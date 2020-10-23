import React, {Component} from 'react';
import {Route, BrowserRouter, Switch} from "react-router-dom";
import './App.css';
import Header from "./component/Header";
import Products from "./component/Products";
import Details from "./component/Details";
import Addgoods from "./component/Addgoods";
import './App.css';

class App extends Component {
  
  state = {
    number: 0,
  };

  path={
    pathname:"/poducts",
    state:this.state,
  }

  render() {
    return (
      <div className="app">
        <BrowserRouter>
          <Header/>
        <Switch>
          <Route exact path='/products' component={Products}/>
          <Route exact path='/details' component={Details}/>
          <Route exact path='/add-goods' component={Addgoods}/>
        </Switch>
        </BrowserRouter>
      </div>
    );
  }
}

export default App;

