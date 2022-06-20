package com.example.thelistcompany;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    private LaunchDataService dataService;
    private Button getDataButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Objects.requireNonNull(getSupportActionBar()).hide();
        setContentView(R.layout.activity_main);
        dataService = new LaunchDataService(MainActivity.this);
        dataService.sendRequest();
        getDataButton = (Button) findViewById(R.id.getButton);
    }

    public void retrieveData(View view) {
        dataService.getLaunchData();
        System.out.println(LaunchDataService.getLaunches());
        navigateToListActivity();
    }

    public void navigateToListActivity() {
        Intent intent = new Intent(MainActivity.this, ListActivity.class);
        startActivity(intent);
    }
}