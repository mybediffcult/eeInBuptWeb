/**
 * Created by josephi on 2016/12/22.
 */
import React, {Component} from 'react';

import {Menu, Icon} from 'antd';
import {browserHistory} from 'react-router';

import './index.scss'
export default class NewList extends Component {
  constructor(props) {
    super(props);
    this.state = {}
  }

  render() {
    const trendsList = this.props.trendsList.map((value, index) =>
      <li key={index}>
          <div className="content">{value.content}</div>
          <div className="time">{value.time}</div>
          <div className="dash"/>
      </li>);
    return (
      <div className="showListForm">
          <div className="listTitle">
              <div className="titleLeft">{this.props.listTitle}
          </div>
              <div className="titleRight">...</div>
          </div>
          <div className="dash-dash"/>
          <ul>{trendsList}</ul>
        </div>
    )
  }
}