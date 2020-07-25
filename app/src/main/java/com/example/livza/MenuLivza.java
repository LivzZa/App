package com.example.livza;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MenuLivza extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_livza);

        //hadi tea btn de retoure
        Button Backbtn=findViewById(R.id.btnback);
        Backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent m=new Intent(MenuLivza.this, SignUp.class);
            }
        });

        //btnShop
        ImageView Shop=findViewById(R.id.Shop);
        Shop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
       //btnProfile
        ImageView profile=findViewById(R.id.Pofile);
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        //hadi tea serch ki yhb yhaws ela kach pla wla ....
        EditText Serch=findViewById(R.id.serch);
        Serch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        //_______________hadi teaa Chesse ki y3abez ela  Chesse yediih l layout whdokher fih les types tea les Chesse_________________
         ConstraintLayout Chesse=findViewById(R.id.ChesseLayout);
         Chesse.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {

             }
         });
        //zeama ychro haba yb9awlo 6 habat zeama
        TextView ChesseDespo=findViewById(R.id.CheeseDespo);
        ChesseDespo.setText("06 ");

        ConstraintLayout Sandwiches=findViewById(R.id.SandwicheLayot);
        Sandwiches.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        TextView SandwichesDespo=findViewById(R.id.SandwichesDespo);
        SandwichesDespo.setText("02");
    }

}
