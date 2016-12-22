/**
 * Created by josephi on 2016/12/22.
 */
import React, {Component} from 'react';

import {Menu, Icon} from 'antd';
import {browserHistory} from 'react-router';

import './index.scss'
export default class ShowList extends Component {
  constructor(props) {
    super(props);
    this.state = {}
  }

  render() {
    const trendsList = this.props.trendsList.map((value, index) =>
      <li key={index}><div className="content">{value.content}</div> <div className="time">[{value.time}] </div></li>);
    const newClassList = this.props.newClassList.map((value, index) =>
      <li key={index}><div className="content">{value.content}</div> <div className="time">[{value.time}] </div></li>);
    const hotClassList = this.props.hotClassList.map((value, index) =>
      <li key={index}><div className="content">{value.content}</div> <div className="time">[{value.time}] </div></li>);

    return (
      <div className="showList">
        <div className="newTrends">
          <h2>最新动态</h2>
          <div className="blank"/>
          <ul>{trendsList}</ul>
          <div className="blank"/>
        </div>
        <div className="newClass" style={{margin: "0 2%"}}>
          <h2>最新课程</h2>
          <div className="blank"/>
          <ul>{newClassList}</ul>
          <div className="blank"/>
        </div>
        <div className="hotClass">
          <h2>最热课程</h2>
          <div className="blank"/>
          <ul>{hotClassList}</ul>
          <div className="blank"/>
        </div>
      </div>
    )
  }
}