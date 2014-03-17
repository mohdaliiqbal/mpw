'use strict';

/* Controllers */

angular.module('myApp.controllers', []).
  controller('MyCtrl1', [function() {
 console.log("The controlller 1 is called.");
  }])
  .controller('MyCtrl2', [function() {
        console.log("The controlller 2 is called.");
  }]);