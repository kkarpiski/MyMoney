package com.example.mymoney;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * Okno menu głownego
 */

public class MainMenuActivity extends AppCompatActivity {

    private Button dodanie_wydatku_przez_przycisk;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_menu_leyout);
        dodanie_wydatku_przez_przycisk = findViewById(R.id.dodanie_wydatku_przez_przycisk);

        dodanie_wydatku_przez_przycisk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                startActivity(new Intent(MainMenuActivity.this, AddExpenseActivity.class));
            }
        });
    }
}
