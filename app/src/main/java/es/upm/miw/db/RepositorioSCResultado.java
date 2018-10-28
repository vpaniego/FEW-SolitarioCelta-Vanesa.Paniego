package es.upm.miw.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.Date;

import static es.upm.miw.db.SCResultadoContract.tablaSCResultado;

public class RepositorioSCResultado extends SQLiteOpenHelper {

    private static final String DB_NAME = tablaSCResultado.TABLE_NAME + ".db";

    private static final int DB_VERSION = 1;

    public RepositorioSCResultado(Context contexto) {
        super(contexto, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String consultaSQL = "CREATE TABLE " + tablaSCResultado.TABLE_NAME + " ("
                + tablaSCResultado.COL_NAME_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + tablaSCResultado.COL_NAME_NOMBRE + " TEXT, "
                + tablaSCResultado.COL_NAME_FECHA + " INTEGER, "
                + tablaSCResultado.COL_NAME_FICHAS + " INTEGER )";
        db.execSQL(consultaSQL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String consultaSQL = "DROP TABLE IF EXISTS " + tablaSCResultado.TABLE_NAME;
        db.execSQL(consultaSQL);
        onCreate(db);
    }

    public long count() {
        SQLiteDatabase db = this.getReadableDatabase();
        return DatabaseUtils.queryNumEntries(db, tablaSCResultado.TABLE_NAME);
    }


    public long add(String nombre, Date fecha, int fichas) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues valores = new ContentValues();
        valores.put(tablaSCResultado.COL_NAME_NOMBRE, nombre);
        valores.put(tablaSCResultado.COL_NAME_FECHA, fecha.getTime());
        valores.put(tablaSCResultado.COL_NAME_FICHAS, fichas);

        return db.insert(tablaSCResultado.TABLE_NAME, null, valores);
    }

    public int removeAll() {

        SQLiteDatabase db = this.getWritableDatabase();

        int deleted = db.delete(tablaSCResultado.TABLE_NAME, "1", null);
        db.close();

        return deleted;

    }


    public ArrayList<SCResultado> getAll() {
        String consultaSQL = "SELECT * FROM " + tablaSCResultado.TABLE_NAME;
        ArrayList<SCResultado> listaSCResultado = new ArrayList<>();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(consultaSQL, null);

        if (cursor.moveToFirst()) {
            while (!cursor.isAfterLast()) {
                SCResultado resultado = new SCResultado(
                        cursor.getInt(cursor.getColumnIndex(tablaSCResultado.COL_NAME_ID)),
                        cursor.getString(cursor.getColumnIndex(tablaSCResultado.COL_NAME_NOMBRE)),
                        new Date(cursor.getLong(cursor.getColumnIndex(tablaSCResultado.COL_NAME_FECHA))),
                        cursor.getInt(cursor.getColumnIndex(tablaSCResultado.COL_NAME_FICHAS))
                );

                listaSCResultado.add(resultado);
                cursor.moveToNext();
            }
        }

        cursor.close();
        db.close();

        return listaSCResultado;
    }

    public ArrayList<SCResultado> getAllOrderByNumFichas() {
        String consultaSQL = "SELECT * FROM " + tablaSCResultado.TABLE_NAME + " ORDER BY " + tablaSCResultado.COL_NAME_FICHAS + " ASC ";
        ArrayList<SCResultado> listaSCResultado = new ArrayList<>();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(consultaSQL, null);

        if (cursor.moveToFirst()) {
            while (!cursor.isAfterLast()) {
                SCResultado resultado = new SCResultado(
                        cursor.getInt(cursor.getColumnIndex(tablaSCResultado.COL_NAME_ID)),
                        cursor.getString(cursor.getColumnIndex(tablaSCResultado.COL_NAME_NOMBRE)),
                        new Date(cursor.getLong(cursor.getColumnIndex(tablaSCResultado.COL_NAME_FECHA))),
                        cursor.getInt(cursor.getColumnIndex(tablaSCResultado.COL_NAME_FICHAS))
                );

                listaSCResultado.add(resultado);
                cursor.moveToNext();
            }
        }

        cursor.close();
        db.close();

        return listaSCResultado;
    }





}
