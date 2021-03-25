package com.example.lifesimulator.Model;

import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;

public class AppDataStore {
    public static Identity identity;

    public static ProgressBar proHealthBar;
    public static ProgressBar proIntelBar;
    public static ProgressBar proHappyBar;
    public static TextView txtCash;
    public static TextView txtSaving;

    public static void UpdateConditionView(){
        Condition condition = identity.getCondition();
        proHealthBar.setProgress(condition.getHealth());
        proIntelBar.setProgress(condition.getIntelligence());
        proHappyBar.setProgress(condition.getHappiness());
    }

    public static void UpdateBankView(){
        Bank bank = identity.getBank();
        txtCash.setText("$ " + bank.getCashString());
        txtSaving.setText("$ " + bank.getSavingMoneyString());
    }

    public static void InitData(){
        ArrayList<House> houses = AppDataStore.identity.getHouses();
        for (int i = 1; i <= 5; i++) {
            houses.add(new House("H"+i, "House "+ i, i*10, "New", false, i*9));
        }
        houses.get(0).setOwner(true);

        ArrayList<Item> items = AppDataStore.identity.getItems();
        for (int i = 1; i <= 6; i++) {
            items.add(new Item("I"+i, "Item "+ i, i*10, "New", false));
        }
    }
}
