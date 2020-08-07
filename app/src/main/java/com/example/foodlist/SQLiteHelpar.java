package com.example.foodlist;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

import androidx.annotation.Nullable;

public class SQLiteHelpar extends SQLiteOpenHelper {
    public SQLiteHelpar(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public  void queryData(String sql){
        SQLiteDatabase db=getWritableDatabase();
        db.execSQL(sql);

    }
    public void insertData(String name,String price,byte[]image){

        SQLiteDatabase db=getWritableDatabase();
        String sql="INSERT INTO FOOD VALUES (NULL, ?, ?, ?)";

        SQLiteStatement statement=db.compileStatement(sql);
        statement.clearBindings();

        statement.bindString(1,name);
        statement.bindString(2,price);
        statement.bindBlob(3,image);

        statement.executeInsert();


    }

    public Cursor getData(String sql){
        SQLiteDatabase db=getReadableDatabase();
        return db.rawQuery(sql,null);

    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
