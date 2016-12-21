/**
 * Created by josephi on 2016/12/21.
 */
/**
 * Created by josephi on 2016/12/19.
 */
import React,{Component} from 'react';

import {Menu,Icon} from 'antd';
import {browserHistory} from 'react-router';

import './index.scss'
export default class Channel extends Component{
  constructor(props){
    super(props);
    this.state={

    }
  }

  render(){
    return(
      <div className="channel">
        <div onClick={()=>{browserHistory.push()}} style={{fontSize:"25px",color:"purple"}}>快速通道</div>
        <div onClick={()=>{browserHistory.push()}}>学员注册/登录</div>
        <div onClick={()=>{browserHistory.push()}}>学员中心</div>
        <div onClick={()=>{browserHistory.push()}}>课程培训</div>
        <div onClick={()=>{browserHistory.push()}}>联系我们</div>
      </div>
    )
  }
}