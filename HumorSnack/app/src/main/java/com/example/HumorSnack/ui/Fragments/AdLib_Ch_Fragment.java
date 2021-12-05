package com.example.HumorSnack.ui.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.HumorSnack.ui.Adapters.AdLib_Ch_Adapter;
import com.example.HumorSnack.ui.Datas.Input_AdLib;
import com.example.HumorSnack.R;

public class AdLib_Ch_Fragment extends Fragment {

    private AdLib_Ch_Adapter adapter = new AdLib_Ch_Adapter();
    private RecyclerView recyclerView;

    public static AdLib_Ch_Fragment newInstance() {
        return new AdLib_Ch_Fragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v =  inflater.inflate(R.layout.adlib_challenge, container, false);

        recyclerView = (RecyclerView) v.findViewById(R.id.ch_recycler_view);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 2);
        recyclerView.setLayoutManager(gridLayoutManager);

        recyclerView.setAdapter(adapter);

        adapter.setItems(new Input_AdLib().getItems());

        return v;
    }

}
