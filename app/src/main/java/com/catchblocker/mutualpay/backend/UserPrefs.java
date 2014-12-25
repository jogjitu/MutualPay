package com.catchblocker.mutualpay.backend;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;

/**
 * Created by Jitendra Jogeshwar on 12/25/2014.
 * This class will be used to store profile details in shared preferences
 */
public class UserPrefs {
    private static String PREFS_NAME="com.catchblocker.mutualpay.UserPrefs";

    private static SharedPreferences settings;

    private static SharedPreferences.Editor editor;

    public UserPrefs(Context ctxt){
        if(settings == null){
            settings = ctxt.getSharedPreferences(PREFS_NAME,Context.MODE_PRIVATE);
        }
        editor = settings.edit();
    }

    public void savePrefs(String key,String value){
        editor.putString(key,value);
        editor.commit();

    }

    public String getPrefs(){
       return settings.getString("User","");
    }

}
