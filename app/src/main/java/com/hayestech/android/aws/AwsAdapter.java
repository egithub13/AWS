package com.hayestech.android.aws;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Eric on 8/1/2017.
 */

public class AwsAdapter extends RecyclerView.Adapter<AwsAdapter.MyViewHolder>  {

    Context context;
    private ArrayList<Facility> facilities;


    public AwsAdapter(Context context, ArrayList<Facility> facilities) {
        this.context = context;
        this.facilities = facilities;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_row,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Facility facility = facilities.get(position);
        holder.siteNumber.setText(facility.getSiteNumber());

    }

    @Override
    public int getItemCount() {
        return facilities.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        TextView siteNumber;

        public MyViewHolder(View itemView) {
            super(itemView);

            siteNumber = (TextView)itemView.findViewById(R.id.tv_faciltiy_number);
        }
    }
}
