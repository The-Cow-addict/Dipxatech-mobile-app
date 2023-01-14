package com.dipxa.dipxatechnology;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class DataBaseHelper extends SQLiteOpenHelper {
    public static final String USER_TABLE = "USER_TABLE";
    public static final String USER_NAME = "USER_NAME";
    public static final String COLUMN_ID = "ID";
    public static final String COLUMN_USER_NAME = USER_NAME;
    public static final String COLUMN_USER_EMAIL = "USER_EMAIL";
    public static final String COLUMN_USER_PASSWORD = "USER_PASSWORD";
    public static final String COLUMN_USER_PASSWORD_CONFIRM = "USER_PASSWORD_CONFIRM";
    public List<RegisterActivity> getUsername;

    public DataBaseHelper(@Nullable Context context) {
        super(context, "customer.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String dropTable = "DROP TABLE " + USER_TABLE;
        sqLiteDatabase.execSQL(dropTable);
        String createTable = "CREATE TABLE " + USER_TABLE + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_USER_NAME + " TEXT, " + COLUMN_USER_EMAIL + " TEXT, " + COLUMN_USER_PASSWORD + " INT, " + COLUMN_USER_PASSWORD_CONFIRM + " INT)";
        sqLiteDatabase.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {

    }

    public List<customerDBregister> getAllUsers(){
        List<customerDBregister> returnList = new ArrayList<>();
        String queryString  = "SELECT * FROM " + USER_TABLE;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(queryString,null);
        if (cursor.moveToFirst()){
            do {
                int customerID = cursor.getInt(0);
                String customerName = cursor.getString(1);
                String customerEmail = cursor.getString(2);
                int customerPassword = cursor.getInt(3);
                int customerConfirmPassword = cursor.getInt(4);
                customerDBregister customerModel = new customerDBregister(customerID,customerName,customerEmail,customerPassword,customerConfirmPassword);
                returnList.add(customerModel);

            }while (cursor.moveToNext());
        }
        else{

        }

//     Closed database and cursor
        cursor.close();
        db.close();

        return returnList;
    }
    public ArrayList<customerDBregister> getAllUsersEmail(){
        ArrayList<customerDBregister> nameArrayList = new ArrayList<>();
        String queryStringGetName  = "SELECT " + COLUMN_USER_EMAIL + " FROM " + USER_TABLE;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor emailCursor = db.rawQuery(queryStringGetName,null);
        if (emailCursor.moveToFirst()){
            do {
                int index = emailCursor.getColumnIndex(COLUMN_USER_EMAIL);
                if (index == -1) { index = 0; }
                String customerEmail = emailCursor.getString(index);
                customerDBregister user = new customerDBregister();
                user.setEmail(customerEmail);
                nameArrayList.add(user);

            }while (emailCursor.moveToNext());
        }
        else{

        }
        return nameArrayList;
    }

    public customerDBregister loginByEmail(String email){
        customerDBregister user = new customerDBregister();
        String queryString = "SELECT MIN(" + COLUMN_ID + "), " + COLUMN_USER_NAME + ", " + COLUMN_USER_EMAIL + ", " + COLUMN_USER_PASSWORD + " FROM " + USER_TABLE + " WHERE " + COLUMN_USER_EMAIL + " = \"" + email + "\"";
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(queryString, null);
        try {
            if (cursor != null && cursor.getCount() > 0 && cursor.moveToFirst()){
                // setting username
                int index = cursor.getColumnIndex(COLUMN_USER_NAME);
                if (index == -1) { index = 1; }
                String customerName = cursor.getString(index);
                user.setUsername(customerName);

                // setting email
                index = cursor.getColumnIndex(COLUMN_USER_EMAIL);
                if (index == -1) { index = 2; }
                String customerEmail = cursor.getString(index);
                user.setEmail(customerEmail);

                // setting password
                index = cursor.getColumnIndex(COLUMN_USER_PASSWORD);
                if (index == -1) { index = 3; }
                int customerPassword = cursor.getInt(index);
                user.setPassword(customerPassword);
            }
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
        return user;
    }

    public void  dropTable(){
        String queryDropTable = "DROP TABLE " + USER_TABLE;
        SQLiteDatabase db = getWritableDatabase();
        Cursor dropCursor = db.rawQuery(queryDropTable, null);
    }

    public boolean addOne(customerDBregister customerDBregister){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_USER_NAME, customerDBregister.getUsername());
        cv.put(COLUMN_USER_EMAIL, customerDBregister.getEmail());
        cv.put(COLUMN_USER_PASSWORD, customerDBregister.getPassword());
        cv.put(COLUMN_USER_PASSWORD_CONFIRM, customerDBregister.getPasswordConfirm());
        long insert = db.insert(USER_TABLE, null, cv);
        if(insert == -1){
            return false;
        }
        else{
            return true;
        }
    }

    public boolean deleteOne(customerDBregister customerDBregister){
        SQLiteDatabase db = this.getWritableDatabase();
        String queryString = "DELETE FROM " + USER_TABLE + " WHERE " + COLUMN_ID + " = " + customerDBregister.getId();

        Cursor cursor = db.rawQuery(queryString, null);
        if (cursor.moveToFirst()){
            return true;
        }
        else{
            return false;
        }
    }

    public boolean checkusername(String username)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from users where username = ?", new String[] {username});
        if(cursor.getCount()>0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public boolean checkusernamePassword(String username, String password){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from users where username = ? and password = ?", new String[] {username, password});
        if(cursor.getCount()>0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }


}
