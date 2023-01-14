package com.dipxa.dipxatechnology;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;
import java.util.List;


public class OnboardingActivity extends AppCompatActivity {

    OnboardingAdapter onboardingAdapter;
    LinearLayout layoutOnboardingIndicator;
    MaterialButton buttonOnBoard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onboarding);

        layoutOnboardingIndicator = findViewById(R.id.layoutOnBoardIndicator);
        buttonOnBoard = findViewById(R.id.buttonOnBoard);

        setupOnboardingItems();
        ViewPager2 onboardingViewPager = findViewById(R.id.onboardViewpager);
        onboardingViewPager.setAdapter(onboardingAdapter);

        setupOnboardingIndicator();
        setCurrentOnboardingIndicator(0);

        onboardingViewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                setCurrentOnboardingIndicator(position);
            }
        });

        buttonOnBoard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(onboardingViewPager.getCurrentItem() + 1 < onboardingAdapter.getItemCount()){
                    onboardingViewPager.setCurrentItem(onboardingViewPager.getCurrentItem() + 1);
                }else{
                    startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                    finish();
                }
            }
        });
    }

    private  void setupOnboardingItems(){

        List<OnboardingItems> onboardingItems = new ArrayList<>();

        OnboardingItems welcome = new OnboardingItems();
        welcome.setTitle("Welcome to Dipxa Technology");
        welcome.setDescription("E-Commerce App for Electronic Products");
        welcome.setImage(R.drawable.welcome);

        OnboardingItems customerSupport = new OnboardingItems();
        customerSupport.setTitle("Customer Service");
        customerSupport.setDescription("Damn nice customer service ever");
        customerSupport.setImage(R.drawable.helloanime);

        OnboardingItems stock = new OnboardingItems();
        stock.setTitle("Our Stock");
        stock.setDescription("We will keep updated our stock as soon as possible");
        stock.setImage(R.drawable.stock);

        onboardingItems.add(welcome);
        onboardingItems.add(customerSupport);
        onboardingItems.add(stock);

        onboardingAdapter = new OnboardingAdapter(onboardingItems);
    }

    private void setupOnboardingIndicator(){
        ImageView[] indicators = new ImageView[onboardingAdapter.getItemCount()];
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT
        );
        layoutParams.setMargins(8, 0, 8, 0);
        for(int i=0; i<indicators.length; i++){
            indicators[i] = new ImageView(getApplicationContext());
            indicators[i].setImageDrawable(ContextCompat.getDrawable(
                    getApplicationContext(),R.drawable.onboard_indicator_inactive
            ));

            indicators[i].setLayoutParams(layoutParams);
            layoutOnboardingIndicator.addView(indicators[i]);
        }
    }

    private void setCurrentOnboardingIndicator(int index){
        int childCount = layoutOnboardingIndicator.getChildCount();
        for (int i=0; i<childCount; i++){
            ImageView imageView = (ImageView) layoutOnboardingIndicator.getChildAt(i);
            if(i == index){
                imageView.setImageDrawable(
                        ContextCompat.getDrawable(getApplicationContext(), R.drawable.onboard_indicator_active)
                );
            }
            else{
                imageView.setImageDrawable(ContextCompat.getDrawable(
                        getApplicationContext(), R.drawable.onboard_indicator_inactive));
            }
        }

        if(index == onboardingAdapter.getItemCount() - 1){
            buttonOnBoard.setText("Start");
        }else{
            buttonOnBoard.setText("Next");
        }
    }
}