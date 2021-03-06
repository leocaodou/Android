package com.example.vocabularybook;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.ListFragment;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TableLayout;

import com.example.vocabularybook.wordcontract.Words;

public class MainActivity extends AppCompatActivity implements WordItemFragment.OnFragmentInteractionListener,WordDetailFragment.OnFragmentInteractionListener{

    private static final String TAG = "Main";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onWordDetailClick(Uri uri) {

    }

    @Override
    public void onWordItemClick(String id) {
        if(island()) {
            ChangeWordDetailFragment(id);
        }
        else {
            Intent intent = new Intent(MainActivity.this,WordDetailActivity.class);
            intent.putExtra(WordDetailFragment.ARG_ID,id);
            startActivity(intent);
        }
    }

    @Override
    public void onDeleteDialog(String strId) {
        DeleteDialog(strId);
    }

    @Override
    public void onUpdateDialog(String strId) {
        WordsDB wordsDB = WordsDB.getWordsDB();
        if(wordsDB != null && strId != null){
            Words.WordDescription item = wordsDB.getSingleWord(strId);
            if(item != null){
                UpdateDialog(strId,item.word, item.meaning,item.sample);
            }
        }
    }

    private boolean island(){
        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE)
            return true;
        else
            return false;
    }

    private void ChangeWordDetailFragment(String id){
        if(id!=null) {
            Bundle arguments = new Bundle();
            arguments.putString(WordDetailFragment.ARG_ID, id);
            Log.v(TAG, id);
            WordDetailFragment fragment = new WordDetailFragment();
            fragment.setArguments(arguments);
            getSupportFragmentManager().beginTransaction().replace(R.id.worddetail, fragment).commit();
        }
    }

    private void InsertDialog(){
        final LinearLayout tableLayout = (LinearLayout) getLayoutInflater().inflate(R.layout.insert,null);
        new AlertDialog.Builder(MainActivity.this).setTitle("新增单词").setView(tableLayout).
                setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String strWord = ((EditText) tableLayout.findViewById(R.id.txtWord)).getText().toString();
                        String strMeaning = ((EditText) tableLayout.findViewById(R.id.txtMeaning)).getText().toString();
                        String strSample = ((EditText) tableLayout.findViewById(R.id.txtSample)).getText().toString();
                        WordsDB wordsDB = WordsDB.getWordsDB();
                        wordsDB.Insert(strWord,strMeaning,strSample);
                        ReFreshWordItemFragment();
                    }
                })
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .create()
                .show();
    }
    private void DeleteDialog(final String strId){
        new AlertDialog.Builder(this).setTitle("删除单词")
                .setMessage("是否确认真的删除单词？")
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        WordsDB wordsDB = WordsDB.getWordsDB();
                        wordsDB.DeleteUserSql(strId);
                        ReFreshWordItemFragment();
                    }
                }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        }).create().show();
    }

    private void UpdateDialog(final String strId,final String strWord,final String strMeaning,final String strSample){
        final LinearLayout tableLayout = (LinearLayout) getLayoutInflater().inflate(R.layout.insert,null);
        ((EditText)tableLayout.findViewById(R.id.txtWord)).setText(strWord);
        ((EditText)tableLayout.findViewById(R.id.txtMeaning)).setText(strMeaning);
        ((EditText)tableLayout.findViewById(R.id.txtSample)).setText(strSample);
        new AlertDialog.Builder(this).setTitle("修改单词")
                .setView(tableLayout)
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String strNewWord = ((EditText)tableLayout.findViewById(R.id.txtWord)).getText().toString();
                        String strNewMeaning = ((EditText)tableLayout.findViewById(R.id.txtMeaning)).getText().toString();
                        String strNewSample = ((EditText)tableLayout.findViewById(R.id.txtSample)).getText().toString();
                        WordsDB wordsDB = WordsDB.getWordsDB();
                        wordsDB.UpdateUseSql(Integer.valueOf(strId),strNewWord,strNewMeaning,strNewSample);
                        ReFreshWordItemFragment();
                    }
                }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        }).create().show();
    }
    private void SearchDialog(){
        final LinearLayout tableLayout = (LinearLayout) getLayoutInflater().inflate(R.layout.searchterm,null);
        new AlertDialog.Builder(this)
                .setTitle("查找单词")
                .setView(tableLayout)
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String txtSearchWord = ((EditText) tableLayout.findViewById(R.id.txtSearchWord)).getText().toString();
                        ReFreshWordItemFragment(txtSearchWord);
                    }
                })
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .create().show();
    }

    private void ReFreshWordItemFragment(){
        WordItemFragment wordItemFragment = (WordItemFragment) getSupportFragmentManager().findFragmentById(R.id.wordlist);
        wordItemFragment.refreshWordsList();
    }
    private void ReFreshWordItemFragment(String strWord){
        WordItemFragment wordItemFragment = (WordItemFragment)getSupportFragmentManager().findFragmentById(R.id.wordlist);
        wordItemFragment.refreshWordsList(strWord);
    }

    //创建菜单
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mianmenu,menu);
        return true;
    }

    //菜单点击事件
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_Insert:
                InsertDialog();
                break;
            case R.id.action_Search:
                SearchDialog();
                break;
        }
        return  true;
    }
}