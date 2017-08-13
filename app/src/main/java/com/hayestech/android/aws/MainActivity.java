package com.hayestech.android.aws;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    CardView cardView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager manager;
    ArrayList<Facility> siteNumbers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        cardView = (CardView) findViewById(R.id.card_view);
        siteNumbers = new ArrayList<>();

        for(int i=0;i<getResources().getStringArray(R.array.siteAddresses).length;i++){
            String temp = String.valueOf("#"+i);
            Facility facility = new Facility(getResources().getStringArray(R.array.siteNumbers)[i].toString(),
                    getResources().getStringArray(R.array.siteAddresses)[i].toString());
            siteNumbers.add(facility);

        }
        adapter = new AwsAdapter(this,siteNumbers);
        recyclerView.setHasFixedSize(true);
        manager = new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);

    }
}
