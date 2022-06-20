package com.example.thelistcompany;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import Models.Launch;

public class LaunchesAdapter extends
        RecyclerView.Adapter<LaunchesAdapter.LaunchesViewHolder> {
    private static final String LOGTAG = LaunchesAdapter.class.getName();
    private List<Launch> launches;
    private OnItemClickListener clickListener;
    private LayoutInflater inflater;

    public class LaunchesViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView mission_name;
        public ImageView patchImage;
        public TextView launch_year;
        public TextView launch_success;

        public LaunchesViewHolder(View itemView, LaunchesAdapter adapter) {
            super(itemView);

            patchImage = (ImageView) itemView.findViewById(R.id.patch_image);
            launch_year = (TextView) itemView.findViewById(R.id.launch_year);
            launch_success = (TextView) itemView.findViewById(R.id.launch_success);
            mission_name = (TextView) itemView.findViewById(R.id.mission_name);

            itemView.setOnClickListener(this);
        }


        @Override
        public void onClick(View view) {
            int clickedPosition = getAdapterPosition();
            Log.i(LOGTAG, "Item " + clickedPosition + " clicked");
            clickListener.onItemClick(clickedPosition);
        }
    }

    public interface OnItemClickListener {
        void onItemClick(int clickPosition);
    }

    public LaunchesAdapter(Context context, List<Launch> launches, OnItemClickListener listener) {
        inflater = LayoutInflater.from(context);
        this.launches = launches;
        clickListener = listener;
    }

    @Override
    public LaunchesViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        Log.d(LOGTAG, "onCreateViewHolder() called");
        View itemView = inflater.inflate(R.layout.layout_launch_item, parent, false);
        return new LaunchesViewHolder(itemView, this);
    }

    @Override
    public void onBindViewHolder(LaunchesViewHolder holder, int position) {
        Log.d(LOGTAG, "onBindViewHolder() called for position" + position);
        Launch launch = launches.get(position);
        Log.d(LOGTAG, "Launch: " + launch.mission_name);

        //fill views with launch data
        Glide.with(inflater.getContext())
                .load(launch.links.mission_patch_small)
//                .placeholder(R.drawable.placeholder)
//                .error(R.drawable.imagenotfound)
                .into(holder.patchImage);
        holder.launch_year.setText(launch.launch_year);
        holder.launch_success.setText(String.valueOf(launch.launch_success));
        holder.mission_name.setText(launch.mission_name);
    }


    @Override
    public int getItemCount() {
        Log.d(LOGTAG, "getItemCount() called");
        return launches.size();
    }
}
