package com.example.funnysnack.ui.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.funnysnack.ui.Activities.Favorite_Activity;
import com.example.funnysnack.ui.Activities.Login_Activity;
import com.example.funnysnack.R;

public class MyPage_Fragment extends Fragment {


    private View v;
    Switch switchAlarm;
    TextView login, nickname, nick_change, favorite, comment, tipoff, logout;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        v = inflater.inflate(R.layout.mypage_off,container,false);

       /*
       //login
       //  v = inflater.inflate(R.layout.mypage_in,container,false);

        nickname =  (TextView) v.findViewById(R.id.nickname);

        nick_change = (TextView) v.findViewById(R.id.nickname_change);
        nick_change.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){

            }
        });



        comment = (TextView) v.findViewById(R.id.comment);
        comment.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){

            }
        });

        logout = (TextView) v.findViewById(R.id.logout);
        logout.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){

            }
        });*/

        login = (TextView) v.findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){
                Intent intent = new Intent(getActivity(), Login_Activity.class);
                startActivity(intent);
            }
        });

        favorite = (TextView) v.findViewById(R.id.favorite);
        favorite.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){
                Intent intent = new Intent(getActivity(), Favorite_Activity.class);
                startActivity(intent);
            }
        });

        tipoff = (TextView) v.findViewById(R.id.tip_off);
        tipoff.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){
                //제보하기
            }
        });

        switchAlarm = v.findViewById(R.id.switch_alarm);

        switchAlarm.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                }
                else {
                }
            }
        });

        return v;
    }

}