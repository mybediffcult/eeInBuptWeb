import {REQUEST_LOGIN, RECEIVE_LOGIN} from './ActionsTypes';

import login from '../api/login';
import {message} from 'antd';

export function getLogin(data) {
  return dispatch =>{
       message.loading('登录中...');
        login.login(data,config=>{
            dispatch({
                type:RECEIVE_LOGIN,
                config:config
            })
        })
    }   
}



