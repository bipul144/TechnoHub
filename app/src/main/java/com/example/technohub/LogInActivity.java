package com.example.technohub;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
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
                Message("Please Enter Your E-mail ID");
            }
        });
        edtPasswordLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Message("Please Enter Your Valid Password");
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnLogin:
                if(edtEmailLogin.getText().toString().equals("")||edtPasswordLogin.getText().toString().equals("")){

                    FancyToast.makeText(LogInActivity.this," Please Fill All The Fields ", Toast.LENGTH_LONG,FancyToast.ERROR,true).show();


                }else{
                    final ProgressDialog progressDialog = new ProgressDialog(this);
                    progressDialog.setMessage("Logging In !!");
                    progressDialog.show();
                    ParseUser.logInInBackground(edtPasswordLogin.getText().toString(), edtPasswordLogin.getText().toString(), new LogInCallback() {
                        @Override
                        public void done(ParseUser user, ParseException e) {

                            if(user!= null && e==null){
                                FancyToast.makeText(LogInActivity.this,user.get("username")+" is Logged in", Toast.LENGTH_LONG,FancyToast.ERROR,true).show();

                            }else {
                                FancyToast.makeText(LogInActivity.this,e.getMessage(), Toast.LENGTH_LONG,FancyToast.ERROR,true).show();

                            }
                            progressDialog.dismiss();
                        }

                    });

                }
                break;

            case R.id.txtLinkToSignup:




                break;
        }

    }

   public void Message(String Message){
        FancyToast.makeText(LogInActivity.this,Message,Toast.LENGTH_SHORT,FancyToast.INFO,true).show();
   }



}




