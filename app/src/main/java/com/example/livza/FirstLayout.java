package com.example.livza;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import java.util.Timer;
import java.util.TimerTask;

public class FirstLayout extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_layout);
        ImageView L=findViewById(R.id.imageView5);

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
