package com.amazonite.projectax;

import android.content.Context;
import android.util.Log;

import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class JsonUtility {
    private static final String TAG = JsonUtility.class.getSimpleName();
    private Context mContext;
    private Gson mGson;

    public JsonUtility(Context context){
        this.mContext = context;
        mGson = new Gson();
    }

    public String readJsonFromAsset(String filePath) {
        if(!filePath.contains(".json")){
            filePath+=".json";
        }
        try {
            InputStream inputStream = mContext.getAssets().open(filePath);
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

    public <T> T getObjectFromAssetJson(String filePath, Class<T> ObjType) {
        try{
            String json = readJsonFromAsset(filePath);
            Object value = mGson.fromJson(json, ObjType);
            return (T)value;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public JSONObject loadJSONFromAsset(String filePath) {
        String json;
        JSONObject jsonObject = null;

        try {
            json = readJsonFromAsset(filePath);
            jsonObject = new JSONObject(json);
        } catch (JSONException ex) {
            Log.e(TAG, "loadJSONFromAsset: ", ex);
        }
        return jsonObject;
    }


    public static String getString(JSONObject json, String field) {
        String value = null;
        try {
            if (!json.has(field)) {
                Log.e(TAG, "field :" + field + "| not found in json object");
                return null;
            }

            value = json.getString(field);
            if (value.isEmpty()) {
                Log.e(TAG, "field :" + field + "| is empty");
            }
        } catch (JSONException ex) {
            Log.e(TAG, "getString: ", ex);
        }
        return value;
    }


}
