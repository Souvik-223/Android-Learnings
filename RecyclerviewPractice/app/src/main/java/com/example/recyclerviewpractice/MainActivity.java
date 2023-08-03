package com.example.recyclerviewpractice;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {
    Contact o1 = new Contact(1,"93393849","souvik");
    Contact o2 = new Contact(1,"93393849","souvik");
    Contact o3 = new Contact(1,"93394849","souvik");
    Contact o4 = new Contact(1,"933543849","souvik");
    Contact o5 = new Contact(1,"93393849","souvik");
    Contact o6 = new Contact(1,"93393849","souvik");
    Contact o7 = new Contact(1,"93393849","souvik");
    Contact o8 = new Contact(1,"93393849","souvik");
    Contact o9 = new Contact(1,"93393849","souvik");

    Contact[] contacts = {o1, o2, o3, o4, o5, o6, o7, o8, o9};
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        CustomAdapter ad = new CustomAdapter(contacts);
    }
}