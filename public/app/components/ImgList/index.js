/**
 * Created by josephi on 2016/12/22.
 */
import React, {Component} from 'react';

import {Menu, Icon} from 'antd';
import {browserHistory} from 'react-router';

import './index.scss'
export default class ImgList extends Component {
  constructor(props) {
    super(props);
    this.state = {
        curnum:3,
        imgList:this.props.imgList,
        showList:[],
        leftList:[]
    };
      this.carousel=this.carousel.bind(this);
      setInterval(this.carousel,1000);
  }
    componentDidMount(){
        //console.log(this.props.imgList.length);
       if(this.props.imgList.length<=4){
           this.setState({showList:this.props.imgList.concat(this.props.imgList)})
       }
        else if(this.props.imgList.length>=8) {
         this.setState({showList:this.props.imgList.slice(0,6),leftList:this.props.imgList.slice(6)});
       }

    }
    carousel(){
        var imgList=this.state.imgList;
        // var curnum=this.state.curnum;
        var showList=this.state.showList;
        var leftList=this.state.leftList;
        if(leftList.length!=0){
            console.log("1")
            showList.push(leftList[0]);
            leftList.splice(0,1);
        }else{
            console.log("2")
            showList.push(imgList[0]);
            imgList.push(imgList[0]);
            imgList.splice(0,1);
        }
        //console.log(showList);
        if(showList.length>3*imgList.length){
            showList.splice(0,imgList.length);
        }
        this.setState({imgList:imgList,showList:showList,leftList:leftList});
        // curnum=curnum+1;
        // console.log("curnum=="+curnum);
        // console.log(imgList.length)
        // if(curnum=imgList.length-3){
        //     console.log("= L-3")
        //     imgList.slice(0,this.props.imgList.length+1);
        //     imgList.concat(imgList);
        //     this.setState({imgList:imgList})
        // }
        // else if(curnum>=imgList.length) {
        //     console.log(">=L")
        //     curnum = 0;
        // }

        //this.setState({curnum:curnum})
    }

  render() {
    const trendsList = this.state.showList.map((value, index) =>
      <div className="imgbody" key={index}>
          <div className="doctorImg"><img src={value.img}/></div>
          <div className="doctorName">{value.name}</div>
      </div>
    );
    return (
      <div className="showListForm">
          <div className="listTitle">
              <div className="titleLeft">专家风采
          </div>
              <div className="titleRight">...</div>
          </div>
          <div className="dash-dash"/>
          <div className="imgContent">
            {trendsList}
          </div>
      </div>
    )
  }
}