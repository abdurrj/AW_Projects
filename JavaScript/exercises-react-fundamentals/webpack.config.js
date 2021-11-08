var webpack = require('webpack');
var path = require('path');

// directories
var jsSrc = path.join(__dirname, '/src/');
var testsDir = path.join(__dirname, '/tests/');
var publicDir = path.join(__dirname, '/public/');

module.exports = {
  devtool: 'inline-source-map',

  entry: {
    'bundle-exercise': './src/exercises/__entry.js',
    'bundle-solution': './src/solutions/__entry.js'
  },

  output: {
    path: publicDir,
    publicPath: '/',
    filename: '[name].js'
  },

  plugins: [
    new webpack.OldWatchingPlugin()
  ],

  module: {
    loaders: [{
      test: require.resolve('react'),
      loader: 'expose?React'
    }, {
      test: /\.jsx?$/,
      loaders:  ['react-hot', 'babel'],
      include: [jsSrc, testsDir]
    }, {
      test: /\.css$/,
      loaders: ['style', 'css']
    }]
  }
};
