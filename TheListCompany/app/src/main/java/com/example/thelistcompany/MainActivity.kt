package com.example.thelistcompany

import androidx.appcompat.app.AppCompatActivity
import com.example.thelistcompany.LaunchDataService
import android.os.Bundle
import com.example.thelistcompany.R
import android.content.Intent
import android.view.View
import android.widget.Button
import java.util.*

class MainActivity : AppCompatActivity() {
    private var dataService: LaunchDataService? = null
    private var getDataButton: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_main)
        dataService = LaunchDataService(this@MainActivity)
        dataService!!.sendRequest()
        getDataButton = findViewById<View>(R.id.getButton) as Button
    }

    fun retrieveData(view: View?) {
        dataService!!.launchData
        println(LaunchDataService.launches)
        navigateToListActivity()
    }

    private fun navigateToListActivity() {
        val intent = Intent(this@MainActivity, ListActivity::class.java)
        startActivity(intent)
    }
}