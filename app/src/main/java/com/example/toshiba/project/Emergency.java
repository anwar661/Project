package com.example.toshiba.project;

import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Emergency extends AppCompatActivity {
    private boolean paused = true;
    ImageButton button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emergency);
        button=(ImageButton)findViewById(R.id.share);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                String shareBody="Your body here";
                String shareSub="Your Subject here";
                intent.putExtra(Intent.EXTRA_SUBJECT,shareSub);
                intent.putExtra(Intent.EXTRA_TEXT,shareBody);
                startActivity(Intent.createChooser(intent,"Share using"));
            }
        });
    }public void liking(View view) {


        button = (ImageButton) view;
        int icon=R.drawable.ic_favorite_border_black_24dp;

        if (paused) {
            paused = false;
            icon = R.drawable.ic_favorite_border_black_24dp;}
        else {
            paused = true;
            icon = R.drawable.heatr_check;
        }

        button.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), icon));


    }public void SendText(View view){

        try {

            // open myfilename.txt for writing
            OutputStreamWriter out=new OutputStreamWriter(openFileOutput("myfilename.txt",MODE_APPEND));
            // write the contents to the file

            EditText ET = (EditText)findViewById(R.id.writecom);
            String text = ET.getText().toString();
            out.write(text);
            out.write('\n');

            // close the file

            out.close();


        }

        catch (java.io.IOException e) {

            //do something if an IOException occurs.
            Toast.makeText(this,"Sorry Text could't be added",Toast.LENGTH_LONG).show();


        }



        StringBuilder text = new StringBuilder();


        try {
            // open the file for reading we have to surround it with a try

            InputStream instream = openFileInput("myfilename.txt");//open the text file for reading

            // if file the available for reading
            if (instream != null) {

                // prepare the file for reading
                InputStreamReader inputreader = new InputStreamReader(instream);
                BufferedReader buffreader = new BufferedReader(inputreader);

                String line=null;
                //We initialize a string "line"

                while (( line = buffreader.readLine()) != null) {
                    //buffered reader reads only one line at a time, hence we give a while loop to read all till the text is null

                    text.append(line);
                    text.append('\n');    //to display the text in text line


                }}}

        //now we have to surround it with a catch statement for exceptions
        catch (IOException e) {
            e.printStackTrace();
        }

        //now we assign the text readed to the textview
        TextView tv = (TextView)findViewById(R.id.comments);
        tv.setText(text);

    }  public void readMore1(View V){

        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
        finish();


    }public void Backto(View V) {

        Intent i = new Intent(this, projectp2.class);
        startActivity(i);
        finish();
    }
}

