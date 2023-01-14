package com.dipxa.dipxatechnology;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class LoadingBuyingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading_buying);

        new Handler().postDelayed(new Runnable() {
            public void run() {
                startActivity(new Intent(LoadingBuyingActivity.this, PaymentActivity.class));
            }
        }, 2500);
    }
}
