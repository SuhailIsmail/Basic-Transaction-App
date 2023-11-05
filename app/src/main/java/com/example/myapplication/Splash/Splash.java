package com.example.myapplication.Splash;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

import com.airbnb.lottie.Lottie;
import com.airbnb.lottie.LottieAnimationView;
import com.example.myapplication.Login.Activity_Register;
import com.example.myapplication.R;

public class Splash extends AppCompatActivity {

    TextView view;
    LottieAnimationView aview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        view = findViewById(R.id.lotv);
        aview = findViewById(R.id.lottie_ani);

        view.animate().translationY(-1500).setDuration(2700).setStartDelay(0);
        aview.animate().translationX(2000).setDuration(500).setStartDelay(6000);
        

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent i = new Intent(getApplicationContext(), Activity_Register.class);
                startActivity(i);
            }
        },6500);

    }


}