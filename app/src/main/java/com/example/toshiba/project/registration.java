package com.example.toshiba.project;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
public class registration extends AppCompatActivity {
    public static final String MyPREFERENCES = "MyPrefs";
    SQLiteOpenHelper openHelper;
    SQLiteDatabase db;
    dblogregg dblg;
    Cursor cursor;
    Button btnreg, btnlogin;
    EditText txtfname, txtlname, txtpass, txtemail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        //Log.d("db", "ok here");
        openHelper = new dblogregg(this);
        txtfname = (EditText) findViewById(R.id.edfname);
        txtlname = (EditText) findViewById(R.id.edlname);
        txtpass = (EditText) findViewById(R.id.edpass);
        txtemail = (EditText) findViewById(R.id.edemail);
        btnlogin = (Button) findViewById(R.id.btnlogin);
        btnreg = (Button) findViewById(R.id.btnreg);
    }
    public void toregister(View v) {
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+.+[a-z]";
        Log.d("db", "ok here");
        db = openHelper.getWritableDatabase();
        String fname = txtfname.getText().toString();
        String lname = txtlname.getText().toString();
        String pass = txtpass.getText().toString();
        String email = txtemail.getText().toString();
        Log.d("db", "ok here6");
        if (fname.equals("") || pass.equals("") || email.equals("")) {
            Toast.makeText(getApplicationContext(), "please fill All Fields",
                    Toast.LENGTH_LONG).show();
            Log.d("db", "ok here1");}
        if(!email.matches(emailPattern)){
            Toast.makeText(getApplicationContext(), "not rigth email format ",
                    Toast.LENGTH_LONG).show();
        }
        else {
            cursor = db.rawQuery("SELECT * FROM " + dblogregg.TABLE_NAME + " WHERE " +
                    dblogregg.COL_EMAIL + "=? ", new String[]{email});
            if (cursor != null) {
                if (cursor.getCount() > 0) {
                    Toast.makeText(getApplicationContext(), "the email is already exist",
                            Toast.LENGTH_LONG).show();
                } else {
                    Log.d("db", "ok here3");
                    insertdata(fname, lname, pass, email);
                    Toast.makeText(getApplicationContext(), "register successfully",
                            Toast.LENGTH_LONG).show();
                    Intent i=new Intent(this,login.class);
                    startActivity(i);
                }
            }
        }
    }
    public void insertdata(String fname, String lname, String pass, String email) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(dblogregg.COL_FNAME, fname);
        contentValues.put(dblogregg.COL_LNAME, lname);
        contentValues.put(dblogregg.COL_PASS, pass);
        contentValues.put(dblogregg.COL_EMAIL, email);
        Log.d("db", "Add record2");
        long id = db.insert(dblogregg.TABLE_NAME, null, contentValues);
    }
    public void tologinpage(View v) {
        Intent i=new Intent(this,login.class);
        startActivity(i);
    }
}