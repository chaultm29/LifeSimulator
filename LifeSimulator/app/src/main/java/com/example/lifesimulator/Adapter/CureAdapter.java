package com.example.lifesimulator.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lifesimulator.Model.AppDataStore;
import com.example.lifesimulator.Model.Cure;
import com.example.lifesimulator.R;

import java.util.List;

public class CureAdapter extends RecyclerView.Adapter<CureAdapter.CureViewHolder> {
    private List<Cure> mListCure;
    private Context mContext;

    public CureAdapter(List<Cure> mListCure, Context mContext) {
        this.mListCure = mListCure;
        this.mContext = mContext;
    }

    public void setData(List<Cure> list){
        this.mListCure = list;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public CureViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();

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
            title = itemView.findViewById(R.id.cure_title);
            interactButton = itemView.findViewById(R.id.interact_button_cure);

            interactButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Cure selectedCure = mListCure.get(getAdapterPosition());

                    if (AppDataStore.identity.useCure(selectedCure)){
                        AppDataStore.UpdateBankView();
                        AppDataStore.UpdateConditionView();
                        Toast.makeText(view.getContext(),
                                title.getText() +" is bought successfully!" , Toast.LENGTH_SHORT)
                                .show();
                    } else {
                        Toast.makeText(view.getContext(),
                                "Can't buy " + title.getText() , Toast.LENGTH_SHORT)
                                .show();
                    }
                }
            });
        }
    }
}
