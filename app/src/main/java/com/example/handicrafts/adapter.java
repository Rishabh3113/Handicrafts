package com.example.handicrafts;

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

import com.example.handicrafts.view.view;

import java.util.ArrayList;

public  class adapter extends RecyclerView.Adapter<adapter.viewholder> {
    ArrayList<model> list;
    Context context;

    public adapter(ArrayList<model> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view,parent,false);
        return new viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewholder holder, int position) {
       model model=list.get(position);
       holder.image.setImageResource(model.getImage());
       holder.subtitles.setText(model.getSubtitle());

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
         TextView subtitles;
         CardView cardView;



        public viewholder(@NonNull View itemView) {
            super(itemView);
            image=itemView.findViewById(R.id.images);
            subtitles=itemView.findViewById(R.id.sub);
            cardView=itemView.findViewById(R.id.card);

        }
    }
}
