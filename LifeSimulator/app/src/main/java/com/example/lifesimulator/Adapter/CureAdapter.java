package com.example.lifesimulator.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lifesimulator.Model.Cure;
import com.example.lifesimulator.Model.Leisure;
import com.example.lifesimulator.R;

import java.util.List;

public class CureAdapter extends RecyclerView.Adapter<CureAdapter.CureViewHolder> {
    private List<Cure> mListCure;
    public void setData(List<Cure> list){
        this.mListCure = list;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public CureViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cure, parent, false);
        return new CureViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CureViewHolder holder, int position) {

        Cure cure = mListCure.get(position);
        if(cure==null)
            return;
        holder.imgCure.setImageResource(cure.getResourceID());
        holder.title.setText(cure.getName());
        holder.interactButton.setText(String.valueOf(cure.getFee()));
    }

    @Override
    public int getItemCount() {
        if(mListCure!=null){
            return mListCure.size();
        }
        return 0;
    }

    public class CureViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgCure;
        private TextView title;
        private Button interactButton;


        public CureViewHolder(@NonNull View itemView) {
            super(itemView);

            imgCure = itemView.findViewById(R.id.img_cure);
            title = itemView.findViewById(R.id.tv_title);
            interactButton = itemView.findViewById(R.id.interact_button);
        }
    }
}
