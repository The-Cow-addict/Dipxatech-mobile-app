package com.dipxa.dipxatechnology;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class LoginActivity extends AppCompatActivity {

    EditText emailLoginInput, passwordLoginInput;
    Button buttonLogin, buttonGoogle, buttonFacebook;
    DataBaseHelper dataBaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        emailLoginInput = findViewById(R.id.emailLoginInput);
        passwordLoginInput = findViewById(R.id.passwordloginInput);
        dataBaseHelper = new DataBaseHelper(LoginActivity.this);


        buttonLogin = findViewById(R.id.buttonLogin);
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                customerDBregister customer = dataBaseHelper.loginByEmail(emailLoginInput.getText().toString());
                if(customer.getPassword() != 0) {
                    if (customer.getPassword() == Integer.parseInt(String.valueOf(passwordLoginInput.getText()))) {
                        // login success
                        Toast.makeText(LoginActivity.this, "Logged in", Toast.LENGTH_SHORT).show();
                        HomeActivity.customer = customer;
                        Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                        startActivity(intent);
                    } else {
                        // wrong password
                        Toast.makeText(LoginActivity.this, "Wrong Password", Toast.LENGTH_SHORT).show();
                    }
                }
                else {
                    //wrong email
                    Toast.makeText(LoginActivity.this, "Your Email is invalid", Toast.LENGTH_SHORT).show();
                }

            }
        });


        TextView signupbutton = findViewById(R.id.signupText);
        signupbutton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
            }
        });
        buttonGoogle = findViewById(R.id.buttonGoogle);
        buttonGoogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(LoginActivity.this, "We will implement this function in future", Toast.LENGTH_SHORT).show();
            }
        });

        buttonFacebook = findViewById(R.id.buttonFacebook);
        buttonFacebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(LoginActivity.this, "We will implement this function in future", Toast.LENGTH_SHORT).show();
            }
        });
    }
}

