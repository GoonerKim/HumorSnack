package com.example.HumorSnack.ui.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ImageView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.HumorSnack.ui.Activities.MainActivity;
import com.example.HumorSnack.ui.Adapters.AdLib_Rk_Adapter;
import com.example.HumorSnack.ui.Datas.Input_AdLib;
import com.example.HumorSnack.R;

public class AdLib_Rk_Fragment extends Fragment {

    private AdLib_Rk_Adapter adapter = new AdLib_Rk_Adapter();
    private RecyclerView recyclerView;
    ImageView toSub;

    public static AdLib_Rk_Fragment newInstance() {
        return new AdLib_Rk_Fragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v =  inflater.inflate(R.layout.adlib_rank_main, container, false);

        recyclerView = (RecyclerView) v.findViewById(R.id.adlib_rk_recycler_view);
        LinearLayoutManager horizonalLayoutManager = new LinearLayoutManager(getActivity(), RecyclerView.HORIZONTAL, false);
        recyclerView.setLayoutManager(horizonalLayoutManager);

        recyclerView.setAdapter(adapter);

        adapter.setItems(new Input_AdLib().getItems());

        toSub = (ImageView) v.findViewById(R.id.to_sub_list);
        toSub.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){
                ((MainActivity)getActivity()).replaceFragment(AdLib_Rk_Sub_Fragment.newInstance());
            }
        });

        return v;
    }

}
