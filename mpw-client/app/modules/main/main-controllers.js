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

                $rootScope.userId = authenticationResult.userId;
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
                $scope.authenticationMessage= "*"+ authenticationFailureResult.data.message;
            }
            );
        };


  }])
  .controller('SignupController', ['$rootScope','$scope','$location','$filter','SignupService', 'GeoNameCountryNameService', function($rootScope, $scope, $location, $filter, SignupService, GeoNameCountryNameService) {
        console.log("The signup controller is called.");

        /*initialize the things required by signup page*/
        $scope.user = {};

        GeoNameCountryNameService.get(function(countrySuccessResults)
        {
            console.log(countrySuccessResults.data);
            $scope.countries = countrySuccessResults.geonames;
        },
        function(countryFailedResult)
        {
            console.log(countryFailedResult.data);
        });



        $scope.signup = function()
        {
            console.log("User :"+$scope.user);

            //converting the date format to something acceptable by server
            $scope.user.birthdate = $filter('date')($scope.birthdate, "yyyy-MM-dd");

            //getting first name and last name
            if( $scope.fullName == undefined || $scope.fullName == ""   )
            {
                $scope.signupMessage = "Please enter your full name in Full name box";
                return;
            }

            //getting first name and last name
            if( $scope.user.userId == "" )
            {
                $scope.signupMessage = "Please enter user name in user name box";
                return;
            }

            $scope.user.firstName = $scope.fullName.split(' ').slice(0, -1).join(' ');
            $scope.user.lastName = $scope.fullName.split(' ').slice(-1).join(' ');

            //simple validation for password and confirmation
            if( $scope.password2 != $scope.user.password )
            {
                $scope.signupMessage = "Password and confirm password do not match.";
                return;
            }

            //calling signup service on the server
            SignupService.signup($scope.user, function(signupResult) {
                    $location.path("/login");

                }, function(signupFailureResult)
                {
                    $scope.signupMessage= "*"+ signupFailureResult.data.message;
                }
            );
        }





  }]).controller('MainController', [function() {
        console.log("The main controller is called.");
}]);