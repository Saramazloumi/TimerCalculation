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
import model.StoreInformation;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener {
    ListView listViewResult;
    TextView textViewPercentage;
    Button btnOk;
    ArrayList<StoreInformation> list;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        list = (ArrayList<StoreInformation>)getIntent().getExtras().getSerializable("key");
        initialize();
    }

    private void initialize() {

        Custom adapter = new Custom(this,R.layout.columnstyle,list);
        listViewResult = findViewById(R.id.listViewResult);
        listViewResult.setAdapter(adapter);
        textViewPercentage = findViewById(R.id.textViewPercentage);
        btnOk = findViewById(R.id.btnOk);
        btnOk.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        finish();
    }
}
