angular.module('mpw-client.main',

        [ 'mpw-client.main-controllers','mpw-client.main-services']

    ).
    config(
        [ '$routeProvider', '$locationProvider', '$httpProvider', function($routeProvider, $locationProvider, $httpProvider) {


            //routes that can be handled by main module
    $routeProvider.when('/login', {
        templateUrl: './modules/main/partials/login.html',
        controller: 'LoginController'
    });
    $routeProvider.when('/signup', {
        templateUrl: './modules/main/partials/signup.html',
        controller: 'SignupController'
    });
    $routeProvider.otherwise({
        templateUrl:'./modules/main/partials/main.html',
        controller:'MainController'
    });




}]).run(function($rootScope, $location, $cookieStore, AuthenticationService) {

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

        var authToken = $cookieStore.get('authToken');
        if (authToken !== undefined) {
            $rootScope.authToken = authToken;
            AuthenticationService.get(function(user) {
                $rootScope.user = user;
                $location.path(originalPath);
            });
        }

        $rootScope.initialized = true;
    });
;