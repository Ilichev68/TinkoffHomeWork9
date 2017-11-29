package com.example.user.tinkoffhomework9.presenter;


import com.example.user.tinkoffhomework9.model.data.TinkoffNews;

import java.util.List;

/**
 * Created by User on 29.11.2017.
 */

public interface IMainPresenter {

    void goToInternet();
    void isSuccsessfull(boolean isSuccessfull, List<TinkoffNews> news);
    void isSuccsessfull(boolean isSuccessfull);
}
