package com.example.HumorSnack.ui.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.HumorSnack.R;

public class Login_Activity extends AppCompatActivity {

    TextView find_id, find_pw, join;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_main);

        login = (Button) findViewById(R.id.btn_login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


        find_id = (TextView) findViewById(R.id.find_id);
        find_id.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(getApplicationContext(), Find_ID_Activity.class);
                startActivity(intent1);
            }
        });

        find_pw = (TextView) findViewById(R.id.find_pw);
        find_pw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(getApplicationContext(), Find_PW_Activity.class);
                startActivity(intent2);
            }
        });

        join = (TextView) findViewById(R.id.join);
        join.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3 = new Intent(getApplicationContext(), Join_Activity.class);
                startActivity(intent3);
            }
        });

    }
}
