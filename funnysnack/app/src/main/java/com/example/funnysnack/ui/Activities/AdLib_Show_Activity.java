package com.example.funnysnack.ui.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.funnysnack.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class AdLib_Show_Activity extends AppCompatActivity {
    ImageView adlib_img;
    TextView adlib_date, adlib_nickname, adlib_title, adlib_like, adlib_comment, reply;
    int like_cnt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.adlib_show);

        Intent intent = getIntent();

        String nickname = intent.getStringExtra("nickname");
        String date = intent.getStringExtra("date");
        String url = intent.getStringExtra("adlib_url");
        String title = intent.getStringExtra("adlib_title");
        String like = intent.getStringExtra("adlib_like");
        String comment = intent.getStringExtra("adlib_comment");

        adlib_img = (ImageView) findViewById(R.id.adlib_img);
        adlib_date = (TextView) findViewById(R.id.date);
        adlib_nickname = (TextView) findViewById(R.id.nickname);
        adlib_title = (TextView) findViewById(R.id.adlib_title);
        adlib_like = (TextView) findViewById(R.id.adlib_like);
        adlib_comment = (TextView) findViewById(R.id.adlib_comment);

        Glide.with(this).load(url).into(adlib_img);
        adlib_date.setText(date);
        adlib_nickname.setText(nickname+"님 작품");
        adlib_title.setText(title);
        adlib_like.setText(like);
        adlib_comment.setText("("+comment+")");

        like_cnt = Integer.parseInt(like);

        ImageButton love = (ImageButton) findViewById(R.id.like_img);
        love.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                // 계정당 한번만
                like_cnt = like_cnt+1;
                adlib_like.setText(String.valueOf(like_cnt));
            }
        });


        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.adlib_bottom_view);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.navi_back:
                        finish();
                        break;

                    case R.id.navi_favorite:
                        //toFavorite
                        break;

                    case R.id.navi_share:
                        //share
                        break;
                }
                return true;
            }
        });

        reply = (TextView) findViewById(R.id.reply);
    }
}
