package com.example.funnysnack.ui.Adapters;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.funnysnack.ui.Activities.Humor_Show_Activity;
import com.example.funnysnack.ui.Datas.Humor;
import com.example.funnysnack.R;

import java.util.ArrayList;

public class Humor_Adapter extends RecyclerView.Adapter<Humor_Adapter.ViewHolder> {

    private ArrayList<Humor> items = new ArrayList<>();

    @NonNull
    @Override
    public Humor_Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView;
        Humor_Adapter.ViewHolder viewHolder;

        itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.humor_item, parent, false);
        viewHolder = new Humor_Adapter.ViewHolder(itemView);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull Humor_Adapter.ViewHolder viewHolder, int position) {

        Humor item = items.get(position);

        viewHolder.humor_title.setText(item.getHumor_title());

        viewHolder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), Humor_Show_Activity.class);
                intent.putExtra("nickname", item.getNickname());
                intent.putExtra("date", item.getRegisterDate());
                intent.putExtra("humor_url", item.getHumor_url());
                intent.putExtra("humor_title", item.getHumor_title());
                intent.putExtra("humor_like", item.getHumor_like());
                intent.putExtra("humor_comment", item.getHumor_comment());
                ((Activity) v.getContext()).startActivityForResult(intent, Activity.RESULT_OK);
            }
        });

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void setItems(ArrayList<Humor> items) {
        this.items = items;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        public final View view;
        TextView humor_title;

        ViewHolder(View itemView) {
            super(itemView);
            view = itemView;

            humor_title = itemView.findViewById(R.id.humor_title);
        }
    }

}
