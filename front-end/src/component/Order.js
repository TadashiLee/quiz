import React, { Component } from 'react';
class Order extends Component {
  render() {
    return (
      <div>
        <div>
          订单号：{this.props.id}
        </div>
        <div>
          # 名称 单价 数量
        </div>
        <div>
          {this.props.goods.map(good => {
            return <div>
              <span>{good.goodid}</span><span>{good.name}</span><span>{good.price}</span><span>{good.amount}</span>
            </div>
          })}
        </div>
      </div>
    );
  }
}

export default Order;