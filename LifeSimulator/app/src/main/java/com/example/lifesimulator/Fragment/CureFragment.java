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

        leisureAdapter.setData(getListLeisure());
        rcvLeisure.setAdapter(leisureAdapter);

        cureAdapter = new CureAdapter();
        LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager(view.getContext());
        rcvCure.setLayoutManager(linearLayoutManager1);
        rcvCure.setFocusable(false);
        rcvCure.setNestedScrollingEnabled(false);

        cureAdapter.setData(getListCure());
        rcvCure.setAdapter(cureAdapter);

    }

    private List<Leisure> getListLeisure() {
        List<Leisure> list = new ArrayList<>();
        list.add(new Leisure("Nghỉ ngơi", 0, "Take a rest", R.drawable.leisure_bed));
        list.add(new Leisure("Đi chơi công viên", 20, "Take a rest", R.drawable.leisure_park_bench));
        list.add(new Leisure("Đi nhậu", 200, "Take a rest", R.drawable.leisure_beer));
        list.add(new Leisure("Đu concert của ộp pa", 1000, "Take a rest", R.drawable.leisure_concert));
        list.add(new Leisure("Đi biển", 2000, "Take a rest", R.drawable.leisure_sunbathe));
        return list;
    }
    private List<Cure> getListCure() {
        List<Cure> list = new ArrayList<>();
        list.add(new Cure("Ngủ", 0, "Take a rest", R.drawable.leisure_bed));
        list.add(new Cure("Ăn cháo", 20, "Take a rest", R.drawable.cure_hand_pill));
        list.add(new Cure("Uống thuốc", 50, "Take a rest", R.drawable.cure_pill));
        list.add(new Cure("Tự chữa", 50, "Take a rest", R.drawable.bandage));
        list.add(new Cure("Đi khám bác sĩ", 1000, "Take a rest", R.drawable.cure_doctor_female));
        list.add(new Cure("Ở bệnh xá", 2000, "Take a rest", R.drawable.cure_hospital_bed));
        list.add(new Cure("Đi hóa trị", 2000, "Take a rest", R.drawable.cure_treatment_plan));
        return list;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cure, container, false);
    }
}