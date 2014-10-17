describe("ProductCtrl", function() {
	var scope, ctrl, mockBackend;

	beforeEach(function() {
		module('controllers');
	});

	beforeEach(inject(function(_$httpBackend_, $rootScope, $controller) {
		mockBackend = _$httpBackend_;
		mockBackend.expectGET("/testapp/api/products").respond(["1", "2"]);
		scope = $rootScope.$new();

		ctrl = $controller("ProductCtrl", {
			$scope : scope
		});
	}));

	it("should fetch products from server", function() {
		expect(scope.products).toBeUndefined();
		mockBackend.flush();
		expect(scope.products).toEqual(["1", "2"]);
	});

});