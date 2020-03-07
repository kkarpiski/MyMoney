package com.example.mymoney;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mymoney.db.DatabaseHelper;

public class LoginMenuActivity extends AppCompatActivity {
    DatabaseHelper db;
    EditText email, password;
    Button login, register;



    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_menu_layout);

        db = new DatabaseHelper(this);
        email = findViewById(R.id.email_login_EditText);
        password = findViewById(R.id.password_login_EditText);
        login = findViewById(R.id.login_Button);
        register = findViewById(R.id.register_login_new_user_Button);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LoginMenuActivity.this, RegisterMenuActivity.class);
                startActivity(i);
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emailLogin = email.getText().toString();
                String passwordLogin = password.getText().toString();
                Boolean CheckEmailPassword = db.emailPassword(emailLogin, passwordLogin);
                if (CheckEmailPassword == true) {
                    Toast.makeText(getApplicationContext(), "Successfully login", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(LoginMenuActivity.this, MainMenuActivity.class);
                    startActivity(i);

                } else {
                    Toast.makeText(getApplicationContext(), "Wrong email or password", Toast.LENGTH_SHORT).show();
                }
            }
        });




    }
}
