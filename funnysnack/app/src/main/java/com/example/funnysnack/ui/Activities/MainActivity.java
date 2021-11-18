package com.example.funnysnack.ui.Activities;

import android.os.Bundle;

import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.funnysnack.ui.Fragments.AdLib_Fragment;
import com.example.funnysnack.ui.Fragments.FanArt_Fragment;
import com.example.funnysnack.ui.Fragments.Humor_Fragment;
import com.example.funnysnack.ui.Fragments.MyPage_Fragment;
import com.example.funnysnack.ui.Fragments.Video_Fragment;
import com.example.funnysnack.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;


public class MainActivity extends AppCompatActivity {

    private FragmentManager fragmentManager = getSupportFragmentManager();
    BottomNavigationView bottomNavigationView;
    private Video_Fragment video = new Video_Fragment();
    private Humor_Fragment humor = new Humor_Fragment();
    private AdLib_Fragment adlib = new AdLib_Fragment();
    private FanArt_Fragment fanart = new FanArt_Fragment();
    private MyPage_Fragment mypage = new MyPage_Fragment();

    public static MainActivity newInstance() {
        return new MainActivity();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);

        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_view);

        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.main_frame, video).commitAllowingStateLoss();

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {

                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                        FragmentTransaction transaction = fragmentManager.beginTransaction();

                        switch (item.getItemId()) {
                            case R.id.navi_video:
                                transaction.replace(R.id.main_frame, video.newInstance()).addToBackStack(null).commitAllowingStateLoss();
                                break;

                            case R.id.navi_humor:
                                transaction.replace(R.id.main_frame, humor).addToBackStack(null).commitAllowingStateLoss();
                                break;

                            case R.id.navi_ad_lib:
                                transaction.replace(R.id.main_frame, adlib.newInstance()).addToBackStack(null).commitAllowingStateLoss();
                                break;

                            case R.id.navi_fan_art:
                                transaction.replace(R.id.main_frame, fanart).addToBackStack(null).commitAllowingStateLoss();
                                break;

                            case R.id.navi_my_page:
                                transaction.replace(R.id.main_frame, mypage).addToBackStack(null).commitAllowingStateLoss();
                                break;
                        }
                        return true;
                    }
                });

    }


    public void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.main_frame, fragment).addToBackStack(null).commitAllowingStateLoss();
    }

}
