'use strict';

/* Controllers */

angular.module('mpw-client.main-controllers', ['mpw-client.main-authentication']).
    controller('LoginController', [ '$rootScope','$location','$scope','$cookieStore','AuthenticationService',function($rootScope, $location, $scope,$cookieStore, AuthenticationService) {
        <!-- Login controller -->

        console.log("Login Controller is called.");

        $scope.rememberMe = false;

        $scope.login = function() {
            AuthenticationService.authenticate($.param({"email": $scope.username, "password"    : $scope.password}), function(authenticationResult) {
                var authToken = authenticationResult.token;
                $rootScope.authToken = authToken;
                if ($scope.rememberMe) {
                    $cookieStore.put('authToken', authToken);
                }

                $location.path("/user/profile");
                /*
                AuthenticationService.get(function(user) {
                    $rootScope.user = user;
                    $location.path("/user/profile");
                }); */
            });
        };
  }])
  .controller('SingupController', [function() {
        console.log("The signup controller is called.");
  }]).controller('MainController', [function() {
        console.log("The main controller is called.");
}]);