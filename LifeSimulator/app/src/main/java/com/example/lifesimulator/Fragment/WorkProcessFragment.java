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
import com.example.lifesimulator.Model.Degree;
import com.example.lifesimulator.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link WorkProcessFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class WorkProcessFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public WorkProcessFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment WorkProcessFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static WorkProcessFragment newInstance(String param1, String param2) {
        WorkProcessFragment fragment = new WorkProcessFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_work_process, container, false);
    }

    Button btnWork;
    Button btnTest;
    Button btnStop;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        btnWork = view.findViewById(R.id.btnWork);
        btnTest = view.findViewById(R.id.btnTest);
        btnStop = view.findViewById(R.id.btnStopWork);
        if (AppDataStore.identity.getDegree() == Degree.WORK){
            btnWork.setText("L??m vi???c");
            btnTest.setText("????i s???p t??ng l????ng");
            btnStop.setText("B??? vi???c");
        } else {
            btnWork.setText("H???c");
            btnTest.setText("L??m b??i thi");
            btnStop.setText("Tr???n h???c ??i ch??i");
        }
    }
}