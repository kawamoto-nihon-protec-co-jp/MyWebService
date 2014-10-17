describe("Myapp", function() {
	it("should show 2 products", function() {
	    browser.get('http://localhost:8080/testapp/app/index.html');

	    expect(browser.getTitle()).toEqual('jersey-angular-test');
	    expect(element.all(by.repeater('product in products')).count()).toEqual(2);
	});
});