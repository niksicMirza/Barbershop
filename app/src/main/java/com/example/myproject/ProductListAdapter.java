package com.example.myproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ProductListAdapter extends BaseAdapter {
    private List<ProductDetails> productDetailsList;
    private Context context;

    public ProductListAdapter(List<ProductDetails> productDetailsList, Context context) {
        this.productDetailsList = productDetailsList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return productDetailsList.size();
    }

    @Override
    public Object getItem(int position) {
        return productDetailsList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return productDetailsList.indexOf(productDetailsList.get(position));
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        convertView = inflater.inflate(R.layout.product_item, parent, false);
        ProductDetails productDetails = productDetailsList.get(position);

        ImageView imageView = convertView.findViewById(R.id.item_image_products);
        TextView titleTextView = convertView.findViewById(R.id.item_name_products);
        TextView price = convertView.findViewById(R.id.item_price_products);

        imageView.setImageResource(productDetails.getImageResId());
        titleTextView.setText(productDetails.getTitle());
        price.setText("Price: "+Integer.toString(productDetails.getPrice())+" KM");

        return convertView;
    }
}