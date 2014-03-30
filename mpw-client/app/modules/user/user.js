/**
 * Created by Ali on 3/24/14.
 */
angular.module('mpw-client.user',

        [ 'mpw-client.main','mpw-client.user-controllers']

    ).
    config(['$routeProvider', function($routeProvider) {

        //register the routes user module can handle.
        $routeProvider.when('/user/profile', {templateUrl: './modules/user/partials/profile.html', controller: 'ProfileController'});
        $routeProvider.when('/user/settings', {templateUrl: './modules/user/partials/settings.html', controller: 'SettingsController'});
    }]);
