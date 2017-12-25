package com.example.toshiba.project;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
public class profile extends AppCompatActivity {
    private BottomNavigationView.OnNavigationItemSelectedListener
            mOnNavigationItemSelectedListener;
    BottomNavigationView btmnav;
    SharedPreferences sh;
    private static final int pick=1,capture=2;
    Uri imgeUri;
    ImageView imp,settingimg;
    TextView nameprofile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        Log.d("test","profile page");
        sh=getSharedPreferences(registration.MyPREFERENCES, Context.MODE_PRIVATE);
        nameprofile=(TextView) findViewById(R.id.nameprofile);
        nameprofile.setText(sh.getString("name",null));
        imp=(ImageView)findViewById(R.id.profile_image);
        //fragment_account faccount=new fragment_account();
        //getSupportFragmentManager().beginTransaction().replace(R.id.content,faccount).commit();
        btmnav=(BottomNavigationView)findViewById(R.id.navigation);
        Log.d("test","project4");
        Menu menu=btmnav.getMenu();
        MenuItem menuItem=menu.getItem(2);
        menuItem.setChecked(true);
        btmnav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener(){
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Log.d("test","project5");
                switch (item.getItemId()) {
                    case R.id.navigation_project:
                        Intent i1=new Intent(profile.this,projectspage.class);
                        startActivity(i1);
                        Log.d("test","from project page in navigation main");
                        break;
                    case R.id.navigation_search:
                        Intent i2=new Intent(profile.this,search.class);
                        Log.d("test","from project page befor go to like page");
                        startActivity(i2);
                        break;
                    case R.id.navigation_profile:
                        // Intent i3=new Intent(profile.this,profile.class);
                        Log.d("test","from project page befor go to profile page");
                        // startActivity(i3);
                        break;
                }
                return false;
            }
        });
    }
    public void changepic(View V){
        final String[] items = {"Take picture","Choose Picture","cancle"};
        AlertDialog.Builder build = new AlertDialog.Builder(this);
        build.setTitle("Add Photo");
        build.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if(items[which].equals("Choose Picture")) {
                    //way1
                    Intent i = new Intent(Intent.ACTION_PICK);
                    i.setType("image/*");
                    //way2
                    //Intent i = new Intent(Intent.ACTION_PICK,MediaStore.Images.Media.INTERNAL_CONTENT_URI);
                    startActivityForResult(i, pick);
                }
                else if (items[which].equals("Take picture")){
                    Intent i=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivityForResult(i, capture);
                }
            }}).create().show();
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        if(requestCode==pick&&resultCode==RESULT_OK){
            // imgeUri=Uri.parse("android.resource://my.package.name/"+R.drawable.phot);
            imgeUri=data.getData();
            imp.setImageURI(imgeUri);
        }
        else if(requestCode==capture&&resultCode==RESULT_OK){
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            imp.setImageBitmap(imageBitmap);
        }
    }
    public void goto_setting_page(View V){
        settingimg=(ImageView)findViewById(R.id.settingimage);
        Intent i=new Intent(getApplicationContext(),setting.class);
         startActivityForResult(i,1);
    }
}