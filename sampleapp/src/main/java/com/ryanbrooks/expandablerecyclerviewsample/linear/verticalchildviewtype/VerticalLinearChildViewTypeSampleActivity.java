package com.ryanbrooks.expandablerecyclerviewsample.linear.verticalchildviewtype;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.ryanbrooks.expandablerecyclerviewsample.R;
import com.ryanbrooks.expandablerecyclerviewsample.linear.verticalchildviewtype.model.BuyModel;
import com.ryanbrooks.expandablerecyclerviewsample.linear.verticalchildviewtype.model.ProductCategoryModel;
import com.ryanbrooks.expandablerecyclerviewsample.linear.verticalchildviewtype.model.ProductModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mertsimsek on 23/03/16.
 */
public class VerticalLinearChildViewTypeSampleActivity extends AppCompatActivity{

    ProductAdapter productAdapter;

    public static Intent newIntent(Context context) {
        return new Intent(context, VerticalLinearChildViewTypeSampleActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vertical_multiple_child_type);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerview_multi_type);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //Two child view item
        List<Object> productShoesList1 = new ArrayList<>();
        ProductModel productShoes1 = new ProductModel("Adidas NK23");
        ProductModel productShoes2 = new ProductModel("Nike KS33");
        ProductModel productShoes3 = new ProductModel("Puma SD45");
        BuyModel buyModel1 = new BuyModel("123.99 $");

        //Add your child items to object list
        productShoesList1.add(productShoes1);
        productShoesList1.add(productShoes2);
        productShoesList1.add(productShoes3);
        productShoesList1.add(buyModel1);

        //create parent list
        List<ProductCategoryModel> categories = new ArrayList<>();
        ProductCategoryModel categoryShoes = new ProductCategoryModel("Shoes", productShoesList1);
        ProductCategoryModel categoryShoes2 = new ProductCategoryModel("Shoes2", productShoesList1);
        ProductCategoryModel categoryShoes3 = new ProductCategoryModel("Shoes3", productShoesList1);
        categories.add(categoryShoes);
        categories.add(categoryShoes2);
        categories.add(categoryShoes3);

        //load adapter
        productAdapter = new ProductAdapter(getApplicationContext(),categories);
        recyclerView.setAdapter(productAdapter);
    }
}
