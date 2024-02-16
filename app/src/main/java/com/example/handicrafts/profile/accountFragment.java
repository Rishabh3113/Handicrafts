package com.example.handicrafts.profile;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.handicrafts.R;
import com.example.handicrafts.detail_activity;
import com.example.handicrafts.edit_profile;
import com.facebook.shimmer.ShimmerFrameLayout;

import java.util.ArrayList;

public class accountFragment extends Fragment {
    ShimmerFrameLayout shimmerFrameLayout;
    TextView textView;
    TextView addresses;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.account,null);
        textView=view.findViewById(R.id.accounts);
        addresses=view.findViewById(R.id.address);
        shimmerFrameLayout=view.findViewById(R.id.shimmer);
       // shimmerFrameLayout.startShimmerAnimation();
        ListView listView=view.findViewById(R.id.list_items);
        listView.setVisibility(View.GONE);
        ArrayList<model> models = new ArrayList<>();
        models.add(new model(R.drawable.baseline_business_24, "Edit profile",R.drawable.baseline_arrow_forward_24));
        models.add(new model(R.drawable.baseline_business_24, "Address",R.drawable.baseline_arrow_forward_24));
        models.add(new model(R.drawable.baseline_business_24, "Phone number",R.drawable.baseline_arrow_forward_24));
        models.add(new model(R.drawable.baseline_business_24, "Contact us",R.drawable.baseline_arrow_forward_24));
        models.add(new model(R.drawable.baseline_business_24, "Rate us",R.drawable.baseline_arrow_forward_24));
        models.add(new model(R.drawable.baseline_business_24, "Profile pic",R.drawable.baseline_arrow_forward_24));
        models.add(new model(R.drawable.baseline_business_24, "Orders",R.drawable.baseline_arrow_forward_24));
        models.add(new model(R.drawable.baseline_logout_24, "Log out",R.drawable.baseline_arrow_forward_24));
        // Create custom adapter with the sample data
        profile_adapter adapter = new profile_adapter(getContext(), models);


        // Set adapter to ListView
        listView.setAdapter(adapter);
        shimmerFrameLayout.postDelayed(() -> {
            shimmerFrameLayout.stopShimmerAnimation();
            shimmerFrameLayout.setVisibility(View.GONE);
            listView.setVisibility(View.VISIBLE);
        }, 3000);

       textView.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
             click();
           }

       });

       addresses.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               addresses1();
           }
       });

        return view;




    }

    private void addresses1() {
        Intent intent=new Intent(getContext(), detail_activity.class);
        startActivity(intent);
    }

    private void click() {
        Intent intent=new Intent(getContext(), edit_profile.class);
        startActivity(intent);
    }

    @Override
    public void onResume() {
        super.onResume();
        shimmerFrameLayout.startShimmerAnimation();
    }

    @Override
    public void onPause() {
        shimmerFrameLayout.stopShimmerAnimation();
        super.onPause();
    }
}
