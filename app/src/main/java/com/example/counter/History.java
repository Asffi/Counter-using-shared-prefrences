package com.example.counter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class History extends AppCompatActivity {
    private static final String DEFAULT_VALUE = "Shared data";
    TextView lastCount,count,date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        initViews();
        SharedPreferences sharedPref = this.getSharedPreferences(DEFAULT_VALUE, Context.MODE_PRIVATE);
        lastCount.setText("Last Count: ");
        count.setText(sharedPref.getString("Count",DEFAULT_VALUE));
        date.setText(sharedPref.getString("Date",DEFAULT_VALUE));
    }

    private void initViews() {
        lastCount=findViewById(R.id.lastcount_txtview);
        count=findViewById(R.id.count_txtview);
        date=findViewById(R.id.date_txtview);
    }
}