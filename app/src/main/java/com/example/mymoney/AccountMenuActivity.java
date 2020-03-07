package com.example.mymoney;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class AccountMenuActivity extends AppCompatActivity {

    public static final int REQUEST_CODE = 02;
    private Button go_to_add_account_button;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.account_menu_layout);

        go_to_add_account_button = (Button) findViewById(R.id.go_to_add_account_button);
        go_to_add_account_button.setOnClickListener(goToAddAccountActivity());

    }
    private View.OnClickListener goToAddAccountActivity() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AccountMenuActivity.this, AddAccountActivity.class);
                startActivityForResult(intent, REQUEST_CODE);
            }
        };
    }

}
