package com.amazonite.projectax;

import android.content.Context;
import android.util.Log;

import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class JsonUtil {
    private static final String TAG = JsonUtil.class.getSimpleName();

    public static String readJsonFromAsset(Context context, String filePath) {
        if (!filePath.contains(".json")) {
            filePath += ".json";
        }
        try {
            InputStream inputStream = context.getAssets().open(filePath);
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            final int read = inputStream.read(buffer);
            inputStream.close();
            if (read > 0) {
                return new String(buffer, StandardCharsets.UTF_8);
            }
        } catch (IOException ex) {
            Log.e(TAG, "loadJSONFromAsset: ", ex);
        }
        return null;
    }

    public static <T> T getObjectFromAssetJson(Context context, String filePath, Class<T> ObjType) {
        try {
            String json = readJsonFromAsset(context, filePath);
            Object value = new Gson().fromJson(json, ObjType);
            return (T) value;
        } catch (Exception ex) {
            Log.e(TAG, "getObjectFromAssetJson: ", ex);
        }
        return null;
    }

    public static JSONObject loadJSONFromAsset(Context context, String filePath) {
        try {
            String json = readJsonFromAsset(context, filePath);
            if (json == null || json.isEmpty()) return null;

            return new JSONObject(json);
        } catch (JSONException ex) {
            Log.e(TAG, "loadJSONFromAsset: ", ex);
            return null;
        }
    }


    public static String getString(JSONObject json, String field) {
        try {
            if (!json.has(field)) {
                Log.e(TAG, "field :" + field + "| not found in json object");
                return null;
            }

            return json.getString(field);
        } catch (JSONException ex) {
            Log.e(TAG, "getString: ", ex);
            return null;
        }
    }
}