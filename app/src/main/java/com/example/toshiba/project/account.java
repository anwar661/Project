package com.example.toshiba.project;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
public class account extends AppCompatActivity {
    private static final String TAG = "q";
    EditText email,pass,username;
    SharedPreferences sh;
    SharedPreferences.Editor editor;
    String us;
    private Cursor cursor;
    String e,n;
    static SQLiteDatabase db;
    SQLiteOpenHelper openHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);
        Log.d("test", "be4 ");
        openHelper = new dblogregg(this);
        db = openHelper.getWritableDatabase();
        email = (EditText) findViewById(R.id.editText1);
        pass = (EditText) findViewById(R.id.editText2);
        username = (EditText) findViewById(R.id.editText3);
        sh=getSharedPreferences(registration.MyPREFERENCES, Context.MODE_PRIVATE);
        pass.setOnTouchListener(handle);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("go back");
        email.setText(sh.getString("email",null));
        pass.setText(sh.getString("pass",null));
        username.setText(sh.getString("name",null));
        sh = getSharedPreferences(login.MyPREFERENCES, Context.MODE_PRIVATE);
        editor = sh.edit();
        Log.d("test", "be4 textchange ");
        email.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {

                Toast.makeText(getApplicationContext(),sh.getString("email",null),Toast.LENGTH_SHORT).show();
                Log.d("test", "stert method ");
                db.execSQL("update "+dblogregg.TABLE_NAME+ " set "+dblogregg.COL_EMAIL+"='"+email.getText().toString()+
                        "' where "+ dblogregg.COL_EMAIL+"='"+e+"';");
                Log.d("test",email.getText().toString());
                Log.d("test", "after update");
                editor.putString("email",email.getText().toString());
                editor.commit();
                //Log.d("test",it1);
            }
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                e=email.getText().toString();}
            public void onTextChanged(CharSequence s, int start, int before, int count) {}
        });
        username.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {

                Toast.makeText(getApplicationContext(),sh.getString("name",null),Toast.LENGTH_SHORT).show();
                Log.d("test", "stert method ");
                db.execSQL("update "+dblogregg.TABLE_NAME+ " set "+dblogregg.COL_FNAME+"='"+username.getText().toString()+
                        "' where "+ dblogregg.COL_FNAME+"='"+n+"';");
                Log.d("test",username.getText().toString());
                Log.d("test", "after update");
                editor.putString("name",username.getText().toString());
                editor.commit();
                //Log.d("test",it1);
            }
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                n=username.getText().toString();}
            public void onTextChanged(CharSequence s, int start, int before, int count) {}
        });
    }
    public boolean onOptionsItemSelected(MenuItem item){
        int id=item.getItemId();
        if(id==android.R.id.home){
            //end the activity
            // Bundle b=new Bundle();
            // b.putString("name",username.getText().toString());
            //Intent i=new Intent(account.this,settings.class);
            // i.putExtras(b);
            // startActivity(i);
            this.finish();
        }
        return super.onOptionsItemSelected(item);
    }
    View.OnTouchListener handle=new View.OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            if(event.getAction() == MotionEvent.ACTION_UP){
                Intent i=new Intent(getApplicationContext(),pop_up_pass.class);
                startActivity(i);
                return true;
            }
            return false;
        }
    }; public void dele(View view){

        String em =  email.getText().toString();

        db.delete(dblogregg.TABLE_NAME ,"Email = ?" , new String[]{em});

        Toast.makeText(getApplicationContext(),"account is deleted",Toast.LENGTH_LONG).show();

        Intent i=new Intent(getApplicationContext(),login.class);
        startActivity(i);



    }


}