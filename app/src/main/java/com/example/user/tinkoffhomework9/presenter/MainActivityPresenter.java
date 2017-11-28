package com.example.user.tinkoffhomework9.presenter;

import android.support.annotation.NonNull;

import com.example.user.tinkoffhomework9.view.IMainView;
import com.example.user.tinkoffhomework9.view.MainActivity;

/**
 * Created by User on 27.11.2017.
 */

public class MainActivityPresenter {

    private IMainView inMainView;
    private MainActivity mainView;

    public MainActivityPresenter(@NonNull IMainView iMainView){
        inMainView = iMainView;
    }

    public void onTakeView(MainActivity view){
        mainView = view;
    }
}
