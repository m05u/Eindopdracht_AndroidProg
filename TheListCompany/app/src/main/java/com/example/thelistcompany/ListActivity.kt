package com.example.thelistcompany
import Models.Launch
import android.app.DatePickerDialog
import android.app.DatePickerDialog.OnDateSetListener
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*
import java.util.function.Supplier
import java.util.stream.Collectors

class ListActivity : AppCompatActivity(), LaunchesAdapter.OnItemClickListener {
    private var filterButton: Button? = null
    private var launchesRv: RecyclerView? = null
    private var launchesAdapter: LaunchesAdapter? = null
    private var startDateEntry: TextView? = null
    private var endDateEntry: TextView? = null
    private val startDialog: DatePickerDialog? = null
    private val endDialog: DatePickerDialog? = null
    private var filteredList = ArrayList<Launch>()
    private var startDateSetListener: OnDateSetListener? = null
    private val endDateSetListener: OnDateSetListener? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_list)
        startDateEntry = findViewById(R.id.startDateEntry)
        endDateEntry = findViewById(R.id.endDateEntry)
        startDateEntry?.setOnClickListener(View.OnClickListener {
            createDatePickerDialog(
                startDialog,
                startDateSetListener
            )
        })
        endDateEntry?.setOnClickListener(View.OnClickListener {
            createDatePickerDialog(
                endDialog,
                endDateSetListener
            )
        })
        startDateSetListener = createDateSetListener(startDateEntry)
        filterButton = findViewById<View>(R.id.filterButton) as Button
        launchesRv = findViewById<View>(R.id.recyclerView) as RecyclerView
        launchesAdapter = LaunchesAdapter(this, LaunchDataService.launches, this)
        launchesRv!!.adapter = launchesAdapter
        launchesRv!!.layoutManager = LinearLayoutManager(this)
    }

    private fun createDatePickerDialog(
        dialog: DatePickerDialog?,
        onDateSetListener: OnDateSetListener?
    ) {
        var dialog = dialog
        val cal = Calendar.getInstance()
        val year = cal[Calendar.YEAR]
        val month = cal[Calendar.MONTH]
        val day = cal[Calendar.DAY_OF_MONTH]
        dialog = DatePickerDialog(
            this@ListActivity,
            android.R.style.Theme_Holo_Light_Dialog_MinWidth,
            onDateSetListener,
            year, month, day
        )
        dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.show()
    }

    private fun createDateSetListener(view: TextView?): OnDateSetListener {
        return OnDateSetListener { datePicker, year, month, day ->
            var month = month
            month = month + 1
            Log.d(LOGTAG, "onDateSet: mm/dd/yyyy: $month/$day/$year")
            val date = "$month/$day/$year"
            view!!.text = date
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    fun filterDataByDate(view: View?) {
        try {
            val formatter = SimpleDateFormat("MM/dd/yyyy")
            val endDate = formatter.parse(endDateEntry!!.text.toString())
            val startDate = formatter.parse(startDateEntry!!.text.toString())
            filteredList = LaunchDataService.launches
                .stream()
                .filter { launch: Launch ->
                    launch.launch_date_local.after(startDate) &&
                            launch.launch_date_local.before(endDate)
                }
                .collect(
                    Collectors.toCollection(
                        Supplier { ArrayList() })
                )
            println(filteredList)
            launchesAdapter = LaunchesAdapter(this, filteredList, this)
            launchesRv!!.adapter = launchesAdapter
        } catch (e: ParseException) {
            e.printStackTrace()
        }
    }

    override fun onItemClick(clickPosition: Int) {
        val intent = Intent(this, InfoActivity::class.java)
        intent.putExtra("item_pos", clickPosition)
        startActivity(intent)
    }

    companion object {
        private val LOGTAG = LaunchesAdapter::class.java.name
    }
}