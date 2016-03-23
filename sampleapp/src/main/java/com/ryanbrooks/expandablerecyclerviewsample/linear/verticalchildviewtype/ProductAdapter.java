package com.ryanbrooks.expandablerecyclerviewsample.linear.verticalchildviewtype;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bignerdranch.expandablerecyclerview.Adapter.ExpandableRecyclerAdapter;
import com.bignerdranch.expandablerecyclerview.Model.ChildType;
import com.bignerdranch.expandablerecyclerview.Model.ParentListItem;
import com.bignerdranch.expandablerecyclerview.ViewHolder.ChildViewHolder;
import com.ryanbrooks.expandablerecyclerviewsample.R;
import com.ryanbrooks.expandablerecyclerviewsample.linear.verticalchildviewtype.model.BuyModel;
import com.ryanbrooks.expandablerecyclerviewsample.linear.verticalchildviewtype.model.ProductCategoryModel;
import com.ryanbrooks.expandablerecyclerviewsample.linear.verticalchildviewtype.model.ProductModel;
import com.ryanbrooks.expandablerecyclerviewsample.linear.verticalchildviewtype.viewholder.BuyViewHolder;
import com.ryanbrooks.expandablerecyclerviewsample.linear.verticalchildviewtype.viewholder.CategoryViewHolder;
import com.ryanbrooks.expandablerecyclerviewsample.linear.verticalchildviewtype.viewholder.ProductViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mertsimsek on 23/03/16.
 */
public class ProductAdapter extends ExpandableRecyclerAdapter<CategoryViewHolder, ChildViewHolder> {

    private LayoutInflater mInflator;
    private static final int TYPE_PRODUCT = 1, TYPE_SUM = 2;
    List<ChildType> childTypes;

    public ProductAdapter(Context context, @NonNull List<? extends ParentListItem> parentItemList) {
        super(parentItemList);
        childTypes = new ArrayList<>();
        childTypes.add(new ChildType(TYPE_PRODUCT, ProductModel.class));
        childTypes.add(new ChildType(TYPE_SUM, BuyModel.class));
        addChildTypes(childTypes);
        mInflator = LayoutInflater.from(context);
    }

    @Override
    public CategoryViewHolder onCreateParentViewHolder(ViewGroup parentViewGroup) {
        View view = mInflator.inflate(R.layout.item_parent, parentViewGroup, false);
        return new CategoryViewHolder(view);
    }

    @Override
    public ChildViewHolder onCreateChildViewHolder(ViewGroup childViewGroup, int viewType) {
        ChildViewHolder childViewHolder = null;
        switch (viewType) {
            case TYPE_PRODUCT:
                View viewProduct = mInflator.inflate(R.layout.item_child_type_one, childViewGroup, false);
                childViewHolder = new ProductViewHolder(viewProduct);
                break;
            case TYPE_SUM:
                View viewBuy = mInflator.inflate(R.layout.item_child_type_two, childViewGroup, false);
                childViewHolder = new BuyViewHolder(viewBuy);
                break;
        }
        return childViewHolder;
    }

    @Override
    public void onBindParentViewHolder(CategoryViewHolder parentViewHolder, int position, ParentListItem parentListItem) {
        parentViewHolder.bind((ProductCategoryModel) parentListItem);
    }

    @Override
    public void onBindChildViewHolder(ChildViewHolder childViewHolder, int position, Object childListItem) {
        if (childViewHolder instanceof ProductViewHolder) {
            ProductModel productModel = (ProductModel) childListItem;
            ((ProductViewHolder) childViewHolder).bind(productModel);
        } else if (childViewHolder instanceof BuyViewHolder) {
            BuyModel buyModel = (BuyModel) childListItem;
            ((BuyViewHolder) childViewHolder).bind(buyModel);
        }
    }
}
