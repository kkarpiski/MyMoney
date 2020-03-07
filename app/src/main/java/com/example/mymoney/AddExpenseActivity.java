package com.example.mymoney;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mymoney.model.WydatekRecord;
import com.example.mymoney.model.WydatkiData;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;

/**
 * Formularz dodawania wydatków
 */

public class AddExpenseActivity extends AppCompatActivity {

    public static final String NOWY_WYDATEK = "Nowy wydatek";
    private EditText dateEditText;
    private EditText wydatekEditText;
    private EditText celWydatkuEditText;

    private Button przyciskZapisz;
    private WydatkiData wydatkiData;
    private DateFormat dateFormat;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_expense_layout);
        obtainExtras();
        viewInit();
        setTitle(NOWY_WYDATEK);


    }

    private void obtainExtras() {
        wydatkiData = (WydatkiData) getIntent().getExtras().getSerializable(MainMenuActivity.SPECIAL_DATA);
    }

    private void viewInit() {
        dateEditText = findViewById(R.id.data);
        wydatekEditText = findViewById(R.id.wydatek);
        celWydatkuEditText = findViewById(R.id.cel);
        dateEditText.setText(getCurrentDate());
        przyciskZapisz = findViewById(R.id.potwierdz);
        przyciskZapisz.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                Toast.makeText(AddExpenseActivity.this, getWydatek(), Toast.LENGTH_SHORT).show();
                WydatekRecord wydatek = new WydatekRecord(getDateEditTextDate(dateEditText), getWydatekEditText(wydatekEditText), getCelWydatek(celWydatkuEditText));
                wydatkiData.getWydatekRecord().add(wydatek);
            }
        });
    }

    private Date getDateEditTextDate(EditText dateEditText) {
        try {
            return dateFormat.parse(dateEditText.getText().toString());
        } catch (ParseException e)
        {
            e.printStackTrace();
        }
        //TODO dodać walidajce
        dateFormat = DateFormat.getDateInstance();
        Date date = new Date();
        return date;

    }

    private Double getWydatekEditText(EditText wydatekEditText) {
        return Double.valueOf(wydatekEditText.getText().toString());
    }

    private String getCelWydatek(EditText celWydatkuEditText) {
        return celWydatkuEditText.getText().toString();
    }

    private String getWydatek() {

        return String.valueOf(Integer.valueOf(String.valueOf(wydatekEditText.getText())));
    }

    private String getCurrentDate() {
        dateFormat = DateFormat.getDateInstance();
        Date date = new Date();

        return dateFormat.format(date);
    }
}
