package com.example.toshiba.project;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
public class pop_up_pass extends AppCompatActivity {
    SQLiteOpenHelper openHelper;
    SQLiteDatabase db;
    EditText curren_pass,new_pass,confirm_new;
    Button change,cancle;
    TextView error;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("test", "start pop up window");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pop_up_pass);
        openHelper = new dblogregg(this);
        db = openHelper.getWritableDatabase();
        db = openHelper.getReadableDatabase();
        curren_pass = (EditText) findViewById(R.id.editText1);
        new_pass = (EditText) findViewById(R.id.editText2);
        confirm_new = (EditText) findViewById(R.id.editText3);
        change = (Button) findViewById(R.id.button1);
        cancle = (Button) findViewById(R.id.button2);
        error = (TextView) findViewById(R.id.textView2);
        Log.d("test", "in pop up window");
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getRealMetrics(dm);
        int w = dm.widthPixels;
        int h = dm.heightPixels;
        getWindow().setLayout((int) (w * .8), (int) (h * .6));
    }
    public void changepass(View v){
        String current=curren_pass.getText().toString();
        String newpass = new_pass.getText().toString();
        String confirmpass = confirm_new.getText().toString();
        SharedPreferences sh = getSharedPreferences(login.MyPREFERENCES, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sh.edit();
        if(!current.equals(sh.getString("pass",null))){
            error.setText("password not rigth");}
        else if (newpass.equals(confirmpass)){
            db.execSQL( "update "+dblogregg.TABLE_NAME+ " set "+dblogregg.COL_PASS+" ='"+newpass+
                    "' where "+ dblogregg.COL_PASS+" ='"+current+"';");
            error.setText("password changed");
            editor.putString("pass",newpass);
            editor.commit();
            finish();
        }else{
            error.setText("password don't matched");
        }
    }
    public void cancle(View v){
        finish();
    }
}
