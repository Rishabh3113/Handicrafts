package com.example.handicrafts.categories;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ListAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.handicrafts.R;

import java.util.ArrayList;

public class catFragment extends Fragment {

     GridView gridView;
    grid_adapter adapters;
    ArrayList<data> arrayList;





    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
         View view=inflater.inflate(R.layout.grid,null);

       //  gridView=view.findViewById(R.id.grid);
         arrayList=new ArrayList<>();
         arrayList.add(new data("punjab",R.drawable.images));
        arrayList.add(new data("punjab",R.drawable.images));
        arrayList.add(new data("punjab",R.drawable.images));
        arrayList.add(new data("punjab",R.drawable.images));
        arrayList.add(new data("punjab",R.drawable.images));
        arrayList.add(new data("punjab",R.drawable.images));
        arrayList.add(new data("punjab",R.drawable.images));
        arrayList.add(new data("punjab",R.drawable.images));
        arrayList.add(new data("Uttar Pradesh", R.drawable.punjab));
        arrayList.add(new data("Kerala", R.drawable.arunachal2));
        arrayList.add(new data("Tamil Nadu", R.drawable.punjab));
        arrayList.add(new data("Madhya Pradesh", R.drawable.punjab));
        arrayList.add(new data("Bihar", R.drawable.images));
        arrayList.add(new data("Odisha", R.drawable.punjab));
        arrayList.add(new data("Kolkata", R.drawable.punjab));
        arrayList.add(new data("Assam", R.drawable.punjab));
        arrayList.add(new data("Meghalaya", R.drawable.punjab));
        arrayList.add(new data("Kashmir", R.drawable.punjab));
        arrayList.add(new data("Telangana", R.drawable.punjab));
        arrayList.add(new data("Karnataka", R.drawable.punjab));

        gridView=view.findViewById(R.id.grid);
        adapters=new grid_adapter(arrayList, getContext());
        gridView.setAdapter(adapters);
        return view;

    }
}
