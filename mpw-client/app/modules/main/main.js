angular.module('mpw-client.main',

        [ 'mpw-client.main-controllers','mpw-client.main-authentication']

    ).
    config(
        [ '$routeProvider', '$locationProvider', '$httpProvider', function($routeProvider, $locationProvider, $httpProvider) {


            //routes that can be handled by main module
    $routeProvider.when('/login', {
        templateUrl: './modules/main/partials/login.html',
        controller: 'LoginController'
    });
    $routeProvider.when('/signup', {
        templateUrl: './modules/main/partials/register.html',
        controller: 'SignupController'
    });
    $routeProvider.otherwise({
        templateUrl:'./modules/main/partials/main.html',
        controller:'MainController'
    });



    $locationProvider.hashPrefix('!');

    /* Register error provider that shows message on failed requests or redirects to login page on
     * unauthenticated requests */
    $httpProvider.interceptors.push(function ($q, $rootScope, $location) {
            return {
                'responseError': function(rejection) {
                    var status = rejection.status;
                    var config = rejection.config;
                    var method = config.method;
                    var url = config.url;

                    if (status == 401) {
                        $location.path( "/login" );
                    } else {
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
                var isRestCall = config.url.indexOf('rest') == 0;
                if (isRestCall && angular.isDefined($rootScope.authToken)) {
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

}]).run(function($rootScope, $location, $cookieStore, UserService) {

        /* Reset error when a new view is loaded */
        $rootScope.$on('$viewContentLoaded', function() {
            delete $rootScope.error;
        });

        $rootScope.hasRole = function(role) {

            if ($rootScope.user === undefined) {
                return false;
            }

            if ($rootScope.user.roles[role] === undefined) {
                return false;
            }

            return $rootScope.user.roles[role];
        };

        $rootScope.logout = function() {
            delete $rootScope.user;
            delete $rootScope.authToken;
            $cookieStore.remove('authToken');
            $location.path("/login");
        };

        /* Try getting valid user from cookie or go to login page */
        var originalPath = $location.path();
        $location.path("/login");
        var authToken = $cookieStore.get('authToken');
        if (authToken !== undefined) {
            $rootScope.authToken = authToken;
            UserService.get(function(user) {
                $rootScope.user = user;
                $location.path(originalPath);
            });
        }

        $rootScope.initialized = true;
    });
;