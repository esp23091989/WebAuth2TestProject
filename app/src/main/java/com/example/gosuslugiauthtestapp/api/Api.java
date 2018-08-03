package com.example.gosuslugiauthtestapp.api;

import com.example.gosuslugiauthtestapp.main.model.MainViewModel;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface Api {

    @GET("/rs/prns/{userId}")
    Single<MainViewModel> getUserInfo(@Path("userId") String sbjId);
}
