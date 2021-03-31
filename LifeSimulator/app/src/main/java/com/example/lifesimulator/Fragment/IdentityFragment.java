package com.example.lifesimulator.Fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.lifesimulator.Model.AppDataStore;
import com.example.lifesimulator.R;


public class IdentityFragment extends Fragment {

    TextView txtName;
    TextView txtAge;
    TextView txtGender;
    TextView txtDegree;
    TextView txtJob;
    TextView txtTotal;
    TextView txtLoan;
    Button btnGrowUp;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_identity, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        txtName = view.findViewById(R.id.txtName);
        txtAge = view.findViewById(R.id.txtAge);
        txtGender = view.findViewById(R.id.txtGender);
        txtDegree = view.findViewById(R.id.txtDegree);
        txtJob = view.findViewById(R.id.txtJob);
        txtTotal = view.findViewById(R.id.txtTotal);
        txtLoan = view.findViewById(R.id.txtLoan);
        btnGrowUp = view.findViewById(R.id.btnGrowUp);

        txtName.setText("Tên: " + AppDataStore.identity.getName());
        txtGender.setText("Giới tính: " + (AppDataStore.identity.isGender()?"Nam":"Nữ"));
        UpdateInformation();
        btnGrowUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppDataStore.identity.GrowUp(view);
                UpdateInformation();
            }
        });
    }

    public void UpdateInformation(){
        txtAge.setText("Tuổi: " + AppDataStore.identity.getAge());
        txtDegree.setText("Học vấn: " + AppDataStore.identity.getAge());
        txtJob.setText("Công việc: " + AppDataStore.identity.getAge());
        txtTotal.setText("Tổng tài sản: " + AppDataStore.identity.getBank().getAllMoney());
        txtLoan.setText("Nợ: " + AppDataStore.identity.getBank().getAllLoan());
    }
}