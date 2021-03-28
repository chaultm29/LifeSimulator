package com.example.lifesimulator.Model;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Type;
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

    public static void LoadData(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("lifesimulator", Context.MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString("identity", null);
        Type type = new TypeToken<Identity>(){}.getType();
        identity = gson.fromJson(json, type);
        if (identity == null){
            identity = new Identity();
            InitData();
        }
    }

    public static void SaveData(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("lifesimulator", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(identity);
        editor.putString("identity", json);
        editor.apply();
    }

    public static void ClearData(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("lifesimulator", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("identity", null);
        editor.apply();
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
