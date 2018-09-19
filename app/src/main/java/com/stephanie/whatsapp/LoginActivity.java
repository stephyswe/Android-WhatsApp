package com.stephanie.whatsapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {

    private FirebaseUser currentUser;
    private Button LoginButton, PhoneLoginButton;
    private EditText UserEMail, UserPassword;
    private TextView NeedNewAccountLink, ForgetPasswordLink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initializeFields();

        NeedNewAccountLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SendUserToRegisterActivity();
            }
        });
    }

    private void initializeFields() {
        LoginButton = findViewById(R.id.login_button);
        PhoneLoginButton = findViewById(R.id.phone_login_button);
        UserEMail = findViewById(R.id.login_email);
        UserPassword = findViewById(R.id.login_password);
        NeedNewAccountLink = findViewById(R.id.need_new_account_link);
        ForgetPasswordLink = findViewById(R.id.forget_password_link);
    }


    @Override
    protected void onStart() {

        super.onStart();

        if (currentUser != null) {
            SendUserToMainActivity();
        }
    }

    private void SendUserToMainActivity() {
    Intent mainIntent = new Intent(LoginActivity.this, MainActivity.class);
    startActivity(mainIntent);
    }

    private void SendUserToRegisterActivity() {
        Intent registerIntent = new Intent(LoginActivity.this, RegisterActivity.class);
        startActivity(registerIntent);
    }
}
