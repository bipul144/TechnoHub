package com.example.technohub;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.shashank.sony.fancytoastlib.FancyToast;

public class SignUpActivity extends AppCompatActivity {
      Button btnSignUp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        setTitle("Sign Up");
        btnSignUp = findViewById(R.id.btnSignUp);

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignUpActivity.this,MainActivity.class);
                startActivity(intent);
                Message("You are successfully Signed Up","S");
                Message("Please Log In Again","I");

            }
        });


    }


    public void Message(String Message ,String act){
        switch (act){
            case "S":
                FancyToast.makeText(SignUpActivity.this,Message, Toast.LENGTH_SHORT,FancyToast.SUCCESS,true).show();
                break;
            case "E":
                FancyToast.makeText(SignUpActivity.this,Message,Toast.LENGTH_SHORT,FancyToast.ERROR,true).show();
                break;
            case "I":
                FancyToast.makeText(SignUpActivity.this,Message,Toast.LENGTH_SHORT,FancyToast.INFO,true).show();
                break;
        }

    }

}


