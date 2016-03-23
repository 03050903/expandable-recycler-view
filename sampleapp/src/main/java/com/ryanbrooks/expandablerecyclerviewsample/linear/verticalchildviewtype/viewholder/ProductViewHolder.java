package com.ryanbrooks.expandablerecyclerviewsample.linear.verticalchildviewtype.viewholder;

import android.view.View;
import android.widget.TextView;

import com.bignerdranch.expandablerecyclerview.ViewHolder.ChildViewHolder;
import com.ryanbrooks.expandablerecyclerviewsample.R;
import com.ryanbrooks.expandablerecyclerviewsample.linear.verticalchildviewtype.model.ProductModel;


/**
 * Created by mertsimsek on 23/03/16.
 */
public class ProductViewHolder extends ChildViewHolder{

    TextView textViewProduct;

    public ProductViewHolder(View itemView) {
        super(itemView);
        textViewProduct = (TextView) itemView.findViewById(R.id.textview_product);
    }

    public void bind(ProductModel model){
        textViewProduct.setText(model.productName);
    }
}
