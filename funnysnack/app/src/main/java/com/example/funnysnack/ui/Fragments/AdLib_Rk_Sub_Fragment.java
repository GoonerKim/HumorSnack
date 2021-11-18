package com.example.funnysnack.ui.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.PopupMenu;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.funnysnack.ui.Activities.MainActivity;
import com.example.funnysnack.ui.Adapters.AdLib_Sub_Adapter;
import com.example.funnysnack.ui.Datas.Input_AdLib_Sub;
import com.example.funnysnack.R;

public class AdLib_Rk_Sub_Fragment extends Fragment {

    private AdLib_Sub_Adapter adapter = new AdLib_Sub_Adapter();
    private RecyclerView recyclerView;
    ImageButton back, list;

    public static AdLib_Rk_Sub_Fragment newInstance() {
        return new AdLib_Rk_Sub_Fragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v =  inflater.inflate(R.layout.adlib_rank_sub, container, false);

        recyclerView = (RecyclerView) v.findViewById(R.id.adlib_rk_sub_recycler_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);

        recyclerView.setAdapter(adapter);

        adapter.setItems(new Input_AdLib_Sub().getItems());

        back = (ImageButton) v.findViewById(R.id.btn_arrow);
        list = (ImageButton) v.findViewById(R.id.btn_list);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).replaceFragment(AdLib_Fragment.newInstance());
            }
        });


        list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu = new PopupMenu(getActivity(), v);
                popupMenu.getMenuInflater().inflate(R.menu.humor_menu, popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()){
                            case R.id.first:
                                Toast.makeText(getActivity(),"전체보기",Toast.LENGTH_SHORT).show();
                                break;
                            case R.id.second:
                                Toast.makeText(getActivity(),"안본거보기",Toast.LENGTH_SHORT).show();
                                break;
                            default:
                                break;
                        }
                        return false;
                    }
                });
                popupMenu.show();
            }
        });

        return v;
    }

}
