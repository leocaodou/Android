package com.example.vocabularybook;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.vocabularybook.wordcontract.Words;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class WordsDB {
    private static final String TAG = "myTag";
    private static WordsDBHelper mDbHelper;
    private static WordsDB instance = new WordsDB();
    public static WordsDB getWordsDB(){
        return WordsDB.instance;
    }

    private WordsDB(){
        if(mDbHelper == null)
            mDbHelper = new WordsDBHelper(WordsApplication.getContext());
    }

    public void close(){
        if(mDbHelper != null)
            mDbHelper.close();
    }

    public Words.WordDescription getSingleWord(String id){
        SQLiteDatabase db = mDbHelper.getReadableDatabase();
        Cursor c;
        c = db.rawQuery("SELECT * FROM "+ Words.Word.TABLE_NAME + " where _ID = ?",new String[]{id});
        return new Words.WordDescription(c.getString(1),c.getString(2),c.getString(3),c.getString(4));
    }
    public ArrayList<Map<String,String>> getAllWords(){
        ArrayList<Map<String,String>> arr = new ArrayList();
        SQLiteDatabase db = mDbHelper.getReadableDatabase();
        Cursor c;
        c = db.rawQuery("SELECT _ID, word FROM "+ Words.Word.TABLE_NAME,new String[]{});
        c.moveToFirst();
        while(!c.isAfterLast()){
            Map<String,String> map = new HashMap<>();
            map.put(Words.Word._ID,c.getString(1));
            map.put(Words.Word.COLUMN_NAME_WORD,c.getString(2));
            arr.add(map);
        }
        return arr;
    }
//    private ArrayList<Map<String,String>> ConvertCursor2WordList(Cursor cursor){
//
//    }
//    public void InsertUserSql(String strWord,String strMeaning, String strSample){
//
//    }
    public void Insert(String strWord,String strMeaning, String strSample){
        ContentValues cv=new ContentValues();
        cv.put(Words.Word.COLUMN_NAME_WORD,strWord);
        cv.put(Words.Word.COLUMN_NAME_MEANING,strMeaning);
        cv.put(Words.Word.COLUMN_NAME_SAMPLE,strSample);
        SQLiteDatabase db = mDbHelper.getReadableDatabase();
        db.insert(Words.Word.TABLE_NAME,null,cv);
    }
    public void DeleteUserSql(String strId){
        SQLiteDatabase db = mDbHelper.getReadableDatabase();
        db.delete(Words.Word.TABLE_NAME, "_ID=?", new String[] { String.valueOf(strId)});
    }
//    public void Delete(String strId){
//
//    }
    public void UpdateUseSql(String strId,String strWord,String strMeaning,String strSample)
    {
        ContentValues cv=new ContentValues();
        cv.put(Words.Word.COLUMN_NAME_WORD,strWord);
        cv.put(Words.Word.COLUMN_NAME_MEANING,strMeaning);
        cv.put(Words.Word.COLUMN_NAME_SAMPLE,strSample);
        SQLiteDatabase db = mDbHelper.getReadableDatabase();
        db.update(Words.Word.TABLE_NAME,cv,"_ID = ?, word = ?, meaning = ?, sample = ?" ,new String[]{strId,strWord,strMeaning,strSample});
    }
//    public void Update(String strId,String strWord,String strMeaning,String strSample)
//    {
//
//    }
    public ArrayList<Map<String,String>> SearchUseSql(String strWordSearch) {
        ArrayList<Map<String,String>> arr = new ArrayList();
        SQLiteDatabase db = mDbHelper.getReadableDatabase();
        Cursor c;
        strWordSearch = '%' + strWordSearch + '%';
        c = db.rawQuery("SELECT _ID, word FROM "+ Words.Word.TABLE_NAME + " where word like " + "'" + strWordSearch + "'",new String[]{});
        c.moveToFirst();
        while(!c.isAfterLast()){
            Map<String,String> map = new HashMap<>();
            map.put(Words.Word._ID,c.getString(1));
            map.put(Words.Word.COLUMN_NAME_WORD,c.getString(2));
            arr.add(map);
        }
        return arr;
    }
//    public ArrayList<Map<String,String>> Search(String strWordSearch)
//    {
//
//    }
}