package com.dipxa.dipxatechnology;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

import com.airbnb.lottie.LottieAnimationView;

public class IntroductionActivity extends AppCompatActivity {
    ImageView logo;
    ImageView appName;
    LottieAnimationView lottieAnimationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introduction);

        logo = findViewById(R.id.dipxa_logo);
        appName = findViewById(R.id.dipxa_name);
        lottieAnimationView = findViewById(R.id.starryBackground);

        appName.animate().translationY(2000).setDuration(1000).setStartDelay(4000);
        logo.animate().translationY(-2000).setDuration(1000).setStartDelay(4000);


        new Handler().postDelayed(new Runnable() {
            public void run() {
                startActivity(new Intent(IntroductionActivity.this, OnboardingActivity.class));
            }
        }, 5000);
    }
}
