package com.example.handicrafts.home;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;

import com.bumptech.glide.Glide;
import com.example.handicrafts.R;
import com.example.handicrafts.detail.detail_view;
import com.example.handicrafts.view.view_data;
import com.example.handicrafts.view.view_gridadap;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class home_adapter extends BaseAdapter {

    Context context;
    ArrayList<home_data> item_list;

    public home_adapter(Context context, ArrayList<home_data> item_list) {
        this.context = context;
        this.item_list = item_list;
    }

    @Override
    public int getCount() {
        return item_list.size();
    }

    @Override
    public Object getItem(int i) {
        return item_list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        ViewHolder viewHolder;

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.grid_item2, viewGroup, false);

            viewHolder = new ViewHolder();
            viewHolder.name = convertView.findViewById(R.id.heading);
            viewHolder.price = convertView.findViewById(R.id.price);
            viewHolder.discount = convertView.findViewById(R.id.discount);
            viewHolder.logo = convertView.findViewById(R.id.image_disocunt);
            viewHolder.productImage = convertView.findViewById(R.id.profile_image);
            viewHolder.fav = convertView.findViewById(R.id.faviconImageView);
            viewHolder.cardView = convertView.findViewById(R.id.card);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        // Get the data for the current position
        home_data currentItem = item_list.get(i);

        // Set data to the views using getters from view_data
        viewHolder.name.setText(currentItem.getName());
        viewHolder.price.setText(currentItem.getPrice());
        viewHolder.discount.setText(currentItem.getDiscount());
        Glide.with(context)
                .load(currentItem.getImages())
                .error(R.drawable.account)// Pass the image URL or resource ID here
                .into(viewHolder.productImage);

        Glide.with(context)
                .load(currentItem.getFav()) // Assuming getFav() returns a resource ID
                .into(viewHolder.fav);

        Glide.with(context)
                .load(currentItem.getDiscount_logo()) // Assuming getDiscount_image() returns a resource ID
                .into(viewHolder.logo);

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, detail_view.class);
                intent.putExtra("product_id", currentItem.getProduct_id());
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });

        return convertView;

    }

    private static class ViewHolder {
        TextView name, price, discount;
        ImageView logo, productImage;
        CircleImageView fav;
        CardView cardView;
    }

}