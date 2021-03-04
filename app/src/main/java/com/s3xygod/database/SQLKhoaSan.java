package com.s3xygod.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.BaseAdapter;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class SQLKhoaSan extends SQLiteOpenHelper {
    SQLKhoaSan sqlKhoaSan;
    public SQLKhoaSan(@Nullable Context context) {
        super(context, "SQLKhoaSan.bd", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String create_KhoaHoc = "Create table KhoaHoc(ID text primary key , Name text(50))";
        db.execSQL(create_KhoaHoc);
    }

    public void addKhoaHoc(KhoaHoc khoaHoc){
        SQLiteDatabase db = getReadableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("ID",khoaHoc.getId());
        contentValues.put("Name",khoaHoc.getTen());
        db.insert("KhoaHoc",null,contentValues);
    }


    public List<KhoaHoc> getall(){
        List<KhoaHoc> lstKhoaHoc = new ArrayList<>();
        String get_all = "SELECT * FROM KhoaHoc";
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(get_all,null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            String id,name;
            id = cursor.getString(0);
            name = cursor.getString(1);
            KhoaHoc khoaHoc = new KhoaHoc(id,name);
            lstKhoaHoc.add(khoaHoc);
            cursor.moveToNext();
        }
        cursor.close();
        return lstKhoaHoc;
    }

    public void xoaAll(){
        String get_all = "SELECT * FROM KhoaSan";
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(get_all,null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            String id;
            id = cursor.getString(0);
            sqlKhoaSan.xoaKhoaHoc(id);
            cursor.moveToNext();
        }
        cursor.close();
    }


    public boolean xoaKhoaHoc(String id) {
        SQLiteDatabase db =getWritableDatabase();
        int kq = db.delete("KhoaHoc","ID = ?",new String[]{id});
        if (kq > 0){
            return true;
        }
        return false;
    }
    public void suaKhoaHoc(KhoaHoc khoaHoc) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("ID", khoaHoc.id);
        contentValues.put("Name", khoaHoc.ten);

        db.update("KhoaHoc", contentValues,
                "ID=?", new String[]{khoaHoc.getId()});
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
