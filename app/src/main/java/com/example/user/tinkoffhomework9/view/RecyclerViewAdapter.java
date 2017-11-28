package com.example.user.tinkoffhomework9.view;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.user.tinkoffhomework9.R;
import com.example.user.tinkoffhomework9.model.data.TinkoffNews;

import java.util.List;

/**
 * Created by User on 27.11.2017.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    List<TinkoffNews> newsList;

    public RecyclerViewAdapter(List<TinkoffNews> newsList) {
        this.newsList = newsList;
    }

    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_item, parent, false);
        return new ViewHolder(v);

    }

    @Override
    public void onBindViewHolder(RecyclerViewAdapter.ViewHolder holder, int position) {

        TinkoffNews tinkoffNews = newsList.get(position);
        holder.bindNews(tinkoffNews);
    }

    @Override
    public int getItemCount() {
        if (newsList == null)
            return 0;
        return newsList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView news;
        TinkoffNews tinkoffNews;

        public ViewHolder(View itemView) {
            super(itemView);
            news = itemView.findViewById(R.id.news_name);
        }

        void bindNews(TinkoffNews myObject){
            tinkoffNews = myObject;
            news.setText(tinkoffNews.getText());
        }
    }
}
