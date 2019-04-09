package model;

public class Validator {

    private int userAnswer;
    private int correctAnswer;

    public Validator(int userAnswer, int correctAnswer) {
        this.userAnswer = userAnswer;
        this.correctAnswer = correctAnswer;
    }

    public int getUserAnswer() {return userAnswer;}
    public int getCorrectAnswer() {return correctAnswer;}

    public boolean validationAnswer(){
        if (userAnswer == correctAnswer)
            return true;
        else
            return false;
    }

}
