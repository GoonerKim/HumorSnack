package com.example.HumorSnack.ui.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ImageButton;
import android.widget.PopupMenu;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.HumorSnack.ui.Adapters.Humor_Adapter;
import com.example.HumorSnack.ui.Datas.Input_Humor;
import com.example.HumorSnack.R;


public class Humor_Fragment extends Fragment {

    private Humor_Adapter adapter = new Humor_Adapter();
    private RecyclerView recyclerView;
    private ImageButton menu;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v =  inflater.inflate(R.layout.humor_main, container, false);

        menu = (ImageButton) v.findViewById(R.id.humor_menu);

        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popup= new PopupMenu(getActivity(), v);//v는 클릭된 뷰를 의미

                getActivity().getMenuInflater().inflate(R.menu.humor_menu, popup.getMenu());
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()){
                            case R.id.first:
                                break;
                            case R.id.second:
                                break;
                            default:
                                break;
                        }
                        return false;
                    }
                });
                popup.show();
            }
        });


/*        SearchView searchView = v.findViewById(R.id.humor_search_view);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                //searchView.setQuery(searchView.getQuery(), true);
                //Toast.makeText(getActivity(), query, Toast.LENGTH_SHORT).show();
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });*/


        recyclerView = (RecyclerView) v.findViewById(R.id.humor_recycler_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);

        recyclerView.setAdapter(adapter);

        adapter.setItems(new Input_Humor().getItems());

        setHasOptionsMenu(true);

        return v;
    }

}