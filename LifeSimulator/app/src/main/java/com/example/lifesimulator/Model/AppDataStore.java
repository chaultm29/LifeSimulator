package com.example.lifesimulator.Model;

import android.widget.ProgressBar;
import android.widget.TextView;

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
}
