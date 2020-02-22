package com.example.mymoney;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.text.DateFormat;
import java.util.Date;

public class AddExpenseActivity extends AppCompatActivity {

    private EditText dateEditText;
    private EditText wydatekEditText;
    private EditText celWydatkuEditText;

    private Button przyciskZapisz;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_expense_layout);
        dateEditText = findViewById(R.id.data);
        wydatekEditText = findViewById(R.id.wydatek);
        celWydatkuEditText = findViewById(R.id.cel);

        dateEditText.setText(getCurrentDate());

        przyciskZapisz = findViewById(R.id.potwierdz);
        przyciskZapisz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(AddExpenseActivity.this, getWydatek(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private String getWydatek() {

        return String.valueOf(Integer.valueOf(String.valueOf(wydatekEditText.getText())));
    }

    private String getCurrentDate() {
        DateFormat dateFormat = DateFormat.getDateInstance();
        Date date = new Date();

        return dateFormat.format(date);
    }
}
