package com.example.miniegyptnews.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.miniegyptnews.MainActivity;
import com.example.miniegyptnews.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SplashScreen extends AppCompatActivity {
    @BindView (R.id.imageView2) ImageView mLogo;
    ConstraintLayout descimage,desctxt;
    Animation uptodown,downtoup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        ButterKnife.bind(this);

//      THE CONTENTS ARE PUT INSIDE A LINEAR LAYOUT.
//      We reference the image and text using their id.
//      descimage = (R.id.titleimage)
//      desctxt = (R.id.titletxt)

        descimage =findViewById(R.id.titleimage);
        desctxt = findViewById(R.id.titletxt);
        uptodown = AnimationUtils.loadAnimation(this,R.anim.uptodown);
        downtoup = AnimationUtils.loadAnimation(this,R.anim.downtoup);
//      THIS ANIMATIONS ARE SET INSIDE THE (ANIM) FOLDER.
//      This initiaizes the animations.

//      //\\ NOTE! //\\
//      FOR THIS ANIMATION TO WORK CONTENTS MUST BE INSIDE LINEAR LAYOUT
//      CHECK...-> activity_splash_screen.xml for reference!
        descimage.setAnimation(downtoup);
        desctxt.setAnimation(uptodown);


        RotateAnimation rotate = new RotateAnimation(0, 720, Animation.RELATIVE_TO_SELF,0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        rotate.setDuration(3000);
        rotate.setInterpolator(new LinearInterpolator());
        mLogo.startAnimation(rotate);



        Thread myThread = new Thread(){
            @Override
            public void run(){
                try {
                    sleep(4000);
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                    finish();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        myThread.start();

    }


}

