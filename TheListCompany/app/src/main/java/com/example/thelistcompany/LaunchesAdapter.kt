package com.example.thelistcompany

import Models.Launch
import android.content.Context
import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import com.example.thelistcompany.LaunchesAdapter.LaunchesViewHolder
import android.view.LayoutInflater
import android.view.View
import com.example.thelistcompany.LaunchesAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import android.widget.TextView
import com.example.thelistcompany.R
import android.view.ViewGroup
import android.widget.ImageView
import com.bumptech.glide.Glide

class LaunchesAdapter(context: Context?, launches: List<Launch>, listener: OnItemClickListener) :
    RecyclerView.Adapter<LaunchesViewHolder>() {
    private val launches: List<Launch>
    private val clickListener: OnItemClickListener
    private val inflater: LayoutInflater

    inner class LaunchesViewHolder(itemView: View, adapter: LaunchesAdapter?) :
        ViewHolder(itemView), View.OnClickListener {
        val mission_name: TextView
        val patchImage: ImageView
        val launch_year: TextView
        val launch_success: TextView

        init {
            patchImage = itemView.findViewById<View>(R.id.patch_image) as ImageView
            launch_year = itemView.findViewById<View>(R.id.launch_year) as TextView
            launch_success = itemView.findViewById<View>(R.id.launch_success) as TextView
            mission_name = itemView.findViewById<View>(R.id.mission_name) as TextView
            itemView.setOnClickListener(this)
        }

        override fun onClick(view: View) {
            val clickedPosition = adapterPosition
            Log.i(LOGTAG, "Item $clickedPosition clicked")
            clickListener.onItemClick(clickedPosition)
        }
    }

    interface OnItemClickListener {
        fun onItemClick(clickPosition: Int)
    }

    init {
        inflater = LayoutInflater.from(context)
        this.launches = launches
        clickListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, i: Int): LaunchesViewHolder {
        Log.d(LOGTAG, "onCreateViewHolder() called")
        val itemView = inflater.inflate(R.layout.layout_launch_item, parent, false)
        return LaunchesViewHolder(itemView, this)
    }

    override fun onBindViewHolder(holder: LaunchesViewHolder, position: Int) {
        Log.d(LOGTAG, "onBindViewHolder() called for position$position")
        val launch = launches[position]
        Log.d(LOGTAG, "Launch: " + launch.mission_name)

        //fill views with launch data
        Glide.with(inflater.context)
            .load(launch.links.mission_patch_small) //                .placeholder(R.drawable.placeholder)
            //                .error(R.drawable.imagenotfound)
            .into(holder.patchImage)
        holder.launch_year.text = launch.launch_year
        holder.launch_success.text = launch.launch_success.toString()
        holder.mission_name.text = launch.mission_name
    }

    override fun getItemCount(): Int {
        Log.d(LOGTAG, "getItemCount() called")
        return launches.size
    }

    companion object {
        private val LOGTAG = LaunchesAdapter::class.java.name
    }
}