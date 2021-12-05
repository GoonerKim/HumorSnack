package com.example.HumorSnack.ui.Adapters;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.HumorSnack.ui.Activities.Favorite_Show_Activity;
import com.example.HumorSnack.ui.Datas.Favorite;
import com.example.HumorSnack.R;

import java.util.ArrayList;

public class Favorite_Adapter extends RecyclerView.Adapter<Favorite_Adapter.ViewHolder> {

    private ArrayList<Favorite> items = new ArrayList<>();

    @NonNull
    @Override
    public Favorite_Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView;
        Favorite_Adapter.ViewHolder viewHolder;

        itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.favorite_item, parent, false);
        viewHolder = new ViewHolder(itemView);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull Favorite_Adapter.ViewHolder viewHolder, int position) {

        Favorite item = items.get(position);

        Glide.with(viewHolder.itemView.getContext())
                .load(item.getFav_url())
                .into(viewHolder.fav_img);

        viewHolder.fav_title.setText(item.getFav_title());
        viewHolder.fav_like.setText(item.getFav_like());
        viewHolder.fav_comment.setText(item.getFav_comment());

        viewHolder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), Favorite_Show_Activity.class);
                intent.putExtra("nickname", item.getNickname());
                intent.putExtra("date", item.getRegisterDate());
                intent.putExtra("fav_url", item.getFav_url());
                intent.putExtra("fav_title", item.getFav_title());
                intent.putExtra("fav_like", item.getFav_like());
                intent.putExtra("fav_comment", item.getFav_comment());
                ((Activity) v.getContext()).startActivityForResult(intent, Activity.RESULT_OK);
            }
        });

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void setItems(ArrayList<Favorite> items) {
        this.items = items;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        public final View view;
        ImageView fav_img;
        TextView fav_title, fav_like, fav_comment;

        ViewHolder(View itemView) {
            super(itemView);
            view = itemView;

            fav_img = itemView.findViewById(R.id.fav_img);

            fav_title = itemView.findViewById(R.id.fav_title);
            fav_like = itemView.findViewById(R.id.fav_like);
            fav_comment = itemView.findViewById(R.id.fav_comment);
        }
    }
}

