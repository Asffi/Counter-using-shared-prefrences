package com.example.counter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    private TextView counter,history,saveOn;
    private Button increment,decrement,reset;
    private int count=0;
    private String date;
    private SharedPreferences sharedPref;
    private static final String SHARED_NAME= "Shared data";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
        onClick();
    }

    private void onClick() {
        increment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count++;
                counter.setText(Integer.toString(count));
            }
        });
        decrement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                decreasing();
                counter.setText(Integer.toString(count));
            }
        });
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count=0;
                counter.setText(Integer.toString(count));
            }
        });
        saveOn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getDetails();
            }
        });


        history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getApplicationContext(),History.class);
                startActivity(intent);
            }
        });
    }

    private void getDetails() {
        Calendar calendar=Calendar.getInstance();
        SimpleDateFormat currentDateFormat= new SimpleDateFormat("MMM dd, yyyy");
        date=currentDateFormat.format(calendar.getTime());
        sharedPref = getSharedPreferences(SHARED_NAME, MODE_PRIVATE);
        //  sharedPref= PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("Date", date);
        editor.putString("Count", String.valueOf(count));
        editor.commit();
        Toast.makeText(this, "data saved", Toast.LENGTH_SHORT).show();
    }
    private void decreasing() {
        if(count<=0){
            Toast.makeText(MainActivity.this, "please make sure your counter has some value.", Toast.LENGTH_SHORT).show();
        }
        else
        {
            count--;
        }
    }
    private void findViews() {
        counter=findViewById(R.id.number);
        increment=findViewById(R.id.add);
        decrement=findViewById(R.id.minus);
        reset=findViewById(R.id.reset);
        history=findViewById(R.id.history_txtview);
        saveOn=findViewById(R.id.save_in_history_txtview);
    }

}