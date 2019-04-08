package model;

public class Operation {
    private int num1, num2, result;
    private String operation, status;
    private long timer;

    public Operation(int num1, int num2, int result, String operation, String status, long timer) {
        this.num1 = num1;
        this.num2 = num2;
        this.result = result;
        this.operation = operation;
        this.status = status;
        this.timer = timer;
    }

    public int getNum1() {
        return num1;
    }

    public void setNum1(int num1) {
        this.num1 = num1;
    }

    public int getNum2() {
        return num2;
    }

    public void setNum2(int num2) {
        this.num2 = num2;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public long getTimer() {
        return timer;
    }

    public void setTimer(long timer) {
        this.timer = timer;
    }

    @Override
    public String toString() {
        return num1 + "" + operation + "" + num2;
    }
}
