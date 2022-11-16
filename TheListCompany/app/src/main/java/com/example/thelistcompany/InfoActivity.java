package com.example.thelistcompany;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.Objects;

import Models.Launch;

public class InfoActivity extends AppCompatActivity {
    private ImageView patchImageLarge;
    private TextView missionName;
    private TextView flightNumber;
    private TextView launchDate;
    private Launch launch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        Objects.requireNonNull(getSupportActionBar()).hide();


        int id = getIntent().getExtras().getInt("item_pos");
        launch = LaunchDataService.getLaunches().get(id);
        patchImageLarge = findViewById(R.id.imageView);
        missionName = findViewById(R.id.mission_name);
        flightNumber = findViewById(R.id.flight_number);
        launchDate = findViewById(R.id.launch_date);

        Glide.with(InfoActivity.this)
                .load(launch.links.mission_patch)
                .placeholder(R.drawable.ic_launcher_foreground)
                .error(R.drawable.ic_launcher_background)
                .into(patchImageLarge);

        missionName.setText("Mission name: " + launch.mission_name);
        flightNumber.setText("Flight number: " + launch.flight_number);
        launchDate.setText("Launch date: " + launch.launch_date_local);
    }
}