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
import com.example.lifesimulator.Model.Item;
import com.example.lifesimulator.R;

import java.util.List;

public class ItemAdapter extends  RecyclerView.Adapter<ItemAdapter.ImageViewHoder> {
    private List<Item> mItem;
    private Context mContext;

    public ItemAdapter(List mItem, Context mContext) {
        this.mItem = mItem;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ImageViewHoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View itemView =
                inflater.inflate(R.layout.template_item, parent, false);

        return new ImageViewHoder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemAdapter.ImageViewHoder holder, int position) {
        Item item = mItem.get(position);

        int resID = 0;
        switch (item.getCode()){
            case "I1":
                resID = R.drawable.it_tv;
                break;
            case "I2":
                resID = R.drawable.it_gamehandle;
                break;
            case "I3":
                resID = R.drawable.it_laptop;
                break;
            case "I4":
                resID = R.drawable.it_passport;
                break;
            case "I5":
                resID = R.drawable.it_stepper;
                break;
            case "I6":
                resID = R.drawable.it_car;
                break;
        }
        holder.item_image.setImageResource(resID);
        holder.item_name.setText(item.getName());
        holder.item_description.setText(item.getDescription());
        if (item.isOwner()){
            holder.interact_button.setEnabled(false);
            holder.interact_button.setText("Owned");
            holder.interact_button.setBackgroundColor(Color.WHITE);
        } else {
            holder.interact_button.setText(item.getPrice()+"");
        }

    }

    @Override
    public int getItemCount() {
        return mItem.size();
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
                    Item selectedItem = mItem.get(getAdapterPosition());
                    if (AppDataStore.identity.buy(selectedItem)){
                        AppDataStore.UpdateBankView();
                        selectedItem.setOwner(true);
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
