package com.example.sqllitedb;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.time.temporal.Temporal;

public class DBHandler extends SQLiteOpenHelper {
    public DBHandler(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
    String create = "CREATE TABLE myemployee(SNO INTEGER PRIMARY KEY, name TEXT , incerement TEXT )";
    db.execSQL(create);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        String drop = String.valueOf("DROP TABLE IF EXISTS");
        db.execSQL(drop, new String[]{"myemployee"});
        onCreate(db);
    }

    public void addemployee(Employee emp){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues value = new ContentValues();
        value.put("name" , emp.getName());
        value.put("increment" , emp.getIncrement());
        long k = db.insert("myemployee",null,value);
        Log.d("mytag",Long.toString(k));
        db.close();
    }

    public void getemployee(int sno){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query("myemployee", new String[]{String.valueOf(sno),"name","increment"},"sno=?",new String[]{"sno"},null,null, null);
        if (cursor != null && cursor.moveToFirst()){
            Log.d("mytag name",cursor.getString(1));
            Log.d("mytag increment",cursor.getString(2));
        }
        else {
            Log.d("mytag","Some error occurred");
        }
    }
}
