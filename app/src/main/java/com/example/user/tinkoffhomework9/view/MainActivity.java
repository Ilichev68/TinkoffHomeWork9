package com.example.user.tinkoffhomework9.view;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.user.tinkoffhomework9.App;
import com.example.user.tinkoffhomework9.R;
import com.example.user.tinkoffhomework9.model.data.TinkoffNews;
import com.example.user.tinkoffhomework9.model.data.ServerAnswer;
import com.example.user.tinkoffhomework9.presenter.MainActivityPresenter;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements IMainView {

    private SwipeRefreshLayout swipeRefreshLayout;
    private RecyclerView recyclerView;
    private List<TinkoffNews> news;
    private static MainActivityPresenter presenter;

    @Override
    protected void onResume() {
        super.onResume();
        update(news);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.rv);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        swipeRefreshLayout = findViewById(R.id.swipeRefreshLayout);

        getNewsFromServer();

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getNewsFromServer();
                swipeRefreshLayout.setRefreshing(false);
            }
        });


    }

    private void getNewsFromServer() {
        App.getTinkoffApi().getNews().enqueue(new Callback<ServerAnswer>() {
            @Override
            public void onResponse(Call<ServerAnswer> call, Response<ServerAnswer> response) {
                news = (response.body().getObjects());
                update(news);

            }

            @Override
            public void onFailure(Call<ServerAnswer> call, Throwable t) {
                t.printStackTrace();
                Toast.makeText(MainActivity.this, "An error occurred during networking", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void update(List<TinkoffNews> news) {
        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(news);
        recyclerView.setAdapter(recyclerViewAdapter);
    }

    @Override
    public void getListForRV(List<TinkoffNews> news) {

    }

    @Override
    public void update() {

    }

    @Override
    public void showError() {
        Toast.makeText(MainActivity.this, "An error occurred during networking", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onTakeView(null);
        if (!isChangingConfigurations())
            presenter = null;
    }
}
