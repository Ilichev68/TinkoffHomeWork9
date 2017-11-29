package com.example.user.tinkoffhomework9.view;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.user.tinkoffhomework9.R;
import com.example.user.tinkoffhomework9.RecyclerViewAdapter;
import com.example.user.tinkoffhomework9.model.data.TinkoffNews;
import com.example.user.tinkoffhomework9.presenter.MainActivityPresenter;

import java.util.List;

public class MainActivity extends AppCompatActivity implements IMainView {

    private SwipeRefreshLayout swipeRefreshLayout;
    private RecyclerView recyclerView;
    private MainActivityPresenter presenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialize(this);

        recyclerView = findViewById(R.id.rv);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        swipeRefreshLayout = findViewById(R.id.swipeRefreshLayout);

        presenter.goToInternet();



        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                presenter.goToInternet();
                swipeRefreshLayout.setRefreshing(false);
            }
        });


    }

    @Override
    public void showNews(List<TinkoffNews> news) {
        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(news);
        recyclerView.setAdapter(recyclerViewAdapter);
    }

    @Override
    public void showError() {
        Toast.makeText(MainActivity.this, "An error occurred during networking", Toast.LENGTH_SHORT).show();
    }

    private void initialize(IMainView iMainView){
        presenter = new MainActivityPresenter(iMainView);
    }

}
