package com.example.funnysnack.ui.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.funnysnack.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Favorite_Show_Activity extends AppCompatActivity {

    ImageView fav_img;
    TextView fav_date, fav_nickname, fav_title, fav_like, reply;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.favorite_show);

        Intent intent = getIntent();

        String nickname = intent.getStringExtra("nickname");
        String date = intent.getStringExtra("date");
        String url = intent.getStringExtra("fav_url");
        String title = intent.getStringExtra("fav_title");
        String like = intent.getStringExtra("fav_like");
        String comment = intent.getStringExtra("fav_comment");


        fav_img = (ImageView) findViewById(R.id.fav_img);
        fav_date = (TextView) findViewById(R.id.date);
        fav_nickname = (TextView) findViewById(R.id.nickname);
        fav_title = (TextView) findViewById(R.id.fav_title);
        fav_like = (TextView) findViewById(R.id.fav_like);

        Glide.with(this).load(url).into(fav_img);
        fav_date.setText(date);
        fav_nickname.setText(nickname+"님 작품");
        fav_title.setText(title);
        fav_like.setText(like);

        reply = (TextView) findViewById(R.id.reply);
    }

}
