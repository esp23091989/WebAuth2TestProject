package com.example.gosuslugiauthtestapp.app;

import android.app.Application;
import android.content.ContextWrapper;

import com.example.gosuslugiauthtestapp.api.Api;
import com.example.gosuslugiauthtestapp.api.ApiManager;
import com.pixplicity.easyprefs.library.Prefs;

public class App extends Application{

    private static App intstance;
    private ApiManager apiManager;

    @Override
    public void onCreate() {
        super.onCreate();
        intstance = this;

        new Prefs.Builder()
                .setContext(this)
                .setMode(ContextWrapper.MODE_PRIVATE)
                .setPrefsName(getPackageName())
                .setUseDefaultSharedPreference(true)
                .build();

        apiManager = new ApiManager();
    }

    public static App getInstance(){
        return intstance;
    }

    public Api getApiService(){
        return apiManager.getApiService();
    }
}
