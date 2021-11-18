package com.example.funnysnack.ui.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;

import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;


import java.util.List;

import com.bumptech.glide.Glide;
import com.example.funnysnack.R;

import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.source.ExtractorMediaSource;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.ui.PlayerControlView;
import com.google.android.exoplayer2.ui.PlayerView;

import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;
import com.google.android.exoplayer2.util.Util;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Video_Play_Activity extends AppCompatActivity {


    private PlayerView exoPlayerView;
    private SimpleExoPlayer player;

    TextView video_date, video_nickname, video_title, video_like, video_comment, reply;
    int like_cnt;
    String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.video_play);

        Intent intent = getIntent();

        url = intent.getStringExtra("video_url");
        String date = intent.getStringExtra("date");
        String title = intent.getStringExtra("video_title");
        String like = intent.getStringExtra("video_like");
        String comment = intent.getStringExtra("video_comment");

        video_date = (TextView) findViewById(R.id.date);
        video_title = (TextView) findViewById(R.id.video_title);
        video_like = (TextView) findViewById(R.id.video_like);
        video_comment = (TextView) findViewById(R.id.video_comment);

        video_date.setText(date);
        video_title.setText(title);
        video_like.setText(like);
        video_comment.setText("("+comment+")");

        initExoPlayer();

        like_cnt = Integer.parseInt(like);

        ImageButton love = (ImageButton) findViewById(R.id.like_img);
        love.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                // 계정당 한번만
                like_cnt = like_cnt+1;
                video_like.setText(String.valueOf(like_cnt));
            }
        });

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.video_bottom_view);

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
    }

    private void initExoPlayer() {
        exoPlayerView = (PlayerView) findViewById(R.id.exoPlayerView);

        player = ExoPlayerFactory.newSimpleInstance(this);
        exoPlayerView.setPlayer(player);

        DataSource.Factory dataSourceFactory = new DefaultDataSourceFactory(this,
                Util.getUserAgent(this, "funny snack"));
        MediaSource videosource = new ExtractorMediaSource.Factory(dataSourceFactory)
                .createMediaSource(Uri.parse(url));
        player.prepare(videosource);
        player.setPlayWhenReady(true);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        player.release();
    }

}
/*    @Override
    protected void onStart() {
        super.onStart();
        initializePlayer();
    }

    @Override
    protected void onStop() {
        super.onStop();
        releasePlayer();
    }

    private void initializePlayer() {
        if (player == null) {

        /*    DefaultRenderersFactory renderersFactory = new DefaultRenderersFactory(this.getApplicationContext());
            DefaultTrackSelector trackSelector = new DefaultTrackSelector();
            DefaultLoadControl loadControl = new DefaultLoadControl();

            player = ExoPlayerFactory.newSimpleInstance(
                    this.getApplicationContext(),
                    renderersFactory,
                    trackSelector,
                    loadControl);

            player = ExoPlayerFactory.newSimpleInstance(this.getApplicationContext());

            //플레이어 연결
            exoPlayerView.setPlayer(player);

            //컨트롤러 없애기
            //exoPlayerView.setUseController(false);

            //사이즈 조절
            //exoPlayerView.setResizeMode(AspectRatioFrameLayout.RESIZE_MODE_ZOOM); // or RESIZE_MODE_FILL

            //음량조절
            //player.setVolume(0);

            //프레임 포지션 설정
            //player.seekTo(currentWindow, playbackPosition);

        }
        String sample = "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4";
        MediaSource mediaSource = buildMediaSource(Uri.parse(sample));

        //prepare
        player.prepare(mediaSource, true, false);

        //start,stop
        player.setPlayWhenReady(playWhenReady);
    }

    private MediaSource buildMediaSource(Uri uri) {

        String userAgent = Util.getUserAgent(this, "funny snack");

        return new ProgressiveMediaSource.Factory(new DefaultHttpDataSourceFactory(userAgent))
                .createMediaSource(uri);

    }

    private void releasePlayer() {
        if (player != null) {
            playbackPosition = player.getCurrentPosition();
            currentWindow = player.getCurrentWindowIndex();
            playWhenReady = player.getPlayWhenReady();

            exoPlayerView.setPlayer(null);
            player.release();
            player = null;

        }
    }
}
@Override
protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.video_play);
        final VideoView videoView = (VideoView)findViewById(R.id.videoView);

        videoView.setVideoPath("https://www.radiantmediaplayer.com/media/bbb-360p.mp4");

        final MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(videoView);
        mediaController.setPadding(0, 0, 0, 80);

        videoView.setMediaController(mediaController);

        ImageButton play = (ImageButton) findViewById(R.id.play_button);
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mediaController.isPlaying()) {
                    resetPlayer();
                }
                else {
                    playVideo(videoUrl, videoView.getHolder());
                    mediaController.show();
                    play.setVisibility(View.GONE);
                }
            }
        });

                videoView.start();

        handler = new Handler() ;

        ListElementsArrayList = new ArrayList<String>(Arrays.asList(ListElements));

        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,
                ListElementsArrayList
        );
        setListView();

        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navi_view);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.navi_back:
                        finish();
                        break;

                    case R.id.navi_favorite:
                        Toast.makeText(Video_Play_Activity.this, "즐겨찾기에 추가됨", Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.navi_share:
                        Toast.makeText(Video_Play_Activity.this, "공유하기", Toast.LENGTH_SHORT).show();
                        break;

                }
                return true;
            }
        });


    }

    private void setListView(){
        String[] stringList = {"바삭이1\n우악 너무 소름끼친다", "바삭이2\n으으으....","바삭이3\n아 밥맛 뚝 떨어짐"};
        ArrayAdapter<String> listAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, stringList);
        listView = (ListView)findViewById(R.id.writing);
        listView.setAdapter(listAdapter);

    }*/