package com.example.toshiba.project;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

public class dblogregg extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION=1;
    public static final String DB_NAME="register.db";
    public static final String TABLE_NAME="registeration";
    public static final String COL_ID ="ID";
    public static final String COL_FNAME="FirstName";
    public static final String COL_LNAME="LastName";
    public static final String COL_EMAIL="Email";
    public static final String COL_PASS="Password";
    public dblogregg(Context context){
        super(context,DB_NAME,null,DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "FirstName TEXT NOT NULL,LastName TEXT,Password TEXT NOT NULL,Email TEXT UNIQUE NOT NULL )");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS" +TABLE_NAME);
        onCreate(db);
    }
}
