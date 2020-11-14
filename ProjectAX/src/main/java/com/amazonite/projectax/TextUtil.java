package com.amazonite.projectax;

import android.util.Log;
import android.widget.EditText;

import java.util.Locale;

public class TextUtil {
    private static final String TAG = TextUtil.class.getSimpleName();

    public static boolean isEmptyString(String stringValue){
        return stringValue == null || stringValue.trim().isEmpty();
    }

    public static String capitalizeFirstLetter(String text){
        try {
            if(text == null || text.trim().isEmpty()) return "";
            text = text.trim();
            return (text.length() > 1 )? (text.substring(0, 1).toUpperCase(Locale.US)) + (text.substring(1).toLowerCase(Locale.US)) : text.toUpperCase();
        }catch (Exception e){
            return text;
        }
    }

    public static String toTitleCaseEveryWord(String text){
        try {
            if(text == null || text.trim().isEmpty()) return "";

            String[] words = text.trim().split(" ");
            StringBuilder result = new StringBuilder();
            for (String word : words) {
                result.append((word.length() > 1 )? (word.substring(0, 1).toUpperCase(Locale.US)) + (word.substring(1).toLowerCase(Locale.US)) : word.toUpperCase()).append(" ");
            }
            return result.toString().trim();
        }catch (Exception e){
            return text;
        }
    }

    public static String getStringValue(String stringValue){
        return (stringValue == null || stringValue.trim().isEmpty())? "" : stringValue.trim();
    }

    public static int getIntValue(String string) {
        if (getStringValue(string).isEmpty()) return 0;

        try {
            return Integer.parseInt(string);
        } catch (NumberFormatException e) {
            Log.e(TAG, "getIntValue: ", e);
            return 0;
        }
    }

    public static float getFloatValue(String string) {
        if (getStringValue(string).isEmpty()) return 0;

        try {
            return Float.parseFloat(string);
        } catch (NumberFormatException e) {
            Log.e(TAG, "getFloatValue: ", e);
            return 0;
        }
    }

    public static double getDoubleValue(String string) {
        if (getStringValue(string).isEmpty()) return 0;

        try {
            return Double.parseDouble(string);
        } catch (NumberFormatException e) {
            Log.e(TAG, "getDoubleValue: ", e);
            return 0;
        }
    }


    public static String getStringValue(EditText editText){
        return (editText == null ? "" : getStringValue(editText.getText().toString()));
    }

    public static int getIntValue(EditText editText){
        return (editText == null ? 0 : getIntValue(editText.getText().toString()));
    }

    public static float getFloatValue(EditText editText){
        return (editText == null ? 0 : getFloatValue(editText.getText().toString()));
    }

    public static double getDoubleValue(EditText editText){
        return (editText == null ? 0 : getDoubleValue(editText.getText().toString()));
    }
}