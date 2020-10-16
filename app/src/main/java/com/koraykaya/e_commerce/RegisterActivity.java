package com.koraykaya.e_commerce;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity {
    private EditText mName ;
    private EditText mEmail ;
    private EditText mPassword ;
    private Button mRegBtn;
    private FirebaseAuth mAuth ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        mName = findViewById(R.id.reg_name);
        mEmail=findViewById(R.id.reg_email);
        mPassword = findViewById(R.id.reg_pass);
        mRegBtn = findViewById(R.id.reg_button);
        mAuth = FirebaseAuth.getInstance();

        mRegBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = mName.getText().toString();
                String email = mEmail.getText().toString();
                String password = mPassword.getText().toString();

                if(!name.isEmpty() && !email.isEmpty() && !password.isEmpty()) {
                    mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                Toast.makeText(RegisterActivity.this,"Account succesfully created",Toast.LENGTH_LONG).show();
                                Intent intent  = new Intent(RegisterActivity.this,HomeActivity.class);
                                startActivity(intent);
                            }else {
                                Toast.makeText(RegisterActivity.this,""+task.getException(),Toast.LENGTH_LONG).show();
                            }
                        }
                    });
                }else {
                    Toast.makeText(RegisterActivity.this,"Please fill empty fields",Toast.LENGTH_LONG).show();
                }
            }
        });

    }

    public void signIn(View view) {
        Intent intent = new Intent(RegisterActivity.this,LoginActivity.class);
        startActivity(intent);
    }
}