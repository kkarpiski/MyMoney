package com.example.mymoney;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.example.mymoney.model.AccountData;

import java.util.ArrayList;

/**
 *Okno dodania nowego konta
 */


    public class AddAccountActivity extends AppCompatActivity {

        public static final String ACCOUNT_DATA_NEW_ACCOUNT = "ACCOUNT_DATA_NEW_ACCOUNT";
        public static final String IS_NEW_ACCOUNT_MASTER_ACCOUNT = "IS_NEW_ACCOUNT_MASTER_ACCOUNT";

        private EditText wprowadzNazweEditText;
        private EditText wprowadzObecneSaldoEditText;
        private Switch masterAccountSwitch;
        private Button confirmButton;
        private Spinner currencySpinner;
        private ArrayAdapter arrayAdapter;


    @Override
        protected void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
           setContentView(R.layout.add_new_account_layout);

        initViews();

    }


    private void initViews() {
        wprowadzNazweEditText = (EditText) findViewById(R.id.wprowadzNazweEditText);
        wprowadzObecneSaldoEditText = (EditText) findViewById(R.id.wprowadzObecneSaldoEditText);
        currencySpinner = (Spinner) findViewById(R.id.currency_spinner);
        masterAccountSwitch = (Switch) findViewById(R.id.master_account_switch);
        confirmButton = (Button) findViewById(R.id.confirmAccountButton);

        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AccountData accountData = new AccountData(wprowadzNazweEditText.getText().toString(), wprowadzObecneSaldoEditText.getText().toString());
                Boolean isMasterAccount = masterAccountSwitch.isChecked();
                Intent intent = new Intent();
                intent.putExtra(ACCOUNT_DATA_NEW_ACCOUNT, accountData);
                intent.putExtra(IS_NEW_ACCOUNT_MASTER_ACCOUNT, isMasterAccount);
                setResult(Activity.RESULT_OK, intent);
                finish();

            }
        });
        String[] items = new String[]{"PLN", "EUR", "GBP", "USD"};
        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, items);
        currencySpinner.setAdapter(arrayAdapter);
    }

}