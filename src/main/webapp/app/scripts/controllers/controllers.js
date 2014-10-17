var ctrlModule = angular.module("controllers", []);

ctrlModule.controller("ProductCtrl", function($scope, $http) {
	$http.get("/testapp/api/products").success(function(products) {
		$scope.products = products;
	});
});