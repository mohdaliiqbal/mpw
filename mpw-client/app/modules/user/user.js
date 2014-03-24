/**
 * Created by Ali on 3/24/14.
 */
angular.module('mpw-client.user',

        [ 'mpw-client.main','mpw-client.user-controllers']

    ).
    config(['$routeProvider', function($routeProvider) {
        $routeProvider.when('/user/profile', {templateUrl: './modules/user/partials/profile.html', controller: 'LoginController'});
        $routeProvider.when('/user/settings', {templateUrl: './modules/user/partials/settings.html', controller: 'SignupController'});
        $routeProvider.otherwise({templateUrl:'./modules/main/partials/main.html', controller:'MainController'});
    }]);
