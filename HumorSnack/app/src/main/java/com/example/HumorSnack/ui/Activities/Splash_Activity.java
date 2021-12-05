package com.example.HumorSnack.ui.Activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class Splash_Activity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
        finish();
    }
}
;