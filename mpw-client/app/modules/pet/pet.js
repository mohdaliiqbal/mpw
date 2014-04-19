/**
 * Created by Imran.
 */
angular.module('mpw-client.pet',

        [ 'mpw-client.main','mpw-client.pet-controllers']

    ).
    config(['$routeProvider', function($routeProvider) {

        //register the routes user module can handle.
        $routeProvider.when('/pet/profile', {templateUrl: './modules/pet/partials/profile.html', controller: 'ProfileController'});
        $routeProvider.when('/pet/settings', {templateUrl: './modules/pet/partials/settings.html', controller: 'SettingsController'});
    }]);
