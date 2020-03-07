package com.example.mymoney.db;

import java.util.ArrayList;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;

public class ExpensescategoriesDao extends DbManager {
    private static final String TAG = "ExpensescategoriesDao";

    protected static SQLiteDatabase database;
    protected static DbManager mDbManager;
    protected static  String[] allColumns = DbSchema.Table_Expensescategories.allColumns;


    protected ExpensescategoriesDao() {
    }

    protected static void database_open() throws SQLException {
        mDbManager = DbManager.getsInstance();
        database = mDbManager.getDatabase();
    }

    protected static void database_close() {
        mDbManager = DbManager.getsInstance();
        mDbManager.close();
    }

    public static Expensescategories loadRecordById(int m_id)  { 
        database_open();
        Cursor cursor = database.query(DbSchema.Table_Expensescategories.TABLE_NAME,allColumns,  "_id = ?" , new String[] { String.valueOf(m_id) } , null, null, null,null);

        if (cursor != null)
            cursor.moveToFirst();

        Expensescategories expensescategories = new Expensescategories();
        expensescategories = cursorToExpensescategories(cursor);

        cursor.close();
        database_close();

        return expensescategories;
    }

    public static ArrayList<Expensescategories> loadAllRecords() {
        ArrayList<Expensescategories> expensescategoriesList = new ArrayList<Expensescategories>();
        database_open();

        Cursor cursor = database.query(
                DbSchema.Table_Expensescategories.TABLE_NAME,
                allColumns,
                null,
                null,
                null,
                null,
                null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Expensescategories expensescategories = cursorToExpensescategories(cursor);
            expensescategoriesList.add(expensescategories);
            cursor.moveToNext();
        }
        cursor.close();
        database_close();
        return expensescategoriesList;
    }

    // Please always use the typed column names (Table_Expensescategories) when passing arguments.
    // Example: Table_Expensescategories.Column_Name
    public static ArrayList<Expensescategories> loadAllRecords(String selection, String[] selectionArgs, String groupBy, String having, String orderBy) {
        ArrayList<Expensescategories> expensescategoriesList = new ArrayList<Expensescategories>();
        database_open();

        if(TextUtils.isEmpty(selection)){
            selection = null;
            selectionArgs = null;
        }

        Cursor cursor = database.query(
                DbSchema.Table_Expensescategories.TABLE_NAME,
                allColumns,
                selection==null ? null : selection,
                selectionArgs==null ? null : selectionArgs,
                groupBy==null ? null : groupBy,
                having==null ? null : having,
                orderBy==null ? null : orderBy);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Expensescategories expensescategories = cursorToExpensescategories(cursor);
            expensescategoriesList.add(expensescategories);
            cursor.moveToNext();
        }
        cursor.close();
        database_close();
        return expensescategoriesList;
    }

    public static long insertRecord(Expensescategories expensescategories) {
        ContentValues values = new ContentValues();
        values = getExpensescategoriesValues(expensescategories);
        database_open();
        long insertId = database.insert(DbSchema.Table_Expensescategories.TABLE_NAME , null, values);
        database_close();
        return insertId;
    }

    public static int updateRecord(Expensescategories expensescategories) { 
        ContentValues values = new ContentValues();
        values = getExpensescategoriesValues(expensescategories);
        database_open();
        String[] where = new String[] { String.valueOf(expensescategories.get_id()) }; 
        int updatedId = database.update(DbSchema.Table_Expensescategories.TABLE_NAME , values, DbSchema.Table_Expensescategories.COL__ID + " = ? ",where );
        database_close();
        return updatedId;
    }

    public static int deleteRecord(Expensescategories expensescategories) { 
        database_open();
        String[] where = new String[] { String.valueOf(expensescategories.get_id()) }; 
        int deletedCount = database.delete(DbSchema.Table_Expensescategories.TABLE_NAME , DbSchema.Table_Expensescategories.COL__ID + " = ? ",where );
        database_close();
        return deletedCount;
    }

    public static int deleteRecord(String id) {
        database_open();
        String[] where = new String[] { id }; 
        int deletedCount = database.delete(DbSchema.Table_Expensescategories.TABLE_NAME , DbSchema.Table_Expensescategories.COL__ID + " = ? ",where );
        database_close();
        return deletedCount;
    }

    public static int deleteAllRecords() {
        database_open();
        int deletedCount = database.delete(DbSchema.Table_Expensescategories.TABLE_NAME , null, null );
        database_close();
        return deletedCount;
    }

    protected static ContentValues getExpensescategoriesValues(Expensescategories expensescategories) {
        ContentValues values = new ContentValues();

        values.put(DbSchema.Table_Expensescategories.COL__ID, expensescategories.get_id());
        values.put(DbSchema.Table_Expensescategories.COL_EXPENSENAME, expensescategories.getExpenseName());

        return values;
    }

    protected static Expensescategories cursorToExpensescategories(Cursor cursor)  {
        Expensescategories expensescategories = new Expensescategories();

        expensescategories.set_id(cursor.getInt(cursor.getColumnIndex(DbSchema.Table_Expensescategories.COL__ID)));
        expensescategories.setExpenseName(cursor.getString(cursor.getColumnIndex(DbSchema.Table_Expensescategories.COL_EXPENSENAME)));

        return expensescategories;
    }

    

}

