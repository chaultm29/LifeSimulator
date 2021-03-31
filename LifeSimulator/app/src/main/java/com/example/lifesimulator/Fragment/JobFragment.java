package com.example.lifesimulator.Fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.example.lifesimulator.Adapter.WorkAdapter;
import com.example.lifesimulator.Model.AppDataStore;
import com.example.lifesimulator.R;


public class JobFragment extends Fragment {

    private RecyclerView rcvJob;

    private WorkAdapter workAdapter;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rcvJob = view.findViewById(R.id.job_list);
//
//
//        workAdapter = new WorkAdapter();
//        //FrameLayout linearLayoutManager1 = new FrameLayout(view.getContext());
//       // rcvJob.setLayoutManager(linearLayoutManager1);
//        rcvJob.setFocusable(false);
//        rcvJob.setNestedScrollingEnabled(false);
//
//       // workAdapter.setData(get());
//        rcvJob.setAdapter(workAdapter);


        if(AppDataStore.identity.getAge()<18){
            getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.job_fragment, new WorkSelectFragment(this)).commit();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_job, container, false);
    }
}