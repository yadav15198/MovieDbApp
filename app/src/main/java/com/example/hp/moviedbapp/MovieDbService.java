package com.example.hp.moviedbapp;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MovieDbService {
    @GET("movie/now_playing")
    Call<NowShowingMovies>getNwShowingMovies(@Query("api_key")String key,@Query("page")int page);
    @GET("movie/popular")
    Call<PopularMovies>getPopopularMovies(@Query("api_key")String key,@Query("page")int page);
    @GET("movie/top_rated")
    Call<TopRatedMovies>getTopRatedMovies(@Query("api_key")String key,@Query("page")int page);
    @GET("movie/upcoming")
    Call<UpComingMovies>getUpcomingMvies(@Query("api_key")String key,@Query("page")int page);
 }
