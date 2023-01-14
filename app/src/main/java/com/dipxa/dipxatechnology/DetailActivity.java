package com.dipxa.dipxatechnology;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {
    ImageView backButton;
    Button buyButton;
    private ImageView plusButton, minusButton, productImage;
    private TextView amountText, titleProduct, descriptionProduct, productPrice;
    int amountOrder=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        amountText = findViewById(R.id.amount_number);
        plusButton = findViewById(R.id.plus_button);
        minusButton = findViewById(R.id.minus_button);
        titleProduct = findViewById(R.id.title_product);
        descriptionProduct = findViewById(R.id.description_product);
        productImage = findViewById(R.id.product_image);
        productPrice = findViewById(R.id.product_price_text);

        titleProduct.setText(getIntent().getExtras().getString("name"));
        productPrice.setText(getIntent().getExtras().getString("price"));
        descriptionProduct.setText(getIntent().getExtras().getString("description"));
        int productimage = getIntent().getIntExtra("image",0);
        productImage.setImageResource(productimage);

        buyButton = findViewById(R.id.buy_button);
        buyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DetailActivity.this, LoadingBuyingActivity.class);
                startActivity(intent);
            }
        });
        backButton = findViewById(R.id.back_button_detail);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DetailActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });

        getProduct();
    }

    public void getProduct(){
        amountText.setText(String.valueOf(amountOrder));
        plusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                amountOrder = amountOrder+1;
                amountText.setText(String.valueOf(amountOrder));
            }
        });

        minusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(amountOrder>1){
                    amountOrder = amountOrder-1;
                }
                amountText.setText(String.valueOf(amountOrder));
            }
        });
    }

}