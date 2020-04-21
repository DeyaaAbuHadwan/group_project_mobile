package com.example.group_project_mobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.group_project_mobile.MainScreen.secondscreen;

public class MainActivity extends AppCompatActivity {

    Animation animation,textanim,buttonanim;
    ImageView imageView;
    TextView textView;
    Button next,exit;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        animation= AnimationUtils.loadAnimation(this,R.anim.anim);
        textanim= AnimationUtils.loadAnimation(this,R.anim.textanim);
        buttonanim= AnimationUtils.loadAnimation(this,R.anim.buttonanim);



        imageView =findViewById(R.id.imageView);
        textView =findViewById(R.id.textView);
        next =findViewById(R.id.button);
        exit=findViewById(R.id.Exit);



        imageView.startAnimation(animation);
        textView.startAnimation(textanim);
        next.startAnimation(buttonanim);
        exit.setAnimation(buttonanim);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, secondscreen.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);

            }
        });


    }
    public void ExitSystem(View view) {
        System.exit(1);
    }



}
