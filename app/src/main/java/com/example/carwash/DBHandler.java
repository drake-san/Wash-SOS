package com.example.carwash;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHandler extends SQLiteOpenHelper {
    private static final String DB_NAME = "washsos";

    private static final int DB_VERSION = 1;

    private static final String TABLE_NAME = "services";

    private static final String ID_COL = "id";

    private static final String NAME_COL = "name";

    private static final String BRAND_COL = "brand";

    private static final String SERVICE_COL = "service";
    private static final String PRICE_COL = "price";

    public DBHandler(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String query = "CREATE TABLE " + TABLE_NAME + " (" + ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + NAME_COL + " TEXT,"
                + BRAND_COL + " TEXT,"
                + SERVICE_COL + " TEXT,"
                + PRICE_COL + " INTEGER"+
                ")";

        db.execSQL(query);
    }

    public void addService(String userName, String carBrand, String service, int price) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(NAME_COL, userName);
        values.put(BRAND_COL, carBrand);
        values.put(SERVICE_COL, service);
        values.put(PRICE_COL, price);

        db.insert(TABLE_NAME, null, values);

        db.close();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public String loadHandler() {
        String result = "";
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor c = db.rawQuery("select name, brand, service, price from services", null);

        while(c.moveToNext()) {
            String name = c.getString(0);
            String brand = c.getString(1);
            String service = c.getString(2);
            int price = c.getInt(3);
            result += name + " " + brand + " " + service + " " + price + System.getProperty("line.separator") +"\n";
        }
        c.close();
        db.close();

        return result;
    }
}
