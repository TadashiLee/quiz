import React, { Component } from 'react';
import '../css/product.css';
import pic from '../assets/product_image.png';
class Product extends Component {
  render() {
    return (
      <div className="phone">
        <div className="phoneName">
          <p>{this.props.name}</p>
        </div>
        <div className="phonePicture">
          <img
            src={pic}
            alt="myPicture"
          />
        </div>
        <div className="nameAndButt">
          <div className="phonePrice">
            <p>{this.props.price}</p>
          </div>
          <div className="addPhone">
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