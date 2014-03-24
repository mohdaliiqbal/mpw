angular.module('mpw-client.main',

        [ 'mpw-client.main-controllers','mpw-client.main-authentication']

    ).
    config(['$routeProvider', function($routeProvider) {
    $routeProvider.when('/login', {templateUrl: './modules/main/partials/login.html', controller: 'LoginController'});
    $routeProvider.when('/signup', {templateUrl: './modules/main/partials/register.html', controller: 'SignupController'});
    $routeProvider.otherwise({templateUrl:'./modules/main/partials/main.html', controller:'MainController'});
}]);