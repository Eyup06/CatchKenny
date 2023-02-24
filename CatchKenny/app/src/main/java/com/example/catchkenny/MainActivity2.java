package com.example.catchkenny;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.Image;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity2 extends AppCompatActivity {

    TextView TextTime;
    TextView TextScore;
    ImageView imageView1,imageView2,imageView3,imageView4,imageView5,imageView6,imageView7,imageView8,imageView9;
    int score;
    ImageView[] ImageArray;
    Handler handler;
    Runnable runnable;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        TextTime = findViewById(R.id.TextTime);
        TextScore = findViewById(R.id.TextScore);
        imageView1 = findViewById(R.id.imageView1);
        imageView2 = findViewById(R.id.imageView2);
        imageView3 = findViewById(R.id.imageView3);
        imageView4 = findViewById(R.id.imageView4);
        imageView5 = findViewById(R.id.imageView5);
        imageView6 = findViewById(R.id.imageView6);
        imageView7 = findViewById(R.id.imageView7);
        imageView8 = findViewById(R.id.imageView8);
        imageView9 = findViewById(R.id.imageView9);

        ImageArray = new ImageView[]{imageView1,imageView2,imageView3,imageView4,imageView5,imageView6,imageView7,
        imageView8,imageView9};

        hideImages();

        score = 0;

        new CountDownTimer(10000,1000){

            @Override
            public void onTick(long millisUntilFinished) {
                TextTime.setText("Time: " + millisUntilFinished/1000);

            }

            @Override
            public void onFinish() {
                TextTime.setText("Time off");
                handler.removeCallbacks(runnable);


                for(ImageView image : ImageArray){
                    image.setVisibility(View.INVISIBLE);
                }

                AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity2.this);
                alert.setTitle("Restart?");
                alert.setMessage("Are you sure restart game?");
                alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        Intent intent = getIntent();
                        finish();
                        startActivity(intent);

                    }
                });

                alert.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity2.this, "Game Over", Toast.LENGTH_SHORT).show();
                    }
                });

                alert.show();





            }
        }.start();


    }

    public void backButton(View view){
        Intent intent = new Intent(MainActivity2.this,MainActivity.class);
        startActivity(intent);
    }

    public void CreaseScore(View view){

        MediaPlayer mediaPlayer = MediaPlayer.create(this,R.raw.mysound_player);
        mediaPlayer.start();



        score++;

        TextScore.setText("Score: " + score);

    }

    public  void hideImages(){

        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {

                for(ImageView image: ImageArray){
                    image.setVisibility(View.INVISIBLE);
                }


                    Random random = new Random();
                    int i = random.nextInt(9);
                    ImageArray[i].setVisibility(View.VISIBLE);

                    handler.postDelayed(this,450);



            }
        };

        handler.post(runnable);


    }
}