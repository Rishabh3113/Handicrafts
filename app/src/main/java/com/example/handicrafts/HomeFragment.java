package com.example.handicrafts;

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

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    ArrayList<model> arrayList;
    ArrayList<model> arrayList1;
    ArrayList<model> arrayList2;
    RecyclerView recyclerView;
    RecyclerView recyclerView1;
   RecyclerView recyclerView4;
   RecyclerView recyclerView5;
   RecyclerView recyclerView6;

    RecyclerView recyclerView2;
    RecyclerView recyclerView3;
    adapter adapter;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.home_fragment,null);

        aruncahal(view);
        nagaland(view);
        assam(view);
        odisha(view);
        gujrat(view);
        kerala(view);
        kashmir(view);
        return view;




    }

    private void kashmir(View view) {
        recyclerView4=view.findViewById(R.id.kashmir);
        arrayList1=new ArrayList<>();
        arrayList1.add(new model(R.drawable.arunachal2, "Thungka Painting"));
        arrayList1.add(new model(R.drawable.arunachal2, "Weaving Craft"));
        arrayList1.add(new model(R.drawable.arunachal2, "arunachal"));
        arrayList1.add(new model(R.drawable.arunachal2, "Weaving Craft"));
        arrayList1.add(new model(R.drawable.images, "Weaving Craft"));
        adapter = new adapter(arrayList1, getContext());
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView4.setLayoutManager(layoutManager);
        recyclerView4.setAdapter(adapter);


    }

    private void kerala(View view) {
        recyclerView5=view.findViewById(R.id.kerala);
        arrayList=new ArrayList<>();
        arrayList.add(new model(R.drawable.images, "Thungka Painting"));
        arrayList.add(new model(R.drawable.images, "Weaving Craft"));
        arrayList.add(new model(R.drawable.images, "Weaving Craft"));
        arrayList.add(new model(R.drawable.images, "Weaving Craft"));
        arrayList.add(new model(R.drawable.images, "Weaving Craft"));
        adapter = new adapter(arrayList, getContext());
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView5.setLayoutManager(layoutManager);
        recyclerView5.setAdapter(adapter);


    }

    private void gujrat(View view) {
        recyclerView6=view.findViewById(R.id.punjab);
        arrayList=new ArrayList<>();
        arrayList.add(new model(R.drawable.images, "Thungka Painting"));
        arrayList.add(new model(R.drawable.images, "Weaving Craft"));
        arrayList.add(new model(R.drawable.images, "Weaving Craft"));
        arrayList.add(new model(R.drawable.images, "Weaving Craft"));
        arrayList.add(new model(R.drawable.images, "Weaving Craft"));
        adapter = new adapter(arrayList, getContext());
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView6.setLayoutManager(layoutManager);
        recyclerView6.setAdapter(adapter);

    }

    private void odisha(View view) {
        recyclerView3=view.findViewById(R.id.odisha);
        arrayList2=new ArrayList<>();
        arrayList2.add(new model(R.drawable.arunachal2, "Thungka Painting"));
        arrayList2.add(new model(R.drawable.arunachal2, "Weaving Craft"));
        arrayList2.add(new model(R.drawable.arunachal, "Weaving Craft"));
        arrayList2.add(new model(R.drawable.arunachal, "Weaving Craft"));
        arrayList2.add(new model(R.drawable.images, "Weaving Craft"));
        adapter = new adapter(arrayList2, getContext());
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView3.setLayoutManager(layoutManager);
        recyclerView3.setAdapter(adapter);

    }

    private void assam(View view) {
        recyclerView2=view.findViewById(R.id.assam);
        arrayList=new ArrayList<>();
        arrayList.add(new model(R.drawable.arunachal, "Thungka Painting"));
        arrayList.add(new model(R.drawable.arunachal, "Weaving Craft"));
        arrayList.add(new model(R.drawable.arunachal, "Weaving Craft"));
        arrayList.add(new model(R.drawable.arunachal, "Weaving Craft"));
        arrayList.add(new model(R.drawable.arunachal2, "Weaving Craft"));
        adapter = new adapter(arrayList, getContext());
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView2.setLayoutManager(layoutManager);
        recyclerView2.setAdapter(adapter);
    }

    private void nagaland(View view) {
        recyclerView1=view.findViewById(R.id.nagaland);
        arrayList=new ArrayList<>();
        arrayList.add(new model(R.drawable.images, "Thungka Painting"));
        arrayList.add(new model(R.drawable.images, "Weaving Craft"));
        arrayList.add(new model(R.drawable.images, "Weaving Craft"));
        arrayList.add(new model(R.drawable.images, "Weaving Craft"));
        arrayList.add(new model(R.drawable.images, "Weaving Craft"));
        adapter = new adapter(arrayList, getContext());
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView1.setLayoutManager(layoutManager);
        recyclerView1.setAdapter(adapter);

    }

    private void aruncahal(View view) {
        recyclerView=view.findViewById(R.id.arunachal);
        arrayList=new ArrayList<>();
        arrayList.add(new model(R.drawable.images, "Thungka Painting"));
        arrayList.add(new model(R.drawable.images, "Weaving Craft"));
        arrayList.add(new model(R.drawable.images, "Weaving Craft"));
        arrayList.add(new model(R.drawable.images, "Weaving Craft"));
        arrayList.add(new model(R.drawable.images, "Weaving Craft"));
        adapter = new adapter(arrayList, getContext());
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

    }


}
