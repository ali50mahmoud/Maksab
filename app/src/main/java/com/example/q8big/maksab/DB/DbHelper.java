package com.example.q8big.maksab.DB;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import static com.example.q8big.maksab.DB.Model.COLUMN_ID;
import static com.example.q8big.maksab.DB.Model.COLUMN_MODEL;
import static com.example.q8big.maksab.DB.Model.COLUMN_TIMESTAMP;
import static com.example.q8big.maksab.DB.Model.TABLE_NAME;

/**
 * Created by q8big on 20/03/2018.
 */

public class DbHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABSE_NAME = "models_db";

    public DbHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String createTable= "CREATE TABLE " + TABLE_NAME+"("
                + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_MODEL + " TEXT," + COLUMN_TIMESTAMP + " TEXT,"
                + ")";



    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE " + Model.TABLE_NAME);
        onCreate(db);

    }


    public long insertModel(String model) {
        // get writable database as we want to write data
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

      /*  values.put(Model.COLUMN_MODEL, model);*/

        db.execSQL("INSERT INTO TABLE_NAME VALUES( id,model,timestamp)");
        db.execSQL("INSERT INTO miso VALUES( 2,koko,egypt)");
        db.execSQL("INSERT INTO romio VALUES( 5,zezo,saudia)");
        db.execSQL("INSERT INTO brutal VALUES( 5,zezo,london)");


        // insert row
        long id = db.insert(Model.TABLE_NAME, null, values);

      /*  long id = db.insert(Model.model1,null,values);
        long id = db.insert(Model.model1,null,values);
        long id = db.insert(Model.model1,null,values);*/


        // close db connection
        db.close();

        // return newly inserted row id
        return id;
    }

    public Model getModel(long id) {
        // get readable database as we are not inserting anything
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(Model.TABLE_NAME,
                new String[]{Model.COLUMN_ID, Model.COLUMN_MODEL, Model.COLUMN_TIMESTAMP},
                Model.COLUMN_ID + "=?",
                new String[]{String.valueOf(id)}, null, null, null, null);

        if (cursor != null)
            cursor.moveToFirst();

        // prepare note object
        Model model = new Model(
                cursor.getInt(cursor.getColumnIndex(Model.COLUMN_ID)),
                cursor.getString(cursor.getColumnIndex(Model.COLUMN_MODEL)),
                cursor.getString(cursor.getColumnIndex(Model.COLUMN_TIMESTAMP)));

        // close the db connection
        cursor.close();

        return model;
    }

    public List<Model> getAllModels() {
        List<Model> models = new ArrayList<>();

        // Select All Query
        String selectQuery = "SELECT  * FROM " + Model.TABLE_NAME + " ORDER BY " +
                Model.COLUMN_TIMESTAMP + " DESC";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Model model = new Model();
                model.setId(cursor.getInt(cursor.getColumnIndex(Model.COLUMN_ID)));
                model.setModel(cursor.getString(cursor.getColumnIndex(Model.COLUMN_MODEL)));
                model.setTimestamp(cursor.getString(cursor.getColumnIndex(Model.COLUMN_TIMESTAMP)));

                models.add(model);
            } while (cursor.moveToNext());
        }

        // close db connection
        db.close();

        // return notes list
        return models;
    }

    public int getModelssCount() {
        String countQuery = "SELECT  * FROM " + Model.TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);

        int count = cursor.getCount();
        cursor.close();

        // return count
        return count;
    }

    public int updateModel(Model model) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Model.COLUMN_MODEL, model.getModel());

        // updating row
        return db.update(Model.TABLE_NAME, values, Model.COLUMN_ID + " = ?",
                new String[]{String.valueOf(model.getId())});
    }

    public void deleteNote(Model note) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(Model.TABLE_NAME, Model.COLUMN_ID + " = ?",
                new String[]{String.valueOf(note.getId())});
        db.close();
    }


}
