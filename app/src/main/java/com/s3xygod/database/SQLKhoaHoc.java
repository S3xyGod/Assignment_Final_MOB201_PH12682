package com.s3xygod.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class SQLKhoaHoc extends SQLiteOpenHelper {
    SQLKhoaHoc sqlKhoaHoc;
    public SQLKhoaHoc(@Nullable Context context) {
        super(context, "SQLKhoaHoc.bd", null, 1);
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

    public boolean check(KhoaHoc khoaHoc){
        List<KhoaHoc> lstKhoaCheck = new ArrayList<>();
        lstKhoaCheck = getall();
        for (int i = 0; i < lstKhoaCheck.size(); i++){
            if (lstKhoaCheck.get(i).getId().equals(khoaHoc.id)){
                return false;
            }
        }
        return true;
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
