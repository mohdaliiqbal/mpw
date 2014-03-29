'use strict';

/* Controllers */

angular.module('mpw-client.main-controllers', ['mpw-client.main-services']).
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
            }, function(authenticationFailureResult)
            {
                authenticationFailureResult.message;
                $scope.authenticationMessage= "*"+ authenticationFailureResult.data.message;
            }
            );
        };


  }])
  .controller('SignupController', ['$rootScope','$scope','$location','SignupService', function($rootScope, $scope, $location, SignupService) {
        console.log("The signup controller is called.");

        /*initialize the things required by signup page*/
        $scope.user = {};

        $scope.signup = function()
        {
            SignupService.signup($scope.user, function(signupResult) {

                    $location.path("/login");

                }, function(signupFailureResult)
                {
                    signupFailureResult.message;
                    $scope.signupMessage= "*"+ signupFailureResult.data.message;
                }
            );
        }

  }]).controller('MainController', [function() {
        console.log("The main controller is called.");
}]);