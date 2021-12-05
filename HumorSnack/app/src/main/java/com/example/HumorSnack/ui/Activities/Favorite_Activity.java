package com.example.HumorSnack.ui.Activities;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.HumorSnack.ui.Adapters.Favorite_Adapter;
import com.example.HumorSnack.ui.Datas.Favorite;
import com.example.HumorSnack.R;

import java.util.ArrayList;

public class Favorite_Activity extends AppCompatActivity {

    private Favorite_Adapter adapter = new Favorite_Adapter();
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.favorite_main);

        Intent intent = getIntent();

        String nickname = intent.getStringExtra("nickname");
        String date = intent.getStringExtra("date");
        String url = intent.getStringExtra("fav_url");
        String title = intent.getStringExtra("fav_title");
        String like = intent.getStringExtra("fav_like");
        String comment = intent.getStringExtra("fav_comment");

        recyclerView = (RecyclerView) findViewById(R.id.favorite_recycler_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        recyclerView.setAdapter(adapter);

        ArrayList<Favorite> items = new ArrayList<>();

        for (int i=0; i<items.size(); i++) {
            Favorite fav = new Favorite(url,title,like,comment,date, nickname);
            items.add(fav);
        }

        adapter.setItems(items);
    }
}
