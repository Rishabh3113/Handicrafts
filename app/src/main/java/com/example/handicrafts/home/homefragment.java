package com.example.handicrafts.home;




import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.core.app.AppOpsManagerCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.handicrafts.R;
import com.facebook.shimmer.ShimmerFrameLayout;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class homefragment extends Fragment {
    androidx.appcompat.widget.SearchView searchView;
    ViewPager2 viewPager2;
    //use viewpager with a timer

    RecyclerView recyclerView;
    RecyclerView recyclerView2;
    recycler_adapter adapter2;

    home_adapter adapter;
    RelativeLayout relativeLayout;
     ArrayList<home_data> filteredData;
    ArrayList<home_data> data;
    LottieAnimationView animationView;
ShimmerFrameLayout frameLayout;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.new_home, null);

        if (!isConnected(getContext())) {



            showNoInternetDialog();
        }


        searchView = view.findViewById(R.id.search);
        frameLayout=view.findViewById(R.id.shimms);
        relativeLayout=view.findViewById(R.id.relative_5);
        viewPager2=view.findViewById(R.id.banner);


        recyclerView2=view.findViewById(R.id.grid2);
        recyclerView=view.findViewById(R.id.grid_love);
        searchView.setQueryHint("Search Handicrafts Here :)");
        searchView.getSolidColor();
        searchView.clearFocus();
        EditText txtSearch = ((EditText)searchView.findViewById(androidx.appcompat.R.id.search_src_text));

        txtSearch.setHintTextColor(getResources().getColor(R.color.black));
        txtSearch.setTextColor(Color.BLACK);


        data = new ArrayList<>();
        adapter2=new recycler_adapter(getContext(),data);
        GridLayoutManager layoutManager = new GridLayoutManager(getContext(), 2);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter2);
        GridLayoutManager layoutManager2 = new GridLayoutManager(getContext(), 2);
        recyclerView2.setLayoutManager(layoutManager2);
        recyclerView2.setAdapter(adapter2);



        fetchdata();

        filteredData = new ArrayList<>(data);



          searchView.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View view) {
                  Intent intent=new Intent(getContext(),home_search.class);
                  startActivity(intent);

              }
          });

         searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
             @Override
             public boolean onQueryTextSubmit(String query) {
                 return false;
             }

             @Override
             public boolean onQueryTextChange(String newText) {


                 filter(newText);
                 return true;
             }
         });
        return view;


    }

    private void showNoInternetDialog() {


        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());


        LayoutInflater inflater = getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.no_internet, null);
        relativeLayout.setVisibility(View.INVISIBLE);
        animationView=dialogView.findViewById(R.id.no_internet);
        animationView.setAnimation(R.raw.internet);
        animationView.playAnimation();
        builder.setView(dialogView);
        AlertDialog dialog = builder.create();


        dialog.show();
    }

    private boolean isConnected(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivityManager != null) {
            NetworkInfo activeNetwork = connectivityManager.getActiveNetworkInfo();
            return activeNetwork != null && activeNetwork.isConnectedOrConnecting();
        }
        return false;
    }

    private void filter(String newText) {

        ArrayList<home_data> filteredlist=new ArrayList<>();
        for (home_data item:data){
            if (item.getName().toLowerCase().contains(newText.toLowerCase())){
                filteredlist.add(item);
            }
        }
        adapter2.filterlist(filteredlist);
    }


    private void fetchdata() {
            frameLayout.startShimmerAnimation();


        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
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
                frameLayout.postDelayed(() -> {
                    frameLayout.stopShimmerAnimation();
                    frameLayout.setVisibility(View.GONE);
                    recyclerView2.setVisibility(View.VISIBLE);
                }, 3000);
            }
            //adapter.notifyDataSetChanged();
            adapter2.notifyDataSetChanged();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}




