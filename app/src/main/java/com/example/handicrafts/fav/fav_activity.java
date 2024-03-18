package com.example.handicrafts.fav;

import static android.content.Intent.getIntent;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.airbnb.lottie.LottieAnimationView;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.example.handicrafts.R;
import com.example.handicrafts.detail.detail_view;
import com.example.handicrafts.home.home_data;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class fav_activity extends Fragment {
    Animation animation;
    LottieAnimationView animationView;
    TextView textView;
    RecyclerView recyclerView;
    fav_adapter adapter;
    ArrayList<home_data> data;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_fav, null);
        recyclerView = view.findViewById(R.id.recyclers);
        textView = view.findViewById(R.id.fav);
        animationView = view.findViewById(R.id.animation1);

        data=new ArrayList<>();

        adapter=new fav_adapter(getContext(),data);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);







        if (adapter.getItemCount() == 0) {
            // recyclerView.setVisibility(View.INVISIBLE);

            textView.setText("No items to display");
            animation = AnimationUtils.loadAnimation(getContext(), R.anim.anim1);
            textView.startAnimation(animation);

            animationView.setAnimation(R.raw.lottie_2);
            animationView.playAnimation();

        } else {

            recyclerView.setVisibility(View.VISIBLE);

            String product_id = getArguments().getString("product_id");
            fetchdata(product_id);

        }




        return view;
    }

    private void fetchdata( String product_id) {


        RequestQueue requestQueue = Volley.newRequestQueue(getContext());
        //String product_id = getArguments().getString("product_id");
        String url = "https://handmadehavens.com/detail.php?product_id=" + product_id;

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(
                Request.Method.GET,
                url,
                null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        Log.d("YourTag", "Response: " + response.toString());
                        processJsonResponse(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("YourTag", "Error fetching data: " + error.toString());
                        // Handle errors
                        Toast.makeText(getContext(), "Error fetching data", Toast.LENGTH_SHORT).show();
                    }
                });

        requestQueue.add(jsonArrayRequest);
    }

    private void processJsonResponse(JSONArray response) {
        try {
            data.clear();
            for (int i = 0; i < response.length(); i++) {
                JSONObject product = response.getJSONObject(i);

                home_data home_data = new home_data(
                        product.getString("product_id"),
                        product.getString("images"),
                        product.getString("name"),
                        product.getString("price"),
                        product.getString("discount"),
                        product.getString("description"),
                        product.getString("content_review"),
                        product.getString("state"),
                        product.getString("city"),
                        R.drawable.favorite2,
                        R.drawable.discount
                );

                //  viewData.setDiscount_logo(R.drawable.discount);
                home_data.setImages(product.getString("images"));
                home_data.setDiscount(product.getString("discount"));
                home_data.setName(product.getString("name"));
                home_data.setPrice(product.getString("price"));
                home_data.setDescription(product.getString(("description")));
                home_data.setState(product.getString("state"));
                home_data.setCity(product.getString("city"));
                home_data.setContent_review(product.getString("content_review"));

                //viewData.setFav(R.drawable.favourite);

                // viewData.setProduct_id(product.getString("product_id"));


                data.add(home_data);
            }
            //adapter.notifyDataSetChanged();
            adapter.notifyDataSetChanged();
        } catch (JSONException e) {
            e.printStackTrace();


        }


    }
}
