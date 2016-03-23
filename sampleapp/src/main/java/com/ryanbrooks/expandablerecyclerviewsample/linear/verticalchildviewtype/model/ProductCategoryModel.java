package com.ryanbrooks.expandablerecyclerviewsample.linear.verticalchildviewtype.model;

import com.bignerdranch.expandablerecyclerview.Model.ParentListItem;

import java.util.List;

/**
 * Created by mertsimsek on 23/03/16.
 */
public class ProductCategoryModel implements ParentListItem{
    public String categoryName;
    public List<Object> productList;

    public ProductCategoryModel(String categoryName, List<Object> productList) {
        this.categoryName = categoryName;
        this.productList = productList;
    }

    @Override
    public List<?> getChildItemList() {
        return productList;
    }

    @Override
    public boolean isInitiallyExpanded() {
        return false;
    }
}
