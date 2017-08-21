package com.heal.alfabet.heal;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

/**
 * Created by alfabet on 8/21/17.
 */

public class ChartHelper extends SQLiteOpenHelper {
    private Context con;
    public ChartHelper(Context context) {
        super(context, "Mydatabase" , null, 1);
        con=context;
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String createTable="create table MyTable (xValue INTEGER);";
        sqLiteDatabase.execSQL(createTable);
        Toast.makeText(con, "Table Created", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void inserData(int x) {
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put("xValue", x);

        sqLiteDatabase.insert("MyTable", null, contentValues);
        Toast.makeText(con, "Data Inserted", Toast.LENGTH_SHORT).show();
    }
}
