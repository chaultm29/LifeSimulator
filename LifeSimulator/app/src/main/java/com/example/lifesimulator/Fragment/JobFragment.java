package com.example.lifesimulator.Fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lifesimulator.Adapter.JobAdapter;
import com.example.lifesimulator.Model.Job;
import com.example.lifesimulator.R;

import java.util.ArrayList;
import java.util.List;


public class JobFragment extends Fragment {

    private RecyclerView rcvJob;

    private JobAdapter jobAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rcvJob = view.findViewById(R.id.rcv_job);


        jobAdapter = new JobAdapter();
        LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager(view.getContext());
        rcvJob.setLayoutManager(linearLayoutManager1);
        rcvJob.setFocusable(false);
        rcvJob.setNestedScrollingEnabled(false);

        jobAdapter.setData(getListJob());
        rcvJob.setAdapter(jobAdapter);

    }


    private List<Job> getListJob() {
        List<Job> list = new ArrayList<>();
        list.add(new Job(R.drawable.leisure_bed, "Còn nhỏ", 600, 6));

        return list;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_job, container, false);
    }
}