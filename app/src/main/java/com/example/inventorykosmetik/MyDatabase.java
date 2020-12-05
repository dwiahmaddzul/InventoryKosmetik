package com.example.inventorykosmetik;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class MyDatabase extends SQLiteOpenHelper {
    private static int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "db_inventorykosmetik";
    private static final String tb_kosmetik = "tb_kosmetik";
    private static final String tb_kosmetik_id = "id";
    private static final String tb_kosmetik_nama = "nama";
    private static final String tb_kosmetik_bpom = "bpom";
    private static final String tb_kosmetik_stok = "stok";
    private static final String CREATE_TABLE_kosmetik = "CREATE TABLE " +
            tb_kosmetik + "("
            + tb_kosmetik_id + " INTEGER PRIMARY KEY ,"
            + tb_kosmetik_nama + " TEXT,"
            + tb_kosmetik_bpom + " TEXT ,"
            + tb_kosmetik_stok + " TEXT " + ")";

    public MyDatabase (Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_kosmetik);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void Createkosmetik (Kosmetik mdNotif) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(tb_kosmetik_id, mdNotif.get_id());
        values.put(tb_kosmetik_nama, mdNotif.get_nama());
        values.put(tb_kosmetik_bpom, mdNotif.get_bpom());
        values.put(tb_kosmetik_stok, mdNotif.get_stok());
        db.insert(tb_kosmetik, null, values);
        db.close();
    }

    public List<Kosmetik> Readkosmetik() {
        List<Kosmetik> judulModelList = new ArrayList<Kosmetik>();
        String selectQuery = "SELECT * FROM " + tb_kosmetik;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                Kosmetik mdKontak = new Kosmetik();
                mdKontak.set_id(cursor.getString(0));
                mdKontak.set_nama(cursor.getString(1));
                mdKontak.set_bpom(cursor.getString(2));
                mdKontak.set_stok(cursor.getString(3));
                judulModelList.add(mdKontak);
            } while (cursor.moveToNext());
        }
        db.close();
        return judulModelList;
    }
    public int Updatekosmetik (Kosmetik mdNotif) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(tb_kosmetik_nama, mdNotif.get_nama());
        values.put(tb_kosmetik_bpom, mdNotif.get_bpom());
        values.put(tb_kosmetik_stok, mdNotif.get_stok());
        return db.update(tb_kosmetik, values, tb_kosmetik_id + " = ?",
                new String[] { String.valueOf(mdNotif.get_id())});
    }
    public void Deletekosmetik (Kosmetik mdNotif) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(tb_kosmetik, tb_kosmetik_id+ " = ?",
                new String[]{String.valueOf(mdNotif.get_id())});
        db.close();
    }
}


