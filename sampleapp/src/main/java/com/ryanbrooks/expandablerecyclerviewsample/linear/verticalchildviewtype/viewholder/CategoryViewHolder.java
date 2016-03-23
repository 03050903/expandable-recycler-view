package com.ryanbrooks.expandablerecyclerviewsample.linear.verticalchildviewtype.viewholder;

import android.view.View;
import android.widget.TextView;

import com.bignerdranch.expandablerecyclerview.ViewHolder.ParentViewHolder;
import com.ryanbrooks.expandablerecyclerviewsample.R;
import com.ryanbrooks.expandablerecyclerviewsample.linear.verticalchildviewtype.model.ProductCategoryModel;

/**
 * Created by mertsimsek on 23/03/16.
 */
public class CategoryViewHolder extends ParentViewHolder{

    TextView textViewCategoryName;

    public CategoryViewHolder(View itemView) {
        super(itemView);
        textViewCategoryName = (TextView) itemView.findViewById(R.id.textview_category);
    }

    public void bind(ProductCategoryModel model){
        textViewCategoryName.setText(model.categoryName);
    }
}
