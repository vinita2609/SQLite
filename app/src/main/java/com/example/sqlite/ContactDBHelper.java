package com.example.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class ContactDBHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "Employee_db";
    public static final int DATABASE_VERSION = 2;


    public ContactDBHelper(Context context) {

        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        Log.d("Database Operation", "Database Created");
    }

    public static final String CREATE_TABLE = "create table " + ContactContract.ContactEntry.TABLE_NAME + "(" + ContactContract.ContactEntry.EMAIL
            + " text, " + ContactContract.ContactEntry.EMPLOYEE_ID + "  number, " + ContactContract.ContactEntry.NAME + " text);";

    public static final String DROP_TABLE = " drop table if exists " + ContactContract.ContactEntry.TABLE_NAME;


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
        Log.d("DATABASE", CREATE_TABLE);
        Log.d("Database Operation", "Table is Created");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL(DROP_TABLE);
        onCreate(db);

    }

    public void addContact(int id, String name, String email, SQLiteDatabase database) {

        Log.d("DATABASE", id + name + email);
        ContentValues contentValues = new ContentValues();
        contentValues.put(ContactContract.ContactEntry.EMPLOYEE_ID, id);
        contentValues.put(ContactContract.ContactEntry.NAME, name);
        contentValues.put(ContactContract.ContactEntry.EMAIL, email);

        database.insert(ContactContract.ContactEntry.TABLE_NAME, null, contentValues);

        Log.d("Database Operation", "One row is created");


        database.close();


    }


    public void Clean() {


    }

}
