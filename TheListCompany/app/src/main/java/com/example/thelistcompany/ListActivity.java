package com.example.thelistcompany;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

import Models.Launch;

public class ListActivity extends AppCompatActivity
        implements LaunchesAdapter.OnItemClickListener {
    private Button updateButton;
    private RecyclerView launchesRv;
    private LaunchesAdapter launchesAdapter;
    private Button startDateEntry;
    private Button endDateEntry;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Objects.requireNonNull(getSupportActionBar()).hide();
        setContentView(R.layout.activity_list);

        updateButton = (Button) findViewById(R.id.filterButton);
        launchesRv = (RecyclerView) findViewById(R.id.recyclerView);

        launchesAdapter = new LaunchesAdapter(this, LaunchDataService.getLaunches(), this);
        launchesRv.setAdapter(launchesAdapter);
        launchesRv.setLayoutManager(new LinearLayoutManager(this));

        startDateEntry = findViewById(R.id.startDateEntry);
        startDateEntry = findViewById(R.id.endDateEntry);

    }

    @Override
    public void onItemClick(int clickPosition) {

    }

    public void filterLaunches() {
        @SuppressLint("SimpleDateFormat") SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");

        Date startDate = null;
        Date endDate = null;
        try {
            String startString = (startDateEntry.getText().toString());
            String endString = (endDateEntry.getText().toString());

            startDate = sdf.parse(startString);


            startDate = sdf.parse(startString);
        } catch (java.text.ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            Log.i("E11111111111", e.toString());
        }

    }

    public void openDatePicker(View view) {

    }
}