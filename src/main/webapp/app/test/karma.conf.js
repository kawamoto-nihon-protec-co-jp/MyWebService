module.exports = function(config) {
	config.set({

		basePath : "../",

		files : ["bower_components/angular/angular.min.js",
				 "bower_components/angular-mocks/angular-mocks.js",
				 "scripts/**/*.js",
				 "test/spec/**/*.js"],

		autoWatch : false,
		singleRun : true,

		frameworks : [ 'jasmine' ],

		browsers : [ 'Chrome' ],

		plugins : [ 'karma-chrome-launcher', 'karma-jasmine' ],
	});
};
