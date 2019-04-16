package com.midterm.lasalle.timercalculationproject2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import model.Custom;
import model.FileManager;
import model.StoreInformation;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener {
    ListView listViewResult;
    TextView textViewPercentage;
    Button btnOk, btnSave;
    ArrayList<StoreInformation> list;
    FileManager fileManager;
    float rightCounter = 0.0f;
    int getTotalQuestion, getTotalAnswer, getTotalElapsedTime,getTotalDuration, getEmptyAnswers;
    double getVelocity = 0.0d;
    String text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        list = (ArrayList<StoreInformation>)getIntent().getExtras().getSerializable("key");
        initialize();

        for (int i = 0; i < list.size(); i++){
            if (list.get(i).getStatus().contains("Right")){
                rightCounter++;
            }
            getTotalQuestion = list.size();
            getTotalElapsedTime += list.get(i).getElapsedTime();
            getTotalDuration = (list.size()) * 10;

            if (list.get(i).getAnswer().equals("")){
                getEmptyAnswers ++;
            }else{
                getEmptyAnswers += 0;
            }
        }

        getTotalAnswer = ((list.size()) - getEmptyAnswers);
        double vel = Double.valueOf(getTotalElapsedTime)/ Double.valueOf(getTotalDuration);
        getVelocity = Math.round(vel);
        int wrong = Math.round((list.size() - rightCounter)/list.size()*100);
        int right = Math.round((rightCounter/list.size())*100);


           text = "\n" + "Total questions: " + getTotalQuestion + "\n" + "Total answered questions: " + getTotalAnswer +
                "\n" + "Total Duration: " + getTotalDuration + "\n"+ "Total Elapsed Time: "+ getTotalElapsedTime +
                "\n" + "Correct Answers: " + right +"%" + "\n" + "Wrong Answers: " + wrong + "%" + "\n"+ "Velocity: " + getVelocity;

        textViewPercentage.setText(text);
    }

    private void initialize() {

        Custom adapter = new Custom(this,R.layout.columnstyle,list);
        listViewResult = findViewById(R.id.listViewResult);
        listViewResult.setAdapter(adapter);
        textViewPercentage = findViewById(R.id.textViewPercentage);
        btnOk = findViewById(R.id.btnOk);
        btnSave = findViewById(R.id.btnSave);
        btnOk.setOnClickListener(this);
        btnSave.setOnClickListener(this);
        fileManager = new FileManager(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.btnOk:
                finish();
                break;

            case R.id.btnSave:
                fileManager.appendInFile(text);
                break;
        }

    }
}
