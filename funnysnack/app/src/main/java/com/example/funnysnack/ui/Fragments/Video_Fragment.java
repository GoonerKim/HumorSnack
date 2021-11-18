package com.example.funnysnack.ui.Fragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.funnysnack.ui.Activities.MainActivity;
import com.example.funnysnack.ui.Adapters.Video_Adapter;
import com.example.funnysnack.ui.Datas.Input_Video;
import com.example.funnysnack.R;



public class Video_Fragment extends Fragment {

    private Video_Adapter adapter = new Video_Adapter();
    private RecyclerView recyclerView;
    ImageView toSub;

    public static Video_Fragment newInstance() {
        return new Video_Fragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v =  inflater.inflate(R.layout.video_main, container, false);

        recyclerView = (RecyclerView) v.findViewById(R.id.video_recycler_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);

        recyclerView.setAdapter(adapter);

        adapter.setItems(new Input_Video().getItems());

        toSub = (ImageView) v.findViewById(R.id.to_sub_list);
        toSub.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){
                ((MainActivity)getActivity()).replaceFragment(Video_Sub_Fragment.newInstance());
            }
        });

        return v;
    }

}
