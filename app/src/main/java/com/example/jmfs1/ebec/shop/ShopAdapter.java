package com.example.jmfs1.ebec.shop;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.jmfs1.ebec.R;
import com.example.jmfs1.ebec.core.Product;

import java.util.List;

/**
 * Created by jeronimo on 31/12/2016.
 */

public class ShopAdapter extends ArrayAdapter<Product> {

    private Context context;
    public List<Product> products;

    public ShopAdapter(Context context, List<Product> products) {
        super(context, -1, products);
        this.context = context;
        this.products = products;
    }

    public int getCount()
    {
        return products.size();
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.shop_item_layout, parent, false);

        // Get shop item
        Product product = products.get(position);

        // Set name, cost and quantity
        TextView nameTextView = (TextView) rowView.findViewById(R.id.shop_item_name);
        TextView priceTextView = (TextView) rowView.findViewById(R.id.shop_item_price);
        TextView quantityTextView = (TextView) rowView.findViewById(R.id.shop_item_quantity);

        nameTextView.setText(product.getName());

        if (product.getPrice() >= 0) {
            priceTextView.setText("Preço: " + product.getPrice() + " créditos");
        } else {
            priceTextView.setText("--");
        }

        if (product.getQuantity() >= 0) {
            quantityTextView.setText("Quantidade: " + product.getQuantity() + " " + product.getUnits());
        } else {
            quantityTextView.setText("--");
        }

        return rowView;
    }
}
