/**
 * Created by Ali on 3/24/14.
 */
'use strict';

/* Services */


// Demonstrate how to register services
// In this case it is a simple value service.
angular.module('mpw-client.user-services', []).factory('UserFactory',['$http', function ($http) {

    return {'authenticate':false};
}]);
