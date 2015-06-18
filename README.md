# Cordova plugin for the [Google Fit](https://developers.google.com/fit/) (SDK)

Status: WIP

**TODO**

[ ] Check if we can simplify the gradle-extras script and extend it automatically with a cordova plugin.xml option.


## Requirements

* Java JDK 1.7 / 7 or greater
* [Android SDK](http://developer.android.com)
* Installed Android Platform and Google Play Services (see next step) within the Android SDK
* A [Google Developer Console](https://console.developers.google.com/) project
  with enabled "Fitness API" and a client certificate.

> **NOTICE:** The Google Developer Project is required for any developer which will
> deploy the app on a local device -- or you share the APK signing key.
> 
> (See section about Application Client ID and certificate fingerprint below.)

For more information please read the [Google Fit Getting Started on Android](https://developers.google.com/fit/android/get-started) documention.

## Prepare your project

### Install plugin

	cordova plugin add https://github.com/ilovept/cordova-plugin-googlefit.git

Or, while developing:

	cordova plugin rm de.ilpt.plugins.googlefit && cordova plugin add ../cordova-plugin-googlefit

### Add Google Play Services dependency

Within your cordova android project create or extend the file
`platforms/android/build-extras.gradle`
with the [Google Play Services](https://developers.google.com/android/guides/setup)
or the Google Fit dependency:

	dependencies {
		compile 'com.google.android.gms:play-services:7.5.0'
	}

or

	dependencies {
		compile 'com.google.android.gms:play-services-fitness:7.5.0'
	}

Also update the `platforms/android/build.gradle` Java version from

	    compileOptions {
	        sourceCompatibility JavaVersion.VERSION_1_6
	        targetCompatibility JavaVersion.VERSION_1_6
	    }

to

	    compileOptions {
	        sourceCompatibility JavaVersion.VERSION_1_7
	        targetCompatibility JavaVersion.VERSION_1_7
	    }

> **NOTICE:** The Google Play Services will not be downloaded from a central Maven
> repository. Instead you can download them manuelly with the `android` program.

### Download Google Play Services

* On OSX with Android Studio just open `~/Library/Android/sdk/tools/android`
* Then install the latest version of `Extras > Google Play Services`

The downloaded files are available under within the SDK, for example.

	~/Library/Android/sdk/extras/google/m2repository/com/google/android/gms

List installed library variants:

	find ~/Library/Android/sdk/extras/google/m2repository/com/google/android/gms -iname '?.?.?' | sed 's/.*gms.//'


## Application client ID and certificate

1. Create a project within the [Google Developer Console](https://console.developers.google.com/)
2. Enable the "APIs → Auth" → "APIs" → "Fitness API"
3. Create a Client ID and submit your signing identity (fingerprint):

Create a SHA1 fingerprint of the certificate you use to sign your APK. For developers this
is, in most cases, automatically generated and stored in `~/.android/debug.keystore`.

	keytool -exportcert -alias androiddebugkey -keystore ~/.android/debug.keystore -list -v

Create a new "APs &amp; Auth" → "Credentials" → "OAuth - "Create new Client ID" and select
"Installed Application" → "Android". (Probably you must create a consent screen first..)

Enter your app package name which you find in your cordova.xml or in `platforms/android/AndroidManifest.xml` (as package attribute) and your signing fingerprint.

> **NOTICE:** It is NOT required to provide this information anywhere within your app. :)


## Debug the plugin

This plugin will call your success or failure callbacks for any javascript function.
For debugging it uses the [Android Log](http://developer.android.com/tools/debugging/debugging-log.html)
command with the tag `GoogleFit` so you can filter all relevant debug information with
[logcat](http://developer.android.com/tools/help/logcat.html):

	adb logcat -s GoogleFit:d

Or, if you want debug Cordova too:

	adb logcat -s GoogleFit:d CordovaActivity:d CordovaApp:d CordovaWebViewImpl:d CordovaInterfaceImpl:d CordovaBridge:d PluginManager:d Config:d


## Development

To build this project locally you need the Cordova Framework for Android which could
be easy downloaded via npm. Just run `npm install`. After that you can import the
project also with Android Studio.

You can build and verified it, incl. [Android Lint](http://developer.android.com/tools/debugging/improving-w-lint.html),
with `./gradlew build`.
