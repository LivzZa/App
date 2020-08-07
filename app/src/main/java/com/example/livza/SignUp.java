package com.example.livza;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.FirebaseException;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.concurrent.TimeUnit;

public class SignUp extends AppCompatActivity {
    EditText UserName,PhoneNumber;
    String username,phonenumer;
    private DatabaseReference mReference;
    PhoneAuthProvider.OnVerificationStateChangedCallbacks  mcall;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up);
       FirebaseDatabase  m=FirebaseDatabase.getInstance();
        mReference= m.getReference();
        //Username to our database
        UserName=findViewById(R.id.UserName);


        //Phone number to our database
        PhoneNumber=findViewById(R.id.PhoneNumbr);



        final TextView Signupbtn=findViewById(R.id.btn_sign_up);
        Signupbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               username=UserName.getText().toString();
                phonenumer=PhoneNumber.getText().toString().substring(1);

            PhoneAuthProvider.getInstance().verifyPhoneNumber(
                        "+213"+phonenumer,        // Phone number to verify
                        120,                 // Timeout duration
                        TimeUnit.SECONDS,   // Unit of timeout
                        SignUp.this,               // Activity (for callback binding)
                        mcall          // OnVerificationStateChangedCallbacks
                );




            }
        });
        mcall=new PhoneAuthProvider.OnVerificationStateChangedCallbacks(){
            @Override
            public void onCodeAutoRetrievalTimeOut(String s) {
                super.onCodeAutoRetrievalTimeOut(s);
                Toast.makeText(SignUp.this,"Failed",Toast.LENGTH_LONG).show();
            }

            public void onVerificationFailed(FirebaseException e) {
                Toast.makeText(SignUp.this,"FAILED",Toast.LENGTH_LONG).show();
            }

            @Override
            public void onVerificationCompleted(PhoneAuthCredential phoneAuthCredential) {
                Toast.makeText(SignUp.this,"Completed",Toast.LENGTH_LONG).show();
            Intent i = new Intent(SignUp.this,MenuLivza.class);
            startActivity(i);
            }

            @Override
            public void onCodeSent(String s, PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                Toast.makeText(SignUp.this,"On code sent",Toast.LENGTH_LONG).show();
                super.onCodeSent(s, forceResendingToken);


                Intent i= new Intent(SignUp.this,ConfirmationCode.class);

                i.putExtra("code",s);

                i.putExtra("phone",phonenumer);

                startActivity(i);
            }
        };


        //Login if not *Intent to logine layout******
        TextView Login=findViewById(R.id.Login);
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
// GO TO LOGIN
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
    private  void saveData(FirebaseUser currentuser){
        String userid=currentuser.getUid();
        DatabaseReference ref= mReference.child("users").child(userid);
        ref.child(username).setValue("+213"+phonenumer);
    }
}
