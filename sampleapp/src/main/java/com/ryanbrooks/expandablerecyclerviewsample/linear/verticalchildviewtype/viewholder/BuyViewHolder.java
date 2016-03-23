package com.ryanbrooks.expandablerecyclerviewsample.linear.verticalchildviewtype.viewholder;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.bignerdranch.expandablerecyclerview.ViewHolder.ChildViewHolder;
import com.ryanbrooks.expandablerecyclerviewsample.R;
import com.ryanbrooks.expandablerecyclerviewsample.linear.verticalchildviewtype.model.BuyModel;

/**
 * Created by mertsimsek on 23/03/16.
 */
public class BuyViewHolder extends ChildViewHolder{

    TextView textViewPrice;
    Button buttonBuy;

    public BuyViewHolder(View itemView) {
        super(itemView);
        textViewPrice = (TextView) itemView.findViewById(R.id.textview_product_price);
        buttonBuy = (Button) itemView.findViewById(R.id.button_product_buy);
    }

    public void bind(BuyModel model){
        textViewPrice.setText(model.price);
    }
}
