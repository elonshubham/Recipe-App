package com.example.carddemo;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Recipe {
    @SerializedName("version")
    private String mversion;

    @SerializedName("title")
    private String mtitle;

    @SerializedName("href")
    private String mhref;

    @SerializedName("results")
    private ArrayList<Result> resultslist = new ArrayList<Result>();

    public String getMversion() {
        return mversion;
    }

    public String getMtitle() {
        return mtitle;
    }

    public String getMhref() {
        return mhref;
    }

    public ArrayList<Result> getResultslist() {
        return resultslist;
    }
}


