/**
 * Created by josephi on 2016/12/19.
 */
import React, {Component} from "react";
import {connect} from 'react-redux';
import {browserHistory} from 'react-router';
import {Input, Button, Icon} from 'antd'
const Search = Input.Search;

import './index.scss'
import Title from '../../components/Title/Title'
import Channel from '../../components/Channel/index'
import Cfigure from '../../components/Cfigure/index'
import ShowList from '../../components/ShowList/index'

class Index extends Component {
  constructor(props) {
    super(props);
    this.state = {}
    this.handleSign = this.handleSign.bind(this)
  }

  handleSign(e) {

  }

  render() {
    const trendsList = [{content: "高考复习12323131231313213131231313123123", time: "2016-11-28"}, {
      content: "高考复习",
      time: "2016-11-28"
    }
      , {content: "高考复习", time: "2016-11-28"}, {content: "高考复习", time: "2016-11-28"}, {
        content: "高考复习",
        time: "2016-11-28"
      }];
    const newClassList = [{content: "高考复习", time: "2016-11-28"}, {content: "高考复习", time: "2016-11-28"}
      , {content: "高考复习", time: "2016-11-28"}, {content: "高考复习", time: "2016-11-28"}, {
        content: "高考复习",
        time: "2016-11-28"
      }];
    const hotClassList = [{content: "高考复习", time: "2016-11-28"}, {content: "高考复习", time: "2016-11-28"}
      , {content: "高考复习", time: "2016-11-28"}, {content: "高考复习", time: "2016-11-28"}, {
        content: "高考复习",
        time: "2016-11-28"
      }];
    return (
      <div className="container">
        <div className="sign">
          <Search placeholder="请输入您要查找的内容" onSearch={value => console.log(value)}/>
          <Button.Group size="default">
            <Button type="primary" onClick={() => browserHistory.push('/login')}><Icon type="user"
                                                                                       onClick={() => browserHistory.push('/login')}/>登录</Button>
            <Button onClick={() => browserHistory.push('/')}>注册</Button>
          </Button.Group>
        </div>
        <div className="company">
          <div className="img"/>
          <div className="name">
            <h1>儿科医师培训平台</h1>
          </div>
        </div>
        <Title/>
        <div className="channel-img">
          <Channel/>
          <Cfigure/>
        </div>
        <div><ShowList trendsList={trendsList} newClassList={newClassList} hotClassList={hotClassList}/></div>
        <div className="footer">
          <div className="friendUrl">友情链接:
            {/*<a href="https://bbs.byr.cn">北邮人论坛考研版</a><em>|</em>*/}
            <a href="http://www.bjmu.edu.cn/">北京大学医学部</a><em>|</em>
            <a href="http://www.cctf.org.cn/">中国儿童少年基金会</a><em>|</em>
            <a href="http://www.bddyyy.com.cn/">北京大学第一医院</a><em>|</em>
            <a href="http://bdfck.cnkme.com/">北京大学第一医院妇产科</a>
          </div>
          <div className="phone" onClick={() => browserHistory.push('/login')}>
            <Icon type="phone" onClick={() => browserHistory.push('/login')}/>咨询热线：
            <a>13520405471</a></div>
          </div>
      </div>
    )
  }
}

export default Index;