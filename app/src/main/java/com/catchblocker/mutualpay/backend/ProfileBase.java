package com.catchblocker.mutualpay.backend;

import android.content.Context;
import android.util.Log;

import com.catchblocker.mutualpay.backend.Entites.Profile;
import com.google.gson.Gson;

/**
 * Created by Jitendra Jogeshwar on 12/25/2014.
 * Manage User Profile
 */
public class ProfileBase {
    private Context _context;
    private Gson gson = new Gson();
    public ProfileBase(Context ctxt){
        this._context = ctxt;
    }


    public void saveProfile(Profile profile){
        UserPrefs userPrefs = new UserPrefs(_context);
        userPrefs.savePrefs("User", gson.toJson(profile));
        Log.i("Name:", profile.getName());

    }

    public Profile getProfile(){
        UserPrefs userPrefs = new UserPrefs(_context);
        Log.i("getprofile:", userPrefs.getPrefs().toString());
        return gson.fromJson(userPrefs.getPrefs(), Profile.class);
    }
}
