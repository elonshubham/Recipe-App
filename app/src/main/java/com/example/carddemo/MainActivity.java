package com.example.carddemo;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    EditText msearchtext;
    TextView detailstext;
    EditText mfoodtext;
    String ing;
    String foo;
    Button mbutton;
    String content;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        msearchtext=(EditText) findViewById(R.id.searchtext);
        detailstext=findViewById(R.id.text_view_result);
        mfoodtext=(EditText) findViewById(R.id.foodtext);
        mbutton= findViewById(R.id.button);


        Retrofit retrofit= new Retrofit.Builder().baseUrl("http://www.recipepuppy.com/").addConverterFactory(GsonConverterFactory.create()).build();

        JsonPlaceHolderApi jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);

        mbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ing=msearchtext.getText().toString();
                foo=mfoodtext.getText().toString();
                content = "";

                Call<Recipe> call = jsonPlaceHolderApi.getrecipe(ing,foo);
                call.enqueue(new Callback<Recipe>() {
                    @Override
                    public void onResponse(Call<Recipe> call, Response<Recipe> response) {
                        if (!response.isSuccessful()) {
                            detailstext.setText("Code: " + response.code());
                            return;
                        }

                        Recipe recipe = response.body();
                        for (int i=0;i<recipe.getResultslist().size();i++) {

                            content += "FOOD TITLE: " + recipe.getResultslist().get(i).gettitle().toString() + "\n";
                            content += "INGREDIENTS: " + recipe.getResultslist().get(i).getingredients().toString() + "\n\n";
                            detailstext.setText(content);
                        }

                    }


                    @Override
                    public void onFailure(Call<Recipe> call, Throwable t) {
                        detailstext.setText(t.getMessage());
                    }
                });

            }
        });







    }


}

