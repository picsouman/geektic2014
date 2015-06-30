var app = angular.module("geektic", ['ngRoute']);

// CONTROLLERS
app.controller('HelloCtrl', function($scope, $http) {
    $http.get('/api/hello').success(function(helloMessage) {
        $scope.helloMessage = helloMessage;
    });
    
    $http.get('/api/search/hobbies').success(function(result) {
    	$scope.hobbieList = result;
    });
});

app.controller('userList', function($scope, $http) {
	$http.get('/api/search/users').success(function(result) {
		$scope.userList = result;
	});
});

app.controller('userDetails', function($scope,$http,$routeParams) {
	$http.get('/api/search/users/' + $routeParams.id).success(function(result) {
		$scope.userDetails = result;
	});
});

app.controller('userFilter', function($scope,$http) {
	$scope.filterLoad = function(filter) {
			$http.post('/api/search/users/filter', filter).success(function(result) {
			$scope.userList = result;
		});
	};
});

// PARTIALS
app.config(['$routeProvider', function($routeProvider) {
    $routeProvider.when('/', {	controller : "userList",
    							templateUrl : 'partials/userList.html'
    }).when('/userDetails/:id', { 	controller : "userDetails",
    								templateUrl : 'partials/userDetails.html'
	});
}]);