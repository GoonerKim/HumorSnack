package com.example.HumorSnack.ui.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ImageButton;
import android.widget.PopupMenu;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.HumorSnack.ui.Activities.MainActivity;
import com.example.HumorSnack.ui.Adapters.Video_Sub_Adapter;
import com.example.HumorSnack.ui.Datas.Input_Video;
import com.example.HumorSnack.R;


public class Video_Sub_Fragment extends Fragment {

    private Video_Sub_Adapter adapter = new Video_Sub_Adapter();
    private RecyclerView recyclerView;
    ImageButton back, list;

    public static Video_Sub_Fragment newInstance() {
        return new Video_Sub_Fragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v =  inflater.inflate(R.layout.video_sub, container, false);

        recyclerView = (RecyclerView) v.findViewById(R.id.video_sub_recycler_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(getActivity(),LinearLayoutManager.VERTICAL);
        dividerItemDecoration.setDrawable(getActivity().getResources().getDrawable(R.drawable.recyclerview_divider));
        recyclerView.addItemDecoration(dividerItemDecoration);

        recyclerView.setAdapter(adapter);

        adapter.setItems(new Input_Video().getItems());

        back = (ImageButton) v.findViewById(R.id.btn_arrow);
        list = (ImageButton) v.findViewById(R.id.btn_list);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).replaceFragment(Video_Fragment.newInstance());
            }
        });


        list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu = new PopupMenu(getActivity(), v);
                popupMenu.getMenuInflater().inflate(R.menu.video_small_menu, popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()){
                            case R.id.first:
                                Toast.makeText(getActivity(),"최신순",Toast.LENGTH_SHORT).show();
                                break;
                            case R.id.second:
                                Toast.makeText(getActivity(),"조회순",Toast.LENGTH_SHORT).show();
                                break;
                            case R.id.third:
                                Toast.makeText(getActivity(),"오래된순",Toast.LENGTH_SHORT).show();
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
