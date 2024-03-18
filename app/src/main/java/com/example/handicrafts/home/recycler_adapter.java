package com.example.handicrafts.home;

import static com.example.handicrafts.R.drawable.baseline_favorite_24;

import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.handicrafts.R;
import com.example.handicrafts.adapter;
import com.example.handicrafts.detail.detail_view;
import com.example.handicrafts.fav.favFragment;
import com.example.handicrafts.fav.fav_activity;
import com.google.android.material.animation.ImageMatrixProperty;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class recycler_adapter extends RecyclerView.Adapter<recycler_adapter.viewholder> {
    Context context;
    ArrayList<home_data> arrayList;
    //ArrayList<home_data> filtered_list;


    public recycler_adapter(Context context, ArrayList<home_data> arrayList) {
        this.context = context;
        this.arrayList = arrayList;

    }


    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_item2,parent,false);
        return new viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewholder holder, int position) {
        home_data data=arrayList.get(position);
        holder.title.setText(data.getName());
        holder.discount.setText(data.getDiscount());
        holder.price.setText(data.getPrice());

        Glide.with(context)
                .load(data.getImages())
                .error(R.drawable.account)// Pass the image URL or resource ID here
                .into(holder.imageView);
        //grid view and list view have same adapter




        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context, detail_view.class);
                intent.putExtra("product_id", data.getProduct_id());
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });




    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public void filterlist(ArrayList<home_data> filterlist){
        arrayList=filterlist;
        notifyDataSetChanged();
        notifyItemChanged(0);


    }

    public static class viewholder extends RecyclerView.ViewHolder{

        ImageView imageView;

        TextView title;
        TextView price;
        TextView discount;




        public viewholder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.profile_image);
            title=itemView.findViewById(R.id.heading);
            price=itemView.findViewById(R.id.price);
            discount=itemView.findViewById(R.id.discount);


        }
    }





}
