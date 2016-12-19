var path = require('path');
var webpack = require('webpack');
var autoprefixer = require('autoprefixer');

var NODE_MODULE_PATH = path.join(__dirname, 'node_modules');
var LOGIN_PATH=path.join(__dirname,'public/login/javascripts');
var APP_PATH=path.join(__dirname,'public/app/javascripts');

var isProduction = process.env.NODE_ENV === 'production';

module.exports = {
  devtool: isProduction ? false : 'inline-source-map',
  entry: {
    //app: [path.resolve(APP_PATH, 'index.js')],
    login:[path.resolve(LOGIN_PATH,'index.js')]
  },
  output: {
    path: path.join(__dirname, 'dist'),
    filename: '[name].js',
    publicPath: '/dist/'
    // publicPath: 'http://localhost:8080/assets/'
  },
  plugins: isProduction ? [
    new webpack.optimize.UglifyJsPlugin({
      compress: {
        warnings: false
      }
    })
  ] : [
    new webpack.HotModuleReplacementPlugin()
  ],
  module: {
    loaders: [
      {
        test: /\.js$/,
        loaders: ['babel?presets[]=es2015&presets[]=es2017&presets[]=react'],
        exclude: /node_modules/,
      },
      {
        test: /\.s?css$/,
        loader: 'style!css!sass'
      }, {
        test: /\.(png|jpg|gif)$/,
        loader: 'url-loader?limit=8192'
      }
    ]
  },
  postcss: [autoprefixer],
  externals: {
    'moment': 'moment',
    'react': 'React',
    'react-dom': 'ReactDOM',
    'babel-polyfill': 'true',
    'antd': "antd"
  },
  resolve: {
    alias: {
      'redux': path.resolve(NODE_MODULE_PATH, "redux/dist/redux.min.js"),
      'react-redux': path.resolve(NODE_MODULE_PATH, "react-redux/dist/react-redux.min.js")
    }
  },
  devServer: {
    historyApiFallback: true,
    hot: true,
    inline: true,
    progress: true,
    host: '0.0.0.0',
    port: 9999,
    contentBase: '',
    proxy: {
      '/dolores/user/*': {
        //target: 'http://10.1.29.249:30315',
        //target: 'http://10.1.29.250:30315',
        target: 'http://flowdev.neoap.com',
        secure: false,
        changeOrigin: true
      }
    }
  }
};