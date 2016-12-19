/**
 * Created by josephi on 2016/12/18.
 */
import 'babel-polyfill'
import React from 'react'
import { render } from 'react-dom'
import { Provider } from 'react-redux'
import { Router, Route, browserHistory, IndexRoute } from 'react-router'

import configureStore from './store/configureStore'
import './stylesheets/styles.scss'
import routes from "./route"

const store = configureStore()
render(
  <Provider store={store}>
    <Router
      history={browserHistory}
      routes={routes}
    >
    </Router>
  </Provider>,
  document.getElementById('root')
);
