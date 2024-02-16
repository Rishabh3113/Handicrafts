package com.example.handicrafts.categories;

import static android.view.LayoutInflater.*;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.handicrafts.R;
import com.facebook.shimmer.ShimmerFrameLayout;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class grid_adapter extends BaseAdapter {

    ArrayList<data>data;
    Context context;

    public grid_adapter(ArrayList<com.example.handicrafts.categories.data> data, Context context) {
        this.data = data;
        this.context = context;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view==null){
            LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.cat_item, null);
        }
        TextView textView=view.findViewById(R.id.cat_text);
        ImageView imageView=view.findViewById(R.id.circular);
        return view;

    }
}