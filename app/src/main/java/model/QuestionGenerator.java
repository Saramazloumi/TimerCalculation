package model;

import java.io.Serializable;
import java.util.Random;

public class QuestionGenerator implements Serializable {

    private int num1, num2;
    private int result;
    private String operation[] = {"+", "-", "*", "/"};
    private String text;
    Random random = new Random();
    String operand;

    public int getNum1() {return num1;}
    public void setNum1(int num1) {
        this.num1 = num1;
    }
    public int getNum2() {
        return num2;
    }
    public void setNum2(int num2) {
        this.num2 = num2;
    }
    public String getOperand() {
        return operand;
    }
    public void setOperand(String operand) {
        this.operand = operand;
    }
    public int getResult() {
        return result;
    }
    public void setResult(int result) {
        this.result = result;
    }
    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }

    public String generateOperation() {
        setNum1(random.nextInt(10) + 1);
        setNum2(random.nextInt(10) + 1);
        setOperand(operation[random.nextInt(operation.length)]);
        return text;
    }

    public int correctResult() {

        switch (getOperand()) {

            case "+":
                this.result = num1 + num2;
                this.text = num1 + "  +  " + num2;
                break;

            case "-":
                this.result = num1 - num2;
                this.text = num1 + "  -  " + num2;
                break;

            case "*":
                this.result = num1 * num2;
                this.text = num1 + "  *  " + num2;
                break;

            case "/":
                if (num2 == 0) {
                    num2 = random.nextInt(10) + 1;
                    this.result = num1 / num2;
                    this.text = num1 + "  /  " + num2;
                } else {
                    this.result = num1 / num2;
                    this.text = num1 + "  /  " + num2;
                }
                break;
        }

        return result;
    }

    @Override
    public String toString() {
        return num1 + " " + operand + " " + num2;
    }
}


