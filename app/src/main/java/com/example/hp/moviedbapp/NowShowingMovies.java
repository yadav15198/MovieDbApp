
package com.example.hp.moviedbapp;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

import java.util.List;
import com.google.gson.annotations.SerializedName;
@Entity()
public class NowShowingMovies {
    @PrimaryKey(autoGenerate = true)
    int id;
    int movieId;
    @Ignore
    @SerializedName("dates")
    private Dates mDates;
    @Ignore
    @SerializedName("page")
    private Long mPage;
    @Ignore
    @SerializedName("results")
    private List<Movies> mMovies;
    @Ignore
    @SerializedName("total_pages")
    private Long mTotalPages;
    @Ignore
    @SerializedName("total_results")
    private Long mTotalResults;
    public Dates getDates() {
        return mDates;
    }


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
        return mMovies;
    }

    public void setResults(List<Movies> movies) {
        mMovies = movies;
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
