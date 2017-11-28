package com.example.user.tinkoffhomework9.model.data;


import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by User on 27.11.2017.
 */

public class ServerAnswer {

    @SerializedName("payload")
    private List<TinkoffNews> objects;


    public List<TinkoffNews> getObjects() {
        return objects;
    }

    public void setObjects(List<TinkoffNews> objects) {
        this.objects = objects;
    }
}
