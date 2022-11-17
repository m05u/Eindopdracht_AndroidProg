package com.example.thelistcompany

import com.example.thelistcompany.LaunchDataService.Companion.launches
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView
import Models.Launch
import android.os.Bundle
import android.widget.ImageView
import com.example.thelistcompany.R
import com.example.thelistcompany.LaunchDataService
import com.bumptech.glide.Glide
import java.util.*

class InfoActivity : AppCompatActivity() {
    private var patchImageLarge: ImageView? = null
    private var missionName: TextView? = null
    private var flightNumber: TextView? = null
    private var launchDate: TextView? = null
    private var launch: Launch? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info)
        supportActionBar?.hide()
        val id = intent.extras!!.getInt("item_pos")
        launch = launches!![id]
        patchImageLarge = findViewById(R.id.imageView)
        missionName = findViewById(R.id.mission_name)
        flightNumber = findViewById(R.id.flight_number)
        launchDate = findViewById(R.id.launch_date)
        Glide.with(this@InfoActivity)
            .load(launch!!.links.mission_patch)
            .placeholder(R.drawable.ic_launcher_foreground)
            .error(R.drawable.ic_launcher_background)
            .into(patchImageLarge!!)
        missionName?.setText("Mission name: " + launch!!.mission_name)
        flightNumber?.setText("Flight number: " + launch!!.flight_number)
        launchDate?.setText("Launch date: " + launch!!.launch_date_local)
    }
}