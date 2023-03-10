package com.example.horizon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button signIn, createAcc;
    public static MediaPlayer mysong;
    public static AudioManager manager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);

        signIn = (Button) findViewById(R.id.signIn);
        createAcc = (Button) findViewById(R.id.create);
        mysong=MediaPlayer.create(MainActivity.this,R.raw.music);
        mysong.setLooping(true);
        manager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        playIT();

        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SignIn.class);
                startActivity(intent);
            }
        });

        createAcc.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CreateUser.class);
                startActivity(intent);
            }
        }));
    }

    public static void playIT(){
        mysong.start();
    }

    public void onPause(){
        super.onPause();
    }
}