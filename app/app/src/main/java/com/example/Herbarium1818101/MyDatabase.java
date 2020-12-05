package com.example.Herbarium1818101;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class MyDatabase extends SQLiteOpenHelper {
    private static int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "db_herbarium";
    private static final String tb_tanamanobat = "tb_tanamanobat";
    private static final String tb_tanamanobat_id = "id";
    private static final String tb_tanamanobat_nama = "nama";
    private static final String tb_tanamanobat_spname = "spname";
    private static final String tb_tanamanobat_manfaat = "manfaat";
    private static final String CREATE_TABLE_Tanamanobat = "CREATE TABLE " +
            tb_tanamanobat + "("
            + tb_tanamanobat_id + " INTEGER PRIMARY KEY ,"
            + tb_tanamanobat_nama + " TEXT,"
            + tb_tanamanobat_spname + " TEXT ,"
            + tb_tanamanobat_manfaat + " TEXT " + ")";

    public MyDatabase (Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_Tanamanobat);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void CreateTanamanobat (Tanaman mdNotif) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(tb_tanamanobat_id, mdNotif.get_id());
        values.put(tb_tanamanobat_nama, mdNotif.get_nama());
        values.put(tb_tanamanobat_spname, mdNotif.get_spname());
        values.put(tb_tanamanobat_manfaat, mdNotif.get_manfaat());
        db.insert(tb_tanamanobat, null, values);
        db.close();
    }

    public List<Tanaman> ReadTanamanobat() {
        List<Tanaman> judulModelList = new ArrayList<Tanaman>();
        String selectQuery = "SELECT * FROM " + tb_tanamanobat;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                Tanaman mdKontak = new Tanaman();
                mdKontak.set_id(cursor.getString(0));
                mdKontak.set_nama(cursor.getString(1));
                mdKontak.set_spname(cursor.getString(2));
                mdKontak.set_manfaat(cursor.getString(3));
                judulModelList.add(mdKontak);
            } while (cursor.moveToNext());
        }
        db.close();
        return judulModelList;
    }
    public int UpdateTanamanobat (Tanaman mdNotif) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(tb_tanamanobat_nama, mdNotif.get_nama());
        values.put(tb_tanamanobat_spname, mdNotif.get_spname());
        values.put(tb_tanamanobat_manfaat, mdNotif.get_manfaat());
        return db.update(tb_tanamanobat, values, tb_tanamanobat_id + " = ?",
                new String[] { String.valueOf(mdNotif.get_id())});
    }
    public void DeleteTanamanobat (Tanaman mdNotif) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(tb_tanamanobat, tb_tanamanobat_id+ " = ?",
                new String[]{String.valueOf(mdNotif.get_id())});
        db.close();
    }
}


