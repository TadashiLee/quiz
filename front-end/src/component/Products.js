import React, { Component } from 'react';
import httpClient from '../utils/HttpClient/index'
import Product from './product';
import '../css/products.css';

class Products extends Component {
  
  state = {
    products: [
      {
        price: '￥1',
        name: '可乐',
      },
      {
        price: '￥2',
        name: '雪碧',
      },
      {
        price: '￥3',
        name: '芬达',
      },
      {
        price: '￥4',
        name: '苹果',
      },
      {
        price: '￥5',
        name: '橘子',
      },
      {
        price: '￥6',
        name: '栗子',
      },
    ],
    number:0,
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

  handleIncrement = () => {
    this.setState({
      number: this.state.number + 1,
    });
  };

  render() {
    return (
      <div>
        <div className="phonepattern">
          <div className="goodchild">
            {this.state.products.map((product) => (
              <div className="goodsss">
                <Product
                  name={product.name}
                  price={product.price}
                  handleIncrement={this.handleIncrement}
                />
              </div>
            ))}
          </div>
      </div>
        <div>
          订单共{this.state.number}件
        </div>
      </div>
    );
  }
}

export default Products;