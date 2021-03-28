package com.example.lifesimulator.Adapter;

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
import com.example.lifesimulator.Model.Leisure;
import com.example.lifesimulator.R;

import java.util.List;

public class LeisureAdapter extends RecyclerView.Adapter<LeisureAdapter.LeisureViewHolder> {
    private List<Leisure> mListLeisure;
    public void setData(List<Leisure> list){
        this.mListLeisure = list;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public LeisureViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_leisure, parent, false);
        return new LeisureViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LeisureViewHolder holder, int position) {

        Leisure leisure = mListLeisure.get(position);
        if(leisure==null)
                return;
        holder.imgLeisure.setImageResource(leisure.getResourceID());
        holder.title.setText(leisure.getName());
        holder.interactButton.setText(String.valueOf(leisure.getFee()));
        holder.description.setText(leisure.getDescription());
    }

    @Override
    public int getItemCount() {
        if(mListLeisure!=null){
            return mListLeisure.size();
        }
        return 0;
    }

    public class LeisureViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgLeisure;
        private TextView title;
        private Button interactButton;
        private TextView description;


        public LeisureViewHolder(@NonNull View itemView) {
            super(itemView);

            imgLeisure = itemView.findViewById(R.id.img_leisure);
            title = itemView.findViewById(R.id.leisure_title);
            interactButton = itemView.findViewById(R.id.interact_button_leisure);
            description = itemView.findViewById(R.id.leisure_description);

            interactButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Leisure selectedLeisure = mListLeisure.get(getAdapterPosition());

                    if (AppDataStore.identity.doLeisure(selectedLeisure)){
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
