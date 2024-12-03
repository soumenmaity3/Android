package com.loginpage;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.*;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
TextView txtSignIn,redText;
EditText logInPass;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtSignIn=findViewById(R.id.signUp);
        logInPass=findViewById(R.id.logInpass);
        redText=findViewById(R.id.logInRed);
        txtSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, SignUp.class);
                startActivity(intent);
                overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
                finish();
            }
        });
//        String password = logInPass.getText().toString();
////        int noLogPass = password.length();
////        if (noLogPass < 10) {
////            redText.setTextColor(Color.RED);
////            redText.setText("Minimum password 10 characters");  // Optional message
////        } else {
////            redText.setTextColor(Color.BLACK);
////            redText.setText("");  // Clear message
////        }
        logInPass.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // Not needed
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // Called as the user types
                String password = logInPass.getText().toString().trim();
                int noLogPass = password.length();

                if (noLogPass < 10) {
                    redText.setTextColor(Color.RED);
                    redText.setText("Minimum password 10 characters");
                } else {
                    redText.setTextColor(Color.BLACK);
                    redText.setText("");  // Clear the warning message
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                // Not needed
            }
        });


    }
}