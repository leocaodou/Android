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
        c = db.rawQuery("SELECT * FROM "+ Words.Word.TABLE_NAME + " where " + Words.Word._ID + " = " + id,new String[]{});
        c.moveToNext();
        return new Words.WordDescription(c.getInt(0),c.getString(1),c.getString(2),c.getString(3));
    }
    public ArrayList<Map<String,String>> getAllWords(){
        ArrayList<Map<String,String>> arr = new ArrayList();
        SQLiteDatabase db = mDbHelper.getReadableDatabase();
        Cursor c;
        c = db.rawQuery("SELECT " +Words.Word._ID + "," + Words.Word.COLUMN_NAME_WORD + " FROM "+ Words.Word.TABLE_NAME,new String[]{});
        while(c.moveToNext()){
            Map<String,String> map = new HashMap<>();
            map.put(Words.Word._ID,String.valueOf(c.getInt(0)));
            map.put(Words.Word.COLUMN_NAME_WORD,c.getString(1));
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
        SQLiteDatabase db = mDbHelper.getReadableDatabase();
        String sql = "insert into " + Words.Word.TABLE_NAME + " (" + Words.Word.COLUMN_NAME_WORD + "," +  Words.Word.COLUMN_NAME_MEANING + "," + Words.Word.COLUMN_NAME_SAMPLE + ") values( '" + strWord + "','" + strMeaning + "','" + strSample + "')";
        db.execSQL(sql);
    }
    public void DeleteUserSql(String strId){
        SQLiteDatabase db = mDbHelper.getReadableDatabase();
        db.delete(Words.Word.TABLE_NAME, Words.Word._ID + "=?", new String[] {strId});
    }
//    public void Delete(String strId){
//
//    }
    public void UpdateUseSql(int strId,String strWord,String strMeaning,String strSample)
    {
        ContentValues cv=new ContentValues();
        cv.put(Words.Word.COLUMN_NAME_WORD,strWord);
        cv.put(Words.Word.COLUMN_NAME_MEANING,strMeaning);
        cv.put(Words.Word.COLUMN_NAME_SAMPLE,strSample);
        SQLiteDatabase db = mDbHelper.getReadableDatabase();
        db.update(Words.Word.TABLE_NAME,cv, Words.Word._ID + " = " + strId,new String[]{});
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
        while(c.moveToNext()){
            Map<String,String> map = new HashMap<>();
            map.put(Words.Word._ID,String.valueOf(c.getInt(0)));
            map.put(Words.Word.COLUMN_NAME_WORD,c.getString(1));
            arr.add(map);
        }
        return arr;
    }
//    public ArrayList<Map<String,String>> Search(String strWordSearch)
//    {
//
//    }
}
