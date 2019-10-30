package com.example.individualproject2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

public class Question3Activity extends AppCompatActivity {
    RadioButton rBtn8;
    Button btn10;
    int temp1, temp2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question3);
        rBtn8 = (RadioButton) findViewById(R.id.rBtn8);
        btn10 = (Button) findViewById(R.id.btn10);
        SharedPreferences sharedPreferences = getSharedPreferences("MyData", Context.MODE_PRIVATE);
        temp1 = sharedPreferences.getInt("correctanswers", 0);
        temp2 = sharedPreferences.getInt("totalquestions", 0);
    }

    public void check(View view) {
        temp2++;
        if (rBtn8.isChecked() == true){
            temp1++;
            Toast.makeText(this, "Correct!", Toast.LENGTH_LONG).show();
        }
        else
            Toast.makeText(this, "Incorrect!", Toast.LENGTH_LONG).show();
        SharedPreferences sharedPreferences = getSharedPreferences("MyData", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("correctanswers", temp1);
        editor.putInt("totalquestions", temp2);
        editor.commit();
        btn10.setVisibility(View.VISIBLE);
    }

    public void next(View view) {
        Intent i = new Intent(view.getContext(), Question4Activity.class);
        startActivity(i);
    }
}
