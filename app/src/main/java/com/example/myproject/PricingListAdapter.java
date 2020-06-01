package com.example.myproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class PricingListAdapter extends BaseAdapter {
    private Context context;
    private List<PriceDetails> pricingList;

    public PricingListAdapter(Context context, List<PriceDetails> pricingList) {
        this.context = context;
        this.pricingList = pricingList;
    }

    @Override
    public int getCount() {
        return pricingList.size();
    }

    @Override
    public Object getItem(int position) {
        return pricingList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return pricingList.indexOf(pricingList.get(position));
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater=LayoutInflater.from(context);
        convertView=inflater.inflate(R.layout.pricing_item,parent,false);

        PriceDetails priceDetails=pricingList.get(position);

        TextView title=convertView.findViewById(R.id.item_name_price);
        TextView price=convertView.findViewById(R.id.item_price_price);
        title.setText(priceDetails.getName());
        price.setText(Integer.toString(priceDetails.getPrice())+" KM");

        return convertView;
    }
}
