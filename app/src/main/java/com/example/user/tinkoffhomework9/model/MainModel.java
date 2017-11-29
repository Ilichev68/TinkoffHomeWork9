package com.example.user.tinkoffhomework9.model;


import com.example.user.tinkoffhomework9.App;
import com.example.user.tinkoffhomework9.model.data.ServerAnswer;
import com.example.user.tinkoffhomework9.model.data.TinkoffNews;
import com.example.user.tinkoffhomework9.presenter.IMainPresenter;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by User on 29.11.2017.
 */

public class MainModel implements IMainModel {

    private List<TinkoffNews> news;
    private IMainPresenter iMainPresenter;

    public MainModel(IMainPresenter iMainPresenter){
        this.iMainPresenter = iMainPresenter;
    }

    @Override
    public void downloadNews() {
        App.getTinkoffApi().getNews().enqueue(new Callback<ServerAnswer>() {
            @Override
            public void onResponse(Call<ServerAnswer> call, Response<ServerAnswer> response) {
                news = (response.body().getObjects());
                iMainPresenter.isSuccsessfull(true, news);
            }

            @Override
            public void onFailure(Call<ServerAnswer> call, Throwable t) {
                iMainPresenter.isSuccsessfull(false);
            }
        });
    }

}
