package com.example.handicrafts.categories;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.handicrafts.R;
import com.example.handicrafts.model;

import java.util.ArrayList;

public  class state_adapters extends RecyclerView.Adapter<state_adapters.viewholder> {
    ArrayList<models> list;
    Context context;

    public state_adapters(ArrayList<models> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.sexy,parent,false);
        return new viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewholder holder, int position) {
       models model=list.get(position);

       holder.subtitles.setText(model.getName());
       holder.price.setText(model.getPrice());
       holder.discount.setText(model.getDiscount());
        Glide.with(context).load(model.getImages()).into(holder.image);

       holder.itemView.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent intent=new Intent(context, com.example.handicrafts.view.view.class);
               context.startActivity(intent);
           }
       });


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class viewholder extends RecyclerView.ViewHolder{
         ImageView image;
         TextView subtitles,discount,price;
         CardView cardView;



        public viewholder(@NonNull View itemView) {
            super(itemView);
            image=itemView.findViewById(R.id.images);
            discount=itemView.findViewById(R.id.discount);
            price=itemView.findViewById(R.id.price);
            subtitles=itemView.findViewById(R.id.sub);
            cardView=itemView.findViewById(R.id.card);

        }
    }
}
