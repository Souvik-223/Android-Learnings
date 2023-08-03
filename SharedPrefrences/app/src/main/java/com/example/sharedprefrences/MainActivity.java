package com.example.sharedprefrences;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Map;
import java.util.Set;

public class MainActivity extends AppCompatActivity {
    private EditText editText;
    private TextView textView;
    private Button submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);
        editText = findViewById(R.id.data);
        submit = findViewById(R.id.Submit);

        SharedPreferences sp = getSharedPreferences("MyPref",MODE_PRIVATE);
        SharedPreferences.Editor ed = sp.edit();
        String edit = sp.getString("name" , "No Value as of Now");
        textView.setText(edit);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = editText.getText().toString();
                ed.putString("name",str);
                ed.apply();
                textView.setText(edit);
            }
        });
    }
}