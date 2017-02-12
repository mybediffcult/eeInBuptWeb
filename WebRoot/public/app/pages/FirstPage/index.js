/**
 * Created by jackieliao on 2017/1/24.
 */
import React, {Component} from "react";
import {connect} from "react-redux"
import moment from 'moment'
import {Input, Button, Icon ,Layout, Menu, Breadcrumb} from 'antd'
import './index.scss'
const { SubMenu } = Menu;

import NewList from "../../components/NewList/index"
import ImgList from "../../components/ImgList/index"


class HomePage extends Component{
    constructor(props){
        super(props);
        this.state={
        navNum:0
        }
    }
    render(){
        const navNum=this.state.navNum;
        const listInform=[{content: "高考复习", time: "2016-11-28"}, {content: "高考复习", time: "2016-11-28"}
            , {content: "高考复习", time: "2016-11-28"}, {content: "高考复习", time: "2016-11-28"}, {
                content: "高考复习",
                time: "2016-11-28"
            }];
        const imgList=[{img:"http://301101.s61i.faiusr.com/2/AD0IrbASEAIYACD-3u2-BSiv4fC2BjCbAjibAg!160x160.jpg",name:"李主任1"},{img:"http://301101.s61i.faiusr.com/2/AD0IrbASEAIYACD-3u2-BSiv4fC2BjCbAjibAg!160x160.jpg",name:"李主任2"},{img:"http://301101.s61i.faiusr.com/2/AD0IrbASEAIYACD-3u2-BSiv4fC2BjCbAjibAg!160x160.jpg",name:"李主任3"},{img:"http://301101.s61i.faiusr.com/2/AD0IrbASEAIYACD-3u2-BSiv4fC2BjCbAjibAg!160x160.jpg",name:"李主任4"},{img:"http://301101.s61i.faiusr.com/2/AD0IrbASEAIYACD-3u2-BSiv4fC2BjCbAjibAg!160x160.jpg",name:"李主任"},{img:"http://301101.s61i.faiusr.com/2/AD0IrbASEAIYACD-3u2-BSiv4fC2BjCbAjibAg!160x160.jpg",name:"李主任5"},{img:"http://301101.s61i.faiusr.com/2/AD0IrbASEAIYACD-3u2-BSiv4fC2BjCbAjibAg!160x160.jpg",name:"李主任"},{img:"http://301101.s61i.faiusr.com/2/AD0IrbASEAIYACD-3u2-BSiv4fC2BjCbAjibAg!160x160.jpg",name:"李主任6"}]
        return(
        <div className="container" >
            <div className="homeTitle">
                <div className="title-name title-left">
                        儿童医师培训平台
                </div>
                <div className="title-right">
                <div className="login">
                    <span><a href="../../../../login.jsp">登陆</a></span>
                    /
                    <span><a href="../../../../reg.jsp">注册</a></span>
                </div>
                    <div className="time">{moment().format("MM/DD/YYYY")}&nbsp;&nbsp; &nbsp; {moment().format("HH:mm")}</div>
                </div>
            </div>
            <div className="navShow">
            <div className="navCenter">
                <div className={navNum==0?"navChoose  navNormal":" navNormal"} onClick={()=>{this.setState({navNum:0})}}>首页</div>
                <div className={navNum==1?"navChoose  navNormal":" navNormal"} onClick={()=>{location.href="../../../../login.jsp?indexParam=0";this.setState({navNum:1})}}>学籍系统</div>
                <div className={navNum==2?"navChoose  navNormal":" navNormal"} onClick={()=>{location.href="../../../../login.jsp?indexParam=1";this.setState({navNum:2})}}>学员中心
                    <ul><li>在线学习</li>
                    <li><a href="../../../../login.jsp?indexParam=10">班主任管理</a></li>
                        {/* <li>BBS讨论区</li>*/}
                </ul>
                </div>
                <div className={navNum==3?"navChoose  navNormal":" navNormal"} onClick={()=>{this.setState({navNum:3})}}>课程培训</div>
                <div className={navNum==4?"navChoose  navNormal":" navNormal"} onClick={()=>{this.setState({navNum:4})}}>关于我们</div>
                <div className={navNum==5?"navChoose  navNormal":" navNormal"} onClick={()=>{this.setState({navNum:5})}}>下载专区</div>
            </div>
                <div className="numImg"></div>
                <div className="homeContent">
                <div className="conLeft">
                    <div className="searchBar">
                    <div className="searchTitle">全站搜索</div>
                        <Input placeholder="请输入您要查找的内容" />
                        <Button type="primary" icon="search">搜索</Button>
                    </div>
                    <div className="formBanner">
                        <div className="formTitle">就医指南</div>
                        <a>关于我们</a>
                    </div>
                    <div className="formBanner">
                        <div className="formTitle">专家门诊</div>
                        <Menu
                            mode="inline"
                            defaultSelectedKeys={['1']}
                            defaultOpenKeys={['sub1']}
                            style={{ height: '100%'}}
                        >
                            <SubMenu key="sub1" title={<span>内科系统</span>}>
                                <Menu.Item key="1">心血管内科</Menu.Item>
                                <Menu.Item key="2">神经内科</Menu.Item>
                            </SubMenu>
                            <div className="dash"></div>
                            <SubMenu key="sub2" title={<span>外科系统</span>}>
                                <Menu.Item key="3">骨科</Menu.Item>
                                <Menu.Item key="4">泌尿外科</Menu.Item>
                            </SubMenu>
                            <div className="dash"></div>
                            <SubMenu key="sub3" title={<span>妇产科研究所</span>}>
                                <Menu.Item key="5">产科</Menu.Item>
                                <Menu.Item key="6">产前诊断科</Menu.Item>
                            </SubMenu>
                            <div className="dash"></div>
                            <SubMenu key="sub4" title={<span>儿科</span>}>
                                <Menu.Item key="7">儿科</Menu.Item>
                            </SubMenu>
                            <div className="dash"></div>
                            <SubMenu key="sub5" title={<span>中医科</span>}>
                                <Menu.Item key="8">中医科</Menu.Item>
                            </SubMenu>
                        </Menu>
                    </div>
                    <div className="formBanner">
                        <div className="formTitle">在线客服</div>
                        <div className="serOnline">
                            <a hidefocus="true" href="http://wpa.qq.com/msgrd?v=3&uin=100000&site=qq&menu=yes">
                              <span className="qqImg">&nbsp;</span>客服一
                            </a>
                        </div>
                        <div className="serOnline">
                            <a hidefocus="true" href="http://wpa.qq.com/msgrd?v=3&uin=100000&site=qq&menu=yes">
                                <span className="qqImg">&nbsp;</span>客服二
                            </a>
                        </div>
                    </div>
                   <div className="dash"></div>
                    <div className="serOnline-time">
                        <span className="timeImg">&nbsp;</span>工作时间
                        <div style={{fontSize:14,color:"#666666",marginTop:5}}>周一至周五：8:30-17:30</div>
                    </div>
                </div>
                <div className="conRight">
                    <div className="news">
                  <div className="leftList">
                      <NewList trendsList={listInform} listTitle="医院新闻"/>
                </div>
                    <div className="rightList">
                      <NewList trendsList={listInform} listTitle="医院新闻"/>
            </div>
                        </div>
                  <div className="picList">  <ImgList imgList={imgList}/></div>
                    <div className="news">
                    <div className="leftList">
                      <NewList trendsList={listInform} listTitle="医院新闻"/>
            </div>
                    <div className="rightList">
                      <NewList trendsList={listInform} listTitle="医院新闻"/>
            </div>
                        </div>
                </div>
        </div>
                </div>
            <div className="homeFooter">
            <div className="line1">
                <span>首页</span>
                <span><div className="footerSpace"/></span>
                <span>学籍系统</span>
                <span><div className="footerSpace"/></span>
                <span>关于我们</span>
                <span><div className="footerSpace"/></span>
                <span>讨论区</span>
                <span><div className="footerSpace"/></span>
                <span>手机版</span>
            </div>
                <div className="line2">
                    <span>©2017-版权所有</span>
                </div>

                </div>
            </div>
        )
    }
}
export default HomePage