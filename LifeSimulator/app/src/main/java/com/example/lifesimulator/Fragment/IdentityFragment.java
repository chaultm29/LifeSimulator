package com.example.lifesimulator.Fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.lifesimulator.Model.AppDataStore;
import com.example.lifesimulator.R;


public class IdentityFragment extends Fragment {

    TextView txtName;
    TextView txtAge;
    TextView txtGender;

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
        txtName.setText("Tên: " + AppDataStore.identity.getName());
        txtAge.setText("Tuổi: " + AppDataStore.identity.getAge());
        txtGender.setText("Giới tính: " + (AppDataStore.identity.isGender()?"Nam":"Nữ"));
    }
}