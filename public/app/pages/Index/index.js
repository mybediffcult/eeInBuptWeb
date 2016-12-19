/**
 * Created by josephi on 2016/12/19.
 */
import React,{Component} from "react";
import {connect} from 'react-redux';
import {browserHistory} from 'react-router';
import {Input,Button,Icon} from 'antd'
const Search=Input.Search;

class Index extends Component{
  constructor(props){
    super(props);
    this.state={

    }
    this.handleSign=this.handleSign.bind(this)
  }
  handleSign(e){

  }

  render(){
    return(
      <div className="container">
        <div className="sign">
          <Search placeholder="请输入您要查找的内容" onSearch={value=>console.log(value)} style={{paddingRight:10}}/>
          <Button.Group size="default">
            <Button type="primary"><Icon type="user" onClick={()=>browserHistory.push('/login')}/>登录</Button>
            <Button onClick={()=>browserHistory.push('/')}>注册</Button>
          </Button.Group>
        </div>

      </div>
    )
  }
}

export default Index;