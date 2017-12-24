package com.example.toshiba.project;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
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
public class login extends AppCompatActivity {
    public static final String MyPREFERENCES = "MyPrefs";
    SQLiteDatabase db;
    SQLiteOpenHelper openHelper;
    private Cursor cursor2;
    private Cursor cursor;
    Button btnLogin;
    EditText txtEmail, txtPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Log.d("test","login");
        txtEmail = (EditText) findViewById(R.id.edemail);
        txtPass = (EditText) findViewById(R.id.edpass);
        btnLogin = (Button) findViewById(R.id.btnlogin);
        openHelper = new dblogregg(this);
        // db = openHelper.getReadableDatabase();
        db = openHelper.getWritableDatabase();
    }
    public void onClick(View v) {
        db = openHelper.getReadableDatabase();
        String email = txtEmail.getText().toString();
        String pass = txtPass.getText().toString();
        cursor = db.rawQuery("SELECT * FROM " + dblogregg.TABLE_NAME + " WHERE " +
                dblogregg.COL_EMAIL + "=? AND " + dblogregg.COL_PASS + "=?", new String[]{email, pass});
        if (cursor != null) {
            Log.d("test", "cursor");
            if (cursor.getCount() > 0) {
                Log.d("test", "cursor2");
                Toast.makeText(getApplicationContext(), "Login Success",
                        Toast.LENGTH_SHORT).show();
                SharedPreferences sh = getSharedPreferences(MyPREFERENCES,
                        Context.MODE_PRIVATE);
                SharedPreferences.Editor editor= sh.edit();
                Log.d("test", "cursor");
                cursor2 = db.rawQuery("select * from registeration where Email=?", new String[]
                        {email});
                Log.d("test", "b4 if");
                if (cursor2.moveToFirst()) {
                    do {
                        String it = cursor2.getString(cursor2.getColumnIndex(dblogregg.COL_FNAME));
                        String it1 = cursor2.getString(cursor2.getColumnIndex(dblogregg.COL_EMAIL));
                        String it2 = cursor2.getString(cursor2.getColumnIndex(dblogregg.COL_PASS));
                        //
                        Toast.makeText(getApplicationContext(),it1+" || "+it2,Toast.LENGTH_SHORT).show();
                        editor.putString("name",it);
                        editor.putString("pass", it2);
                        editor.putString("email", it1);
                        editor.commit();
                        Log.d("test",it2);
                    } while (cursor2.moveToNext());}
                Intent i = new Intent(this, projectspage.class);
                startActivity(i);
                Log.d("test", "here ok");
            } else {
                Toast.makeText(getApplicationContext(), "Login error",
                        Toast.LENGTH_SHORT).show();
            }
        }
    }
    public void tosignup(View v) {
        Intent i = new Intent(this, registration.class);
        startActivity(i);
    }}