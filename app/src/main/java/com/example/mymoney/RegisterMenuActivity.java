package com.example.mymoney;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mymoney.db.DatabaseHelper;

public class RegisterMenuActivity extends AppCompatActivity {
    DatabaseHelper db;
    EditText email, password, confirm_password;
    Button register_Button;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_menu_layout);
        db = new DatabaseHelper(this);
        email = findViewById(R.id.emailReg_EditText);
        password = findViewById(R.id.passwordReg_EditText);
        confirm_password = findViewById(R.id.confirm_passwordReg_EditText);
        register_Button = findViewById(R.id.register_Button);

        register_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s_email = email.getText().toString();
                String s_password = password.getText().toString();
                String s_confirm_password = confirm_password.getText().toString();

                if(s_email.equals("") || s_password.equals("") || s_confirm_password.equals("")){
                    Toast.makeText(getApplicationContext(), "Fields are empty", Toast.LENGTH_SHORT).show();
                }
                else {
                    if(s_password.equals(s_confirm_password)){
                        boolean checkEmail = db.checkEmail(s_email);
                        if(checkEmail){
                            boolean insert = db.insert(s_email, s_password);
                            if(insert){
                                Toast.makeText(getApplicationContext(), "Registered succesfully", Toast.LENGTH_SHORT).show();
                                setContentView(R.layout.login_menu_layout);
                            }
                        }
                        else {
                            Toast.makeText(getApplicationContext(), "Email already exists", Toast.LENGTH_SHORT).show();
                        }
                    }
                    Toast.makeText(getApplicationContext(), " Password do not match", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
