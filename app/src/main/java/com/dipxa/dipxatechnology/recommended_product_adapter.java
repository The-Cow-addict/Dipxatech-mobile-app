package com.dipxa.dipxatechnology;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class recommended_product_adapter extends RecyclerView.Adapter<recommended_product_adapter.ViewHolder> {

    private ArrayList<product> products = new ArrayList<>();

    private Context context;

    public recommended_product_adapter(Context context) {
        this.context = context;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recommended_items, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.product_name.setText(products.get(position).getProduct_name());
        holder.product_price.setText(products.get(position).getProduct_price());
        holder.product_description.setText(products.get(position).getProduct_description());
        holder.image_product.setImageResource(products.get(position).getImage_product());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra("name", products.get(position).getProduct_name());
                intent.putExtra("price", products.get(position).getProduct_price());
                intent.putExtra("image", products.get(position).getImage_product());
                intent.putExtra("description", products.get(position).getProduct_description());
                context.startActivity(intent);
            }
        });
        Glide.with(context)
                .asBitmap()
                .load(products.get(position).getImage_product())
                .into(holder.image_product);
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    public void setProducts(ArrayList<product> products) {
        this.products = products;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView product_name, product_price, product_description;
        private CardView parent;
        private ImageView image_product;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            product_name = itemView.findViewById(R.id.product_name);
            parent = itemView.findViewById(R.id.parent);
            product_price = itemView.findViewById(R.id.product_price);
            image_product = itemView.findViewById(R.id.image_product);
            product_description = itemView.findViewById(R.id.product_description);
        }
    }

}
