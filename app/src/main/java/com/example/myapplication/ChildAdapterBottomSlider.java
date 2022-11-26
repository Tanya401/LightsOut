package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.Collections;
import java.util.List;


public class ChildAdapterBottomSlider extends RecyclerView.Adapter<ChildAdapterBottomSlider.MyViewHolder>{

    Context context;
    private List<ChildModelBottomSlider> childlists;

    public ChildAdapterBottomSlider() {
    }

    public ChildAdapterBottomSlider(List<ChildModelBottomSlider> childlists) {
        this.childlists = childlists;
        this.childlists.removeAll(Collections.singleton(null));
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.child_item_dashboard_bottom_slider,parent,false);
        return new ChildAdapterBottomSlider.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        ChildModelBottomSlider childItem = childlists.get(position);
        Glide.with(holder.itemView.getContext()).load(childItem.getPoster()).into(holder.poster);

    }

    @Override
    public int getItemCount() {
        if(childlists!=null)
        {
            return childlists.size();
        }
        else {
            return 0;
        }
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        ImageView poster;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            poster=itemView.findViewById(R.id.BottomPoster);
        }
    }
}
