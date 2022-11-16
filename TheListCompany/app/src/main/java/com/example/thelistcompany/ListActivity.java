package com.example.thelistcompany;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;
import java.util.stream.Collectors;

import Models.Launch;

public class ListActivity extends AppCompatActivity
        implements LaunchesAdapter.OnItemClickListener {
    private Button filterButton;
    private RecyclerView launchesRv;
    private LaunchesAdapter launchesAdapter;
    private TextView startDateEntry;
    private TextView endDateEntry;
    private DatePickerDialog startDialog;
    private DatePickerDialog endDialog;
    private ArrayList<Launch> filteredList = new ArrayList<>();
    private static final String LOGTAG = LaunchesAdapter.class.getName();
    private DatePickerDialog.OnDateSetListener startDateSetListener;
    private DatePickerDialog.OnDateSetListener endDateSetListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Objects.requireNonNull(getSupportActionBar()).hide();
        setContentView(R.layout.activity_list);

        startDateEntry = findViewById(R.id.startDateEntry);
        endDateEntry = findViewById(R.id.endDateEntry);

        startDateEntry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createDatePickerDialog(startDialog, startDateSetListener);
            }
        });

        endDateEntry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createDatePickerDialog(endDialog, endDateSetListener);
            }
        });

        startDateSetListener = createDateSetListener(startDateEntry);

        filterButton = (Button) findViewById(R.id.filterButton);
        launchesRv = (RecyclerView) findViewById(R.id.recyclerView);

        launchesAdapter = new LaunchesAdapter(this, LaunchDataService.getLaunches(), this);
        launchesRv.setAdapter(launchesAdapter);
        launchesRv.setLayoutManager(new LinearLayoutManager(this));


    }

    private void createDatePickerDialog(DatePickerDialog dialog, DatePickerDialog.OnDateSetListener onDateSetListener) {
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);

       dialog = new DatePickerDialog(
                ListActivity.this,
                android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                onDateSetListener,
                year,month,day);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();
    }

    private DatePickerDialog.OnDateSetListener createDateSetListener(TextView view) {
        return new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;
                Log.d(LOGTAG, "onDateSet: mm/dd/yyyy: " + month + "/" + day + "/" + year);

                String date = month + "/" + day + "/" + year;
                view.setText(date);
            }
        };
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void filterDataByDate(View view) {
        try {
            SimpleDateFormat formatter =new SimpleDateFormat("MM/dd/yyyy");
            Date endDate = formatter.parse(endDateEntry.getText().toString());
            Date startDate = formatter.parse(startDateEntry.getText().toString());

            filteredList = LaunchDataService.getLaunches()
                    .stream()
                    .filter(launch -> launch.launch_date_local.after(startDate) &&
                            launch.launch_date_local.before(endDate))
                    .collect(Collectors.toCollection(ArrayList::new));

            System.out.println(filteredList);
            launchesAdapter = new LaunchesAdapter(this, filteredList, this);
            launchesRv.setAdapter(launchesAdapter);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }



    @Override
    public void onItemClick(int clickPosition) {
        Intent intent = new Intent(this, InfoActivity.class);
        intent.putExtra("item_pos", clickPosition);
        startActivity(intent);
    }
}