
var cordova = require('cordova'),
    exec = require('cordova/exec');

var googlefit = {
	test: function(successCallback, failureCallback) {
		console.log('googlefit.test');
		exec(successCallback, failureCallback, 'GoogleFit', 'test', []);
	}
};

module.exports = googlefit;
