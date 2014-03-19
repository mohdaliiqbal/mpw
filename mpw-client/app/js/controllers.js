'use strict';

/* Controllers */

angular.module('mpw-client.controllers', []).
  controller('LoginController', [function() {
 console.log("The Login controlller is called.");
  }])
  .controller('SignupController', [function() {
        console.log("The signup controlller s called.");
  }]).controller('MainController', [function() {
        console.log("The main controlller is called.");
  }]);