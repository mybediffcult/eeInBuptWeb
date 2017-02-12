/**
 * Created by liaojianjun on 2016/7/27.
 */
import {
    RECEIVE_LOGIN,REQUEST_LOGIN
}from '../actions/ActionsTypes';

import {message} from 'antd';

const initialState = {
  login:{}
}
export function login(state=initialState.login,action) {
    switch (action.type){
      case RECEIVE_LOGIN:
            return Object.assign({},state,action.login);
        default:
            return state
    }
}