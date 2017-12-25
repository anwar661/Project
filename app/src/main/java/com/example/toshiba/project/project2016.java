package com.example.toshiba.project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class project2016 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project2016);
    }public void watchvideo1(View V) {

        Intent i = new Intent(this, prophet.class);
        startActivity(i);
        finish();


    }public void watchvideo2(View V) {

        Intent i = new Intent(this, Arrangement_words.class);
        startActivity(i);
        finish();


    }public void watchvideo3(View V) {

        Intent i = new Intent(this, Arrangement_words.class);
        startActivity(i);
        finish();


    }
}
