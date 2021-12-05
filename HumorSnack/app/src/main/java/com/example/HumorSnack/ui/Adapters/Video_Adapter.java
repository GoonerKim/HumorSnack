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
import com.example.HumorSnack.ui.Activities.Video_Play_Activity;
import com.example.HumorSnack.ui.Datas.Video;
import com.example.HumorSnack.R;

import java.util.ArrayList;

public class Video_Adapter extends RecyclerView.Adapter<Video_Adapter.ViewHolder> {

    private ArrayList<Video> items = new ArrayList<>();

    @NonNull
    @Override
    public Video_Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView;
        Video_Adapter.ViewHolder viewHolder;

        itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.video_item_main, parent, false);
        viewHolder = new ViewHolder(itemView);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull Video_Adapter.ViewHolder viewHolder, int position) {

        Video item = items.get(position);

        Glide.with(viewHolder.itemView.getContext())
                .load(item.getThumbnail())
                .into(viewHolder.thumbnail);

        viewHolder.video_title.setText(item.getVideo_title());
        viewHolder.video_like.setText(item.getVideo_like());
        viewHolder.video_comment.setText(item.getVideo_comment());

        viewHolder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), Video_Play_Activity.class);
                intent.putExtra("nickname", item.getNickname());
                intent.putExtra("date", item.getRegisterDate());
                intent.putExtra("video_url", item.getVideo_url());
                intent.putExtra("video_title", item.getVideo_title());
                intent.putExtra("video_like", item.getVideo_like());
                intent.putExtra("video_comment", item.getVideo_comment());
                ((Activity) v.getContext()).startActivityForResult(intent, Activity.RESULT_OK);
            }
        });

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void setItems(ArrayList<Video> items) {
        this.items = items;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        public final View view;
        ImageView thumbnail;
        TextView video_title, video_like, video_comment;

        ViewHolder(View itemView) {
            super(itemView);
            view = itemView;

            thumbnail = itemView.findViewById(R.id.thumbnail);

            video_title = itemView.findViewById(R.id.video_title);
            video_like = itemView.findViewById(R.id.video_like);
            video_comment = itemView.findViewById(R.id.video_comment);

        }

    }

}
