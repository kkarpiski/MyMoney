package com.example.mymoney.db;

import android.os.Bundle;
import java.util.Date;

public class Expensescategories {

    public static final String COL__ID = "_id";
    public static final String COL_EXPENSENAME = "ExpenseName";

    private Integer m_id;
    private String mExpenseName;

    public Expensescategories() {
    }

    public Expensescategories(Integer _id, String ExpenseName) {
        this.m_id = _id;
        this.mExpenseName = ExpenseName;
    }

    public Integer get_id() {
        return m_id;
    }

    public void set_id(Integer _id) {
        this.m_id = _id;
    }

    public String getExpenseName() {
        return mExpenseName;
    }

    public void setExpenseName(String ExpenseName) {
        this.mExpenseName = ExpenseName;
    }


    public Bundle toBundle() { 
        Bundle b = new Bundle();
        b.putInt(COL__ID, this.m_id);
        b.putString(COL_EXPENSENAME, this.mExpenseName);
        return b;
    }

    public Expensescategories(Bundle b) {
        if (b != null) {
            this.m_id = b.getInt(COL__ID);
            this.mExpenseName = b.getString(COL_EXPENSENAME);
        }
    }

    @Override
    public String toString() {
        return "Expensescategories{" +
            " m_id=" + m_id +
            ", mExpenseName='" + mExpenseName + '\'' +
            '}';
    }


}
