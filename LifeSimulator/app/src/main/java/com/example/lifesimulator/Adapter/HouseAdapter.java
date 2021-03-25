package com.example.lifesimulator.Adapter;

import android.content.Context;
import android.graphics.Color;
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
import com.example.lifesimulator.Model.House;
import com.example.lifesimulator.R;

import java.util.List;

public class HouseAdapter extends RecyclerView.Adapter<HouseAdapter.ImageViewHoder> {
    private List<House> mHouse;
    private Context mContext;

    public HouseAdapter(List mHouse, Context mContext) {
        this.mHouse = mHouse;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ImageViewHoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View houseView =
                inflater.inflate(R.layout.template_item, parent, false);

        return new ImageViewHoder(houseView);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageViewHoder holder, int position) {
        House house = mHouse.get(position);
        int resID = 0;
        switch (house.getCode()){
            case "H2":
                resID = R.drawable.h_shareroom;
                break;
            case "H3":
                resID = R.drawable.h_apartment1;
                break;
            case "H4":
                resID = R.drawable.h_apartment2;
                break;
            case "H5":
                resID = R.drawable.h_house;
                break;
            default:
                resID = R.drawable.h_bench;
                break;
        }
        holder.item_image.setImageResource(resID);
        holder.item_name.setText(house.getName());
        holder.item_description.setText(house.getDescription());
        if (house.isOwner()){
            holder.interact_button.setEnabled(false);
            holder.interact_button.setText("Owned");
            holder.interact_button.setBackgroundColor(Color.WHITE);
        } else {
            holder.interact_button.setText(house.getPrice()+"");
        }
    }

    @Override
    public int getItemCount() {
        return mHouse.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    public class ImageViewHoder extends RecyclerView.ViewHolder{
        public ImageView item_image;
        public TextView item_name;
        public TextView item_description;
        public Button interact_button;

        public ImageViewHoder(View itemView) {
            super(itemView);
            item_image = itemView.findViewById(R.id.item_image);
            item_name = itemView.findViewById(R.id.item_name);
            item_description = itemView.findViewById(R.id.item_description);
            interact_button = itemView.findViewById(R.id.interact_button);

            interact_button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    House selectedHouse = mHouse.get(getAdapterPosition());
                    if (AppDataStore.identity.buy(selectedHouse)){
                        AppDataStore.UpdateBankView();
                        selectedHouse.setOwner(true);
                        interact_button.setEnabled(false);
                        interact_button.setText("Owned");
                        interact_button.setBackgroundColor(Color.WHITE);
                        Toast.makeText(view.getContext(),
                                item_name.getText() +" is bought successfully!" , Toast.LENGTH_SHORT)
                                .show();
                    } else {
                        Toast.makeText(view.getContext(),
                                "Can't buy " + item_name.getText() , Toast.LENGTH_SHORT)
                                .show();
                    }
                }
            });
        }
    }
}
