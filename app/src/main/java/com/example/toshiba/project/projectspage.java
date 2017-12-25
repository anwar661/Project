package com.example.toshiba.project;

import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import static com.example.toshiba.project.search.items;

public class projectspage extends AppCompatActivity {
    ListView listView;
    String [] year_project={"\nGRADUATE-2016\n","\nGRADUATE-2015\n","\nGRADUATE-2014\n","\nGRADUATE-2013\n",
            "\nGRADUATE-2012\n","\nGRADUATE-2011\n","\nGRADUATE-2010\n"};
private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener;
        BottomNavigationView btmnav;
@Override
protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_projectspage);
        Log.d("test","project");
        listView =(ListView)findViewById(R.id.listview);
        Log.d("test","project1");
        //create adapter
        ArrayAdapter<String>array_Adapter=new ArrayAdapter<String>(this,
        android.R.layout.simple_list_item_1, year_project);
        Log.d("test","project2");
        //to make a list
        listView.setAdapter(array_Adapter);
        Log.d("test","project3");
        btmnav=(BottomNavigationView)findViewById(R.id.navigation);
        Log.d("test","project4");
        Menu menu=btmnav.getMenu();
        MenuItem menuItem=menu.getItem(0);
        menuItem.setChecked(true);
        btmnav.setOnNavigationItemSelectedListener(new
        BottomNavigationView.OnNavigationItemSelectedListener(){
@Override
public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Log.d("test","project5");
        switch (item.getItemId()) {
        case R.id.navigation_project:
        //Intent i1=new Intent(projectspage.this,projectspage.class);
        //startActivity(i1);
        Log.d("test","from project page in navigation main");
        break;
        case R.id.navigation_search:
        Intent i2=new Intent(projectspage.this,search.class);
        Log.d("test","from project page befor go to like page");
        startActivity(i2);
        break;
        case R.id.navigation_profile:
        Intent i3=new Intent(projectspage.this,profile.class);
        Log.d("test","from project page befor go to profile page");
        startActivity(i3);
        break;
        }
        return false;
        }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        if (position == 6) {
                                Intent i = new Intent(view.getContext(), projectp2.class);
                                startActivityForResult(i, 6);
                        }
                        if (position == 0) {
                                Intent i = new Intent(view.getContext(), project2016.class);
                                startActivityForResult(i, 1);
                        }
                }
        }); }
        }

