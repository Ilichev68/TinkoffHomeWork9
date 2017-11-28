package com.example.user.tinkoffhomework9.model.data;

import com.google.gson.annotations.SerializedName;

/**
 * Created by User on 27.11.2017.
 */

public class TinkoffNews {

    @SerializedName("text")
    private String text;
    @SerializedName("publicationDate")
    private PublicationDate publicationDate;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public PublicationDate getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(PublicationDate publicationDate) {
        this.publicationDate = publicationDate;
    }
}
