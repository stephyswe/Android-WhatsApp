package com.stephanie.whatsapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class RegisterActivity extends AppCompatActivity {

    private Button CreateAccountButton;
    private EditText UserEMail, UserPassword;
    private TextView AlreadyHaveAccountLink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        initializeFields();

        AlreadyHaveAccountLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SendUserToLoginActivity();

            }
        });
    }

    private void initializeFields() {
        CreateAccountButton = findViewById(R.id.register_button);
        UserEMail = findViewById(R.id.register_email);
        UserPassword = findViewById(R.id.register_password);
        AlreadyHaveAccountLink = findViewById(R.id.already_have_account_link);
    }

    private void SendUserToLoginActivity() {
        Intent loginIntent = new Intent(RegisterActivity.this, LoginActivity.class);
        startActivity(loginIntent);
    }
}
