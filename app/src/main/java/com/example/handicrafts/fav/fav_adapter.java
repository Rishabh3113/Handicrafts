package com.example.handicrafts.fav;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.handicrafts.R;
import com.example.handicrafts.detail.detail_view;
import com.example.handicrafts.home.home_data;
import com.example.handicrafts.home.recycler_adapter;

import java.util.ArrayList;

public class fav_adapter extends RecyclerView.Adapter<fav_adapter.viewholder> {
    Context context;
    ArrayList<home_data> datalist;

    public fav_adapter(Context context, ArrayList<home_data> datalist) {
        this.context = context;
        this.datalist = datalist;
    }

    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.fav_recycler,parent,false);
        return new viewholder(view);
    }

    @Override
    public int getItemCount() {
        return datalist.size();
    }

    @Override
    public void onBindViewHolder(@NonNull viewholder holder, int position) {
        home_data data=datalist.get(position);
        holder.price.setText(data.getPrice());
        holder.title.setText(data.getName());
        holder.body.setText(data.getDescription());
        Glide.with(context).load(data.getImages()).into(holder.view);


        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context, detail_view.class);
                intent.putExtra("product_id",data.getProduct_id());
                context.startActivity(intent);
            }
        });

    }

    public static class viewholder extends RecyclerView.ViewHolder{
        ImageView view;
        TextView title,body,price;


        public viewholder(@NonNull View itemView) {
            super(itemView);

            view=itemView.findViewById(R.id.image_fav);
            title=itemView.findViewById(R.id.fav_text);
            body=itemView.findViewById(R.id.fav_desc);
            price=itemView.findViewById(R.id.price);
        }
    }
}
