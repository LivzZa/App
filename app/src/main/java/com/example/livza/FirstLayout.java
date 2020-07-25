package com.example.livza;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class FirstLayout extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_layout);
        ConstraintLayout L=findViewById(R.id.Layout);
        Animation iconAnimation=
        Timer time=new Timer();
        time.schedule(new TimerTask() {
            @Override
            public void run() {
                Intent m=new Intent(FirstLayout.this, SignUp.class);
                startActivity(m);
                finish();
            }

        },2500);

    }


}
