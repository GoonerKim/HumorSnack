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

import com.example.HumorSnack.ui.Activities.AdLib_Show_Activity;
import com.example.HumorSnack.ui.Datas.AdLib;
import com.example.HumorSnack.R;

import java.util.ArrayList;

public class AdLib_Rk_Adapter extends RecyclerView.Adapter<AdLib_Rk_Adapter.ViewHolder> {

    private ArrayList<AdLib> items = new ArrayList<>();

    @NonNull
    @Override
    public AdLib_Rk_Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView;
        AdLib_Rk_Adapter.ViewHolder viewHolder;

        itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.adlib_rank_main_item, parent, false);
        viewHolder = new AdLib_Rk_Adapter.ViewHolder(itemView);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull AdLib_Rk_Adapter.ViewHolder viewHolder, int position) {

        AdLib item = items.get(position);

        Glide.with(viewHolder.itemView.getContext())
                .load(item.getAdlib_url())
                .into(viewHolder.adlib_url);

        viewHolder.adlib_title.setText(item.getAdlib_title());
        viewHolder.adlib_like.setText(item.getAdlib_like());
        viewHolder.nickname.setText(item.getNickname());

        viewHolder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), AdLib_Show_Activity.class);
                intent.putExtra("nickname", item.getNickname());
                intent.putExtra("date", item.getRegisterDate());
                intent.putExtra("adlib_url", item.getAdlib_url());
                intent.putExtra("adlib_title", item.getAdlib_title());
                intent.putExtra("adlib_like", item.getAdlib_like());
                intent.putExtra("adlib_comment", item.getAdlib_comment());
                ((Activity) v.getContext()).startActivityForResult(intent, Activity.RESULT_OK);
            }
        });

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void setItems(ArrayList<AdLib> items) {
        this.items = items;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        public final View view;
        ImageView adlib_url;
        TextView adlib_title, adlib_like, nickname;

        ViewHolder(View itemView) {
            super(itemView);
            view = itemView;

            adlib_url = itemView.findViewById(R.id.adlib_url);

            adlib_title = itemView.findViewById(R.id.adlib_title);
            adlib_like = itemView.findViewById(R.id.adlib_like);
            nickname = itemView.findViewById(R.id.nickname);

        }
    }
}
