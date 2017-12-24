package com.example.toshiba.project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class projectp2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_projectp2);
    }public void readMore1(View V) {

        Intent i = new Intent(this, Emergency.class);
        startActivity(i);
        finish();


    }



}
