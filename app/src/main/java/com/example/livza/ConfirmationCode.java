package com.example.livza;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

public class ConfirmationCode extends AppCompatActivity {
    TextView button;
    EditText editText;
    String code,phonenumber;
    private FirebaseAuth mAuth;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmation_code);

        editText=findViewById(R.id.editText2);

        mAuth= FirebaseAuth.getInstance();
        code=getIntent().getExtras().getString("code");

        phonenumber=getIntent().getExtras().getString("phone");
        Toast.makeText(this,phonenumber,Toast.LENGTH_LONG).show();
       button=findViewById(R.id.textView2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PhoneAuthCredential credential = PhoneAuthProvider.getCredential(code, editText.getText().toString());

                signInWithPhoneAuthCredential(credential);
            }
        });

    } private void signInWithPhoneAuthCredential(PhoneAuthCredential credential) {
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(ConfirmationCode.this,"Succesful",Toast.LENGTH_LONG).show();
                            // Sign in success, update UI with the signed-in user's information
                            Intent intent =new Intent(ConfirmationCode.this,MenuLivza.class);

                            FirebaseUser user = task.getResult().getUser();
                            // ...
                        } else {
                            Toast.makeText(ConfirmationCode.this,"Failed",Toast.LENGTH_LONG).show();
                            // Sign in failed, display a message and update the UI

                            
                        }
                    }


                });
    }
}
