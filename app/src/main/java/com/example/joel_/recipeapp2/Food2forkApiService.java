package com.example.joel_.recipeapp2;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public interface Food2forkApiService {

    String BASE_URL = "https://www.food2fork.com/api/";
    String KEY = "5ea9337ef8b72deb2b88b81560d12084";
    String SORT = "r";

    /**
     * Create a retrofit client.
     */

    Retrofit retrofit = new Retrofit.Builder()

            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();


    @GET("search?key=" + KEY + "&sort=" + SORT)

        /*
    https://www.food2fork.com/api/search?key=5ea9337ef8b72deb2b88b81560d12084&sort=r
    Dit is de link die ik moet gebruiken om de meest populaire gerechten te krijgen.
    */


    Call<Recipe> getRecipes();
}
