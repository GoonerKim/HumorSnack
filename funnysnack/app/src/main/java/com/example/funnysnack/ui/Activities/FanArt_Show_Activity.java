package com.example.funnysnack.ui.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.funnysnack.R;
import com.example.funnysnack.ui.Adapters.Comment_Adapter;
import com.example.funnysnack.ui.Adapters.Video_Adapter;
import com.example.funnysnack.ui.Datas.Input_Comment;
import com.example.funnysnack.ui.Datas.Input_Video;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class FanArt_Show_Activity extends AppCompatActivity{

    //private Comment_Adapter adapter = new Comment_Adapter();
    //private RecyclerView recyclerView;

    ImageView fanart_img;
    TextView fanart_date, fanart_nickname, fanart_title, fanart_like, fanart_comment, reply;
    int like_cnt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fanart_show);

        Intent intent = getIntent();

        String nickname = intent.getStringExtra("nickname");
        String date = intent.getStringExtra("date");
        String url = intent.getStringExtra("fanart_url");
        String title = intent.getStringExtra("fanart_title");
        String like = intent.getStringExtra("fanart_like");
        String comment = intent.getStringExtra("fanart_comment");

        fanart_img = (ImageView) findViewById(R.id.fanart_img);
        fanart_date = (TextView) findViewById(R.id.date);
        fanart_nickname = (TextView) findViewById(R.id.nickname);
        fanart_title = (TextView) findViewById(R.id.fanart_title);
        fanart_like = (TextView) findViewById(R.id.fanart_like);
        fanart_comment = (TextView) findViewById(R.id.fanart_comment);

        Glide.with(this).load(url).into(fanart_img);
        fanart_date.setText(date);
        fanart_nickname.setText(nickname+"님 작품");
        fanart_title.setText(title);
        fanart_like.setText(like);
        fanart_comment.setText("("+comment+")");

        like_cnt = Integer.parseInt(like);

        ImageButton love = (ImageButton) findViewById(R.id.like_img);
        love.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                // 계정당 한번만
                like_cnt = like_cnt+1;
                fanart_like.setText(String.valueOf(like_cnt));
            }
        });


        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.fanart_bottom_view);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.navi_back:
                        finish();
                        break;

                    case R.id.navi_favorite:
                        Intent intent = new Intent(FanArt_Show_Activity.this, Favorite_Activity.class);
                        intent.putExtra("fav_img", url);
                        intent.putExtra("date", date);
                        intent.putExtra("nickname", nickname);
                        intent.putExtra("fav_title", title);
                        intent.putExtra("fav_like", like);
                        break;

                    case R.id.navi_share:
                        //share
                        break;
                }
                return true;
            }
        });

   /*     reply = (TextView) findViewById(R.id.reply);
        reply.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                recyclerView = (RecyclerView) findViewById(R.id.comment_recycler_view);
                recyclerView.setLayoutManager(linearLayoutManager);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);;
                recyclerView.setAdapter(adapter);

                adapter.setItems(new Input_Comment().getItems());
            }
        });*/
    }
}
