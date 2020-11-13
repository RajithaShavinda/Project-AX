package com.amazonite.projectax;

import android.os.Build;

public class SystemUtil {
    private static final String TAG = SystemUtil.class.getSimpleName();

    public SystemUtil() {
    }


    public static String getBrand() {
        return Build.BRAND;
    }


    public static String getDeviceModel() {
        return Build.MODEL;
    }


    public static String getOSVersion() {
        return "android" + Build.VERSION.RELEASE;
    }


    public static String getOSVersionSDK() {
        return Build.VERSION.SDK;
    }


    public static int getOSVersionSDKINT() {
        return Build.VERSION.SDK_INT;
    }

    /**
     * build id
     */
    public static String getBuildId() {
        return Build.ID;
    }

    /**
     * display
     */
    public static String getBuildDisplay() {
        return Build.DISPLAY;
    }

    /**
     * DEVICE
     */
    public static String getBuildDevice() {
        return Build.DEVICE;
    }


    /**
     * MANUFACTURER
     */
    public static String getBuildManufacturer() {
        return Build.MANUFACTURER;
    }


    /**
     * HARDWARE
     */
    public static String getHardware() {
        return Build.HARDWARE;
    }

    /**
     * SERIAL
     */
    public static String getSerial() {
        return Build.SERIAL;
    }

    /**
     * PRODUCT
     */
    public static String getProduct() {
        return Build.PRODUCT;
    }

    /**
     * BUILDTIME
     */
    public static long getBuildTime() {
        return Build.TIME;
    }


    /**
     * TYPE
     */
    public static String getType() {
        return Build.TYPE;
    }

    /**
     * TAGS
     */
    public static String getTags() {
        return Build.TAGS;
    }

    /**
     * CODENAME
     */
    public static String getCodename() {
        return Build.VERSION.CODENAME;
    }

    /**
     * USER
     */
    public static String getUser() {
        return Build.USER;
    }

    /**
     * FINGERPRINT
     */
    public static String getFingerprint() {
        return Build.FINGERPRINT;
    }

}
