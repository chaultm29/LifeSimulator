package com.example.lifesimulator.Model;

import java.util.ArrayList;

public class Question {
    private String ques;
    private String ansArr[];
    private int answer;

    public Question(String ques, String[] ansArr, int answer) {
        this.ques = ques;
        this.ansArr = ansArr;
        this.answer = answer;
    }

    public String getQues() {
        return ques;
    }

    public void setQues(String ques) {
        this.ques = ques;
    }

    public String[] getAnsArr() {
        return ansArr;
    }

    public void setAnsArr(String[] ansArr) {
        this.ansArr = ansArr;
    }

    public int getAnswer() {
        return answer;
    }

    public void setAnswer(int answer) {
        this.answer = answer;
    }
}
