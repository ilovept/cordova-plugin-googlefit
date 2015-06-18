
package de.ilpt.plugins.googlefit;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.PluginResult;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;

import android.content.Intent;
import android.content.IntentSender;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;

import com.google.android.gms.fitness.*;
import com.google.android.gms.fitness.data.*;
import com.google.android.gms.fitness.request.*;
import com.google.android.gms.fitness.result.*;

public class GoogleFit extends CordovaPlugin implements
		GoogleApiClient.ConnectionCallbacks,
		GoogleApiClient.OnConnectionFailedListener,
		OnDataPointListener {

	private static final String TAG = "GoogleFit";

    private static final int REQUEST_OAUTH = 1;

	private GoogleApiClient googleApiClient;

	public void initGoogleApiClient() {
		Context context = null;
		googleApiClient = new GoogleApiClient.Builder(context)
				.useDefaultAccount()
				.addApi(Fitness.HISTORY_API)
				.addScope(new Scope(Scopes.FITNESS_ACTIVITY_READ_WRITE))
				.addConnectionCallbacks(this)
				.addOnConnectionFailedListener(this)
				.build();

		googleApiClient.connect();
	}

	public boolean execute(String action, JSONArray args, CallbackContext callbackContext) {

		Log.w(TAG, "execute " + action + " with arguments: " + args);

		initGoogleApiClient();

		callbackContext.success();

		return true;
	}

	@Override
	public void onConnected(Bundle connectionHint) {
		Log.w(TAG, "onConnected");
		// Connected to Google Fit Client.
		Fitness.SensorsApi.add(
				googleApiClient,
				new SensorRequest.Builder()
						.setDataType(DataType.TYPE_STEP_COUNT_DELTA)
						.build(),
				this);
	}

	@Override
	public void onConnectionSuspended(int cause) {
		Log.w(TAG, "onConnectionSuspended");
	}

	@Override
	public void onConnectionFailed(ConnectionResult result) {
		Log.w(TAG, "onConnectionFailed");
		
		// Error while connecting. Try to resolve using the pending intent returned.
		/*
		if (result.getErrorCode() == FitnessStatusCodes.NEEDS_OAUTH_PERMISSIONS) {
			try {
				result.startResolutionForResult(this, REQUEST_OAUTH);
			} catch (IntentSender.SendIntentException e) {
			}
		}
		*/
	}

	@Override
	public void onDataPoint(DataPoint dataPoint) {
		Log.w(TAG, "onDataPoint");
	}

//	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		Log.w(TAG, "onDataPoint");
		if (requestCode == REQUEST_OAUTH && resultCode == Activity.RESULT_OK) {
			googleApiClient.connect();
		}
	}

}
