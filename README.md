# Cordova plugin for the [Google Fit](https://developers.google.com/fit/) (SDK)

Status: WIP

**TODO**

* Check if we can simplify the gradle-extras script and extend it automatically with a cordova plugin.xml option.


## Requires

* Java JDK 1.6 or greater
* [Android SDK](http://developer.android.com)
* Installed Android Platform and Google Play Services (see next step)

## Prepare project

Within your cordova android project create or extend the file `platforms/android/build-extras.gradle`
with the [Google Play Services](https://developers.google.com/android/guides/setup)
or the Google Fit dependency:

	dependencies {
		compile 'com.google.android.gms:play-services:7.0.0+'
	}

or

	dependencies {
		compile 'com.google.android.gms:play-services-fitness:7.0.0+'
	}

**Hint:** The Google Play Services will not be downloaded from a central Maven
repository. Instead you can download them manuelly with the `android` program.

* On OSX with Android Studio just open `~/Library/Android/sdk/tools/android`
* Then install the latest version of `Extras &gt; Google Play Services`

The downloaded files are available under within the SDK, for example.

	~/Library/Android/sdk/extras/google/m2repository/com/google/android/gms

List installed library variants:

	find ~/Library/Android/sdk/extras/google/m2repository/com/google/android/gms -iname '?.?.?' | sed 's/.*gms.//'


## Debug the plugin

This plugin will call your success or failure callbacks for any javascript function.
For debugging it uses the [Android Log](http://developer.android.com/tools/debugging/debugging-log.html)
command with the tag `GoogleFit` so you can filter all relevant debug information with
[logcat](http://developer.android.com/tools/help/logcat.html):

	adb logcat -s GoogleFit:d


## Development

To build this plugin you need the Cordova Plugin downloaded with NPM: `npm install`

After that you can build and verified it, incl. [Android Lint](http://developer.android.com/tools/debugging/improving-w-lint.html),
with `./gradlew build`.

