package com.dipxa.dipxatechnology;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.google.android.material.navigation.NavigationView;

import java.text.BreakIterator;
import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ImageView imageView;
    private ImageSlider imageSlider;
    private RecyclerView recyclerView;
    TextView textView5;
    DataBaseHelper dataBaseHelper;
    public static customerDBregister customer = new customerDBregister();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        textView5 = findViewById(R.id.textView5);
        if (customer.getUsername() != null) {
            textView5.setText("Hello " + customer.getUsername());
        }
        else {
            textView5.setText("Hello Guest");
        }

        imageSlider = findViewById(R.id.imageSlider);

        ArrayList<SlideModel>  slideModels = new ArrayList<>();

        slideModels.add(new SlideModel(R.drawable.welcome_to_dipxatechnology, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.contact_our_customer_services, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.we_will_keep_update_stock, ScaleTypes.FIT));

        imageSlider.setImageList(slideModels, ScaleTypes.FIT);

        recyclerView = findViewById(R.id.recyclerView);

        ArrayList<product> products = new ArrayList<>();
        products.add(new product("RTX 3060", "$1200", "ASUS Dual GeForce RTX™ 3060 12GB GDDR6 with two powerful Axial-tech fans and a 2-slot design for broad compatibility", R.drawable.rtx3060));
        products.add(new product("Acer Nitro 5", "$5500", "Acer Nitro 5 (2020) is a Windows 10 Home laptop with a 15.00-inch display that has a resolution of 1920x1080 pixels. It is powered by a Core i5 processor and it comes with 8GB of RAM. The Acer Nitro 5 (2020) packs 1TB of HDD storage and 256GB of SSD storage. Graphics are powered by Nvidia GeForce GTX 1650.", R.drawable.acernitro_5_an515_55));
        products.add(new product("TPLink Archer C6","$600", "AC1200 Wireless MU-MIMO Gigabit Router",R.drawable.tp_link_acher_c6));
        products.add(new product("iPhone 12","$4500", "The new finish complements the beautiful flat-edge design of iPhone 12, which features an advanced dual-camera system, Super Retina XDR display with the Ceramic Shield front cover, A14 Bionic, and 5G",R.drawable.iphone_12_img));
        products.add(new product("Samsung Galaxy Watch 4","$1500", "Track your fitness progress with our first smartwatch that conveniently measures body composition. Get to know your body fat percentage, skeletal muscle, body water and more to achieve your goals. The Samsung BioActive Sensor and our fastest chip brings the biggest innovation to Galaxy Watch yet.",R.drawable.galaxy_watch4));
        products.add(new product("Razer Cynosa V2","$650", "Paint your play in a truly immersive light with the Razer Cynosa V2—the essential RGB gaming keyboard. With customizable lighting in every key, watch it come alive as you game on Chroma-integrated titles, and embrace a gaming experience you won’t ever want to turn away from.",R.drawable.razer_cynosa_v2));
        products.add(new product("Logitech G502","$270", "Iconic G502 design meets pro-grade LIGHTSPEED wireless for ultra-fast, reliable connectivity. HERO 25K sensor features sub-micron tracking. POWERPLAY compatible for continuous charging both at rest and play.",R.drawable.g502_lightspeed_hero));
        products.add(new product("Sony WH-1000XM4","$2900", "Designed in a new Silent White colour to reflect the concept of silence and serenity of the noise cancelling headphones.",R.drawable.sony_wh_1000xm4));
        products.add(new product("PS5 Controller","$500", "Heighten Your Senses™\n" + "\n" + "The DualSense wireless controller for PS5 offers immersive haptic feedback2, dynamic adaptive triggers2 and a built-in microphone, all integrated into an iconic design.",R.drawable.ps5_controller));
        products.add(new product("JBL Flip 3","$360", "Portable speakers are all the craze now. JBL speakers in particular, are some of the most popular of the lot. For a start, the cylinder-shaped speaker looks amazing. It stands at a mere 6.65 inches tall with a 2.51 inch width and weighs only 450 grams. That’s a little more than a smartphone.",R.drawable.jbl_flip3));

        recommended_product_adapter adapter = new recommended_product_adapter(HomeActivity.this);
        adapter.setProducts(products);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)
        );

        imageView = findViewById(R.id.profile_picture_home);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, ProfileActivity.class);
                startActivity(intent);
            }
        });

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigation_view);
        androidx.appcompat.widget.Toolbar toolbar = findViewById(R.id.toolbar);


        toolbar.setTitleTextColor(getResources().getColor(R.color.purple_200));

        setSupportActionBar(toolbar);

        navigationView.bringToFront();
        ActionBarDrawerToggle toggle= new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        toggle.getDrawerArrowDrawable().setColor(getResources().getColor(R.color.purple_200));
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

        navigationView.setCheckedItem(R.id.navigation_home);
    }

    @Override
    public void onBackPressed(){
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else
        {
            super.onBackPressed();
        }
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch(item.getItemId()){
            case R.id.navigation_home:
                break;
            case R.id.navigation_profile:
                Intent intent = new Intent(HomeActivity.this, ProfileActivity.class);
                startActivity(intent);
                break;
            case R.id.navigation_login:
                Intent intent2 = new Intent(HomeActivity.this, LoginActivity.class);
                startActivity(intent2);
                break;
            case R.id.navigation_contactUs:
                Intent intent3 = new Intent(HomeActivity.this, ContactUsAcitvity.class);
                startActivity(intent3);
            case R.id.navigation_logout:
                textView5.setText("Hello GUEST");
        }

        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }


}
