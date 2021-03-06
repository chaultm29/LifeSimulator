package com.example.lifesimulator.Model;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;

import com.example.lifesimulator.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AppDataStore {
    public static Identity identity;
    public static ArrayList<Cure> cures;
    public static ArrayList<Leisure> leisures;
    public static ArrayList<Job> jobs;
    public static ArrayList<University> universities;
    public static ArrayList<LifeEvent> lifeEvents;

    public static ProgressBar proHealthBar;
    public static ProgressBar proIntelBar;
    public static ProgressBar proHappyBar;
    public static TextView txtCash;
    public static TextView txtSaving;

    public static void LoadData(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("lifesimulator", Context.MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString("identity", null);
        Type type = new TypeToken<Identity>(){}.getType();
        identity = gson.fromJson(json, type);
        initDefaultData();
        if (identity == null){
            identity = new Identity();
            identity.EventBirth(context);
            initData();
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

    public static int Generate(int min, int max){
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }

    public static LifeEvent GetLifeEvent(Milestone... milestones){
        int total = 0;
        for (LifeEvent event : lifeEvents) {
            for (Milestone m : milestones) {
                if (event.getMilestone() == m) total++;
            }
        }
        if (total > 0){
            int eventIndex = AppDataStore.Generate(1, total);
            total = 0;
            for (LifeEvent event : lifeEvents) {
                for (Milestone m : milestones) {
                    if (event.getMilestone() == m && ++total == eventIndex){
                        return  event;
                    };
                }
            }
        }
        return null;
    }

    private static void initData(){
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

    private static void initDefaultData(){
        leisures = getListLeisure();
        cures = getListCure();
        jobs = getListJob();
        universities = getListUniversity();
        lifeEvents = getListLifeEvent();
    }

    private static ArrayList<University> getListUniversity(){
        ArrayList<University> list = new ArrayList<>();

        list.add(new University(R.drawable.university_classroom, "?????i h???c FPT", "Culi ph???n m???m"));
        list.add(new University(R.drawable.university_classroom, "?????i h???c s?? ph???m", "Gi??o vi??n m???m non"));
        list.add(new University(R.drawable.university_music, "?????i h???c ??m nh???c", "Ca s?? d???o"));
        list.add(new University(R.drawable.university_positive_dynamic, "?????i h???c ngo???i th????ng", "Giao d???ch vi??n"));
        list.add(new University(R.drawable.university_stock_share, "?????i h???c kinh t???", "Marketing"));
        list.add(new University(R.drawable.university_slug_eating, "?????i h???c n??ng nghi???p", "K??? s?? n??ng nghi???p"));
        list.add(new University(R.drawable.cure_doctor_female, "?????i h???c y", "B??c s??"));
        list.add(new University(R.drawable.university_robot, "?????i h???c b??ch khoa", "L???p r??p robot"));
        return list;
    }
    private static ArrayList<Job> getListJob(){
        ArrayList<Job> list = new ArrayList<>();
        list.add(new Job(R.drawable.university_classroom, "L???p tr??nh vi??n", "Culi b??ng tr?? r??t n?????c cho PM", 10000));
        list.add(new Job(R.drawable.university_classroom, "Gi??o vi??n","Gi??o vi??n mi???n n??i", 10000));
        list.add(new Job(R.drawable.university_music, "Ca s??","Ca s?? ph??ng tr??", 10000));
        list.add(new Job(R.drawable.university_positive_dynamic, "Nh?? ?????u t??","B??n c??? phi???u", 10000));
        list.add(new Job(R.drawable.university_classroom, "Sale","Sale", 10000));
        list.add(new Job(R.drawable.university_classroom, "N??ng d??n","Nu??i t???m", 10000));
        list.add(new Job(R.drawable.cure_doctor_female, "Y t??","Y t??", 10000));
        list.add(new Job(R.drawable.university_classroom, "Th??? m??y","B??n linh ki???n m??y t??nh", 10000));
        return list;
    }
    private static ArrayList<Leisure> getListLeisure() {
        ArrayList<Leisure> list = new ArrayList<>();
        list.add(new Leisure("Ngh??? ng??i", 0, "+1 vui +1 iq", R.drawable.leisure_bed, new Condition(0,0,0,1, 1)));
        list.add(new Leisure("??i ch??i c??ng vi??n", 20, "-2 kh???e +2 vui +1 iq", R.drawable.leisure_park_bench, new Condition(0, 0, -2, 2, 1)));
        list.add(new Leisure("??i nh???u", 200, "-1 kh???e +5 vui -2 iq", R.drawable.leisure_beer, new Condition(0, 0, -1, 5, -2)));
        list.add(new Leisure("??u concert c???a ???p pa", 1000, "-2 kh???e +6 vui -1 iq", R.drawable.leisure_concert, new Condition(0, 0, -2, 6, -1)));
        list.add(new Leisure("??i bi???n", 2000, "+1 kh???e +8 vui +1 iq", R.drawable.leisure_sunbathe, new Condition(0, 0, 1, 8, 1)));
        return list;
    }

    private static ArrayList<Cure> getListCure() {
        ArrayList<Cure> list = new ArrayList<>();

        list.add(new Cure("Ng???", 0, "+1 kh???e", R.drawable.leisure_bed, new Condition(0,0,1,0,0)));
        list.add(new Cure("??n ch??o b??c ?????u ng?? n???u", 20, "+3 kh???e", R.drawable.cure_hand_pill, new Condition(0, 0 , 3, 0, 0)));
        list.add(new Cure("U???ng thu???c", 50, "+3 kh???e -1 vui", R.drawable.cure_pill, new Condition(0, 0 , 3, -1, 0)));
        list.add(new Cure("T??? ch???a", 50, "+5 kh???e", R.drawable.bandage, new Condition(0, 0, 5, 0,  0)));
        list.add(new Cure("??i kh??m b??c s??", 1000, "+10 kh???e", R.drawable.cure_doctor_female, new Condition(0, 0, 10, 0, 0)));
        list.add(new Cure("??? b???nh x??", 2000, "+20 kh???e", R.drawable.cure_hospital_bed, new Condition(0, 0, 20, 0, 0)));
        list.add(new Cure("??i h??a tr???", 20000, "+50 kh???e", R.drawable.cure_treatment_plan, new Condition(0, 0, 50, 0, 0)));
        return list;
    }

    private static ArrayList<LifeEvent> getListLifeEvent() {
        ArrayList<LifeEvent> list = new ArrayList<>();
        list.add(new LifeEvent("Bir1", Milestone.BIRTH, "B???n ???????c sinh ra trong m???t gia ????nh gi??u c??, b??? m??? ????? cho b???n 100K khi v???a ch??o ?????i.", new Bank(100000), new Condition() ));
        list.add(new LifeEvent("Bir2", Milestone.BIRTH, "B???n ???????c sinh ra trong m???t gia ????nh b??nh th?????ng, ???????c b??? m??? ch??m lo chu ????o n??n m???nh kh???e, h???nh ph??c", new Bank(), new Condition(50, 4, 80,85,60)));
        list.add(new LifeEvent("New1", Milestone.NEWAGE, "N??m nay b??? h???a ???????c h???c sinh gi???i s??? d???n ??i ch??i, b???n n??? l???c v?? ?????t ???????c k???t qu??? t???t", new Bank(), new Condition(0,0,0,10,5) ));
        list.add(new LifeEvent("New2", Milestone.NEWAGE, "Ch??? hi???u sao ??ang ??i ???????ng c?? ?????a qu??ng c??i d??p v??u c??? m???m, ??i kh??m m???t 100 ?????ng", new Bank(-100), new Condition(0,0,-10,-5,-5) ));
        list.add(new LifeEvent("New3", Milestone.NEWAGE, "Th???y b??i b???o ra ???????ng ch?? ?? nh??n tr?????c nh??n sau, th??? l?? kh??ng nh??n 2 b??n n??n b??? ?? t?? ????m n???m vi???n. May m?? kh??ng m???t ti???n vi???n ph??", new Bank(), new Condition(0,-5,-20,-5,-5) ));
        list.add(new LifeEvent("New4", Milestone.NEWAGE, "?????u n??m ??i ch??c t???t t??? nhi??n nh???t ???????c phong bao d???y c???p, b??n trong c?? 10k ti???n l??? T.T Th??i c??ng ????? h???nh ph??c r???i", new Bank(10000), new Condition(0,5,5,10, 1) ));
        return list;
    }

}
