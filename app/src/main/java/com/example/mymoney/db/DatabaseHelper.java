package com.example.mymoney.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    public DatabaseHelper(@Nullable Context context) {
        super(context, "Login.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("Create table user(email text primary key, password text)");
       // db.execSQL("Create table category_data(_id integer primary key autoincrement, category_name text not null) ");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists user");
       // db.execSQL("drop table if exists category_data");
    }
    // insert in db
    public boolean insert(String email, String password){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("email", email);
        contentValues.put("password", password);
        long ins = db.insert("user", null, contentValues);
        if (ins == 1){
            return false;
        }
        else {
            return true;
        }

    }
    // check - if email exists
    public boolean checkEmail(String email){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from user where email =?", new String[]{email});
        if (cursor.getCount() > 0){
            return true;
        }
        else {
            return false;
        }
    }
    // check the email and password
    public boolean emailPassword(String email, String password){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from user where email =? and password =?", new String[]{email, password});
        if (cursor.getCount() > 0){
            return true;
        }
        else {
            return false;
        }
    }
}
