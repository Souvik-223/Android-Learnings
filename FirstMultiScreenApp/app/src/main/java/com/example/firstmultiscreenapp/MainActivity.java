package com.example.firstmultiscreenapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static  final String EXTRA_NAME = "com.example.firstmultiscreenapp.extra.NAME";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void openActivity(View v){
        Toast.makeText(this, "Opening second Activity", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this,MainActivity2.class);
        TextView name = findViewById(R.id.name);
        String nametext = name.getText().toString();
        intent.putExtra(EXTRA_NAME,nametext);
        startActivity(intent);

    }
}