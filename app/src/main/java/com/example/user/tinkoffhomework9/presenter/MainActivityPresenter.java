package com.example.user.tinkoffhomework9.presenter;



import com.example.user.tinkoffhomework9.model.IMainModel;
import com.example.user.tinkoffhomework9.model.MainModel;
import com.example.user.tinkoffhomework9.model.data.TinkoffNews;
import com.example.user.tinkoffhomework9.view.IMainView;

import java.lang.ref.WeakReference;
import java.util.List;

/**
 * Created by User on 27.11.2017.
 */

public class MainActivityPresenter implements IMainPresenter {

    private WeakReference<IMainView> iMainView;
    private IMainModel iMainModel;

    public MainActivityPresenter(IMainView iMainView){
        this.iMainView = new WeakReference<>(iMainView);
        this.iMainModel = new MainModel(this);
    }

    @Override
    public void goToInternet() {
        iMainModel.downloadNews();
    }

    @Override
    public void isSuccsessfull(boolean isSuccessfull, List<TinkoffNews> news) {
        if (isSuccessfull) iMainView.get().showNews(news);

    }

    @Override
    public void isSuccsessfull(boolean isSuccessfull) {
        if (!isSuccessfull) iMainView.get().showError();
    }
}
