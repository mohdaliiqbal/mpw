'use strict';

/* Filters */

angular.module('myApp.filters', []).
  filter('interpolate', ['version', function(version) {
        console.log("version :"+version);
    return function(text) {
        console.log("text :"+text);
      return String(text).replace(/\%VERSION\%/mg, version);
    }
  }]);
