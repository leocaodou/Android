package com.example.vocabularybook;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.vocabularybook.wordcontract.Words;

public class WordsDBHelper extends SQLiteOpenHelper {
    private final static String DATEBASE_NAME = "wordsdb";
    private final static int DATEBASE_VERSION = 1;
    private final static String SQL_CREATE_DATEBASE = "CREATE TABLE " + Words.Word.TABLE_NAME + "(" + Words.Word._ID + " VARCHAR(32) PRIMARY KEY NOT NULL," + Words.Word.COLUMN_NAME_WORD + "TEXT UNIQUE NOT NULL," + Words.Word.COLUMN_NAME_MEANING + "TEXT, " + Words.Word.COLUMN_NAME_SAMPLE + " TEXT)";
    private final static String SQL_DELETE_DATEBASE = "DROP TABLE IF EXISTS " + Words.Word.TABLE_NAME;

    public WordsDBHelper(@Nullable Context context) {
        super(context,DATEBASE_NAME,null,DATEBASE_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_DATEBASE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_DATEBASE);
        onCreate(db);
    }
    
}
