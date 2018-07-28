package com.example.hp.moviedbapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieViewholder> {
     List<Movies> MoviewArraylist;
     Context context;
     RowListener listener;
     LayoutInflater inflater;
     public MovieAdapter(Context context,List<Movies> moviewArraylist,RowListener listener){
         this.inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
         this.MoviewArraylist = moviewArraylist;
         this.context = context;
         this.listener = listener;
     }
    @NonNull
    @Override
    public MovieViewholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = inflater.inflate(R.layout.movies_row_layout,viewGroup,false);
        return new MovieViewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MovieViewholder movieViewholder, int i) {
       movieViewholder.tvtitle.setText(MoviewArraylist.get(i).getTitle());
       if(MoviewArraylist.get(i).getPosterPath() != null){
           Picasso.get().load(Contracts.IMAGE_URL+MoviewArraylist.get(i).getPosterPath()).into(movieViewholder.poster);
           movieViewholder.itemView.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {
                 listener.OnItemclick(view,movieViewholder.getAdapterPosition());
               }
           });
       }
    }

    @Override
    public int getItemCount() {
        return MoviewArraylist.size();
    }
}
