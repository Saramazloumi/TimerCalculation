package model;

import java.io.Serializable;

public class StoreInformation implements Serializable {

    private String question;
    private String answer;
    private int elapsedTime;
    private String status;

    public StoreInformation(String question, String answer,int elapsedTime, String status) {
        this.question = question;
        this.answer = answer;
        this.elapsedTime = elapsedTime;
        this.status = status;
    }

    public String getQuestion() {
        return this.question;
    }
    public String getAnswer() {
        return this.answer;
    }
    public int getElapsedTime() {return this.elapsedTime;}
    public String getStatus() {
        return this.status;
    }


    @Override
    public String toString() {

        return "Question: " + question+", " + "Answer: " + answer + ", " + "ElapsedTime: " + elapsedTime
                + ", " + "Status: " + status + "\n";
    }
}
