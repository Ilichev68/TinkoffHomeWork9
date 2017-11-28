package com.example.user.tinkoffhomework9;

import android.app.Application;

import com.example.user.tinkoffhomework9.model.rest.TinkoffApi;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by User on 27.11.2017.
 */

public class App extends Application {

    private static final String BASE_URL = "https://api.tinkoff.ru/";
    private static TinkoffApi tinkoffApi;
    private Retrofit retrofit;

    @Override
    public void onCreate() {
        super.onCreate();

        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        tinkoffApi = retrofit.create(TinkoffApi.class);
    }

    public static TinkoffApi getTinkoffApi(){
        return tinkoffApi;
    }

}
