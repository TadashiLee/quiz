import React, { Component } from 'react';
import '../css/product.css';
import pic from '../assets/product_image.png';
class Product extends Component {
  render() {
    return (
      <div className="good">
        <div className="goodName">
          <p>{this.props.name}</p>
        </div>
        <div className="goodPicture">
          <img
            src={pic}
            alt="myPicture"
          />
        </div>
        <div className="nameAndButt">
          <div className="goodPrice">
            <p>{this.props.price}</p>
          </div>
          <div className="addGood">
            <button className="addbutton" onClick={this.props.handleIncrement}>
              add to cart
            </button>
          </div>
        </div>
      </div>
    );
  }
}

export default Product;