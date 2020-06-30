package com.example.carddemo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface JsonPlaceHolderApi {

    @GET("api/")
    Call<Recipe> getrecipe(@Query("i") String ingredients, @Query("q") String food);

}
