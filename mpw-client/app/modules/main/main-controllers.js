'use strict';

/* Controllers */

angular.module('mpw-client.main-controllers', ['mpw-client.main-authentication']).
   <!-- Login controller -->
    controller('LoginController', [ '$rootScope','$location','$scope','AuthenticationFactory',function($rootScope, $location, $scope, AuthenticationFactory) {


        console.log("Login Controller is called.");



   $scope.login = function(){
        var authenitcationResult = AuthenticationFactory.authenticate($scope.email, $scope.password);
        authenitcationResult.then(function(result)
        {
            console.log("setting user profile path :"+result.data)
            $rootScope.user = result.data;
            $location.path("/user/profile");
        }, function(result)
        {
            $location.path("/main/login");
            console.log("failed to login returning to the path:"+result);
        });
    }

  }])
  .controller('SingupController', [function() {
        console.log("The signup controller is called.");
  }]).controller('MainController', [function() {
        console.log("The main controller is called.");
    }]);