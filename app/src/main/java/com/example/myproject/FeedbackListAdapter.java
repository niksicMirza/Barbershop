package com.example.myproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class FeedbackListAdapter extends BaseAdapter {
    private Context context;
    private List<FeedbackDetails> feedbackDetails;

    public FeedbackListAdapter(Context context, List<FeedbackDetails> feedbackDetails) {
        this.context = context;
        this.feedbackDetails = feedbackDetails;
    }

    @Override
    public int getCount() {
        return feedbackDetails.size();
    }

    @Override
    public Object getItem(int position) {
        return feedbackDetails.get(position);
    }

    @Override
    public long getItemId(int position) {
        return feedbackDetails.indexOf(feedbackDetails.get(position));
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater=LayoutInflater.from(context);
        convertView=inflater.inflate(R.layout.feedback_item,parent,false);

        FeedbackDetails details=feedbackDetails.get(position);

        TextView nameTextView=convertView.findViewById(R.id.item_name_feedback);
        TextView messageTextView=convertView.findViewById(R.id.item_message_feedback);

        nameTextView.setText(details.getName());
        messageTextView.setText(details.getMessage());

        return convertView;
    }
}
