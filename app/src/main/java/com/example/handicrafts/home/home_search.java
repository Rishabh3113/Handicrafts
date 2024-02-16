package com.example.handicrafts.home;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.handicrafts.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class home_search extends AppCompatActivity {

    RecyclerView recyclerView;
    search_recycler adapter;
    ArrayList<home_data> data;
    SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_search);
        searchView=findViewById(R.id.seach_view);
        recyclerView=findViewById(R.id.search);



        EditText txtSearch = ((EditText)searchView.findViewById(androidx.appcompat.R.id.search_src_text));

        txtSearch.setHintTextColor(getResources().getColor(R.color.black));
       txtSearch.setTextColor(Color.BLACK);

       data=new ArrayList<>();
       adapter=new search_recycler(getBaseContext(),data);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getBaseContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                 recyclerView.setVisibility(View.VISIBLE);
                       return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                recyclerView.setVisibility(View.VISIBLE);
                filter(newText);
                return true;
            }
        });




        fetchdata();









    }

    private void filter(String newText) {
        ArrayList<home_data> filteredlist=new ArrayList<>();
        for (home_data item:data){
            if (item.getName().toLowerCase().contains(newText.toLowerCase())){
                filteredlist.add(item);
                //recyclerView.setVisibility(View.INVISIBLE);
            }
        }
        adapter.filterlist(filteredlist);
        //recyclerView.setVisibility(View.INVISIBLE);
    }

    private void fetchdata() {



            RequestQueue requestQueue = Volley.newRequestQueue(getBaseContext());
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
                        recyclerView.setVisibility(View.GONE);
                    }
                    //adapter.notifyDataSetChanged();
                    adapter.notifyDataSetChanged();
                   // recyclerView.setVisibility(View.GONE);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

    }
