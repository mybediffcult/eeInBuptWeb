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

import APP from './pages/Index/index'

const store = configureStore()
render(
  <Provider store={store}>
    <Router history={browserHistory}>
      <Route path='/eeInBuptWeb/dashboard' component={APP}/>
    </Router>
  </Provider>,
  document.getElementById('root')
);
