import React, { Component } from 'react';
import Product from './product';
import '../css/products.css';

class Products extends Component {
  
  render() {
    return (
      <div className="phonepattern">
        <div className="phonechild">
          {this.props.products.map((product) => (
            <div className="phonesss">
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