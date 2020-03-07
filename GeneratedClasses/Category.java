package com.example.mymoney.db;

import android.os.Bundle;
import java.util.Date;

public class Category {

    public static final String COL__ID = "_id";
    public static final String COL_CATEGORYNAME = "categoryName";

    private Integer m_id;
    private String mcategoryName;

    public Category() {
    }

    public Category(Integer _id, String categoryName) {
        this.m_id = _id;
        this.mcategoryName = categoryName;
    }

    public Integer get_id() {
        return m_id;
    }

    public void set_id(Integer _id) {
        this.m_id = _id;
    }

    public String getcategoryName() {
        return mcategoryName;
    }

    public void setcategoryName(String categoryName) {
        this.mcategoryName = categoryName;
    }


    public Bundle toBundle() { 
        Bundle b = new Bundle();
        b.putInt(COL__ID, this.m_id);
        b.putString(COL_CATEGORYNAME, this.mcategoryName);
        return b;
    }

    public Category(Bundle b) {
        if (b != null) {
            this.m_id = b.getInt(COL__ID);
            this.mcategoryName = b.getString(COL_CATEGORYNAME);
        }
    }

    @Override
    public String toString() {
        return "Category{" +
            " m_id=" + m_id +
            ", mcategoryName='" + mcategoryName + '\'' +
            '}';
    }


}
