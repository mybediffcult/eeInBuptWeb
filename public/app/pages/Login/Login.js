import './Login.scss'
import React, {Component, PropTypes} from 'react'
import {browserHistory} from 'react-router'
import {connect} from 'react-redux'

import {Icon, Input, Button, Form, Row, Col, message} from 'antd'
import {getLogin} from '../../../login/javascripts/actions/fetchLoginInfo'

class Login extends Component {
  constructor() {
    super();
    this.state = {
      username: '',
      password: ''
    }
    this.handlePressEnter = this.handlePressEnter.bind(this)
  }

  componentDidMount() {
    document.documentElement.addEventListener('keydown', this.handlePressEnter)
  }

  componentWillUnmount() {
    document.documentElement.removeEventListener('keydown', this.handlePressEnter)
  }

  handlePressEnter(evt) {
    if (evt.keyCode == 13) {
      this.handleSubmit()
    }
  }

  handleChange(e) {
    let value = e.target.value
    let name = e.target.name
    this.setState({[name]: value})
  }

  handleSubmit() {
    let data = {
      email: this.state.username,
      pwd: this.state.password
    }
    if (data.email == "") {
      message.error("请输入用户名", 2)
    }
    else if (data.pwd == "") {
      message.error("请输入密码", 2)
    }
    else {
      this.props.dispatch(getLogin(data))
    }
  }

  render() {
    const formItemLayout = {
      labelCol: {span: 6},
      wrapperCol: {span: 14},
    }
    const FormItem = Form.Item
    return (
      <div className="loginContainer">
        <Icon type="apple" className="logo"/>
        <h2>eeInBuptWeb登录</h2>
        <Form horizontal className="loginForm">
          <FormItem
            {...formItemLayout}
            label="用户名">
            <Input onChange={this.handleChange.bind(this)} name="username"/>
          </FormItem>
          <FormItem
            {...formItemLayout}
            label="密码">
            <Input type="password" onChange={this.handleChange.bind(this)} name="password"/>
          </FormItem>
          <FormItem
            wrapperCol={{offset:6, span:14}}>
            <Button
              type="primary"
              onClick={this.handleSubmit.bind(this)}>
              登&nbsp;&nbsp;录
            </Button>
            <a src="">注册</a>
          </FormItem>
        </Form>
      </div>
    )
  }

}
Login.propTypes = {
  login: PropTypes.shape({}).isRequired
}
function mapStateToProps(state) {
  return {
    login: state.login
  }
}

export default connect(mapStateToProps)(Login)