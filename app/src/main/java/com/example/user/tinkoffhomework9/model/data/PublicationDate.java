package com.example.user.tinkoffhomework9.model.data;

import com.google.gson.annotations.SerializedName;

/**
 * Created by User on 27.11.2017.
 */

public class PublicationDate {

    @SerializedName("milliseconds")
    private long milliseconds;

    public long getMilliseconds() {
        return milliseconds;
    }

    public void setMilliseconds(long milliseconds) {
        this.milliseconds = milliseconds;
    }


}
