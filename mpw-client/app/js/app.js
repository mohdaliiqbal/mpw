'use strict';


// Declare app level module which depends on filters, and services
angular.module('mpw-client', [
  'ngRoute',
  'mpw-client.filters',
  'mpw-client.services',
  'mpw-client.directives',
  'mpw-client.controllers'
]).
config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/', {templateUrl: 'partials/partial0.html', controller: 'MainController'});
	
	$routeProvider.when('/login', {templateUrl: 'partials/partial1.html', controller: 'LoginController'});
	
  $routeProvider.when('/signup', {templateUrl: 'partials/partial2.html', controller: 'SignupController'});
  $routeProvider.otherwise({redirectTo: '/view1'});
}]);
