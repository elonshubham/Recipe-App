package com.example.carddemo;

import com.google.gson.annotations.SerializedName;

public class Result {

    @SerializedName("title")
    private String title;

    @SerializedName("ingredients")
    private String ingredients;

    @SerializedName("href")
    private String href;

    @SerializedName("thumbnail")
    private String thumbnail;

    public String gettitle() {
        return title;
    }

    public String getingredients() {
        return ingredients;
    }

    public String gethref() {
        return href;
    }

    public String getthumbnail() {
        return thumbnail;
    }
}
