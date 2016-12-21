/**
 * Created by josephi on 2016/12/19.
 */
import React,{Component} from 'react';

import {Menu,Icon} from 'antd';
import {browserHistory} from 'react-router';

import './index.scss'
export default class Title extends Component{
  constructor(props){
    super(props);
    this.state={

    }
  }

  render(){
    return(
      <div className="title">
        <div onClick={()=>{browserHistory.push()}}>首页</div>
        <div onClick={()=>{browserHistory.push()}}>新闻资讯</div>
        <div onClick={()=>{browserHistory.push()}}>在线学习</div>
        <div onClick={()=>{browserHistory.push()}}>下载专区</div>
        <div onClick={()=>{browserHistory.push()}}>关于我们</div>
      </div>
    )
  }
}