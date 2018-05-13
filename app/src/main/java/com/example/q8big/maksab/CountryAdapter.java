package com.example.q8big.maksab;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Admin on 3/12/2018.
 */

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.ViewHolder> {
    private CountryItemData[] itemsData;

    public CountryAdapter(CountryItemData[] itemsData) {
        this.itemsData = itemsData;
    }


    // inner class to hold a reference to each item of RecyclerView
    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView txtViewTitle;
        public ImageView imgViewIcon;

        public ViewHolder(View itemLayoutView) {
            super(itemLayoutView);
            txtViewTitle = (TextView) itemLayoutView.findViewById(R.id.item_title);
            imgViewIcon = (ImageView) itemLayoutView.findViewById(R.id.item_icon);
        }
    }


    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.country_item_view, null);

        // create ViewHolder

        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {

        // - get data from your itemsData at this position
        // - replace the contents of the view with that itemsData

        viewHolder.txtViewTitle.setText(itemsData[position].getTitle());
        viewHolder.imgViewIcon.setImageResource(itemsData[position].getImageUrl());


        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(view.getContext(), MainActivity.class);
               /* i.putExtra("name", project.getName());*/

                view.getContext().startActivity(i);
            }
        });


    }


    // Return the size of your itemsData (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return itemsData.length;
    }
}