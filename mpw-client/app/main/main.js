angular.module('myApp.main', [ ])
    .config(function ($routeProvider) {
    $routeProvider.when('/login',
        templateUrl: 'main/login.html',
        controller: 'LoginController',
        resolve: {
        newsItems: function ($http) {
            return $http.get('api/news');
        }
    }
})
}).controller('HomeController', function ($scope, newsItems) {
    $scope.newsItems = newsItems;
});