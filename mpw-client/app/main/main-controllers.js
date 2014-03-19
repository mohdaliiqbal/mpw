'use strict';

/* Controllers */

angular.module('myApp.main-controller', []).

  controller('LoginController', [function() {
 console.log("Login Controller is called.");
  }])
  .controller('SingupController', [function() {
        console.log("The signup controller is called.");
  }]);