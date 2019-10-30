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

public class Question5Activity extends AppCompatActivity {
    RadioButton rBtn15;
    Button btn14;
    int temp1, temp2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question5);
        rBtn15 = (RadioButton) findViewById(R.id.rBtn15);
        btn14 = (Button) findViewById(R.id.btn14);
        SharedPreferences sharedPreferences = getSharedPreferences("MyData", Context.MODE_PRIVATE);
        temp1 = sharedPreferences.getInt("correctanswers", 0);
        temp2 = sharedPreferences.getInt("totalquestions", 0);
    }
    public void check(View view) {
        temp2++;
        if (rBtn15.isChecked() == true){
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
        btn14.setVisibility(View.VISIBLE);
    }

    public void next(View view) {
        Intent i = new Intent(view.getContext(), ResultsActivity.class);
        startActivity(i);
    }
}
