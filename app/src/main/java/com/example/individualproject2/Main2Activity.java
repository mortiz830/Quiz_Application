package com.example.individualproject2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.nfc.Tag;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;

public class Main2Activity extends AppCompatActivity {
    EditText et3, et4, et5, et6, et7;
    Button btn3;
    DatePickerDialog.OnDateSetListener mDateSetListener;
    private static final String TAG ="Main2Activity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        et3 = (EditText) findViewById(R.id.et3);
        et4 = (EditText) findViewById(R.id.et4);
        et5 = (EditText) findViewById(R.id.et5);
        et6 = (EditText) findViewById(R.id.et6);
        et7 = (EditText) findViewById(R.id.et7);
        btn3 = (Button) findViewById(R.id.btn3);

        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;
                Log.d(TAG, "onDateSet mm/dd/yy: " + month + "/" + day + "/" + year);
                String date = month + "/" + day + "/" + year;
                et5.setText(date);
            }
        };
    }

    public void submit(View view) {

        while (TextUtils.isEmpty(et3.getText()) == true || TextUtils.isEmpty(et4.getText()) == true ||
                TextUtils.isEmpty(et5.getText()) == true || TextUtils.isEmpty(et6.getText()) == true ||
                TextUtils.isEmpty(et7.getText()) == true){
            if(TextUtils.isEmpty(et3.getText()) == true){
                et3.setError("This field cannot be empty!");
            }
            if(TextUtils.isEmpty(et4.getText()) == true){
                et4.setError("This field cannot be empty!");
            }
            if(TextUtils.isEmpty(et5.getText()) == true){
                et5.setError("This field cannot be empty!");
            }
            if(TextUtils.isEmpty(et6.getText()) == true){
                et6.setError("This field cannot be empty!");
            }
            if(TextUtils.isEmpty(et7.getText()) == true){
                et7.setError("This field cannot be empty!");
            }
            return;
        }
        if(et3.getText().toString().length() < 3 || et3.getText().toString().length() > 30){
            et3.setError("Valid input is between 3 and 30 characters!");
            return;
        }

        if(et4.getText().toString().length() < 3 || et4.getText().toString().length() > 30){
            et4.setError("Valid input is between 3 and 30 characters!");
            return;
        }

        SharedPreferences sharedPreferences = getSharedPreferences("MyData", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("firstname", et3.getText().toString());
        editor.putString("lastname", et4.getText().toString());
        editor.putString("dob", et5.getText().toString());
        editor.putString("emailaddress", et6.getText().toString());
        editor.putString("password", et7.getText().toString());
        editor.commit();

        Intent i = new Intent(view.getContext(), MainActivity.class);
        startActivity(i);
    }

    public void date(View view) {
        Calendar cal = Calendar.getInstance();
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);
        int year = cal.get(Calendar.YEAR);

        DatePickerDialog dialog = new DatePickerDialog(this,
                android.R.style.Theme_Holo_Light_Dialog_MinWidth, mDateSetListener,
                year, month, day);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();
    }


};
