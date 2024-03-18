package com.example.handicrafts.categories;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.handicrafts.R;
import com.example.handicrafts.adapter;
import com.example.handicrafts.profile.model;

import java.util.ArrayList;

public class catFragment extends Fragment {

    ArrayList<state_data> arrayList;
    ArrayList<model> arrayList1;
    ArrayList<model> arrayList2;
    RecyclerView recyclerView;
    RecyclerView recyclerView1;
    RecyclerView recyclerView4;
    RecyclerView recyclerView5;
    RecyclerView recyclerView6;
    list_adapter adapter;


    RecyclerView recyclerView2;
    RecyclerView recyclerView3;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.mydesign, null);

        recyclerView=view.findViewById(R.id.recyler);

        arrayList=new ArrayList<>();
        arrayList.add(new state_data(R.drawable.images,R.drawable.baseline_arrow_drop_down_24,"AndhraPradesh Handicrafts"));
        arrayList.add(new state_data(R.drawable.arunachal,R.drawable.baseline_arrow_drop_down_24,"Nagaland Handicrafts"));
        arrayList.add(new state_data(R.drawable.arunachal2,R.drawable.baseline_arrow_drop_down_24,"Kerala Handicrafts"));
        arrayList.add(new state_data(R.drawable.punjab,R.drawable.baseline_arrow_drop_down_24," Punjab Handicrafts"));
        arrayList.add(new state_data(R.drawable.images,R.drawable.baseline_arrow_drop_down_24,"Rajashan Handicrafts"));
        arrayList.add(new state_data(R.drawable.arunachal2,R.drawable.baseline_arrow_drop_down_24,"odisha  Handicrafts"));
        arrayList.add(new state_data(R.drawable.arunachal,R.drawable.baseline_arrow_drop_down_24,"TamilNadu Handicrafts"));
        adapter=new list_adapter(arrayList,getContext());
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);





        return view;


    }
}
