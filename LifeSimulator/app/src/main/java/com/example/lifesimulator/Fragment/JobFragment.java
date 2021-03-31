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
import android.widget.TextView;

import com.example.lifesimulator.Adapter.WorkAdapter;
import com.example.lifesimulator.Model.AppDataStore;
import com.example.lifesimulator.Model.Identity;
import com.example.lifesimulator.R;


public class JobFragment extends Fragment {

    TextView jobText;
    Fragment selectedFragment = null;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        jobText = view.findViewById(R.id.jobText);
        switch (AppDataStore.identity.getDegree()){
            case NONE:
                jobText.setText("Chưa đủ tuổi đi học");
                break;
            case LEVEL1:
                jobText.setText("Học tiểu học");
                selectedFragment = new WorkProcessFragment();
                break;
            case LEVEL2:
                jobText.setText("Học cấp 2");
                selectedFragment = new WorkProcessFragment();
                break;
            case LEVEL3:
                jobText.setText("Học cấp 3");
                selectedFragment = new WorkProcessFragment();
                break;
            case SELECTUNI:
                jobText.setText("Ngã rẽ cuộc đời");
                selectedFragment = new WorkSelectFragment(this);
                break;
            case UNIVERSITY:
                jobText.setText("Học đại học");
                selectedFragment = new WorkProcessFragment();
                break;
            case SELECTWORK:
                jobText.setText("Chọn nơi gửi gắm");
                selectedFragment = new WorkSelectFragment(this);
                break;
            case WORK:
                jobText.setText("Đi làm");
                selectedFragment = new WorkProcessFragment();
                break;
            default:

        }
        if (selectedFragment != null) {
            getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.job_fragment, selectedFragment).commit();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_job, container, false);
    }
}