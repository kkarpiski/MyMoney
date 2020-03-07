package com.example.mymoney.model;

import androidx.appcompat.app.AppCompatActivity;
import java.io.Serializable;
import java.util.List;

/**
 * Model danych kategorii
 */

public class CategoryData extends AppCompatActivity implements Serializable {
    /**
     * Kolekcja kategorii
     */
    private List<CategoryRecord> categoryRecord;
    private String bills;
    private String transport;
    private String shop;
    private String health;

    public CategoryData(String Bills) {
        this.bills = bills;
    }

    public List<CategoryRecord> getCategoryRecord() {
        return categoryRecord;
    }

    public void setCategoryRecord(List<CategoryRecord> categoryRecord) {
        this.categoryRecord = categoryRecord;
    }

    public String getBills() {
        return bills;
    }

    public void setBills(String bills) {
        bills = bills;
    }

    public String getTransport() {
        return transport;
    }

    public void setTransport(String transport) {
        transport = transport;
    }

    public String getShop() {
        return shop;
    }

    public void setShop(String shop) {
        shop = shop;
    }

    public String getHealth() {
        return health;
    }

    public void setHealth(String health) {
        health = health;
    }


}
