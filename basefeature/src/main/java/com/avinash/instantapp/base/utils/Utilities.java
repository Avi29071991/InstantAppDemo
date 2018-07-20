package com.avinash.instantapp.base.utils;

import android.content.Context;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import java.util.List;
import java.util.Map;

public class Utilities {


    /**
     * Returns the boolean value depending on the device internet connectivity
     *
     * @param context Checking the internet connectivity using context
     * @return boolean value depending on the device internet connectivity
     **/
    public static boolean isOnline(Context context) {
        try {
            if (context != null) {

                ConnectivityManager cm = (ConnectivityManager) context
                        .getSystemService(Context.CONNECTIVITY_SERVICE);


                NetworkInfo netInfo = cm.getActiveNetworkInfo();

                if (netInfo != null && netInfo.getState() == NetworkInfo.State.CONNECTED) {
                    return true;
                } else {
                    return false;
                }
            } else
                return false;
        } catch (Exception exp) {
            return false;
        }

    }

    /**
     * Returns the boolean value depending on the null pointer check for mentioned string.
     *
     * @param obj Object which needs to be checked for null conditions.
     * @return boolean value which is used to identify if the obj is null or not.
     **/

    @SuppressWarnings("rawtypes")
    public static boolean isNotEmpty(Object obj) {
        boolean result = true;
        if (obj != null) {
            if (obj instanceof String) {

                if (obj.toString().trim().length() != 0
                        && !obj.toString().trim().equalsIgnoreCase("null")
                        && !obj.toString().trim().equalsIgnoreCase(""))
                    result = false;
            } else if (obj instanceof List) {
                if (((List) obj).size() > 0)
                    result = false;
            } else if (obj instanceof Map) {
                if (((Map) obj).size() > 0)
                    result = false;
            }
        }

        return !result;

    }

    /**
     * Returns a boolean value depending on the condition whether
     * the user had granted the specified permission or not (Only for Android 23+).
     *
     * @param requiredPermission Permission which is required for performing some actions.
     * @return a boolean value depending on the available permissions.
     **/
    public static boolean checkPermission(Context context, String requiredPermission) {
        PackageManager pm = context.getPackageManager();
        int hasRequiredPermission = pm.checkPermission(
                requiredPermission,
                context.getPackageName());
        if (hasRequiredPermission == PackageManager.PERMISSION_GRANTED) {
            return true;
        } else {
            return false;
        }
    }


    /**
     * Returns the temperature in degree celcius which can be displayed on the screen.
     * The fahrenheit argument must specify an absolute temperature value.
     *
     * @param fahrenheit the temperature value in degree fahrenheit.
     * @return a float value i.e temperature in degree celcius.
     **/
    public static float convertFarheniteToCelcius(double fahrenheit) {
        // TODO Auto-generated method stub
        double celcius;
        float x;
        celcius = ((fahrenheit - 32) * 5) / 9;
        x = (float) Math.round(celcius);
        return x;
    }
}
