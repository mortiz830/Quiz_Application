package com.example.individualproject2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main3Activity extends AppCompatActivity {
    TextView tv2, tv5, tv6;
    int count, attempts, score;
    public static final String DEFAULT = "N/A";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        tv2 = (TextView) findViewById(R.id.tv2);
        tv5 = (TextView) findViewById(R.id.tv5);
        tv6 = (TextView) findViewById(R.id.tv6);

        SharedPreferences sharedPreferences = getSharedPreferences("MyData", Context.MODE_PRIVATE);
        String fName = sharedPreferences.getString("firstname", DEFAULT);
        attempts = sharedPreferences.getInt("attempts", 0);
        score = sharedPreferences.getInt("score", 0);
        tv2.setText("Welcome " + fName);
        tv5.setText(Integer.toString(attempts));
        tv6.setText(Integer.toString(score));
    }

    public void takequiz(View view) {
        count = attempts + 1;
        SharedPreferences sharedPreferences = getSharedPreferences("MyData", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("attempts",count);
        editor.remove("correctanswers");
        editor.remove("totalquestions");
        editor.remove("score");
        editor.commit();

        Intent i = new Intent(view.getContext(), Question1Activity.class);
        startActivity(i);
    }
}
