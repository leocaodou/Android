package com.example.vocabularybook;

import android.database.Cursor;

import com.example.vocabularybook.wordcontract.Words;

import java.util.ArrayList;
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

    }
    public ArrayList<Map<String,String>> getAllWords(){

    }
    private ArrayList<Map<String,String>> ConvertCursor2WordList(Cursor cursor){

    }
    public void InsertUserSql(String strWord,String strMeaning, String strSample){

    }
    public void Insert(String strWord,String strMeaning, String strSample){

    }
    public void DeleteUserSql(String strId){

    }
    public void Delete(String strId){

    }
    public void UpdateUseSql(String strId,String strWord,String strMeaning,String strSample)
    {

    }
    public void Update(String strId,String strWord,String strMeaning,String strSample)
    {

    }
    public ArrayList<Map<String,String>> SearchUseSql(String strWordSearch)
    {

    }
    public ArrayList<Map<String,String>> Search(String strWordSearch)
    {

    }
}
