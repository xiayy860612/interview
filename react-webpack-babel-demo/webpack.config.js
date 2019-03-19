const path = require('path');
const HtmlWebpackPlugin = require('html-webpack-plugin');
const webpack = require('webpack')

const ROOT_PATH = path.resolve(__dirname);
const APP_PATH = path.resolve(ROOT_PATH, 'src');
const BUILD_PATH = path.resolve(ROOT_PATH, 'dist');

module.exports = {
  // mode: 'development',
  entry: path.resolve(APP_PATH, 'app.jsx'),
  output: {
    path: BUILD_PATH,
    filename: 'bundle.js',
  },
  devtool: 'eval-source-map',
  devServer: {
    historyApiFallback: true,
    hot: true,
    inline: true,
    progress: true,
  },
  module: {
    rules: [
      {
        test: /\.(js|jsx)?$/,
        loader: ['eslint-loader'],
        include: APP_PATH,
        enforce: 'pre',
      },
      {
        test: /\.css$/,
        use: [
          'style-loader',
          'css-loader',
        ],
      },
      {
        test: /\.(js|jsx)$/,
        exclude: /node_modules/,
        loader: 'babel-loader',
      },
    ],
  },
  resolve: {
    extensions: ['.js', '.jsx'],
  },
  plugins: [
    new HtmlWebpackPlugin({
      title: 'use plugin',
    }),
    new webpack.HotModuleReplacementPlugin(),
  ],
};
