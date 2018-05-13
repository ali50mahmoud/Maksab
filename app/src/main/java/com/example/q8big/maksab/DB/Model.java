package com.example.q8big.maksab.DB;

/**
 * Created by q8big on 20/03/2018.
 */

public class Model {


    public static final String TABLE_NAME = "models";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_MODEL = "model";
    public static final String COLUMN_TIMESTAMP = "timestamp";


    private int id;
    private String model;
    private String timestamp;


    public Model(int id, String note, String timestamp) {
        this.id = id;
        this.model = note;
        this.timestamp = timestamp;
    }

    public Model() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }


    public static final String CREATE_TABLE =
            "CREATE TABLE" + TABLE_NAME + "(" + COLUMN_ID + "INTGER PRIMARY KEY AUTOINCREMENT,"
                    + COLUMN_MODEL + "TEXT"
                    + COLUMN_TIMESTAMP + "DATETIME DEFUALT CURRENT_TIMESTAMP"
                    + ")";


}







