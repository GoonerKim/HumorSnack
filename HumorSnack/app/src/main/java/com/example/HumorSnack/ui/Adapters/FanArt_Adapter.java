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
import com.example.HumorSnack.ui.Activities.FanArt_Show_Activity;
import com.example.HumorSnack.ui.Datas.FanArt;
import com.example.HumorSnack.R;

import java.util.ArrayList;

public class FanArt_Adapter extends RecyclerView.Adapter<FanArt_Adapter.ViewHolder> {

    private ArrayList<FanArt> items = new ArrayList<>();

    @NonNull
    @Override
    public FanArt_Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.fanart_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(itemView);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull FanArt_Adapter.ViewHolder viewHolder, int position) {

        FanArt item = items.get(position);

        Glide.with(viewHolder.itemView.getContext())
                .load(item.getFanart_url())
                .into(viewHolder.fanArt_url);

        viewHolder.fanArt_like.setText(item.getFanart_like());
        viewHolder.fanArt_comment.setText(item.getFanart_comment());

        viewHolder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), FanArt_Show_Activity.class);
                intent.putExtra("nickname", item.getNickname());
                intent.putExtra("date", item.getRegisterDate());
                intent.putExtra("fanArt_url", item.getFanart_url());
                intent.putExtra("fanArt_title", item.getFanart_title());
                intent.putExtra("fanArt_like", item.getFanart_like());
                intent.putExtra("fanArt_comment", item.getFanart_comment());
                ((Activity) v.getContext()).startActivityForResult(intent, Activity.RESULT_OK);
            }
        });

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void setItems(ArrayList<FanArt> items) {
        this.items = items;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        public final View view;
        ImageView fanArt_url;
        TextView fanArt_title, fanArt_like, fanArt_comment;

        ViewHolder(View itemView) {
            super(itemView);
            view = itemView;

            fanArt_url = itemView.findViewById(R.id.fanart_url);

            //fanart_title = itemView.findViewById(R.id.fanart_title);
            fanArt_like = itemView.findViewById(R.id.fanart_like);
            fanArt_comment = itemView.findViewById(R.id.fanart_comment);
        }
    }
}
