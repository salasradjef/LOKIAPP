package com.loki.lokiapp;

import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    MediaPlayer mediaPlayer;




    public void select(View view){
        textView = (TextView) findViewById(R.id.textView);
        mediaPlayer = MediaPlayer.create(this,R.raw.audio);
        int time = 900;
        int ms = time * 1000;
        new CountDownTimer(ms, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                long nb_m = (((millisUntilFinished / 1000) % 86400 ) % 3600 ) / 60;
                long nb_s = (((millisUntilFinished / 1000) % 86400 ) % 3600 ) % 60  ;

                textView.setText(String.valueOf(nb_m) + ":" + String.valueOf(nb_s));
            }

            @Override
            public void onFinish() {
                textView.setText("Le repas de loki est pret !");
                mediaPlayer.start();

            }
        }.start();

    }

    public void stop(View view){
        mediaPlayer.stop();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }
}
