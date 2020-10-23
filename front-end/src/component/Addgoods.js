import React, { Component } from 'react';
import '../../node_modules/bootstrap/dist/css/bootstrap.min.css';
class Addgoods extends Component {
  
  state = {
    name: '',
    price: '',
    unit:'',
    pic:'',
  };

  handleFieldChange = (field, event) => {
    this.setState({
      [field]:event.target.value,
    });
  };


  handleFormSubmit=()=>{
    alert(JSON.stringify(this.state));
  };

  render() {
    return (
      <div className="container">
        <h2>添加商品</h2>
        <form className="my-form" onSubmit={this.handleFormSubmit}>
        <div class="form-row"></div>
          <div className="form-group col-md-4">
            <label htmlFor="name">*名称：</label>
              <input
                type="text"
                value={this.state.name}
                onChange={(e)=>this.handleFieldChange("name", e)}
                className="form-control"
                id="name"
                placeholder="名称" 
              />
        </div>
        <div class="form-row"></div>
          <div className="form-group col-md-4">
            <label htmlFor="price">*价格：</label>
              <input
                type="text"
                value={this.state.price}
                onChange={(e)=>this.handleFieldChange("price", e)}
                className="form-control"
                id="price"
                placeholder="价格" 
              />
          </div>
          <div class="form-row"></div>
          <div className="form-group col-md-4">
            <label htmlFor="unit">*单位：</label>
              <input
                type="text"
                value={this.state.unit}
                onChange={(e)=>this.handleFieldChange("unit", e)}
                className="form-control"
                id="unit"
                placeholder="单位" 
              />
          </div>
          <div class="form-row"></div>
          <div className="form-group col-md-4">
            <label htmlFor="pic">*图片：</label>
              <input
                type="text"
                value={this.state.pic}
                onChange={(e)=>this.handleFieldChange("pic", e)}
                className="form-control"
                id="pic"
                placeholder="URL" 
              />
          </div>
          <input type="submit" 
          value="Submit" 
          className="btn btn-primary" 
          disabled={!this.state.name ||!this.state.gender ||!this.state.description ||!this.state.check}
          />
        </form>
      </div>
    );
  }
}

export default Addgoods;