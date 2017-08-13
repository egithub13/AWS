package com.hayestech.android.aws;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Eric on 8/1/2017.
 */

public class AwsAdapter extends RecyclerView.Adapter<AwsAdapter.MyViewHolder>  {

    Context context;
    private ArrayList<Facility> facilities;
    Facility facility;
    String[] getAddress;


    public AwsAdapter(Context context, ArrayList<Facility> facilities) {
        this.context = context;
        this.facilities = facilities;
        getAddress = context.getResources().getStringArray(R.array.siteAddresses);
    }

    @Override
    public MyViewHolder onCreateViewHolder(final ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_row,parent,false);

        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        facility = facilities.get(position);
        holder.siteNumber.setText(facility.getSiteNumber());

    }

    @Override
    public int getItemCount() {
        return facilities.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView siteNumber;
        public MyViewHolder(View itemView) {
            super(itemView);

            siteNumber = (TextView)itemView.findViewById(R.id.tv_faciltiy_number);
            siteNumber.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Toast.makeText(context,"Site: "+getAddress[getAdapterPosition()],Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("google.navigation:q="+getAddress[getAdapterPosition()]));
            context.startActivity(intent);

        }
    }
}
