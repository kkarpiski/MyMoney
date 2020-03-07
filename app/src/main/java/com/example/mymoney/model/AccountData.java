package com.example.mymoney.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Model danych konta
 */

public class AccountData implements Serializable {

    /**
     * Kolekcja konta
     */
    private List<AccountRecord> accountRecord ;
    private String konto;
    private String saldo;


    public List<AccountRecord> getAccountRecord() {
        return accountRecord;
    }

    public void setAccountRecord(List<AccountRecord> accountRecord) {
        this.accountRecord = accountRecord;
    }

    public String getKonto() {
        return konto;
    }

    public void setKonto(String konto) {
        this.konto = konto;
    }

    public String getSaldo() {
        return saldo;
    }

    public void setSaldo(String saldo) {
        this.saldo = saldo;
    }

    public AccountData(String konto, String saldo) {
        this.konto = konto;
        this.saldo = saldo;

        accountRecord = new ArrayList<>();
    }


}
