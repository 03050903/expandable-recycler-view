package com.bignerdranch.android.criminalintent;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bignerdranch.expandablerecyclerview.Adapter.ExpandableRecyclerAdapter;
import com.bignerdranch.expandablerecyclerview.Model.ParentListItem;
import com.bignerdranch.expandablerecyclerview.ViewHolder.ChildViewHolder;

import java.util.List;


public class CrimeExpandableAdapter extends ExpandableRecyclerAdapter<CrimeParentViewHolder, CrimeChildViewHolder> {

    private LayoutInflater mInflater;

    public CrimeExpandableAdapter(Context context, List<ParentListItem> itemList) {
        super(itemList);
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public CrimeParentViewHolder onCreateParentViewHolder(ViewGroup viewGroup) {
        View view = mInflater.inflate(R.layout.list_item_crime_parent, viewGroup, false);
        return new CrimeParentViewHolder(view);
    }

    @Override
    public CrimeChildViewHolder onCreateChildViewHolder(ViewGroup viewGroup, int viewType) {
        View view = mInflater.inflate(R.layout.list_item_crime_child, viewGroup, false);
        return new CrimeChildViewHolder(view);
    }

    @Override
    public void onBindParentViewHolder(CrimeParentViewHolder crimeParentViewHolder, int i, ParentListItem parentListItem) {
        Crime crime = (Crime) parentListItem;
        crimeParentViewHolder.mCrimeTitleTextView.setText(crime.getTitle());
    }

    @Override
    public void onBindChildViewHolder(ChildViewHolder crimeChildViewHolder, int i, Object childListItem) {
        CrimeChild crimeChild = (CrimeChild) childListItem;
        ((CrimeChildViewHolder) crimeChildViewHolder).mCrimeDateText.setText(crimeChild.getDate().toString());
        ((CrimeChildViewHolder) crimeChildViewHolder).mCrimeSolvedCheckBox.setChecked(crimeChild.isSolved());
    }
}
