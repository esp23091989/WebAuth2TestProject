package com.example.gosuslugiauthtestapp.api;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.example.gosuslugiauthtestapp.auth.model.AuthDataDTO;
import com.example.gosuslugiauthtestapp.preferences.PreferenceManager;

import java.io.IOException;

import okhttp3.Authenticator;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Route;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiManager {

    public static final String API_BASE_URL = "https://esia-portal1.test.gosuslugi.ru";

    public ApiManager() {
    }

    public Api getApiService(){
        Retrofit.Builder builder = new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(API_BASE_URL);

        OkHttpClient.Builder clientBuilder = new OkHttpClient.Builder();
        final AuthDataDTO authDataDTO = PreferenceManager.getInstance().getAuthData();
        clientBuilder.addInterceptor(new Interceptor() {
            @Override
            public Response intercept(@NonNull Chain chain) throws IOException {
                Request request = chain.request();

                Request.Builder requestBuilder = request.newBuilder()
                        .header("Authorization", "Bearer " + authDataDTO.getAccessToken());
                return chain.proceed(requestBuilder.build());
            }
        });

        Retrofit retrofit = builder
                .client(clientBuilder.build())
                .build();

        return retrofit.create(Api.class);

//        clientBuilder.authenticator(new Authenticator() {
//            @Nullable
//            @Override
//            public Request authenticate(Route route, Response response) throws IOException {
//                return null;
//            }
//        })
    }
}
