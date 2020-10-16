package com.koraykaya.e_commerce;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private EditText mEmail;
    private  EditText mPass ;
    private Button mLoginBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mEmail = findViewById(R.id.log_email);
        mPass = findViewById(R.id.log_pass);
        mLoginBtn=findViewById(R.id.log_button);

        mLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = mEmail.getText().toString();
                String pass = mEmail.getText().toString();

                if(!email.isEmpty() && !pass.isEmpty()){

                }else {
                    Toast.makeText(LoginActivity.this,"Please fill empty places",Toast.LENGTH_LONG).show();
                }
            }
        });
    }


    public void signUp(View view) {
        Intent intent = new Intent(LoginActivity.this,RegisterActivity.class);
        startActivity(intent);
    }
}