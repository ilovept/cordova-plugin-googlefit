
package de.ilpt.plugins.googlefit;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.PluginResult;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;

public class GoogleFit extends CordovaPlugin {

	private static final String TAG = "GoogleFit";

	public boolean execute(String action, JSONArray args, CallbackContext callbackContext) {

		Log.w(TAG, "execute " + action + " with arguments: " + args);

		callbackContext.success();

		return true;
	}
}
