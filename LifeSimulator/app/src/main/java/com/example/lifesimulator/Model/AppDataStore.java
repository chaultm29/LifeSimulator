package com.example.lifesimulator.Model;

import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.lifesimulator.R;

import java.util.ArrayList;
import java.util.List;

public class AppDataStore {
    public static Identity identity;
    public static ArrayList<Cure> cures;
    public static ArrayList<Leisure> leisures;
    public static ArrayList<Job> jobs;

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
        leisures = getListLeisure();
        cures = getListCure();
    }

    private static ArrayList<Leisure> getListLeisure() {
        ArrayList<Leisure> list = new ArrayList<>();
        list.add(new Leisure("Nghỉ ngơi", 0, "Take a rest", R.drawable.leisure_bed, new Condition(0,0,0,1, 1)));
        list.add(new Leisure("Đi chơi công viên", 20, "Take a rest", R.drawable.leisure_park_bench, new Condition(0, 0, -2, 2, 1)));
        list.add(new Leisure("Đi nhậu", 200, "Take a rest", R.drawable.leisure_beer, new Condition(0, 0, -1, 5, -2)));
        list.add(new Leisure("Đu concert của ộp pa", 1000, "Take a rest", R.drawable.leisure_concert, new Condition(0, 0, -2, 6, -1)));
        list.add(new Leisure("Đi biển", 2000, "Take a rest", R.drawable.leisure_sunbathe, new Condition(0, 0, 1, 8, 1)));
        return list;
    }

    private static ArrayList<Cure> getListCure() {
        ArrayList<Cure> list = new ArrayList<>();

        list.add(new Cure("Ngủ", 0, "Take a rest", R.drawable.leisure_bed, new Condition(0,0,1,-1,1)));
        list.add(new Cure("Ăn cháo", 20, "Take a rest", R.drawable.cure_hand_pill, new Condition(0, 0 , 1, 1, 0)));
        list.add(new Cure("Uống thuốc", 50, "Take a rest", R.drawable.cure_pill, new Condition(0, 0 , 3, -1, -1)));
        list.add(new Cure("Tự chữa", 50, "Take a rest", R.drawable.bandage, new Condition(0, 0, 5, -2,  -1)));
        list.add(new Cure("Đi khám bác sĩ", 1000, "Take a rest", R.drawable.cure_doctor_female, new Condition(0, 0, 10, 0, 0)));
        list.add(new Cure("Ở bệnh xá", 2000, "Take a rest", R.drawable.cure_hospital_bed, new Condition(0, 0, 20, 0, 0)));
        list.add(new Cure("Đi hóa trị", 2000, "Take a rest", R.drawable.cure_treatment_plan, new Condition(0, 0, 50, 0, 0)));
        return list;
    }

}
