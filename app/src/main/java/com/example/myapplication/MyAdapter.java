package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyviewHolder> {
   Context context;
    ArrayList<movie>list;

    public MyAdapter(Context context, ArrayList<movie> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.recycle_movie,parent,false);
        return new MyviewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyviewHolder holder, int position) {
     movie Movie=list.get(position);
        holder.available.setText(Movie.getAvailable());
        holder.censor.setText(Movie.getCensor());
        holder.synopsis.setText(Movie.getSynopsis());
        holder.duration.setText(Movie.getDuration());
        holder.releaseDate.setText(Movie.getReleaseDate());
        holder.movieName.setText(Movie.getMovieName());
//        Glide.with(holder.itemView.getContext()).load(Movie.getDirector()).into(holder.director);
        Glide.with(holder.itemView.getContext()).load(Movie.getPoster()).into(holder.poster);


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyviewHolder extends RecyclerView.ViewHolder{
        TextView censor,available,synopsis,duration,releaseDate,movieName;
        ImageView director,poster;

        public MyviewHolder(@NonNull View itemView) {
            super(itemView);
            censor =itemView.findViewById(R.id.censor);
            available =itemView.findViewById(R.id.info);
            synopsis =itemView.findViewById(R.id.syntext);
            duration =itemView.findViewById(R.id.duration);
            releaseDate=itemView.findViewById(R.id.release);
            movieName =itemView.findViewById(R.id.moviename);
//            director =itemView.findViewById(R.id.director);
            poster =itemView.findViewById(R.id.movieposter);



        }
    }
}
