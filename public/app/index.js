/**
 * Created by josephi on 2016/12/18.
 */
import 'babel-polyfill'
import React from 'react'
import { render } from 'react-dom'
import { Provider } from 'react-redux'
import { Router, Route, browserHistory, IndexRoute } from 'react-router'

import configureStore from './store/configureStore'
import './stylesheets/index.scss'

import Dashboard from './pages/Index/index'
import Login  from './pages/Login/Login';

const store = configureStore()
render(
  <Provider store={store}>
    <Router history={browserHistory}>
      <Route path="/" component={Login}>
      <Route path="login" component={Login}/>
      <Route path="register"/>
      </Route>
      <Route path='/eeInBuptWeb/dashboard' component={Dashboard}/>
    </Router>
  </Provider>,
  document.getElementById('root')
);
