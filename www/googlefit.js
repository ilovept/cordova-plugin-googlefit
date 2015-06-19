
var cordova = require('cordova'),
    exec = require('cordova/exec');

function GoogleFit() {
}

//
// GENERAL
//

// WIP:

GoogleFit.prototype.connect = function(successCallback, failureCallback) {
	exec(successCallback, failureCallback, 'GoogleFit', 'connect', []);
};

GoogleFit.prototype.query = function(successCallback, failureCallback) {
	exec(successCallback, failureCallback, 'GoogleFit', 'query', []);
};

// untested:

GoogleFit.prototype.available = function(successCallback, failureCallback) {
	exec(successCallback, failureCallback, 'GoogleFit', 'available', []);
};

GoogleFit.prototype.checkAuthStatus = function(options, successCallback, failureCallback) {
	exec(successCallback, failureCallback, 'GoogleFit', 'checkAuthStatus', [options]);
};

GoogleFit.prototype.requestAuthorization = function(options, successCallback, failureCallback) {
	exec(successCallback, failureCallback, 'GoogleFit', 'requestAuthorization', [options]);
};

GoogleFit.prototype.readDateOfBirth = function(successCallback, failureCallback) {
	exec(successCallback, failureCallback, 'GoogleFit', 'readDateOfBirth', []);
};

GoogleFit.prototype.readGender = function(successCallback, failureCallback) {
	exec(successCallback, failureCallback, 'GoogleFit', 'readGender', []);
};

//
// WEIGHT AND HEIGHT
//

/**
 * Healthkit option keys:
 * - date: Date
 * - requestWritePermission: Boolean
 * - unit: String -- 'kg', etc.
 */
GoogleFit.prototype.readWeight = function(options, successCallback, failureCallback) {
	exec(successCallback, failureCallback, 'GoogleFit', 'readWeight', [options]);
};

GoogleFit.prototype.saveWeight = function(options, successCallback, failureCallback) {
	// From HealthKit plugin
	if (options.date === undefined) {
		options.date = new Date()
	}
	if (typeof options.date == 'object') {
		options.date = Math.round(options.date.getTime() / 1000);
	}

	exec(successCallback, failureCallback, 'GoogleFit', 'saveWeight', [options]);
};

GoogleFit.prototype.readHeight = function(options, successCallback, failureCallback) {
	exec(successCallback, failureCallback, 'GoogleFit', 'readHeight', [options]);
};

GoogleFit.prototype.saveHeight = function(options, successCallback, failureCallback) {
	// From HealthKit plugin
	if (options.date === undefined) {
		options.date = new Date()
	}
	if (typeof options.date == 'object') {
		options.date = Math.round(options.date.getTime() / 1000);
	}

	exec(successCallback, failureCallback, 'GoogleFit', 'saveHeight', [options]);
};

//
// WORKAROUNDS
//

// TODO

/*
GoogleFit.prototype.findWorkouts = function (options, successCallback, errorCallback)
GoogleFit.prototype.saveWorkout = function (options, successCallback, errorCallback)
GoogleFit.prototype.monitorSampleType = function (options, successCallback, errorCallback)
GoogleFit.prototype.querySampleType = function (options, successCallback, errorCallback)
GoogleFit.prototype.queryCorrelationType = function (options, successCallback, errorCallback)
GoogleFit.prototype.saveQuantitySample = function (options, successCallback, errorCallback)
GoogleFit.prototype.saveCorrelation = function (options, successCallback, errorCallback)
GoogleFit.prototype.sumQuantityType = function (options, successCallback, errorCallback)
*/

module.exports = new GoogleFit();
