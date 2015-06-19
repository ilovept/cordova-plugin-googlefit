package de.ilpt.plugins.googlefit;

import com.google.android.gms.common.ConnectionResult;

/**
 * Created by christoph on 18.06.15.
 */
public class Connection {
    static String getStatusString(int statusCode) {
        switch (statusCode) {
            case ConnectionResult.SUCCESS:
                return "SUCCESS";
            case ConnectionResult.SERVICE_MISSING:
                return "SERVICE_MISSING";
            case ConnectionResult.SERVICE_VERSION_UPDATE_REQUIRED:
                return "SERVICE_VERSION_UPDATE_REQUIRED";
            case ConnectionResult.SERVICE_DISABLED:
                return "SERVICE_DISABLED";
            case ConnectionResult.SIGN_IN_REQUIRED:
                return "SIGN_IN_REQUIRED";
            case ConnectionResult.INVALID_ACCOUNT:
                return "INVALID_ACCOUNT";
            case ConnectionResult.RESOLUTION_REQUIRED:
                return "RESOLUTION_REQUIRED";
            case ConnectionResult.NETWORK_ERROR:
                return "NETWORK_ERROR";
            case ConnectionResult.INTERNAL_ERROR:
                return "INTERNAL_ERROR";
            case ConnectionResult.SERVICE_INVALID:
                return "SERVICE_INVALID";
            case ConnectionResult.DEVELOPER_ERROR:
                return "DEVELOPER_ERROR";
            case ConnectionResult.LICENSE_CHECK_FAILED:
                return "LICENSE_CHECK_FAILED";
            case ConnectionResult.CANCELED:
                return "CANCELED";
            case ConnectionResult.TIMEOUT:
                return "TIMEOUT";
            case ConnectionResult.INTERRUPTED:
                return "INTERRUPTED";
            case ConnectionResult.API_UNAVAILABLE:
                return "API_UNAVAILABLE";
            case ConnectionResult.SIGN_IN_FAILED:
                return "SIGN_IN_FAILED";
//            case ConnectionResult.SERVICE_UPDATING:
//                return "SERVICE_UPDATING";

            // Verifiy this:
            case 5000:
                return "NO_DATA";

            default:
                return "UNKNOWN STATUS (" + statusCode + ")";
        }
    }
}
