package com.example.lifesimulator.Model;

public class Bank {
    private float cash;
    private float savingMoney;
    private float loan;

    public Bank() {
        cash = 1000;
    }

    public Bank(float cash, float savingMoney) {
        this.cash = cash;
        this.savingMoney = savingMoney;
    }

    public void increase(float money){
        cash += money;
    }

    public boolean decrease(float money) {
        if (cash >= money) {
            cash -= money;
            return true;
        }
        return false;
    }

    public boolean getLoan(float money) {
        if (loan+money <= 10000) {//limit of loan
            cash += money;
            loan += money;
            return true;
        }
        return false;
    }

    public boolean payLoan(float money) {
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

    public String convertMoneyString(float money){
        int thousand = (int)(money/1000);
        int million = (int)(money/1000000);
        int billion = (int)(money/1000000000);
        if (billion > 0) return billion + "B";
        else if (million > 0) return million + "M";
        else if (thousand > 0) return thousand + "K";
        return money + "";
    }

    public float getCash() {
        return cash;
    }

    public String getCashString() {
        return convertMoneyString(cash);
    }

    public void setCash(float cash) {
        this.cash = cash;
    }

    public float getSavingMoney() {
        return savingMoney;
    }

    public String getSavingMoneyString() {
        return convertMoneyString(savingMoney);
    }

    public void setSavingMoney(float savingMoney) {
        this.savingMoney = savingMoney;
    }
}
