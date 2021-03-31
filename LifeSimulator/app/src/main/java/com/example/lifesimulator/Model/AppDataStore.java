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

        list.add(new University(R.drawable.university_classroom, "Đại học FPT", "Culi phần mềm"));
        list.add(new University(R.drawable.university_classroom, "Đại học sư phạm", "Giáo viên mầm non"));
        list.add(new University(R.drawable.university_music, "Đại học âm nhạc", "Ca sĩ dạo"));
        list.add(new University(R.drawable.university_positive_dynamic, "Đại học ngoại thương", "Giao dịch viên"));
        list.add(new University(R.drawable.university_stock_share, "Đại học kinh tế", "Marketing"));
        list.add(new University(R.drawable.university_slug_eating, "Đại học nông nghiệp", "Kỹ sư nông nghiệp"));
        list.add(new University(R.drawable.cure_doctor_female, "Đại học y", "Bác sĩ"));
        list.add(new University(R.drawable.university_robot, "Đại học bách khoa", "Lắp ráp robot"));
        return list;
    }
    private static ArrayList<Job> getListJob(){
        ArrayList<Job> list = new ArrayList<>();
        list.add(new Job(R.drawable.university_classroom, "Lập trình viên", "Culi bưng trà rót nước cho PM", 10000));
        list.add(new Job(R.drawable.university_classroom, "Giáo viên","Giáo viên miền núi", 10000));
        list.add(new Job(R.drawable.university_music, "Ca sĩ","Ca sĩ phòng trà", 10000));
        list.add(new Job(R.drawable.university_positive_dynamic, "Nhà đầu tư","Bán cổ phiếu", 10000));
        list.add(new Job(R.drawable.university_classroom, "Sale","Sale", 10000));
        list.add(new Job(R.drawable.university_classroom, "Nông dân","Nuôi tằm", 10000));
        list.add(new Job(R.drawable.cure_doctor_female, "Y tá","Y tá", 10000));
        list.add(new Job(R.drawable.university_classroom, "Thợ máy","Bán linh kiện máy tính", 10000));
        return list;
    }
    private static ArrayList<Leisure> getListLeisure() {
        ArrayList<Leisure> list = new ArrayList<>();
        list.add(new Leisure("Nghỉ ngơi", 0, "+1 vui +1 iq", R.drawable.leisure_bed, new Condition(0,0,0,1, 1)));
        list.add(new Leisure("Đi chơi công viên", 20, "-2 khỏe +2 vui +1 iq", R.drawable.leisure_park_bench, new Condition(0, 0, -2, 2, 1)));
        list.add(new Leisure("Đi nhậu", 200, "-1 khỏe +5 vui -2 iq", R.drawable.leisure_beer, new Condition(0, 0, -1, 5, -2)));
        list.add(new Leisure("Đu concert của ộp pa", 1000, "-2 khỏe +6 vui -1 iq", R.drawable.leisure_concert, new Condition(0, 0, -2, 6, -1)));
        list.add(new Leisure("Đi biển", 2000, "+1 khỏe +8 vui +1 iq", R.drawable.leisure_sunbathe, new Condition(0, 0, 1, 8, 1)));
        return list;
    }

    private static ArrayList<Cure> getListCure() {
        ArrayList<Cure> list = new ArrayList<>();

        list.add(new Cure("Ngủ", 0, "+1 khỏe", R.drawable.leisure_bed, new Condition(0,0,1,0,0)));
        list.add(new Cure("Ăn cháo bác đầu ngõ nấu", 20, "+3 khỏe", R.drawable.cure_hand_pill, new Condition(0, 0 , 3, 0, 0)));
        list.add(new Cure("Uống thuốc", 50, "+3 khỏe -1 vui", R.drawable.cure_pill, new Condition(0, 0 , 3, -1, 0)));
        list.add(new Cure("Tự chữa", 50, "+5 khỏe", R.drawable.bandage, new Condition(0, 0, 5, 0,  0)));
        list.add(new Cure("Đi khám bác sĩ", 1000, "+10 khỏe", R.drawable.cure_doctor_female, new Condition(0, 0, 10, 0, 0)));
        list.add(new Cure("Ở bệnh xá", 2000, "+20 khỏe", R.drawable.cure_hospital_bed, new Condition(0, 0, 20, 0, 0)));
        list.add(new Cure("Đi hóa trị", 20000, "+50 khỏe", R.drawable.cure_treatment_plan, new Condition(0, 0, 50, 0, 0)));
        return list;
    }

    private static ArrayList<LifeEvent> getListLifeEvent() {
        ArrayList<LifeEvent> list = new ArrayList<>();
        list.add(new LifeEvent("Bir1", Milestone.BIRTH, "Bạn được sinh ra trong một gia đình giàu có, bố mẹ để cho bạn 100K khi vừa chào đời.", new Bank(100000), new Condition() ));
        list.add(new LifeEvent("Bir2", Milestone.BIRTH, "Bạn được sinh ra trong một gia đình bình thường, được bố mẹ chăm lo chu đáo nên mạnh khỏe, hạnh phúc", new Bank(), new Condition(50, 4, 80,85,60)));
        list.add(new LifeEvent("New1", Milestone.NEWAGE, "Năm nay bố hứa được học sinh giỏi sẽ dẫn đi chơi, bạn nỗ lực và đặt được kết quả tốt", new Bank(), new Condition(0,0,0,10,5) ));
        list.add(new LifeEvent("New2", Milestone.NEWAGE, "Chả hiểu sao đang đi đường có đứa quăng cái dép vêu cả mồm, đi khám mất 100 đồng", new Bank(-100), new Condition(0,0,-10,-5,-5) ));
        list.add(new LifeEvent("New3", Milestone.NEWAGE, "Thầy bói bảo ra đường chú ý nhìn trước nhìn sau, thế là không nhìn 2 bên nên bị ô tô đâm nằm viện. May mà không mất tiền viện phí", new Bank(), new Condition(0,-5,-20,-5,-5) ));
        list.add(new LifeEvent("New4", Milestone.NEWAGE, "Đầu năm đi chúc tết tự nhiên nhặt được phong bao dầy cộp, bên trong có 10k tiền lẻ T.T Thôi cũng đủ hạnh phúc rồi", new Bank(10000), new Condition(0,5,5,10, 1) ));
        return list;
    }

}
