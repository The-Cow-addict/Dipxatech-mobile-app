package com.dipxa.dipxatechnology;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class ProfileActivity extends AppCompatActivity {

    ImageView imageView;
    Button button, logout_button;
    TextView activity_profile_name, activity_profile_email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        activity_profile_name = findViewById(R.id.activity_profile_name);
        activity_profile_email = findViewById(R.id.email_profile_setting);
        if(HomeActivity.customer.getUsername() != null && HomeActivity.customer.getEmail() != null){
            activity_profile_name.setText(HomeActivity.customer.getUsername());
            activity_profile_email.setText(HomeActivity.customer.getEmail());
        }
        else{
            activity_profile_name.setText("GUEST");
            activity_profile_email.setText("GUEST");
        }

        imageView = findViewById(R.id.back_button);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfileActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });

        button = findViewById(R.id.button_editProfile);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent intent2 = new Intent(ProfileActivity.this, EditProfileActivity.class);
               startActivity(intent2);
            }
        });
    }

}