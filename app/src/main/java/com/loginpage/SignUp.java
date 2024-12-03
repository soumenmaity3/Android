package com.loginpage;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.*;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SignUp extends AppCompatActivity {
TextView txtLogIn,forRed,forred2;
EditText signUpnPass,signUpPass;
String password,password2;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        txtLogIn=findViewById(R.id.logIn);
        forRed=findViewById(R.id.forRed);
        forred2=findViewById(R.id.forRed2);
        signUpPass=findViewById(R.id.signUpPass);
        txtLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(SignUp.this, MainActivity.class);
                startActivity(intent);
                overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
                finish();
            }
        });
        signUpnPass=findViewById(R.id.signUpnPass);
        signUpnPass.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // Not needed
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // Called as the user types
                 password = signUpnPass.getText().toString().trim();
                int noLogPass = password.length();

                if (noLogPass < 10) {
                    forRed.setTextColor(Color.RED);
                    forRed.setText("Minimum password 10 characters");
                } else {
                    forRed.setTextColor(Color.BLACK);
                    forRed.setText("");
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                // Not needed
            }
        });
        signUpPass.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                password2 = signUpPass.getText().toString().trim();
                int noLogPass = password2.length();

                if (!password.equals(password2)) {
                    forred2.setTextColor(Color.RED);
                    forred2.setText("Password not match");
                } else {
                    forred2.setTextColor(Color.BLACK);
                    forred2.setText("");
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
}