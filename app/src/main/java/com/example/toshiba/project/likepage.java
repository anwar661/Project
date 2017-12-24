package com.example.toshiba.project;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
public class likepage extends AppCompatActivity {
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener;
    BottomNavigationView btmnav;
    ListView lv;
    String [] year_project={"\nLIKE1\n","\nlike2\n","\nGRADUATE-2012\n","\nGRADUATE-2013\n",
            "\nGRADUATE-2014\n","\nGRADUATE-2015\n","\nGRADUATE-2016\n"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_likepage);
        Log.d("test","like page");
        lv =(ListView)findViewById(R.id.listview);
        Log.d("test","project1");
        //create adapter
        ArrayAdapter<String>array_Adapter=new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, year_project);
        Log.d("test","project2");
        //to make a list
        lv.setAdapter(array_Adapter);
        btmnav=(BottomNavigationView)findViewById(R.id.navigation);
        Menu menu=btmnav.getMenu();
        MenuItem menuItem=menu.getItem(1);
        menuItem.setChecked(true);
        btmnav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener(){
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navigation_project:
                        Intent i1=new Intent(likepage.this,projectspage.class);
                        startActivity(i1);
                        Log.d("test","from likepage in navigation main");
                        break;
                    case R.id.navigation_like:
                        //Intent i2=new Intent(likepage.this,likepage.class);
                        Log.d("test","from like page befor go to like page");
                        // startActivity(i2);
                        break;
                    case R.id.navigation_profile:
                        Intent i3=new Intent(likepage.this,profile.class);
                        Log.d("test","from like page befor go to profile page");
                        startActivity(i3);
                        break;
                }
                return false;
            }
        });
    }
}
