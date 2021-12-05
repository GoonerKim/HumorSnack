package com.example.HumorSnack.ui.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.HumorSnack.ui.Adapters.FanArt_Adapter;
import com.example.HumorSnack.ui.Datas.Input_FanArt;
import com.example.HumorSnack.R;

public class FanArt_Fragment extends Fragment {

    private FanArt_Adapter adapter = new FanArt_Adapter();
    private RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v =  inflater.inflate(R.layout.fanart_main, container, false);

        recyclerView = (RecyclerView) v.findViewById(R.id.fan_art_recycler_view);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 2);
        recyclerView.setLayoutManager(gridLayoutManager);

        recyclerView.setAdapter(adapter);

        adapter.setItems(new Input_FanArt().getItems());

        return v;
    }

}