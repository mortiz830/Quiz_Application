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

public class Question1Activity extends AppCompatActivity {
    RadioButton rBtn1, rBtn2;
    Button btn6;
    int temp1, temp2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question1);
        rBtn1 = (RadioButton) findViewById(R.id.rBtn1);
        rBtn2 = (RadioButton) findViewById(R.id.rBtn2);
        btn6 = (Button) findViewById(R.id.btn6);
        SharedPreferences sharedPreferences = getSharedPreferences("MyData", Context.MODE_PRIVATE);
        temp1 = sharedPreferences.getInt("correctanswers", 0);
        temp2 = sharedPreferences.getInt("totalquestions", 0);

    }

    public void check(View view) {
        temp2++;
        if (rBtn1.isChecked() == true){
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
        btn6.setVisibility(View.VISIBLE);
    }

    public void next(View view) {
        Intent i = new Intent(view.getContext(), Question2Activity.class);
        startActivity(i);
    }
}
