
package com.example.hp.moviedbapp;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

import java.util.List;
import com.google.gson.annotations.SerializedName;

@Entity()
public class PopularMovies {
    @PrimaryKey(autoGenerate = true)
   int id;
   int movieId;
   @Ignore
    @SerializedName("page")
    private Long mPage;
   @Ignore
    @SerializedName("results")
    private List<Movies> mResults;
   @Ignore
    @SerializedName("total_pages")
    private Long mTotalPages;
   @Ignore
    @SerializedName("total_results")
    private Long mTotalResults;

    public Long getPage() {
        return mPage;
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
