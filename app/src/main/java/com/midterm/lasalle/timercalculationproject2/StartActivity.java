package com.midterm.lasalle.timercalculationproject2;

import android.content.Context;
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

import model.FileManager;
import model.QuestionGenerator;
import model.StoreInformation;
import model.Validator;

public class StartActivity extends AppCompatActivity implements View.OnClickListener {

    EditText editTextShowResult;
    TextView textViewOperation, textViewTimer;
    Button btnZero, btnOne, btnTwo,btnThree,btnFour,btnFive,btnSix,btnSeven,btnEight,btnNine,
    btnDash,btnDot,btnStartStop,btnClear,btnNext,btnQuit,btnEqual,btnSave,btnResult;

    private final String DIGITS[] = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", " -", "."};

    private CountDownTimer countDownTimer, countDownTimer2;

    public long timeLeft = 10000;
    QuestionGenerator question;
    FileManager fileManager;
    Validator validatory;
    ArrayList<StoreInformation> infoList;

    long userTimer;
    String status, questions;
    boolean activeButton;
    String userAnswer;

    public enum btnStartStopState{
        Start,
        Stop
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        initialize();
    }


    private void initialize() {
        editTextShowResult = findViewById(R.id.editTextShowResult);
        textViewOperation = findViewById(R.id.textViewOperation);
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
        btnStartStop = findViewById(R.id.btnStartStop);
        btnClear = findViewById(R.id.btnClear);
        btnNext = findViewById(R.id.btnNext);
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
        btnStartStop.setOnClickListener(this);
        btnClear.setOnClickListener(this);
        btnNext.setOnClickListener(this);
        btnQuit.setOnClickListener(this);
        btnEqual.setOnClickListener(this);
        btnSave.setOnClickListener(this);
        btnResult.setOnClickListener(this);
        activeButton = false;
        question = new QuestionGenerator();
        infoList = new ArrayList<StoreInformation>();
        fileManager = new FileManager(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.btnZero:
                editTextShowResult.append(DIGITS[0]);
                break;
            case R.id.btnOne:
                editTextShowResult.append(DIGITS[1]);
                break;
            case R.id.btnTwo:
                editTextShowResult.append(DIGITS[2]);
                break;
            case R.id.btnThree:
                editTextShowResult.append(DIGITS[3]);
                break;
            case R.id.btnFour:
                editTextShowResult.append(DIGITS[4]);
                break;
            case R.id.btnFive:
                editTextShowResult.append(DIGITS[5]);
                break;
            case R.id.btnSix:
                editTextShowResult.append(DIGITS[6]);
                break;
            case R.id.btnSeven:
                editTextShowResult.append(DIGITS[7]);
                break;
            case R.id.btnEight:
                editTextShowResult.append(DIGITS[8]);
                break;
            case R.id.btnNine:
                editTextShowResult.append(DIGITS[9]);
                break;
            case R.id.btnDot:
                editTextShowResult.append(DIGITS[11]);
                break;
            case R.id.btnDash:
                String text = "-";
                editTextShowResult.append(text);
                break;
            case R.id.btnStartStop:

                if (activeButton){
                  stopCounter();
                }else {
                    startTimer();
                    updateCountDown();
                }
                break;

            case R.id.btnSave:
                fileManager.writeInFile(infoList);
                break;

            case R.id.btnClear:
                clearText();
                break;

            case R.id.btnNext:
                try {
                    stopCountDown();
                    questions = textViewOperation.getText().toString();
                    infoList.add(new StoreInformation(questions, "", (int)userTimer / 1000, "Fail"));
                    Toast.makeText(this,"Fail!", Toast.LENGTH_SHORT).show();
                    startTimer();
                    updateCountDown();
                }catch(Exception e){
                    Toast.makeText(this,e.getMessage(), Toast.LENGTH_SHORT).show();
                }

                break;

            case R.id.btnQuit:
                finish();
                break;

            case R.id.btnEqual:

                try { //validate the result
                    validatory = new Validator(Integer.valueOf(editTextShowResult.getText().toString()), question.correctResult());
                    if (validatory.validationAnswer()) {
                        status = "Right";
                        Toast.makeText(this, "Good Job!", Toast.LENGTH_SHORT).show();
                    } else if(validatory.validationAnswer() == false || userAnswer.equals("")){
                        status = "Fail";
                        Toast.makeText(this, "Wrong!", Toast.LENGTH_SHORT).show();
                    }
                    saveInformation();
                    stopCountDown();

                    startTimer();
                    updateCountDown();

                }catch(Exception e){
                    Toast.makeText(this, "No answer!", Toast.LENGTH_SHORT).show();
                }

                break;

            case R.id.btnResult:
                try {
                    stopCountDown();
                    Intent intent = new Intent(this, SecondActivity.class);
                    intent.putExtra("key", infoList);
                    startActivity(intent);
                }catch(Exception e){
                    Toast.makeText(this, "No Answer yet!", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
Context context  = this;
    private void startTimer() {
        question.generateOperation();
        textViewOperation.setText(question.toString());

        btnStartStop.setText(btnStartStopState.Stop.name());
        activeButton = true;

          countDownTimer = new CountDownTimer(10000,1000) {

            @Override
            public void onTick(long millisUntilFinished) {
                userTimer = 10000 - millisUntilFinished;
            }
            @Override
            public void onFinish() {
                userTimer = 0;
                startTimer();
                questions = textViewOperation.getText().toString();
                infoList.add(new StoreInformation(questions, "", 10, "Fail"));
                    Toast.makeText(context, "time's up, FAIL!", Toast.LENGTH_SHORT).show();
            }
        }.start();
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
                updateCountDown();
            }
        }.start();
    }

    public void stopCounter(){
        btnStartStop.setText(btnStartStopState.Start.name());
        btnStartStop.setVisibility(View.VISIBLE);
        countDownTimer.cancel();
        countDownTimer2.cancel();
        activeButton = false;
    }

    public void stopCountDown(){
        editTextShowResult.setText("");
        countDownTimer.cancel();
        countDownTimer2.cancel();
    }

    public void clearText(){
        editTextShowResult.setText("");
        textViewOperation.setText("");
        editTextShowResult.requestFocus();
    }

    public void saveInformation(){

        userAnswer = editTextShowResult.getText().toString();
        questions = textViewOperation.getText().toString();

        infoList.add(new StoreInformation(questions,userAnswer,(int)userTimer / 1000,status));
    }

}
