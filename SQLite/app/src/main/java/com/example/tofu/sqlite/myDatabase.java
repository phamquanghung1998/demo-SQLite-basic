package com.example.tofu.sqlite;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class myDatabase extends SQLiteOpenHelper {
    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    public myDatabase(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }
// truy vấn k trả kết quả
    public void QueryData(String sql){
        SQLiteDatabase  database = getWritableDatabase();
        database.execSQL(sql);
    }
// truy vấn trả kết quả
    public Cursor getData(String sql)
    {
        SQLiteDatabase database = getReadableDatabase();
        return database.rawQuery(sql,null);

    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
