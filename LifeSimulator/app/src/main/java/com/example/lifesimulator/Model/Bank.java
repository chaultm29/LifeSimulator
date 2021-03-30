package com.example.lifesimulator.Model;

import android.content.Context;
import android.widget.Toast;

public class Bank {
    private int cash;
    private int savingMoney;
    private int loan;
    private int hotLoan;

    public Bank() {
        cash = 1000;
    }

    public Bank(int cash, int savingMoney) {
        this.cash = cash;
        this.savingMoney = savingMoney;
    }

    public void increase(int money){
        cash += money;
        AppDataStore.UpdateBankView();
    }

    public boolean decrease(Context context, int money) {
        if (cash >= money) {
            cash -= money;
            AppDataStore.UpdateBankView();
            return true;
        }
        Toast.makeText(context,"Không đủ tiền!" , Toast.LENGTH_SHORT).show();
        return false;
    }

    public boolean withdraw(Context context, float ratio) {
        int wd = (int) Math.ceil(savingMoney*ratio/100);
        if (wd > 0) {
            increase(wd);
            savingMoney -= wd;
            Toast.makeText(context,"Rút tiền thành công!" , Toast.LENGTH_SHORT).show();
            return true;
        }
        Toast.makeText(context,"Không thể rút tiền!" , Toast.LENGTH_SHORT).show();
        return false;
    }

    public boolean saveMoney(Context context, float ratio) {
        int sm = (int) Math.ceil(cash*ratio/100);
        if (sm > 0) {
            decrease(context, sm);
            savingMoney += sm;
            Toast.makeText(context,"Gửi tiền thành công!" , Toast.LENGTH_SHORT).show();
            return true;
        }
        Toast.makeText(context,"Không thể gửi tiền!" , Toast.LENGTH_SHORT).show();
        return false;
    }

    public boolean getLoan(Context context, int money) {
        if (loan+money <= 10000) {//limit of loan
            loan += money;
            increase(money);
            Toast.makeText(context,"Vay ngân hàng thành công!" , Toast.LENGTH_SHORT).show();
            return true;
        }
        Toast.makeText(context,"Ngân hàng không cho bạn vay!" , Toast.LENGTH_SHORT).show();
        return false;
    }

    public boolean getHotLoan(Context context, int money) {
        if (loan+money <= 50000) {//limit of loan
            loan += money;
            increase(money);
            Toast.makeText(context,"Anh em cho bạn vay! Giữ uy tín nhé" , Toast.LENGTH_SHORT).show();
            return true;
        }
        Toast.makeText(context,"Anh em đi vắng không có nhà!" , Toast.LENGTH_SHORT).show();
        return false;
    }

    public boolean payLoan(int money) {
        if (loan > 0) {
            loan -= money;
            if (loan < 0){
                cash -= loan;
                loan = 0;
            }
            return true;
        }
        return false;
    }

    public String convertMoneyString(int money){
        int thousand = money/1000;
        int million = money/1000000;
        int billion = money/1000000000;
        if (billion > 0) return billion + "B";
        else if (million > 0) return million + "M";
        else if (thousand > 0) return thousand + "K";
        return money + "";
    }

    public String getCashString() {
        return convertMoneyString(cash);
    }

    public String getSavingMoneyString() {
        return convertMoneyString(savingMoney);
    }
}
