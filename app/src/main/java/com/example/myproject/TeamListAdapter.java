package com.example.myproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class TeamListAdapter extends BaseAdapter {
    private List<TeamDetails> teamDetailsList;
    private Context context;

    public TeamListAdapter(List<TeamDetails> teamDetailsList, Context context) {
        this.teamDetailsList = teamDetailsList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return teamDetailsList.size();
    }

    @Override
    public Object getItem(int position) {
        return teamDetailsList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return teamDetailsList.indexOf(teamDetailsList.get(position));
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        convertView = inflater.inflate(R.layout.team_item, parent, false);
        TeamDetails teamDetails = teamDetailsList.get(position);

        ImageView imageView = convertView.findViewById(R.id.item_image_team);
        TextView titleTextView = convertView.findViewById(R.id.item_name_team);
        TextView phoneNumber = convertView.findViewById(R.id.item_phone_number_team);

        imageView.setImageResource(teamDetails.getImageResId());
        titleTextView.setText(teamDetails.getName());
        phoneNumber.setText(teamDetails.getPhone_number());

        return convertView;
    }
}
