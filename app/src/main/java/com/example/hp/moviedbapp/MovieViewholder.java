package com.example.hp.moviedbapp;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MovieViewholder extends RecyclerView.ViewHolder {
    public  View itemView;
    TextView tvtitle,tvOverview;
    public ImageView poster;
    public MovieViewholder(@NonNull View itemView) {
        super(itemView);
        this.itemView = itemView;
        this.tvtitle = itemView.findViewById(R.id.textView2);
        poster = itemView.findViewById(R.id.imageView);
    }

}
