package com.example.funnysnack.ui.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.funnysnack.ui.Datas.AdLib_Sub;
import com.example.funnysnack.R;

import java.util.ArrayList;

public class AdLib_Sub_Adapter extends RecyclerView.Adapter<AdLib_Sub_Adapter.ViewHolder> {

    private ArrayList<AdLib_Sub> items = new ArrayList<>();

    @NonNull
    @Override
    public AdLib_Sub_Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView;
        AdLib_Sub_Adapter.ViewHolder viewHolder;

        itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.adlib_rank_sub_item, parent, false);
        viewHolder = new AdLib_Sub_Adapter.ViewHolder(itemView);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull AdLib_Sub_Adapter.ViewHolder viewHolder, int position) {

        AdLib_Sub item = items.get(position);

        viewHolder.month_week.setText(item.getMonth_week());

        viewHolder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void setItems(ArrayList<AdLib_Sub> items) {
        this.items = items;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        public final View view;
        TextView month_week;

        ViewHolder(View itemView) {
            super(itemView);
            view = itemView;

            month_week = itemView.findViewById(R.id.month_week);
        }
    }
}
