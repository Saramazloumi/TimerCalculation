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
    Validator validatory;
    //StoreInformation allInformation;

    ArrayList<StoreInformation> infoList;
    FileManager fileManager;

    long userTimer;
    String status, questions;
    boolean activeButton;
    int userAnswer;

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
        //btnStartStop.setText("Start");
    }

    @Override
    public void onClick(View v) {
        int result = 0;
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

            case R.id.btnClear:
                clearText();
                break;

            case R.id.btnNext:
                startTimer();
                break;

            case R.id.btnQuit:
                finish();
                break;

            case R.id.btnEqual:
                //validate the result
                validatory = new Validator(Integer.valueOf(editTextShowResult.getText().toString()), question.correctResult());
                if (validatory.validationAnswer()){
                    Toast.makeText(this, "Good Job!", Toast.LENGTH_SHORT).show();
                    status = "Correct";
                }else {
                    Toast.makeText(this, "Wrong!", Toast.LENGTH_SHORT).show();
                    status = "Fail";
                }

              editTextShowResult.setText(null);
              countDownTimer.cancel();
              countDownTimer2.cancel();

              startTimer();
              updateCountDown();

              //saving information
                saveInformation();
                break;

            case R.id.btnSave:
                fileManager.writeInFile(infoList);
                break;

            case R.id.btnResult:
                editTextShowResult.setText(null);
                countDownTimer.cancel();
                countDownTimer2.cancel();
                Intent intent = new Intent(this, SecondActivity.class);
                intent.putExtra("key", infoList);
                startActivity(intent);
                break;
        }
    }

    private void startTimer() {
        question.generateOperation();
        textViewOperation.setText(question.toString());

        btnStartStop.setText(btnStartStopState.Stop.name());
        activeButton = true;

          countDownTimer = new CountDownTimer(getResources().getInteger(R.integer.time),10000) {

            @Override
            public void onTick(long millisUntilFinished) {
                editTextShowResult.setText(null);
                userTimer = getResources().getInteger(R.integer.time) - millisUntilFinished;
                updateCountDown();

            }
            @Override
            public void onFinish() {
                //userTimer = 0;
                startTimer();
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

    public void clearText(){
        editTextShowResult.setText(null);
        textViewOperation.setText(null);
        editTextShowResult.requestFocus();
    }

    public void saveInformation(){
        userAnswer = Integer.valueOf(editTextShowResult.getText().toString());
        questions = textViewOperation.getText().toString();

        infoList.add(new StoreInformation(questions,userAnswer,(int)userTimer / 1000,status));
    }

}
