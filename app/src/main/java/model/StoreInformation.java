package model;

import java.io.Serializable;

public class StoreInformation implements Serializable {

    private String question;
    private int answer;
    private int elapsedTime;
    private String status;

    public StoreInformation(String question, int answer,int elapsedTime, String status) {
        this.question = question;
        this.answer = answer;
        this.elapsedTime = elapsedTime;
        this.status = status;
    }

    public String getQuestion() {
        return this.question;
    }
    public int getAnswer() {
        return this.answer;
    }
    public int getElapsedTime() {return this.elapsedTime;}
    public String getStatus() {
        return this.status;
    }


    @Override
    public String toString() {
        return question+","+answer+","+elapsedTime+","+status;
    }
}
