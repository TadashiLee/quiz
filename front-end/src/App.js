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
    products: [
      {
        price: '￥1',
        name: '可乐1',
      },
      {
        price: '￥2',
        name: '可乐2',
      },
      {
        price: '￥3',
        name: '可乐3',
      },
      {
        price: '￥4',
        name: '可乐4',
      },
      {
        price: '￥5',
        name: '可乐5',
      },
      {
        price: '￥6',
        name: '可乐6',
      },
    ],
    // products: [],
    number: 0,
  };

  path={
    pathname:"/poducts",
    state:this.state,
  }
  handleIncrement = () => {
    this.setState({
      number: this.state.number + 1,
    });
  };

  render() {
    return (
      <div className="app">
        <BrowserRouter>
          <Header number={this.state.number} path={this.path}/>
          <Products products={this.state.products} onIncrement={this.handleIncrement} />
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

