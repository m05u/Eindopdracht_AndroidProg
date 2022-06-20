package com.example.thelistcompany;

import android.os.Bundle;
import android.view.WindowManager;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Objects;

public class ListActivity extends AppCompatActivity
implements LaunchesAdapter.OnItemClickListener{
    private Button updateButton;
    private RecyclerView launchesRv;
    private LaunchesAdapter launchesAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Objects.requireNonNull(getSupportActionBar()).hide();
        setContentView(R.layout.activity_list);

        updateButton = (Button) findViewById(R.id.updateButton);
        launchesRv = (RecyclerView) findViewById(R.id.recyclerView);

        launchesAdapter = new LaunchesAdapter(this, LaunchDataService.getLaunches(), this);
        launchesRv.setAdapter(launchesAdapter);
        launchesRv.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void onItemClick(int clickPosition) {

    }
}