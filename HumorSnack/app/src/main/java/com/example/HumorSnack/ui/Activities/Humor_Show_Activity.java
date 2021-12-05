package com.example.HumorSnack.ui.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.HumorSnack.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Humor_Show_Activity extends AppCompatActivity {

    ImageView humor_img;
    TextView humor_date, humor_nickname, humor_title, humor_like, humor_comment, reply;
    int like_cnt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.humor_show);

        Intent intent = getIntent();

        String nickname = intent.getStringExtra("nickname");
        String date = intent.getStringExtra("date");
        String url = intent.getStringExtra("humor_url");
        String title = intent.getStringExtra("humor_title");
        String like = intent.getStringExtra("humor_like");
        String comment = intent.getStringExtra("humor_comment");


        humor_img = (ImageView) findViewById(R.id.humor_img);
        humor_date = (TextView) findViewById(R.id.date);
        humor_nickname = (TextView) findViewById(R.id.nickname);
        humor_title = (TextView) findViewById(R.id.humor_title);
        humor_like = (TextView) findViewById(R.id.humor_like);
        humor_comment = (TextView) findViewById(R.id.humor_comment);

        Glide.with(this).load(url).into(humor_img);
        humor_date.setText(date);
        humor_nickname.setText(nickname+"님 작품");
        humor_title.setText(title);
        humor_like.setText(like);
        humor_comment.setText("("+comment+")");

        like_cnt = Integer.parseInt(like);

        ImageButton love = (ImageButton) findViewById(R.id.like_img);
        love.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                // 계정당 한번만
                like_cnt = like_cnt+1;
                humor_like.setText(String.valueOf(like_cnt));
            }
        });


        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.humor_bottom_view);

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
