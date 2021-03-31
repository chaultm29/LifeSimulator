package com.example.lifesimulator.Model;

import android.content.Context;
import android.widget.Toast;

public class Bank {
    private int cash;
    private int savingMoney;

    private int loan;
    private int hotLoan;
    private int countLoan;
    private int revenue;
    private int countHotLoan;

    public Bank() {
    }

    public Bank(int cash) {
        this.cash = cash;
    }

    public Bank(int cash, int savingMoney) {
        this.cash = cash;
        this.savingMoney = savingMoney;
    }

    public void newYear(){
        savingMoney += savingMoney*0.01;
        if (countHotLoan > 0) {
            countHotLoan++;
            hotLoan += hotLoan*0.2;
            if (cash*0.5 < hotLoan) {
                cash -= cash*0.5;
                hotLoan -= cash;
            } else {
                cash -= hotLoan;
                hotLoan = 0;
                countHotLoan = 0;
            }
        }
        if (countLoan > 0){
            countLoan++;
            revenue += loan*0.07;
            int payment = loan/5 + revenue;
            if (cash > payment) {
                cash -= payment;
                loan -= loan/5;
                revenue = 0;
            } else if (cash > loan/5){
                cash -= loan/5;
                loan -= loan/5;
            } else if (cash > revenue){
                cash -= revenue;
                revenue = 0;
            }
        }
        AppDataStore.UpdateBankView();
    }

    public int getLoanStatus(){
        int status = 0;
        if (countLoan > 5) status += 1;
        if (countHotLoan > 5) status += 2;
        return status;
    }

    public void effect(Bank other) {
        this.cash += other.getCash();
        this.cash = this.cash < 0 ? 0 : this.cash;
        this.savingMoney += other.getSavingMoney();
        this.loan += other.getLoan();
        this.hotLoan += other.getHotLoan();
        this.countLoan += other.getCountLoan();
        this.countHotLoan += other.getCountHotLoan();
        AppDataStore.UpdateBankView();
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
        if (countLoan == 0) {
            loan += money;
            increase(money);
            countLoan = 1;
            revenue = 0;
            Toast.makeText(context,"Vay ngân hàng thành công!" , Toast.LENGTH_SHORT).show();
            return true;
        }
        Toast.makeText(context,"Ngân hàng không cho bạn vay!" , Toast.LENGTH_SHORT).show();
        return false;
    }

    public boolean getHotLoan(Context context, int money) {
        if (countHotLoan == 0) {
            hotLoan += money;
            increase(money);
            countHotLoan = 1;
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
        if (billion > 0) return billion + "B "+million + "M " +thousand + "K";
        else if (million > 0) return million + "M " +thousand + "K";
        else if (thousand > 0) return thousand + "K";
        return money + "";
    }

    public String getCashString() {
        return convertMoneyString(cash);
    }

    public String getSavingMoneyString() {
        return convertMoneyString(savingMoney);
    }

    public String getAllMoney(){ return convertMoneyString(cash+savingMoney);}

    public String getAllLoan(){ return convertMoneyString(loan+revenue+hotLoan);}

    public int getCash() {
        return cash;
    }

    public int getSavingMoney() {
        return savingMoney;
    }

    public int getLoan() {
        return loan;
    }

    public int getHotLoan() {
        return hotLoan;
    }

    public int getCountLoan() {
        return countLoan;
    }

    public int getRevenue() {
        return revenue;
    }

    public int getCountHotLoan() {
        return countHotLoan;
    }
}
