package com.example.technohub;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.shashank.sony.fancytoastlib.FancyToast;

public class LogInActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText edtEmailLogin,edtPasswordLogin;
    private Button btnLogin;
    private TextView txtLinkToSignup;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        edtEmailLogin = findViewById(R.id.edtEmailLogin);
        edtPasswordLogin = findViewById(R.id.edtPasswordLogin);
        btnLogin = findViewById(R.id.btnLogin);
        txtLinkToSignup = findViewById(R.id.txtLinkToSignup);

        btnLogin.setOnClickListener(this);
        txtLinkToSignup.setOnClickListener(this);

        edtEmailLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Message("Please Enter Your E-mail ID","I");
            }
        });
        edtPasswordLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Message("Please Enter Your Valid Password","I");
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnLogin:
                if(edtEmailLogin.getText().toString().equals("")||edtPasswordLogin.getText().toString().equals("")){

                    Message("Please Enter All The Fields Properly","E");


                }else{
                    final ProgressDialog progressDialog = new ProgressDialog(this);
                    progressDialog.setMessage("Logging In !!");
                    progressDialog.show();
                    ParseUser.logInInBackground(edtEmailLogin.getText().toString(), edtPasswordLogin.getText().toString(), new LogInCallback() {
                        @Override
                        public void done(ParseUser user, ParseException e) {

                            if(user!= null && e==null){
                                FancyToast.makeText(LogInActivity.this,user.get("username")+" is Logged in", Toast.LENGTH_LONG,FancyToast.ERROR,true).show();

                            }else {
                                Message(e.getMessage(),"E");

                            }
                            progressDialog.dismiss();
                        }

                    });

                }
                break;

            case R.id.txtLinkToSignup:

                Message("Lets go and Sign Up First :)","I");
                Intent intent = new Intent(LogInActivity.this,SignUpActivity.class);
                startActivity(intent);



                break;
        }

    }

   public void Message(String Message ,String act){
        switch (act){
            case "S":
                FancyToast.makeText(LogInActivity.this,Message,Toast.LENGTH_SHORT,FancyToast.SUCCESS,true).show();
                break;
            case "E":
                FancyToast.makeText(LogInActivity.this,Message,Toast.LENGTH_SHORT,FancyToast.ERROR,true).show();
                break;
            case "I":
                FancyToast.makeText(LogInActivity.this,Message,Toast.LENGTH_SHORT,FancyToast.INFO,true).show();
                break;
        }

   }



}




