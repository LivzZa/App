package com.example.livza;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class SignUp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up);

        //Username to our database
        EditText UserName=findViewById(R.id.UserName);
        UserName.getText();

        //Phone number to our database
        EditText PhoneNumber=findViewById(R.id.PhoneNumbr);
        PhoneNumber.getText();

        //signeUp
        TextView Signupbtn=findViewById(R.id.btn_sign_up);
        Signupbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Confirme=new Intent(SignUp.this, ConfirmationCode.class);

            }
        });


        //Login if not *Intent to logine layout******
        TextView Login=findViewById(R.id.Login);
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


        ImageView Icon=findViewById(R.id.icon);
        Icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pass=new Intent(SignUp.this, MenuLivza.class);
                startActivity(pass);
            }
        });
    }
}
