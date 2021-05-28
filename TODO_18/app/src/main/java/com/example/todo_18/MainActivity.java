package com.example.todo_18;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.res.TypedArray;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private ArrayList<Sport>mSportsData;
    private SportsAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initialize RecycleView
        mRecyclerView = findViewById(R.id.recyclerView);

        //set the layout manager
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        //initialise the arraylist that contains data
        mSportsData = new ArrayList<>();

        //initialize the adapter and set it on RecyclerView
        mAdapter = new SportsAdapter(this, mSportsData);
        mRecyclerView.setAdapter(mAdapter);

        //get the data
        initializeData();
    }
    //method for initializeing
    private void initializeData() {
        //get the resources from XML file
        String[] sportsList = getResources().getStringArray(R.array.sports_title);
        String[] sportsInfo = getResources().getStringArray(R.array.sports_info);
        TypedArray sportsImageResources = getResources().obtainTypedArray(R.array.sports_images);

        //clear the existing data
        mSportsData.clear();


        //Create the ArrayList of sports Object with title and info.
        for(int i = 0; i<sportsList.length; i++){
            mSportsData.add(new Sport(sportsList[i], sportsInfo[i], sportsImageResources.getResourceId(i, 0)));
        }

        //notify the adapter of the change
        mAdapter.notifyDataSetChanged();
        sportsImageResources.recycle();
    }
}