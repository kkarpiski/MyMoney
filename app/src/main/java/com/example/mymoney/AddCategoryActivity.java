package com.example.mymoney;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;



public class AddCategoryActivity extends AppCompatActivity {

    public static final String CATEGORY_DATA_NEW_CATEGORY = "CATEGORY_DATA_NEW_CATEGORY";

    private EditText addCategoryEditText;
    private Button confirmCategoryButton;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_category_layout);

        confirmCategoryButton = (Button) findViewById(R.id.confirm_category);
        confirmCategoryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }
}
