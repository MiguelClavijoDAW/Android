package com.example.trabajofinal;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class TrabajoFinalSQLiteHelper extends SQLiteOpenHelper {
    String tablaUsuario="CREATE TABLE usuario (codigo INTEGER PRIMARY KEY AUTOINCREMENT, nombre TEXT, apellido TEXT, dni TEXT, usuario TEXT, contraseña TEXT, perfil INT," +
            "foto TEXT)";
    String tablaIncidente="CREATE TABLE incidencia (codigo INTEGER PRIMARY KEY AUTOINCREMENT, dni TEXT,fechaIncidencia TEXT, dniResponsable TEXT, estado INT, fechaResolucion TEXT)";

    public TrabajoFinalSQLiteHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(tablaUsuario);
        db.execSQL(tablaIncidente);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS usuario");
        db.execSQL("DROP TABLE IF EXISTS incidencia");
        db.execSQL(tablaUsuario);
        db.execSQL(tablaIncidente);
    }
}
