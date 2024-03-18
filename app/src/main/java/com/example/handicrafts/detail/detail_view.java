package com.example.handicrafts.detail;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.example.handicrafts.R;
import com.example.handicrafts.categories.data;
import com.example.handicrafts.fav.fav_activity;
import com.example.handicrafts.fav.test_activity;
import com.example.handicrafts.view.view_data;

import org.json.JSONException;
import org.json.JSONObject;

public class detail_view extends AppCompatActivity {
    ImageView images;
    ImageView backbutton,fav;
    TextView description, state, city, title, price, discount,price2;

    LottieAnimationView animationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_new);
        price2=findViewById(R.id.title2);
        fav=findViewById(R.id.fav_detail);



        backbutton = findViewById(R.id.backed);
        images = findViewById(R.id.detail_images);
        description = findViewById(R.id.description);
        state = findViewById(R.id.state);
        city = findViewById(R.id.city);
        title = findViewById(R.id.detail_title);
        price = findViewById(R.id.price);
        discount = findViewById(R.id.detail_discount);
        animationView = findViewById(R.id.lottie);
        animationView.setAnimation(R.raw.lottie4);
        animationView.playAnimation();

        backbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        String product_id = getIntent().getStringExtra("product_id");
        fav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fav.setImageResource(R.drawable.baseline_favorite_24);
                Toast.makeText(detail_view.this, "pls check favorites !! your item have been added", Toast.LENGTH_SHORT).show();

                test_activity fragment = new test_activity();

                // Create a Bundle and pass the product ID to the fragment
                Bundle bundle = new Bundle();
                bundle.putString("product_id", product_id);
                fragment.setArguments(bundle);
                getSupportFragmentManager().beginTransaction()
                        .add(fragment, "test_fragment_tag")
                        .addToBackStack(null)
                        .commit();

            }
        });

        String url = "https://handmadehavens.com/detail.php?product_id=" + product_id;


        fetchProductDetail(url);
    }
    private void fetchProductDetail(String url) {
        // Instantiate the RequestQueue
        RequestQueue queue = Volley.newRequestQueue(this);

        // Request a JSON object response from the provided URL
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        // Parse the JSON response and populate UI elements with product details
                        try {
                            String productDescription = response.getString("description");
                            String productState = response.getString("state");
                            String productCity = response.getString("city");
                            String productName = response.getString("name");
                            String productPrice = response.getString("price");
                            String productDiscount = response.getString("discount");
                            String productImage = response.getString("images");

                            // Populate UI elements
                            description.setText(productDescription);
                            state.setText(productState);
                            city.setText(productCity);
                            title.setText(productName);
                            price.setText(productPrice);
                            discount.setText(productDiscount);
                            price2.setText(productName);

                            // Load product image using Glide
                            Glide.with(detail_view.this)
                                    .load(productImage)
                                    .error(R.drawable.account) // Placeholder image in case of error
                                    .into(images);
                        } catch (JSONException e) {
                            e.printStackTrace();
                            // Handle JSON parsing error
                            Toast.makeText(detail_view.this, "Error parsing product details", Toast.LENGTH_SHORT).show();
                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        Toast.makeText(detail_view.this, "Error fetching product details", Toast.LENGTH_SHORT).show();
                    }
                });


        queue.add(jsonObjectRequest);
    }
}




