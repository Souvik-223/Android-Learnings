package com.example.sqllitedb;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DBHandler handler = new DBHandler(this , "empdb" , null , 1);
        handler.addemployee(new Employee(1,"Souvik", 33.3));
        handler.getemployee(1);
        handler.close();
    }
}