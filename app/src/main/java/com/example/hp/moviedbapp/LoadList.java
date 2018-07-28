package com.example.hp.moviedbapp;

import android.arch.persistence.room.Database;
import android.content.Context;
import android.os.Bundle;
import android.provider.SyncStateContract;
import android.support.v7.widget.AppCompatButton;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoadList {
  String type;
 private List<Movies> moviesList;
 private ListLoadListener listener;
  public LoadList(Bundle bundle,Context context,ListLoadListener listener){
     // type = bundle.toString(Contracts.TYPE);
      this.listener = listener;
      this.type=bundle.getString(Contracts.TYPE);
  }
  public  List<Movies> getMovie(int page,long id){
      moviesList = new ArrayList<>();
      if(type.equals(Contracts.NOW_SHOWING_MOVIES)){
          Call<NowShowingMovies>call = Api_Client.getMovieDbService().getNwShowingMovies(Contracts.API_KEY,page);
          call.enqueue(new Callback<NowShowingMovies>() {
              @Override
              public void onResponse(Call<NowShowingMovies> call, Response<NowShowingMovies> response) {
                  if(response.body()!=null)
                  {
                      NowShowingMovies nowShowingResponse;
                      List<NowShowingMovies> nowShowings=new ArrayList<>();
                      nowShowingResponse=response.body();
                      for(int i=0;i<nowShowingResponse.getResults().size();i++)
                      {
                          NowShowingMovies nowShowing=new NowShowingMovies();
                          nowShowings.add(nowShowing);
                      }

                      moviesList.clear();
                      moviesList.addAll(nowShowingResponse.getResults());
                      listener.OnMovieloded(moviesList);

                  }
              }

              @Override
              public void onFailure(Call<NowShowingMovies> call, Throwable t) {

              }
          });
      }
      else if(type.equals(Contracts.POPULAR_MOVIES)){
          Call<PopularMovies>call = Api_Client.getMovieDbService().getPopopularMovies(Contracts.API_KEY,page);
          call.enqueue(new Callback<PopularMovies>() {
              @Override
              public void onResponse(Call<PopularMovies> call, Response<PopularMovies> response) {
                  if(response.body()!=null)
                  {
                      PopularMovies popularresponse;
                      List<PopularMovies> popularMovies=new ArrayList<>();
                      popularresponse=response.body();
                      for(int i=0;i<popularresponse.getResults().size();i++)
                      {
                          PopularMovies popularMovies1=new PopularMovies();
                          popularMovies.add(popularMovies1);
                      }

                      moviesList.clear();
                      moviesList.addAll(popularresponse.getResults());
                      listener.OnMovieloded(moviesList);
                  }
              }

              @Override
              public void onFailure(Call<PopularMovies> call, Throwable t) {

              }
          });
      }
      else if (type.equals(Contracts.TOP_RATED_MOVIES)){
          Call<TopRatedMovies>call  = Api_Client.getMovieDbService().getTopRatedMovies(Contracts.API_KEY,page);
          call.enqueue(new Callback<TopRatedMovies>() {
              @Override
              public void onResponse(Call<TopRatedMovies> call, Response<TopRatedMovies> response) {
                  if(response.body()!=null)
                  {
                      TopRatedMovies topratedresponse;
                      List<TopRatedMovies> topRatedMovies=new ArrayList<>();
                      topratedresponse=response.body();
                      for(int i=0;i<topratedresponse.getResults().size();i++)
                      {
                          TopRatedMovies topRatedMovies1=new TopRatedMovies();
                          topRatedMovies.add(topRatedMovies1);
                      }

                      moviesList.clear();
                      moviesList.addAll(topratedresponse.getResults());
                      listener.OnMovieloded(moviesList);
                  }
              }

              @Override
              public void onFailure(Call<TopRatedMovies> call, Throwable t) {

              }
          });
      }
      else if (type.equals(Contracts.UPCOMING_MOVIES)){
         Call<UpComingMovies>call = Api_Client.getMovieDbService().getUpcomingMvies(Contracts.API_KEY,page);
          call.enqueue(new Callback<UpComingMovies>() {
              @Override
              public void onResponse(Call<UpComingMovies> call, Response<UpComingMovies> response) {
                  if(response.body()!=null)
                  {
                      UpComingMovies upcomingresponse;
                      List<UpComingMovies> upComingMovies=new ArrayList<>();
                      upcomingresponse=response.body();
                      for(int i=0;i<upcomingresponse.getResults().size();i++)
                      {
                          UpComingMovies nowShowing=new UpComingMovies();
                          upComingMovies.add(nowShowing);
                      }

                      moviesList.clear();
                      moviesList.addAll(upcomingresponse.getResults());
                      listener.OnMovieloded(moviesList);
                  }
              }

              @Override
              public void onFailure(Call<UpComingMovies> call, Throwable t) {

              }
          });
      }
      return moviesList;
  }
}
