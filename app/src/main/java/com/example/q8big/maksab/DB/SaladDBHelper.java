package com.example.q8big.maksab.DB;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by q8big on 04/04/2018.
 */
class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "miodzio";
    private static final int DB_VERSION = 1;

    public DatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE SALAD (_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "NAME TEXT, "
                + "IMAGE_RESOURCE_ID INTEGER, "
                + "FAVORITE INTEGER);");
/*
        insertSalad(db, "Sałatka grecka", R.drawable.salatka_grecka, 0);
        insertSalatki(db, "Sałatka z grillowanym kurczakiem", R.drawable.salatka_z_kurczakiem, 0);
*/
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    private static void insertSalad(SQLiteDatabase db, String name, int resourceId, int favorite){

        ContentValues saladValues = new ContentValues();
        saladValues.put("NAME", name);
        saladValues.put("IMAGE_RESOURCE_ID", resourceId);
        saladValues.put("Favorite", favorite);
        db.insert("SALAD", null, saladValues);


    }private static void insertSalatki (SQLiteDatabase db, String name, int resourceId, int favorite){

        ContentValues saladValues = new ContentValues();
        saladValues.put("NAME", name);
        saladValues.put("IMAGE_RESOURCE_ID", resourceId);
        saladValues.put("Favorite", favorite);
        db.insert("SALAD", null, saladValues);
    }
}