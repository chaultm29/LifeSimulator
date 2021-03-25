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

import com.example.lifesimulator.Adapter.LeisureAdapter;
import com.example.lifesimulator.Model.Leisure;
import com.example.lifesimulator.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


public class LeisureFragment extends Fragment {

    private RecyclerView rcvLeisure;

    private LeisureAdapter leisureAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_leisure, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rcvLeisure = view.findViewById(R.id.rcv_leisure);

        leisureAdapter = new LeisureAdapter();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(view.getContext());
        rcvLeisure.setLayoutManager(linearLayoutManager);
        rcvLeisure.setFocusable(false);
        rcvLeisure.setNestedScrollingEnabled(false);

        leisureAdapter.setData(getListLeisure());
        rcvLeisure.setAdapter(leisureAdapter);

    }

    private List<Leisure> getListLeisure() {
        List<Leisure> list = new ArrayList<>();
        list.add(new Leisure("Nghỉ ngơi", 0, "Take a rest", R.drawable.leisure_bed));
        list.add(new Leisure("Đi chơi công viên", 20, "Take a rest", R.drawable.leisure_park_bench));
        list.add(new Leisure("Đi nhậu", 0, "Take a rest", R.drawable.leisure_beer));
        list.add(new Leisure("Đu concert của ộp pa", 0, "Take a rest", R.drawable.leisure_concert));
        list.add(new Leisure("Đi biển", 0, "Take a rest", R.drawable.leisure_sunbathe));
        return list;
    }

}