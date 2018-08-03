package com.example.gosuslugiauthtestapp.preferences;

import com.example.gosuslugiauthtestapp.auth.model.AuthDataDTO;
import com.google.gson.Gson;
import com.pixplicity.easyprefs.library.Prefs;

public class PreferenceManager {

    private static final String PREFS_AUTH_DATA_KEY = "auth_data";

    private static PreferenceManager instance;
    private Gson gson;

    public static PreferenceManager getInstance(){
        if(instance == null)
            instance = new PreferenceManager();

        return instance;
    }

    private PreferenceManager(){
        gson = new Gson();
    }

    public AuthDataDTO getAuthData(){
        String authDataJson = Prefs.getString(PREFS_AUTH_DATA_KEY, "");
        return gson.fromJson(authDataJson, AuthDataDTO.class);
    }

    public void setAuthData(AuthDataDTO authData) {
        Prefs.putString(PREFS_AUTH_DATA_KEY, gson.toJson(authData));
    }

    public void clearAuthData() {
        Prefs.putString(PREFS_AUTH_DATA_KEY, "");
    }
}
