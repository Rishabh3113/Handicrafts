package com.example.handicrafts.view;

import android.os.Bundle;
import android.util.Log;
import android.widget.GridView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuBuilder;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.handicrafts.R;
import com.example.handicrafts.categories.data;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class view extends AppCompatActivity {
    private ArrayList<view_data> dataclass;
    private view_gridadap view_gridadap;
    private GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        gridView = findViewById(R.id.grid);

        dataclass = new ArrayList<>();
        view_gridadap = new view_gridadap(getBaseContext(), dataclass);
        gridView.setAdapter(view_gridadap);
        fetchDataFromServer();


    }

    private void fetchDataFromServer() {

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        String url = "https://handmadehavens.com/database.php"; // Replace with your actual PHP API URL

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
                        Toast.makeText(getBaseContext(), "Error fetching data", Toast.LENGTH_SHORT).show();
                    }
                });

        requestQueue.add(jsonArrayRequest);
    }

    private void processJsonResponse(JSONArray response) {
        try {
            dataclass.clear();
            for (int i = 0; i < response.length(); i++) {
                JSONObject product = response.getJSONObject(i);

                view_data viewData = new view_data(
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
                viewData.setImages(product.getString("images"));
                viewData.setDiscount(product.getString("discount"));
                viewData.setName(product.getString("name"));
                viewData.setPrice(product.getString("price"));
                viewData.setDescription(product.getString(("description")));
                viewData.setState(product.getString("state"));
                viewData.setCity(product.getString("city"));
                viewData.setContent_review(product.getString("content_review"));

                //viewData.setFav(R.drawable.favourite);

               // viewData.setProduct_id(product.getString("product_id"));



                dataclass.add(viewData);
            }
            view_gridadap.notifyDataSetChanged();
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
    }








