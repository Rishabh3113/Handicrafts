package com.example.handicrafts.home;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.handicrafts.R;
import com.example.handicrafts.detail.detail_view;

import java.util.ArrayList;

public class search_recycler extends RecyclerView.Adapter<search_recycler.viewholder>  {
    Context context;
    ArrayList<home_data> datalist;
    ArrayList<home_data> filterlist;

    public search_recycler(Context context, ArrayList<home_data> datalist) {
        this.context = context;
        this.datalist = datalist;
        this.filterlist = new ArrayList<>(datalist);
       // if (datalist != null) {
           // this.filterlist.addAll(datalist);
        //}

    }

    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_search,parent,false);
        return new viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewholder holder, int position) {
        home_data data=datalist.get(position);
        holder.title.setText(data.getName());
        holder.discount.setText(data.getDiscount());
        holder.price.setText(data.getPrice());
        holder.description.setText(data.getDescription());
        Glide.with(context)
                .load(data.getImages())
                .error(R.drawable.account)// Pass the image URL or resource ID here
                .into(holder.imageView);

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
        return datalist.size();
    }

    public void filterlist(ArrayList<home_data> filterlist){
        datalist=filterlist;
        notifyDataSetChanged();
        notifyItemChanged(0);


    }



    public static class viewholder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView title,description,price,discount;

        public viewholder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.image_search);
            title=itemView.findViewById(R.id.search_title);
            description=itemView.findViewById(R.id.search_description);
            price=itemView.findViewById(R.id.price);
            discount=itemView.findViewById(R.id.discount);
        }
    }
}
