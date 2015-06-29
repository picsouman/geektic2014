var app = angular.module("geektic", ['ngRoute']);

// CONTROLLERS
app.controller('HelloCtrl', function($scope, $http) {
    $http.get('/api/hello').success(function(helloMessage) {
        $scope.helloMessage = helloMessage;
    });
});

app.controller('userList', function($scope, $http) {
	$http.get('/api/search/users').success(function(result) {
		$scope.userList = result;
	});
});

app.controller('userDetails', function($scope,$http,$routeParams) {
	$http.get('/api/search/users/' $routeParams.idKeyUser).success(function(result) {
		$scope.userDetails = result;
	});
});



// PARTIALS
app.config(['$routeProvider', function($routeProvider) {
    $routeProvider.when('/', {	controller : "userList",
    							templateUrl : 'partials/userList.html'
    });
}]);

app.config(['$routeProvider', function($routeProvider) {
	$routeProvider.when('/userDetails', {	controller : "userDetails",
											templateUrl : "partials/userDetails.html"
	});
}]);