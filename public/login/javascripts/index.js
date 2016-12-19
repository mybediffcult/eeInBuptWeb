import 'babel-polyfill';
import React from 'react';
import { render } from 'react-dom';
import { Router, Route, hashHistory} from 'react-router';
import { Provider } from 'react-redux';
import configureStore from './store/configureStore';

//组件
import Login  from './pages/Login';

const store = configureStore();

render(
    <Provider store={store}>
        <Router history={hashHistory}>
                <Route path="/" component={Login}/>
        </Router>
    </Provider>,
    document.getElementById('root')
);