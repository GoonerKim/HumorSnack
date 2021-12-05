package com.example.HumorSnack.ui.Adapters;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.HumorSnack.ui.Activities.Humor_Show_Activity;
import com.example.HumorSnack.ui.Datas.Comment;
import com.example.HumorSnack.R;

import java.util.ArrayList;

public class Comment_Adapter extends RecyclerView.Adapter<Comment_Adapter.ViewHolder> {

    private ArrayList<Comment> items = new ArrayList<>();

    @NonNull
    @Override
    public Comment_Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView;
        Comment_Adapter.ViewHolder viewHolder;

        itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.comment_item, parent, false);
        viewHolder = new Comment_Adapter.ViewHolder(itemView);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull Comment_Adapter.ViewHolder viewHolder, int position) {

        Comment item = items.get(position);

        viewHolder.reply.setText(item.getReply());
        viewHolder.reply_like.setText(item.getReply_like());
        viewHolder.nickname.setText(item.getNickname());

        viewHolder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), Humor_Show_Activity.class);
                intent.putExtra("nickname", item.getNickname());
                intent.putExtra("date", item.getRegisterDate());
                intent.putExtra("reply", item.getReply());
                intent.putExtra("reply_like", item.getReply_like());
                ((Activity) v.getContext()).startActivityForResult(intent, Activity.RESULT_OK);
            }
        });

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void setItems(ArrayList<Comment> items) {
        this.items = items;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        public final View view;
        TextView reply, reply_like, nickname;

        ViewHolder(View itemView) {
            super(itemView);
            view = itemView;

            reply = itemView.findViewById(R.id.reply);
            reply_like = itemView.findViewById(R.id.reply_like);
            nickname = itemView.findViewById(R.id.nickname);
        }
    }

}

