package com.example.user.biodata;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DataHelper extends SQLiteOpenHelper {
    private static  final String DATABASE_NAME="biodatadiri.db";
    private static final int DATABASE_VERSION=1;
    public  DataHelper(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql="create table biodata(nama text primary key,almat text null,tanggal lahir text null,sekolah text null,hobbi text null);";
        Log.d("Data","onCreate:"+sql);
        db.execSQL(sql);
        sql="INSERT INTO biodata(nama,alamat,tanggal lahir,sekolah,hobbi)VALUES('Neti','Cijaringao','28 September 2001','SMK ALFALAH','Makan');";
        db.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {


    }
}
