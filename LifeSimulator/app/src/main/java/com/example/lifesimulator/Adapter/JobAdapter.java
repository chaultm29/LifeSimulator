package com.example.lifesimulator.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lifesimulator.Model.Job;
import com.example.lifesimulator.R;

import java.util.List;

public class JobAdapter extends RecyclerView.Adapter<JobAdapter.JobViewHolder> {
    private List<Job> mListJob;
    public void setData(List<Job> list){
        this.mListJob = list;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public JobViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_job, parent, false);
        return new JobViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull JobViewHolder holder, int position) {

        Job job = mListJob.get(position);
        if(job==null)
            return;
        holder.imgJob.setImageResource(job.getResourceID());
        holder.title.setText(job.getName());
        holder.interactButton.setText(String.valueOf(job.getGrossSalary()));
    }

    @Override
    public int getItemCount() {
        if(mListJob!=null){
            return mListJob.size();
        }
        return 0;
    }

    public class JobViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgJob;
        private TextView title;
        private Button interactButton;


        public JobViewHolder(@NonNull View itemView) {
            super(itemView);

            imgJob = itemView.findViewById(R.id.img_job);
            title = itemView.findViewById(R.id.tv_title);
            interactButton = itemView.findViewById(R.id.interact_button);
        }
    }
}
