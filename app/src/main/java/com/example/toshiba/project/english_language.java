package com.example.toshiba.project;

import android.graphics.PixelFormat;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.VideoView;

public class english_language extends AppCompatActivity {
    Button clk;
    VideoView vi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_english_language);
        clk = (Button) findViewById(R.id.Watch);
        getWindow().setFormat(PixelFormat.UNKNOWN);
        vi = (VideoView) findViewById(R.id.videoView);
    }public void videoplay(View view){
        String vidiop = "android.resource://com.example.toshiba.project/"+R.raw.development_of_the_english_language;
        Uri uri2 = Uri.parse(vidiop);
        vi.setVideoURI(uri2);
        vi.requestFocus();
        vi.start();

    }}
