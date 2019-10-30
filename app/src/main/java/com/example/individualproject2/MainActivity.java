package com.example.individualproject2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final String DEFAULT = "N/A";
    EditText et1, et2;
    Button btn1, btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = (EditText) findViewById(R.id.et1);
        et2 = (EditText) findViewById(R.id.et2);
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
    }

    public void register(View view) {
        Intent i = new Intent(view.getContext(), Main2Activity.class);
        startActivity(i);
    }

    public void signin(View view) {
        SharedPreferences sharedPreferences = getSharedPreferences("MyData", Context.MODE_PRIVATE);
        String email = sharedPreferences.getString("emailaddress", DEFAULT);
        String password = sharedPreferences.getString("password", DEFAULT);
        String uEmail = et1.getText().toString();
        String uPassword = et2.getText().toString();
        if(uEmail.equals(email) && uPassword.equals(password)){
            Intent i = new Intent(view.getContext(), Main3Activity.class);
            startActivity(i);
        }
        else
            Toast.makeText(this, "Invalid email address or password! Please re-enter.", Toast.LENGTH_LONG).show();
    }
}
