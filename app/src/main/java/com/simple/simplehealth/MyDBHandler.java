package com.simple.simplehealth;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class MyDBHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASSE_NAME = "productDB.db";
    private static final String TABLE_PRODUCTS = "simpleHealth";

    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_WEIGHT = "weight";
    public static final String COLUMN_HOUR = "hour";
    public static final String COLUMN_MINUTE = "minute";
    public static final String COLUMN_HEALTH = "health";

    public MyDBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int vision) {
        super(context, DATABASSE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_PRODUTS_TABLE = "CREATE TABLE IF NOT EXISTS " + TABLE_PRODUCTS + "("
                + COLUMN_ID + " TEXT PRIMARY KEY,"
                + COLUMN_WEIGHT + " TEXT,"
                + COLUMN_HOUR + " TEXT,"
                + COLUMN_MINUTE + " TEXT,"
                + COLUMN_HEALTH + " TEXT" + ")";
        db.execSQL(CREATE_PRODUTS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PRODUCTS);
        onCreate(db);
    }

    public void addProduct(Product product){
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, product.get_id());
        values.put(COLUMN_WEIGHT, product.get_weight());
        values.put(COLUMN_HOUR, product.get_hour());
        values.put(COLUMN_MINUTE, product.get_minute());
        values.put(COLUMN_HEALTH, product.get_health());

        SQLiteDatabase db = this.getWritableDatabase();

        db.insert(TABLE_PRODUCTS, null, values);
        db.close();
    }

    public Product findProduct(String id){
        String query = " SELECT *  FROM " + TABLE_PRODUCTS + " WHERE " + COLUMN_ID + " = \""+ id +"\"";

        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery(query, null);

        Product product = new Product();

        if (cursor.moveToFirst()){
            cursor.moveToFirst();

            product.set_id(cursor.getString(0));
            product.set_weight(cursor.getString(1));
            product.set_hour(cursor.getString(2));
            product.set_minute(cursor.getString(3));
            product.set_health(cursor.getString(4));
            cursor.close();
        } else {
            product = null;
        }

        db.close();
        return product;
    }

    public void updateProduct(Product product){
/*        String query = " UPDATE " + TABLE_PRODUCTS + " SET "
                + COLUMN_WEIGHT + " = \"" + weight + "\", "
                + COLUMN_HOUR + " = \"" + hour + "\", "
                + COLUMN_MINUTE + " = \"" + minute + "\", "
                + COLUMN_HEALTH + " = \"" + health
                + "\" WHERE " + COLUMN_ID + " = \""+ id +"\"";*/

        ContentValues values = new ContentValues();
        //values.put(COLUMN_ID, product.get_id());
        values.put(COLUMN_WEIGHT, product.get_weight());
        values.put(COLUMN_HOUR, product.get_hour());
        values.put(COLUMN_MINUTE, product.get_minute());
        values.put(COLUMN_HEALTH, product.get_health());

        String db_id = String.valueOf(product.get_id());
        String updateDB[] = {db_id};

        Log.i("database", ""+db_id);

        SQLiteDatabase db = this.getWritableDatabase();
        db.update(TABLE_PRODUCTS, values,COLUMN_ID +"=?"  ,  updateDB);

        db.close();

/*        db.update(TABLE_PRODUCTS, values,COLUMN_WEIGHT + product.get_minute() ,  null);
        db.update(TABLE_PRODUCTS, values,COLUMN_HOUR + product.get_hour() ,  null);
        db.update(TABLE_PRODUCTS, values,COLUMN_MINUTE + product.get_minute() ,  null);
        db.update(TABLE_PRODUCTS, values,COLUMN_HEALTH + product.get_health() ,  null);*/
    }

}
