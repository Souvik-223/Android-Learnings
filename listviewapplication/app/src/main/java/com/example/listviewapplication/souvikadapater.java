package com.example.listviewapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.jetbrains.annotations.NotNull;

public class souvikadapater extends ArrayAdapter<String> {

    private String []arr;
    private Context context;
    public souvikadapater(@NonNull Context context, int resource , @NotNull String[] arr) {
        super(context, resource,arr);
        this.context = context;
        this.arr = arr;

    }

    @Override
    public String getItem(int position) {
        return arr[position];
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView = LayoutInflater.from(getContext()).inflate(R.layout.my_souvik_layout , parent, false);
        TextView t = convertView.findViewById(R.id.textView);
        t.setText(getItem(position));
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "You clicked on listview" + position, Toast.LENGTH_SHORT).show();
            }
        });
        return convertView;
    }
}
