import React, { Component } from 'react';
import httpClient from '../utils/HttpClient/index'
import Product from './product';
import '../css/products.css';

class Products extends Component {
  
  state = {
    products: [],
  };
  
  componentDidMount() {
    httpClient.get('/products').then(resp => {
      this.setState({
        products: [
          ...resp.data
        ],
      })
    })
  }

  render() {
    return (
      <div className="phonepattern">
        <div className="goodchild">
          {this.props.products.map((product) => (
            <div className="goodsss">
              <Product
                name={product.name}
                price={product.price}
                handleIncrement={this.props.onIncrement}
              />
            </div>
          ))}
        </div>
      </div>
    );
  }
}

export default Products;