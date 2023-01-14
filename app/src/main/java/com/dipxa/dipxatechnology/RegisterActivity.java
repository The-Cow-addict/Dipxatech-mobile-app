package com.dipxa.dipxatechnology;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class RegisterActivity extends AppCompatActivity {

    EditText username,email,password,passwordConfirm;
    Button registerButton;
    DataBaseHelper dataBaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        username = findViewById(R.id.userNameInput);
        email = findViewById(R.id.emailInput);
        password = findViewById(R.id.passwordInput);
        passwordConfirm = findViewById(R.id.confirmpasswordInput);
        registerButton = findViewById(R.id.registerButton);



        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username.getText().toString();
                String pass = password.getText().toString();
                String confirmpass = passwordConfirm.getText().toString();

                if(user.equals("") || pass.equals("") || confirmpass.equals(""))
                {
                    Toast.makeText(RegisterActivity.this, "Fill All The Fields.", Toast.LENGTH_SHORT).show();
                }else{}
                customerDBregister customerDB;
                try {
                    customerDB = new customerDBregister( username.getText().toString(), email.getText().toString(), Integer.parseInt(password.getText().toString()), Integer.parseInt(passwordConfirm.getText().toString()));
                    if(Integer.parseInt(password.getText().toString()) == Integer.parseInt(passwordConfirm.getText().toString())){
                        Toast.makeText(RegisterActivity.this, customerDB.toString(), Toast.LENGTH_SHORT).show();
                    }else {
                        Toast.makeText(RegisterActivity.this, "The Passwords Do Not Align", Toast.LENGTH_SHORT).show();
                        return;
                    }
                }
                catch (Exception e){
                    Toast.makeText(RegisterActivity.this, "Error when Registering", Toast.LENGTH_SHORT).show();
                    return;
                }

                DataBaseHelper dataBaseHelper = new DataBaseHelper(RegisterActivity.this);
                boolean success = dataBaseHelper.addOne(customerDB);
                Toast.makeText(RegisterActivity.this, "Success= " + success, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });


        TextView loginbutton = findViewById(R.id.alreadyhaveaccountText);
        loginbutton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                DataBaseHelper dataBaseHelper = new DataBaseHelper(RegisterActivity.this);
            }
        });
    }
}