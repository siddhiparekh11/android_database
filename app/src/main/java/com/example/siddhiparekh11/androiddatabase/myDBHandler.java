package com.example.siddhiparekh11.androiddatabase;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.Cursor;
import android.content.Context;
import android.content.ContentValues;

public class myDBHandler extends SQLiteOpenHelper{


    private static final int DATABASE_VERSION=1;
    private static final String DATABASE_NAME="products.db";
    public static final String TABLE_NAME="products";
    public static final String COLUMN_ID="id";
    public static final String COLUMN_NAME="productname";
    public static final String COLUMN_DESCRIPTION="productdes";
    public static final String COLUMN_PRICE="productprice";
    public static final String COLUMN_REVIEW="productreview";

    public myDBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String query="CREATE TABLE " + TABLE_NAME + "(" + COLUMN_ID +
                " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_NAME + " TEXT, " +
                COLUMN_DESCRIPTION + " TEXT, " + COLUMN_PRICE + " TEXT, " + COLUMN_REVIEW + " TEXT);";
        db.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS" + TABLE_NAME);
        onCreate(db);


    }
    //adding rows to the table
    public void addProduct(Products product)
    {
        ContentValues values=new ContentValues();
        values.put(COLUMN_NAME,product.get_itemname());
        values.put(COLUMN_DESCRIPTION,product.get_itemdescription());
        values.put(COLUMN_PRICE,product.get_itemprice());
        values.put(COLUMN_REVIEW,product.get_itemreview());
        SQLiteDatabase db= getWritableDatabase();
        db.insert(TABLE_NAME,null,values);
        db.close();
    }
    public String databaseToString(String itemName){
        String dbString="Search results:\n";
        SQLiteDatabase db= getWritableDatabase();
        String query="SELECT * FROM " + TABLE_NAME + " WHERE " + COLUMN_NAME + "='" + itemName + "';" ;
        Cursor c= db.rawQuery(query,null);
        c.moveToFirst();
        if(c.getCount()==0)
        {
            dbString +="No Records exists.";
        }
        while(!c.isAfterLast())
        {
            if(c.getString(c.getColumnIndex("productname"))!=null)
            {
                  dbString += "\nItem name: " + c.getString(c.getColumnIndex("productname"));
                   dbString += "\nItem description: " + c.getString(c.getColumnIndex("productdes"));
                dbString += "\nItem price: " + c.getString(c.getColumnIndex("productprice"));
                dbString += "\nItem review: " + c.getString(c.getColumnIndex("productreview"));

            }

            c.moveToNext();
        }
        db.close();
        return dbString;

    }
}
