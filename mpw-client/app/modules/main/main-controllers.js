'use strict';

/* Controllers */

angular.module('mpw-client.main-controllers', ['mpw-client.main-authentication']).
   <!-- Login controller -->
    controller('LoginController', [ '$rootScope','$location','$scope','AuthenticationFactory','AuthenticationService',function($rootScope, $location, $scope, AuthenticationFactory, AuthenticationService) {


        console.log("Login Controller is called.");

        $scope.rememberMe = false;

        $scope.login = function() {
            AuthenticationService.authenticate($.param({username: $scope.username, password: $scope.password}), function(authenticationResult) {
                var authToken = authenticationResult.token;
                $rootScope.authToken = authToken;
                if ($scope.rememberMe) {
                    $cookieStore.put('authToken', authToken);
                }
                AuthenticationService.get(function(user) {
                    $rootScope.user = user;
                    $location.path("/");
                });
            });
        };
/*
   $scope.login = function(){

       //call authenticate
        var authenitcationResult = AuthenticationFactory.authenticate($scope.email, $scope.password);

       //show loading screen....


        authenitcationResult.then(function(result)
        {
            console.log("setting user profile path :"+result.data)

            //hide loading screen

            //load the data from result
            $rootScope.user = result.data;

            //move to the new location
            $location.path("/user/profile");

        }, function(result)
        {
            $location.path("/main/login");
            console.log("failed to login returning to the path:"+result);
        });
    }
*/
  }])
  .controller('SingupController', [function() {
        console.log("The signup controller is called.");
  }]).controller('MainController', [function() {
        console.log("The main controller is called.");
    }]);