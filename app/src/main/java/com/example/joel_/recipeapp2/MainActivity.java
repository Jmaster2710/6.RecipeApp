package com.example.joel_.recipeapp2;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import java.util.ArrayList;
import java.util.Arrays;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Recipe> recipes = new ArrayList<>();


    public ArrayList<Recipe> getRecipes() {
        return recipes;
    }

    public void setRecipes(ArrayList<Recipe> recipes) {
        this.recipes = recipes;
    }


    private SectionsPagerAdapter mSectionsPagerAdapter;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d("testing", "requesting data");
        requestData();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager(), recipes) {
        };

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

    }


    //Data collecting
    private void requestData() {
        Food2forkApiService service = Food2forkApiService.retrofit.create(Food2forkApiService.class);

        Call<RecipeList> call = service.getRecipes();
        call.enqueue(new Callback<RecipeList>() {
            @Override
            public void onResponse(Call<RecipeList> call, Response<RecipeList> response) {
                Log.d("testing", "info binnen gekregen");

                recipes.addAll(Arrays.asList(response.body().recipes));
                mSectionsPagerAdapter.notifyDataSetChanged();

            }

            @Override
            public void onFailure(Call<RecipeList> call, Throwable t) {
                Log.d("testing", t.getMessage());
            }
        });

    }
}
