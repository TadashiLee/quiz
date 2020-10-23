import React, { Component } from 'react';
import { NavLink } from 'react-router-dom';


class Header extends Component {
  
  render() {
    return (
      <div className="links">
        <NavLink exact to='/mall' className='nav-linkh'activeStyle={{fontWeight: "bold",color: "yellow"}} >
          商城
        </NavLink>
        <NavLink exact to='/details' className='nav-linkh' activeStyle={{fontWeight: "bold",color: "yellow"}}>
          订单 订单共{this.props.number}件
        </NavLink>
        <NavLink exact to='/add-goods' className='nav-linkh' activeStyle={{fontWeight: "bold",color: "yellow"}}>
          + 添加商品 
        </NavLink>
      </div>
    );
  }
}

export default Header;