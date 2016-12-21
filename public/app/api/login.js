/**
 * Created by liaojianjun on 2016/7/27.
 */
import fetch from 'isomorphic-fetch'
import {message} from 'antd'
import {browserHistory} from 'react-router'
export  default{
    login(data, cb){
      browserHistory.push('/eeInBuptWeb/dashboard');
      message.success('登录成功！');
        let formData = new FormData();
        for (name in data) {
            formData.append(name, data[name]);
        }
        fetch('/feeler2/login/submit', {
            method: 'POST',
            credentials: 'same-origin',
            body: formData
        })
            .then(response => {
                return response.json()
            .then(json => {
                switch (json.errCode) {
                    case 0:
                      message.success('登录成功！');
                      browserHistory.push('/eeInBuptWeb/dashboard');
                        cb(json.data);
                        break;
                    case 1001000:
                        message.error("用户不存在");
                        break;
                    case 1001001:
                        message.error("密码错误");
                        break;
                    default:
                        message.error(json.msg);
                        break;
                }
            });
            });
    }
}