var path = require('path')
var webpack = require('webpack')
var autoprefixer = require('autoprefixer');

var CUSTOMER_PATH = path.join(__dirname,'public/javascript/customer')
var MOBILE_PATH = path.join(__dirname,'public/javascript/mobile')
var SHITANG_PATH = path.join(__dirname,'public/javascript/shitang')
var ADMIN_PATH = path.join(__dirname,'public/javascript/admin')
var NODE_MODULE_PATH = path.join(__dirname,'node_modules')
var WAITER_APP_PATH=path.join(__dirname,'public/javascript/waiter/app')
var WAITER_LOGIN_PATH=path.join(__dirname,'public/javascript/waiter/login')

var isProduction = process.env.NODE_ENV === 'production';


module.exports = {
  devtool: isProduction?false:'source-map',
  entry: isProduction?{
    shitang: [path.resolve(SHITANG_PATH, 'index.js')],
    // admin: path.resolve(ADMIN_PATH, 'index.js'),
    // customer: [path.resolve(CUSTOMER_PATH, 'index.js')],
    // mobile: [path.resolve(MOBILE_PATH, 'index.js')],
    // waiterApp:[path.resolve(WAITER_APP_PATH,'index.js')],
    // waiterLogin:[path.resolve(WAITER_LOGIN_PATH,'index.js')],
    //vendors: ['react', 'moment']
  }:{
     // shitang:['webpack/hot/dev-server',
     //  'webpack-dev-server/client?http://localhost:9999',
     //    path.resolve(SHITANG_PATH, 'index.js')
     // ],
     // waiterApp:['webpack/hot/dev-server',
     //   'webpack-dev-server/client?http://localhost:9999',
     //   path.resolve(WAITER_APP_PATH, 'index.js')
     // ],
    // waiterLogin:['webpack/hot/dev-server',
    //   'webpack-dev-server/client?http://localhost:9999',
    //   path.resolve(WAITER_LOGIN_PATH, 'index.js') 
    // ],
    admin: ['webpack/hot/dev-server',
     'webpack-dev-server/client?http://localhost:9999',
     path.resolve(ADMIN_PATH, 'index.js')
    ]
  },
  output: {
    path: path.join(__dirname, 'public/dist/'),
    filename: isProduction?'[name].[hash].js':'[name].js',
    publicPath: isProduction?'/miami/assets/dist/':'/public/dist/'
  },
  plugins: isProduction?[
    new webpack.optimize.UglifyJsPlugin({
      compress:{
        warnings: false
      }
    })
  ]:[
    new webpack.HotModuleReplacementPlugin()
  ],

  module: {
    loaders: [
      {
        test: /\.js$/,
        loaders: ['babel?presets[]=es2015&presets[]=react'],
        exclude: /node_modules/
      },
      {
        test: /\.s?css$/,
        loader: 'style!css!sass!postcss'
      },
      {
        test: /\.(png|jpg|gif)$/,
        loader: 'url-loader?limit=8192'
      }
    ]
  },
  postcss:[autoprefixer],
  externals: {
    'moment': 'moment',
    'react': 'React',
    'react-dom':'ReactDOM',
    'babel-polyfill': 'true',
    'antd':"antd"
  },
  resolve: {
    alias: {
      'redux': path.resolve(NODE_MODULE_PATH,"redux/dist/redux.min.js"),
      'react-redux': path.resolve(NODE_MODULE_PATH,"react-redux/dist/react-redux.min.js")
    }
  },
  devServer: {
    historyApiFallback: true,
    hot: true,
    inline: true,
    progress: true,
    host: '0.0.0.0',
    port: 9999,
    contentBase:'',
    proxy: {
      '/miami/customer/*': {
        target: 'http://www.chinaworldstyle.com',
        // target: 'http://10.1.29.249:30227',
        //target: 'http://124.205.118.164:30227',
        // target: 'http://buscome.neoap.com',
        secure: false,
        changeOrigin:true
      },
      '/terra/customer/auth/login*': {
        // target: 'http://www.chinaworldstyle.com',
        //target: 'http://10.1.29.249:30222',
        target: 'http://buscome.neoap.com',
        secure: false,
        changeOrigin:true
      },
      '/miami/login': {
        //target: 'http://10.1.29.249:30227',
        target: 'http://buscome.neoap.com',
        // target: 'http://www.chinaworldstyle.com',
        secure: false,
        changeOrigin:true
      },
      '/miami/admin/*': {
        //target: 'http://10.1.29.249:30227',
         target: 'http://buscome.neoap.com',
        // target: 'http://www.chinaworldstyle.com',
        secure: false,
        changeOrigin:true
      },
      '/miami/admin/login': {
        target: 'http://buscome.neoap.com',
        // target: 'http://www.chinaworldstyle.com',
        secure: false,
        changeOrigin:true
      },
      '/miami/waiter/*': {
        target: 'http://buscome.neoap.com',
        // target: 'http://www.chinaworldstyle.com',
        secure: false,
        changeOrigin:true
      },
      '/miami/waiter/login': {
        target: 'http://buscome.neoap.com',
        // target: 'http://www.chinaworldstyle.com',
        secure: false,
        changeOrigin:true
      },
      '/miami/assets/*': {
        target: 'http://www.chinaworldstyle.com',
        // target: 'http://10.1.29.249:30227',
        // target: 'http://buscome.neoap.com',
        secure: false,
        changeOrigin:true
      }
    }
  }
}
