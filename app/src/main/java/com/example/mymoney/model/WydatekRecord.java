package com.example.mymoney.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Model danych pojedyńczej transakcji
 */

public class WydatekRecord implements Serializable {
    /**
     * Data wydatku
     */
    private Date wydatekData;
    /**
     * Kwota wydatku
     */
    private Double wydatekKwotaPLN;
    /**
     * Cel Wydatku, kategoria
     */
    private String wydatekCel;

    public WydatekRecord(Date wydatekData, Double wydatekKwotaPLN, String wydatekCel) {
        this.wydatekData = wydatekData;
        this.wydatekKwotaPLN = wydatekKwotaPLN;
        this.wydatekCel = wydatekCel;
    }

    public Date getWydatekData() {
        return wydatekData;
    }

    public void setWydatekData(Date wydatekData) {
        this.wydatekData = wydatekData;
    }

    public Double getWydatekKwotaPLN() {
        return wydatekKwotaPLN;
    }

    public void setWydatekKwotaPLN(Double wydatekKwotaPLN) {
        this.wydatekKwotaPLN = wydatekKwotaPLN;
    }

    public String getWydatekCel() {
        return wydatekCel;
    }

    public void setWydatekCel(String wydatekCel) {
        this.wydatekCel = wydatekCel;
    }
}
