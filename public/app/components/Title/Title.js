/**
 * Created by josephi on 2016/12/19.
 */
import React,{Component} from 'react';

import {Menu,Icon} from 'antd';

export default class Title extends Component{
  constructor(props){
    super(props);
    this.state={

    }
  }

  render(){
    return(
      <div className="title">
        <a>首页</a>
        <a>新闻资讯</a>
        <a>在线学习</a>
        <a>下载专区</a>
        <a>关于我们</a>
      </div>
    )
  }
}