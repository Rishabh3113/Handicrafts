package com.example.handicrafts.categories;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.handicrafts.R;
import com.example.handicrafts.model;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class list_adapter extends RecyclerView.Adapter<list_adapter.viewholder> {

    items_adapter adapter;

    ArrayList<state_data> dataArrayList;
    Context context;
    boolean isclosed=false;

    public list_adapter(ArrayList<state_data> dataArrayList, Context context) {
        this.dataArrayList = dataArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.design9,parent,false);
        return new viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewholder holder, int position) {
        state_data data=dataArrayList.get(position);
        holder.textView.setText(data.getName());

        Glide.with(context).load(data.getDrop()).into(holder.imageView);
        Glide.with(context).load(data.getImage()).into(holder.imageViews);

        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!isclosed) {//is not true
                    holder.view.setVisibility(View.VISIBLE);
                    holder.imageView.setImageResource(R.drawable.baseline_arrow_drop_up_24);
                   isclosed = true;
                    ArrayList<test_data> models = new ArrayList<>();
                    models.add(new test_data(R.drawable.images, " Rs 700", "  Pen Stand and Holder", "10% discount"));
                    models.add(new test_data(R.drawable.arunachal, " Rs 600", "Mandiram", "10% discount"));
                    models.add(new test_data(R.drawable.arunachal2, "Rs 1000", "Kukuma Box", "20% discount"));
                    models.add(new test_data(R.drawable.punjab, "Rs 800", "Kokin", "30% discount"));
                    models.add(new test_data(R.drawable.images, "Rs 400", "Thungkal", "10% discount"));
                    models.add(new test_data(R.drawable.arunachal2, "Rs 900", "Antique", "10% discount"));
                    models.add(new test_data(R.drawable.punjab, " Rs700", "Gudda Gudii", "15% discount"));


                    adapter = new items_adapter(models, view.getContext());


                    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(view.getContext(), LinearLayoutManager.HORIZONTAL, false);
                    holder.view.setLayoutManager(layoutManager);
                    holder.view.setAdapter(adapter);

                }
                else {
                    holder.view.setVisibility(View.GONE);
                    holder.imageView.setImageResource(R.drawable.baseline_arrow_drop_down_24);
                    isclosed=false;
                }



            }
        });

    }



    @Override
    public int getItemCount() {
        return dataArrayList.size();
    }

    public static class viewholder extends RecyclerView.ViewHolder{

         RecyclerView view;
        CircleImageView imageViews;
        ImageView imageView;
        TextView textView;


        public viewholder(@NonNull View itemView) {
            super(itemView);
            view=itemView.findViewById(R.id.views);
            textView=itemView.findViewById(R.id.state_name);
            imageView=itemView.findViewById(R.id.drop2);
            imageViews=itemView.findViewById(R.id.circle);

        }
    }
}
