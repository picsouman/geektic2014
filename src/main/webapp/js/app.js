var app = angular.module("geektic", ['ngRoute']);

// CONTROLLERS
app.controller('HelloCtrl', function($scope, $http) {
    $http.get('/api/hello').success(function(helloMessage) {
        $scope.helloMessage = helloMessage;
    });
});

app.controller('userList', function($scope, $http) {
	$http.get('/api/search').success(function(result) {
		$scope.userList = result;
	});
});


// PARTIALS
app.config(['$routeProvider', function($routeProvider) {
    $routeProvider.when('/', {	controller : "userList",
    							templateUrl : 'partials/userList.html'});
}])