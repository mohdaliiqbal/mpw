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
  'ui.bootstrap'
]).
config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/', {templateUrl: './modules/main/partials/main.html', controller: 'MainController'});
  $routeProvider.otherwise({templateUrl: './modules/main/partials/main.html', controller: 'MainController'});
}]);
