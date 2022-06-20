package com.example.thelistcompany;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private LaunchDataService dataService;
    private Button getDataButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dataService = new LaunchDataService(MainActivity.this);
        getDataButton = (Button) findViewById(R.id.getButton);
    }

    public void retrieveData(View view) {
        dataService.getLaunchData();
        navigateToListActivity();
    }

    public void navigateToListActivity() {
        Intent intent = new Intent(MainActivity.this, ListActivity.class);
        startActivity(intent);
    }
}