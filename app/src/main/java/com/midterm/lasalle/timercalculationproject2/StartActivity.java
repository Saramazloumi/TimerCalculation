package com.midterm.lasalle.timercalculationproject2;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

import model.Operation;

public class StartActivity extends AppCompatActivity implements View.OnClickListener {

    EditText editTextShowResult;
    TextView textViewFirstNumber, textViewSecondNumber,textViewOperation, textViewTimer;
    Button btnZero, btnOne, btnTwo,btnThree,btnFour,btnFive,btnSix,btnSeven,btnEight,btnNine,
    btnDash,btnDot,btnStart,btnClear,btnStop,btnQuit,btnEqual,btnSave,btnResult;

    private CountDownTimer countDownTimer, countDownTimer2;

    public long timeLeft = 10000;
    int num1, num2, userResult;
    long userTimer;
    String[] operand = {"+", "-", "*","/"};
    String op, status;

    ArrayList<Operation> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        initialize();
    }

    private void initialize() {
        editTextShowResult = findViewById(R.id.editTextShowResult);
        textViewFirstNumber = findViewById(R.id.textViewFirstNumber);
        textViewOperation = findViewById(R.id.textViewOperation);
        textViewSecondNumber = findViewById(R.id.textViewSecondNumber);
        textViewTimer = findViewById(R.id.textViewTimer);
        btnZero = findViewById(R.id.btnZero);
        btnOne = findViewById(R.id.btnOne);
        btnTwo = findViewById(R.id.btnTwo);
        btnThree = findViewById(R.id.btnThree);
        btnFour = findViewById(R.id.btnFour);
        btnFive = findViewById(R.id.btnFive);
        btnSix = findViewById(R.id.btnSix);
        btnSeven = findViewById(R.id.btnSeven);
        btnEight = findViewById(R.id.btnEight);
        btnNine = findViewById(R.id.btnNine);
        btnDot = findViewById(R.id.btnDot);
        btnDash = findViewById(R.id.btnDash);
        btnStart = findViewById(R.id.btnStart);
        btnClear = findViewById(R.id.btnClear);
        btnStop = findViewById(R.id.btnStop);
        btnQuit = findViewById(R.id.btnQuit);
        btnEqual = findViewById(R.id.btnEqual);
        btnSave = findViewById(R.id.btnSave);
        btnResult = findViewById(R.id.btnResult);
        btnZero.setOnClickListener(this);
        btnOne.setOnClickListener(this);
        btnTwo.setOnClickListener(this);
        btnThree.setOnClickListener(this);
        btnFour.setOnClickListener(this);
        btnFive.setOnClickListener(this);
        btnSix.setOnClickListener(this);
        btnSeven.setOnClickListener(this);
        btnEight.setOnClickListener(this);
        btnNine.setOnClickListener(this);
        btnDash.setOnClickListener(this);
        btnDot.setOnClickListener(this);
        btnStart.setOnClickListener(this);
        btnClear.setOnClickListener(this);
        btnStop.setOnClickListener(this);
        btnQuit.setOnClickListener(this);
        btnEqual.setOnClickListener(this);
        btnSave.setOnClickListener(this);
        btnResult.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        int result = 0;
        String randOp = null, status = null;
        long timer = 0;

        switch (v.getId()){

            case R.id.btnZero:
                if (editTextShowResult.toString().equals("")){
                    editTextShowResult.setText(String.valueOf(0));
                }else{
                    editTextShowResult.append(String.valueOf(0));
                }
                break;

            case R.id.btnOne:
                if (editTextShowResult.toString().equals("")){
                    editTextShowResult.setText(String.valueOf(1));
                }else{
                    editTextShowResult.append(String.valueOf(1));
                }
                break;

            case R.id.btnTwo:
                if (editTextShowResult.toString().equals("")){
                    editTextShowResult.setText(String.valueOf(2));
                }else{
                    editTextShowResult.append(String.valueOf(2));
                }
                break;

            case R.id.btnThree:
                if (editTextShowResult.toString().equals("")){
                    editTextShowResult.setText(String.valueOf(3));
                }else{
                    editTextShowResult.append(String.valueOf(3));
                }
                break;

            case R.id.btnFour:
                if (editTextShowResult.toString().equals("")){
                    editTextShowResult.setText(String.valueOf(4));
                }else{
                    editTextShowResult.append(String.valueOf(4));
                }
                break;

            case R.id.btnFive:
                if (editTextShowResult.toString().equals("")){
                    editTextShowResult.setText(String.valueOf(5));
                }else{
                    editTextShowResult.append(String.valueOf(5));
                }
                break;

            case R.id.btnSix:
                if (editTextShowResult.toString().equals("")){
                    editTextShowResult.setText(String.valueOf(6));
                }else{
                    editTextShowResult.append(String.valueOf(6));
                }
                break;

            case R.id.btnSeven:
                if (editTextShowResult.toString().equals("")){
                    editTextShowResult.setText(String.valueOf(7));
                }else{
                    editTextShowResult.append(String.valueOf(7));
                }
                break;

            case R.id.btnEight:
                if (editTextShowResult.toString().equals("")){
                    editTextShowResult.setText(String.valueOf(8));
                }else{
                    editTextShowResult.append(String.valueOf(8));
                }
                break;

            case R.id.btnNine:
                if (editTextShowResult.toString().equals("")){
                    editTextShowResult.setText(String.valueOf(9));
                }else{
                    editTextShowResult.append(String.valueOf(9));
                }
                break;

            case R.id.btnDot:
                String text = editTextShowResult.getText().toString();
                editTextShowResult.setText(text + ".");
                break;

            case R.id.btnDash:
                editTextShowResult.setText("-");
                break;

            case R.id.btnStart:
                startTimer();
                break;

            case R.id.btnClear:
                clearText();
                break;

            case R.id.btnStop:
                countDownTimer.cancel();
                countDownTimer2.cancel();
                break;

            case R.id.btnQuit:
                finish();
                break;

            case R.id.btnEqual:

                switch (textViewOperation.getText().toString()){

                    case "+":
                        result = num1 + num2;
                        break;

                    case "-":
                        result = num1 - num2;
                        break;

                    case "*":
                        result = num1 * num2;
                        break;

                    case "/":
                        result = num1 / num2;
                        break;
                }
                userResult = Integer.valueOf(editTextShowResult.getText().toString());
                if (result == userResult){
                    status = "Correct";
                    countDownTimer2.cancel();
                    timer = Integer.valueOf(textViewTimer.getText().toString());
                    Toast.makeText(this, "Correct Answer", Toast.LENGTH_LONG).show();
                }else{
                    status = "Wrong";
                    timer = Integer.valueOf(textViewTimer.getText().toString());
                    Toast.makeText(this, "Wrong Answer", Toast.LENGTH_LONG).show();
                }

                list.add(new Operation(num1, num2, userResult, op, status,timer));
                break;

            case R.id.btnSave:
                break;

            case R.id.btnResult:
                editTextShowResult.setText(null);
                Intent intent = new Intent(this, SecondActivity.class);
                intent.putExtra("key",list);
                startActivity(intent);
                break;
        }

    }

    private void startTimer() {
          countDownTimer = new CountDownTimer(3600000,10000) {
            @Override
            public void onTick(long millisUntilFinished) {
                editTextShowResult.setText(null);
                Random random = new Random();
                num1 = random.nextInt(10) + 1;
                num2 = random.nextInt(10) + 1;
                op = operand[random.nextInt(operand.length)];
                textViewFirstNumber.setText(String.valueOf(num1));
                textViewOperation.setText(op);
                textViewSecondNumber.setText(String.valueOf(num2));
                updateCountDown();
            }
            @Override
            public void onFinish() {

            }
        };
        countDownTimer.start();
    }

    public void updateCountDown(){
            countDownTimer2 = new CountDownTimer(10000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeLeft = millisUntilFinished;
                int second = (int)(timeLeft / 1000);
                String timeFormat = String.format("%02d", second);
                textViewTimer.setText(String.valueOf(timeFormat));
            }
            @Override
            public void onFinish() {
                //textViewTimer.setText(String.valueOf(timeLeft));
            }
        };
        countDownTimer2.start();
    }

    public void clearText(){
        editTextShowResult.setText(null);
        textViewFirstNumber.setText(null);
        textViewOperation.setText(null);
        textViewSecondNumber.setText(null);
        editTextShowResult.requestFocus();
    }
}
