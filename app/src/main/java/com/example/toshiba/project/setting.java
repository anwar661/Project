package com.example.toshiba.project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

public class setting extends AppCompatActivity {
    ListView listView;
    String s;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("go back");
        //Bundle b=null;
        //b=this.getIntent().getExtras();
        //s=b.getString("name");
        String [] settings_options={"\nAccount\n","\ncontact_us\n","\nlogout\n"};
        listView =(ListView)findViewById(R.id.listview);
        ArrayAdapter<String> array_Adapter=new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,
                settings_options);
        listView.setAdapter(array_Adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    Intent i = new Intent(view.getContext(), account.class);
                    startActivityForResult(i, 0);
                }
                else if (position == 1) {
                    Intent i = new Intent(view.getContext(), contact_us.class);
                    startActivityForResult(i, 1);
                }
                else if (position == 2) {
                    Intent i = new Intent(view.getContext(), login.class);
                    startActivityForResult(i, 2);
                }
            }
        });}public boolean onOptionsItemSelected(MenuItem item){
        int id=item.getItemId();
        if(id==android.R.id.home){
            //end the activity
            //Bundle b=new Bundle();
            // b.putString("name",s);
            // Intent i=new Intent(settings.this,profile.class);
            //i.putExtras(b);
            // startActivity(i);
            this.finish();
        }
        return super.onOptionsItemSelected(item);
    }}