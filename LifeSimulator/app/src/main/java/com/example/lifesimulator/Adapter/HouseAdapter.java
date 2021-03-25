package com.example.lifesimulator.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

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

        holder.item_name.setText(house.getName());
        holder.item_price.setText(house.getPrice()+"");
    }

    @Override
    public int getItemCount() {
        return mHouse.size();
    }

    public class ImageViewHoder extends RecyclerView.ViewHolder{
        public TextView item_name;
        public TextView item_price;
        public Button interact_button;

        public ImageViewHoder(View itemView) {
            super(itemView);
            item_name = itemView.findViewById(R.id.item_name);
            item_price = itemView.findViewById(R.id.item_price);
            interact_button = itemView.findViewById(R.id.interact_button);

            interact_button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(view.getContext(),
                            item_name.getText() + " is price " + item_price.getText() , Toast.LENGTH_SHORT)
                            .show();
                }
            });
        }
    }
}
