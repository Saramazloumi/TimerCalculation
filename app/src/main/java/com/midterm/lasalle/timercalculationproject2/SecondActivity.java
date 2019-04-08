package com.midterm.lasalle.timercalculationproject2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener {
    ListView listViewResult;
    Button btnOk;
    TextView textViewShowResult;
    ArrayAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        initialize();
    }

    private void initialize() {
        listViewResult = findViewById(R.id.listViewResult);
        btnOk = findViewById(R.id.btnOk);
        textViewShowResult = findViewById(R.id.textViewShowResult);
        btnOk.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {

    }
}
