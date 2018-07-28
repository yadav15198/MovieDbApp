package com.example.hp.moviedbapp;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Api_Client {
    private static Retrofit retrofit;

    private static MovieDbService service;

    public static Retrofit getInstance(){
        if (retrofit == null) {
            Retrofit.Builder builder = new Retrofit.Builder()
                    .baseUrl(Contracts.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create());
            retrofit = builder.build();
        }
        return retrofit;
    }

    public static MovieDbService getMovieDbService(){
        if(service == null){
            service = getInstance().create(MovieDbService.class);
        }
        return service;
    }
}

