package de.ilpt.plugins.googlefit;

import android.os.Bundle;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;

import org.apache.cordova.CallbackContext;

/**
 * Created by christoph on 18.06.15.
 */
public class ConnectionCallback implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {

    private GoogleApiClient googleApiClient;
    private CallbackContext callbackContext;

    private boolean fulfilled = false;
    private boolean rejected = false;

    public ConnectionCallback(GoogleApiClient googleApiClient, CallbackContext callbackContext) {
        this.googleApiClient = googleApiClient;
        this.callbackContext = callbackContext;
        register();
    }

    @Override
    public void onConnected(Bundle bundle) {
        if (!fulfilled && !rejected) {
            callbackContext.success(Connection.getStatusString(ConnectionResult.SUCCESS));
        }
        unregister();
    }

    @Override
    public void onConnectionSuspended(int cause) {
        if (!fulfilled && !rejected) {
            callbackContext.error(Connection.getStatusString(cause));
        }
        unregister();
    }

    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {
        if (!fulfilled && !rejected) {
            callbackContext.error(Connection.getStatusString(connectionResult.getErrorCode()));
        }
        unregister();
    }

    private void register() {
        googleApiClient.registerConnectionFailedListener(this);
        googleApiClient.registerConnectionCallbacks(this); // Will call onConnected automatically if already connected!
    }

    private void unregister() {
        googleApiClient.unregisterConnectionFailedListener(this);
        googleApiClient.unregisterConnectionCallbacks(this);
    }
}
