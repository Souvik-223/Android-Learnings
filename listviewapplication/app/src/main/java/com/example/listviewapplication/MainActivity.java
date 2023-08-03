package com.example.listviewapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ListView listview;
    String []arr = {"this","is","souvik","chakraborty"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listview = findViewById(R.id.listview);

    // Using the built in adapters
//     ArrayAdapter ad = new ArrayAdapter(this, android.R.layout.simple_list_item_1, arr);
//     listview.setAdapter(ad);

        // Using Custom adapter
        souvikadapater sk = new souvikadapater(this , R.layout.my_souvik_layout , arr);
        listview.setAdapter(sk);

        // This is how to apply OnItemClickListener
//        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                Toast.makeText(MainActivity.this, "You clicked on listview" + i, Toast.LENGTH_SHORT).show();
//            }
//        });
    }
}