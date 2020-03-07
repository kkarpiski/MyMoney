package com.example.mymoney.model;


import java.io.Serializable;
/**
 * Model dodania danych pojedyńczej kategorii
 */

public class CategoryRecord implements Serializable {
    /**
     * Nazwa kategorii
     */
    private String nazwaKategorii;

    public CategoryRecord(String nazwaKategorii) {

        this.nazwaKategorii = nazwaKategorii;
    }
    public String getNazwaKategorii() {
        return nazwaKategorii;
    }

    public void setNazwaKategorii(String nazwaKategorii) {
        this.nazwaKategorii = nazwaKategorii;
    }


}
