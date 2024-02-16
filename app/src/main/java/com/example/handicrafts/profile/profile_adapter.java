package com.example.handicrafts.profile;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.handicrafts.R;

import java.util.ArrayList;

public class profile_adapter extends BaseAdapter {
    Context context;
    ArrayList<model> models;

    public profile_adapter(Context context, ArrayList<model> models) {
        this.context = context;
        this.models = models;
    }


    @Override
    public int getCount() {
        return models.size();
    }

    @Override
    public Object getItem(int i) {
        return models.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);

            viewHolder = new ViewHolder();
            viewHolder.imageView = convertView.findViewById(R.id.click);
            viewHolder.textViewName = convertView.findViewById(R.id.list_text);
            viewHolder.imageViews=convertView.findViewById(R.id.clicks);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        model currentModel = models.get(i);

        viewHolder.imageView.setImageResource(currentModel.getArrow());
        viewHolder.textViewName.setText(currentModel.getText());
        viewHolder.imageViews.setImageResource(currentModel.getClick());

        return convertView;
    }

    static class ViewHolder {
        ImageView imageView;
        TextView textViewName;
        ImageView imageViews;
    }
}





