package com.amazonite.projectax;


import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import static android.os.Build.BRAND;
import static android.os.Build.DEVICE;
import static android.os.Build.FINGERPRINT;
import static android.os.Build.HARDWARE;
import static android.os.Build.MANUFACTURER;
import static android.os.Build.MODEL;
import static android.os.Build.TAGS;

@SuppressWarnings("deprecation")
public class SystemUtil {
    private static final String TAG = SystemUtil.class.getSimpleName();

    public SystemUtil() {
    }


    public static void setScreenStyleDark(Activity activity) {
        transparencyStatusBar(activity);
        setNavigationBarColor(activity, Color.BLACK);
    }


    public static void transparencyStatusBar(Activity activity) {
        Window window = activity.getWindow();
        //change status bar text colour
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);

        } else {
            window.setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS,
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
    }

    public static void setNavigationBarColorByResource(Activity activity, int resId){
        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            activity.getWindow().setNavigationBarColor(activity.getResources().getColor(resId));
        }
    }

    public static void setNavigationBarColor(Activity activity, int color){
        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            activity.getWindow().setNavigationBarColor(color);
        }
    }

    public static void hideKeyboard(Activity activity) {
        View view = activity.getCurrentFocus();
        if (view != null) {
            InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
            view.clearFocus();
        } else {
            activity.getWindow().setSoftInputMode(
                    WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        }
    }


    public static void showKeyboard(final Context context, final EditText editText) {
        new Handler().post(new Runnable() {
            @Override
            public void run() {
                if (context != null) {
                    InputMethodManager inputMethodManager = (InputMethodManager) context
                            .getSystemService(Context.INPUT_METHOD_SERVICE);
                    inputMethodManager.showSoftInput(editText, InputMethodManager.SHOW_IMPLICIT);
                }
            }
        });
    }

    public static void sleepFor(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }



    /**
     *  BRAND
     * The consumer-visible brand with which the product/hardware will be associated, if any.
     */
    public static String getBrand() {
        return BRAND;
    }

    /**
     * MODEL
     *The end-user-visible name for the end product.
     */
    public static String getDeviceModel() {
        return MODEL;
    }

    /**
     * RELEASE
     * The user-visible version string.
     */
    public static String getOSVersion() {
        return "android " + Build.VERSION.RELEASE;
    }

    /**
     * DEVICE
     * The name of the industrial design.
     */
    public static String getBuildDevice() {
        return DEVICE;
    }

    /**
     * MANUFACTURER
     * The manufacturer of the product/hardware.
     */
    public static String getBuildManufacturer() {
        return MANUFACTURER;
    }

    /**
     * HARDWARE
     * The name of the hardware (from the kernel command line or /proc).
     */
    public static String getHardware() {
        return HARDWARE;
    }

    /**
     * FINGERPRINT
     * A string that uniquely identifies this build.
     */
    public static String getFingerprint() {
        return FINGERPRINT;
    }

    /**
     * TAGS
     * Comma-separated tags describing the build, like "unsigned,debug".
     */
    public static String getTags() {
        return TAGS;
    }

    /**
     * SDK_INT
     * The SDK version of the software currently running on this hardware device.
     */
    public static int getOSVersionSDKINT() {
        return Build.VERSION.SDK_INT;
    }
}