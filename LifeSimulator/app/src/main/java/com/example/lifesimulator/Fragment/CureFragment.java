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

import com.example.lifesimulator.Adapter.CureAdapter;
import com.example.lifesimulator.Adapter.LeisureAdapter;
import com.example.lifesimulator.Model.AppDataStore;
import com.example.lifesimulator.Model.Cure;
import com.example.lifesimulator.Model.Leisure;
import com.example.lifesimulator.R;

import java.util.ArrayList;
import java.util.List;


public class CureFragment extends Fragment {

    private RecyclerView rcvLeisure;
    private RecyclerView rcvCure;

    private LeisureAdapter leisureAdapter;
    private CureAdapter cureAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rcvLeisure = view.findViewById(R.id.rcv_leisure);
        rcvCure = view.findViewById(R.id.rcv_cure);

        leisureAdapter = new LeisureAdapter();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(view.getContext());
        rcvLeisure.setLayoutManager(linearLayoutManager);
        rcvLeisure.setFocusable(false);
        rcvLeisure.setNestedScrollingEnabled(false);

        leisureAdapter.setData(AppDataStore.leisures);
        rcvLeisure.setAdapter(leisureAdapter);

        cureAdapter = new CureAdapter(AppDataStore.cures, view.getContext());
        LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager(view.getContext());
        rcvCure.setLayoutManager(linearLayoutManager1);
        rcvCure.setFocusable(false);
        rcvCure.setNestedScrollingEnabled(false);

        cureAdapter.setData(AppDataStore.cures);
        rcvCure.setAdapter(cureAdapter);

    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cure, container, false);
    }
}