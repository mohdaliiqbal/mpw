'use strict';

/* Services */


// Demonstrate how to register services
// In this case it is a simple value service.
var mainServices = angular.module('mpw-client.main-authentication', ['$ngResource']);

mainServices.factory('AuthenticationFactory',['$http', function ($http) {

        var authenticate = function(email, password)
        {
            //returning data
            var authenticatedUser;
            var isAuthenticated = false;
            var message = "";

            var promise = $http.post("http://localhost:8080/api/v01/users/authenticate",

         {
                email:email,
                password: password
        })
                .success(function(data, status, headers, config)
                {
                    isAuthenticated = true;
                    authenticatedUser = data.user;
                    if(authenticatedUser==null)
                        message = "Authentication failed";
                    else
                        message = "Authenticated successfully";
                    console.log("Success authentication:"+message);
                    return {authenticated:isAuthenticated, user:authenticatedUser, msg:message}
                })
                .error(function(data, status )
                {
                    isAuthenticated = false;
                    authenticatedUser =null;
                    message = "Failed to authenticate, please try again.";

                    console.log("Failed authentication");

                    return {authenticated:isAuthenticated, user:authenticatedUser, msg:message}
                }
            )

            return promise;
        }
        return {'authenticate':authenticate};
    }]);

mainServices.factory('AuthenticationService',['$resource', function($resource) {

        return $resource('http://localhost:8080/api/v01/users/:action', {},
            {
                authenticate: {
                    method: 'POST',
                    params: {'action' : 'authenticate'},
                    headers : {'Content-Type': 'application/x-www-form-urlencoded'}
                }
            }
        );
    }]);
