package com.example.user.tinkoffhomework9.view;

import com.example.user.tinkoffhomework9.model.data.TinkoffNews;

import java.util.List;

/**
 * Created by User on 27.11.2017.
 */

public interface IMainView {

    void getListForRV(List<TinkoffNews> news);
    void update();
    void showError();
}
