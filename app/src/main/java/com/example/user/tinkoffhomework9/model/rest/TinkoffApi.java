package com.example.user.tinkoffhomework9.model.rest;

import com.example.user.tinkoffhomework9.model.data.ServerAnswer;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by User on 27.11.2017.
 */

public interface TinkoffApi {

    @GET("v1/news")
    Call<ServerAnswer> getNews();

}
