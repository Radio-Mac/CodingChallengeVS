package com.vivideatsfinal.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.vivideatsfinal.model.Events;
import com.vivideatsfinal.volleycustomlistview.AppController;
import com.vividseatsfinal.R;

import java.util.List;

public class CustomListAdapter extends BaseAdapter {

    private Activity activity;
    private LayoutInflater inflater;
    private List<Events> EventItems;
    private String temp;
    private String temp2;

    ImageLoader imageLoader = AppController.getInstance().getImageLoader();

    public CustomListAdapter(Activity activity, List<Events> EventItems) {
        this.activity = activity;
        this.EventItems = EventItems;
    }

    @Override
    public int getCount() {
        return EventItems.size();
    }

    @Override
    public Object getItem(int location) {
        return EventItems.get(location);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (inflater == null)
            inflater = (LayoutInflater) activity
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null)
            convertView = inflater.inflate(R.layout.list_row, null);

        if (imageLoader == null)
            imageLoader = AppController.getInstance().getImageLoader();
        NetworkImageView thumbNail = (NetworkImageView) convertView
                .findViewById(R.id.thumbnail);
        TextView name = (TextView) convertView.findViewById(R.id.name);
        TextView dateDisplay = (TextView) convertView.findViewById(R.id.dateDisplay);

        // getting event data for the row
        Events m = EventItems.get(position);

            // thumbnail image
            temp = m.getCategoryHeroImage().toString();
            temp2 = m.getPerformerHeroImage().toString();
            if (!temp.matches("")) {
                thumbNail.setImageUrl(m.getPerformerHeroImage(), imageLoader);
            } else
                thumbNail.setImageUrl(m.getCategoryHeroImage(), imageLoader);

                // name
                name.setText(m.getName());


        // Start Date
        dateDisplay.setText(String.valueOf(m.getDateDisplay()));

        return convertView;
    }

}

