module.exports = function(grunt) {

    grunt.initConfig({
        pkg: grunt.file.readJSON('package.json'),
 
        karma: {
            unit: {
                configFile: 'test/karma.conf.js'
            }
        },
        protractor: {
            options: {
                  configFile: "test/e2e/conf.js", //your protractor config file
                  keepAlive: false, // If false, the grunt process stops when the test fails.
                  noColor: false, // If true, protractor will not use colors in its output.
                  args: {
                      // Arguments passed to the command
                  }
              },
            chrome: {
                options: {
                      args: {
                          browser: "chrome"
                      }
                  }
            }
        }
    });
 
    grunt.loadNpmTasks('grunt-karma');
    grunt.loadNpmTasks('grunt-protractor-runner');
};