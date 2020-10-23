import React, { Component } from 'react';
import httpClient from '../utils/HttpClient/index'
import Order from './Order';

class Details extends Component {
  state = {
    orders: [
      {
        id: 123,
        goods: [{
          goodid:1,
          name: '可乐1',
          price: 2.50,
          amount: 2 
        }, {
          goodid:2,
          name: '雪碧',
          price: 3.50,
          amount: 1 
          }, {
          goodid:3,
          name: '芬达',
          price: 2.50,
          amount: 3 
        }]
      },
      {
        id: 223,
        goods: [{
          goodid:1,
          name: '可乐2',
          price: 2.50,
          amount: 2 
        }, {
          goodid:2,
          name: '雪碧2',
          price: 3.50,
          amount: 1 
          }, {
          goodid:3,
          name: '芬达2',
          price: 2.50,
          amount: 3 
        }]
      }
    ],
  };

  componentDidMount() {
    httpClient.get('/orders').then(resp => {
      this.setState({
        orders: resp.data.orders
      })
    })
  }
  render() {
    return (
      <div className="products">
        {this.state.orders.length ? <div>
          <Order order={this.state.orders}/>
        </div>:'暂无订单'}
      </div>
    );
  }
}

export default Details;