
package com.example.hp.moviedbapp;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import java.util.List;
import com.google.gson.annotations.SerializedName;
@Entity
public class UpComingMovies {
     @PrimaryKey(autoGenerate = true)
     int id ;
     int movieId;
    @SerializedName("dates")
    private Dates mDates;
    @SerializedName("page")
    private Long mPage;
    @SerializedName("results")
    private List<Movies> mResults;
    @SerializedName("total_pages")
    private Long mTotalPages;
    @SerializedName("total_results")
    private Long mTotalResults;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public Dates getDates() {
        return mDates;
    }

    public void setDates(Dates dates) {
        mDates = dates;
    }

    public Long getPage() {
        return mPage;
    }

    public void setPage(Long page) {
        mPage = page;
    }

    public List<Movies> getResults() {
        return mResults;
    }

    public void setResults(List<Movies> results) {
        mResults = results;
    }

    public Long getTotalPages() {
        return mTotalPages;
    }

    public void setTotalPages(Long totalPages) {
        mTotalPages = totalPages;
    }

    public Long getTotalResults() {
        return mTotalResults;
    }

    public void setTotalResults(Long totalResults) {
        mTotalResults = totalResults;
    }

}
