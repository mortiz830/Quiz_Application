package com.example.individualproject2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.provider.BaseColumns;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultsActivity extends AppCompatActivity {
    TextView tv7, tv8, tv9;
    int answers, questions, score;
    double temp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        tv7 = (TextView) findViewById(R.id.tv7);
        tv8 = (TextView) findViewById(R.id.tv8);
        tv9 = (TextView) findViewById(R.id.tv9);

        SharedPreferences sharedPreferences = getSharedPreferences("MyData", Context.MODE_PRIVATE);
        answers = sharedPreferences.getInt("correctanswers", 0);
        questions = sharedPreferences.getInt("totalquestions", 0);
        temp = ((double) answers / (double) questions) * 100;
        score = (int) temp;

        tv7.setText(Integer.toString(answers));
        tv8.setText(Integer.toString(score));

        if(score == 100)
            tv9.setText("PERFECT!");
        if (score >= 60 && score < 100)
            tv9.setText("You passed, well done!");
        if (score < 60)
            tv9.setText("Better luck next time.");
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("score", score);
        editor.commit();
    }

    public void retry(View view) {
        Intent i = new Intent(view.getContext(), Main3Activity.class);
        startActivity(i);
    }
}