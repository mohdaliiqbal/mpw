'use strict';


// Declare app level module which depends on filters, and services
angular.module('mpw-client', [
  'ngRoute',
  'mpw-client.filters',
  'mpw-client.services',
  'mpw-client.directives',
  'mpw-client.controllers',
  'mpw-client.main',
  'mpw-client.user',
  'angularShamSpinner',
  'ui.bootstrap',
  'ngCookies'
]).
config(['$routeProvider', '$httpProvider', '$locationProvider', function( $routeProvider, $httpProvider, $locationProvider) {
  $routeProvider.when('/', {templateUrl: './modules/main/partials/main.html', controller: 'MainController'});
  $routeProvider.otherwise({templateUrl: './modules/main/partials/main.html', controller: 'MainController'});


        //$locationProvider.hashPrefix('!');

        /* Register error provider that shows message on failed requests or redirects to login page on
         * unauthenticated requests */
        $httpProvider.interceptors.push(function ($q, $rootScope, $location) {
                return {
                    'responseError': function(rejection) {
                        var status = rejection.status;
                        var config = rejection.config;
                        var method = config.method;
                        var url = config.url;

                        if (status == 401 || status ==0) {
                            $location.path( "/login" );
                        }
                        else{
                                $rootScope.error = method + " on " + url + " failed with status " + status;

                        }

                        return $q.reject(rejection);
                    }
                };
            }
        );

        /* Registers auth token interceptor, auth token is either passed by header or by query parameter
         * as soon as there is an authenticated user */
        $httpProvider.interceptors.push(function ($q, $rootScope, $location) {
            return {
                'request': function(config) {

                    if (angular.isDefined($rootScope.authToken)) {
                        var authToken = $rootScope.authToken;
                        if (mpwConfig.useAuthTokenHeader) {
                            config.headers['X-Auth-Token'] = authToken;
                        } else {
                            config.url = config.url + "?token=" + authToken;
                        }
                    }
                    return config || $q.when(config);
                }
            };
        });



    }
]);
