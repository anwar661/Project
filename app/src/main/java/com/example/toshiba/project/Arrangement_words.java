package com.example.toshiba.project;

import android.graphics.PixelFormat;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.VideoView;

public class Arrangement_words extends AppCompatActivity {
    Button clk;
    VideoView vi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arrangement_words);
         clk = (Button)findViewById(R.id.Watch);
        getWindow().setFormat(PixelFormat.UNKNOWN);
        vi = (VideoView)findViewById(R.id.videoView);

        String vidiop = "android.resource://com.example.toshiba.project/"+R.raw.order_words;
        Uri uri2 = Uri.parse(vidiop);
        vi.setVideoURI(uri2);
        vi.requestFocus();
        vi.start();
    vi.setOnClickListener(new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
            vi = (VideoView) findViewById(R.id.videoView);
// VideoView mVideoView = new VideoView(this);
            String uriPath = "android.resource://com.example.toshiba.project/"+R.raw.order_words;
            Uri uri2 = Uri.parse(uriPath);
            vi.setVideoURI(uri2);
            vi.requestFocus();
            vi.start();
        }
    });
}}
