package com.example.mymoney;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mymoney.model.CategoryData;

/**
 * Okno menu głownego
 */

public class MainMenuActivity extends AppCompatActivity {

    public static final String SPECIAL_DATA = "SPECIAL_DATA";
    public static final int REQUEST_CODE = 01;
    public static final int REQUEST_CODE2 = 02;
    private Button go_to_add_expense_button;
    private Button go_to_add_new_category_button;
    private Button go_to_my_accounts_button;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_menu_layout);

        go_to_add_new_category_button =(Button) findViewById(R.id.add_new_category_button);
        go_to_add_new_category_button.setOnClickListener(goToAddCategoryActivity());
        go_to_my_accounts_button = (Button) findViewById(R.id.go_to_my_accounts);
        go_to_my_accounts_button.setOnClickListener(goToAccountMenuActivity());
    }

    private View.OnClickListener goToAddCategoryActivity() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainMenuActivity.this, AddCategoryActivity.class);
                startActivityForResult(intent, REQUEST_CODE);
            }
        };
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE) {
            if (resultCode == Activity.RESULT_OK) {
                if (data != null) {
                    CategoryData newCategoryDate = (CategoryData) data.getExtras().get(AddCategoryActivity.CATEGORY_DATA_NEW_CATEGORY);
                }
            }
        }
    }

    private View.OnClickListener goToAccountMenuActivity(){
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainMenuActivity.this, AccountMenuActivity.class);
                startActivityForResult(intent, REQUEST_CODE2);
            }
        };
    }


}
