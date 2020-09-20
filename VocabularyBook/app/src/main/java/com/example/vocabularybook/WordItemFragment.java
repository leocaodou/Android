package com.example.vocabularybook;

import android.content.Context;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.ListFragment;

import com.example.vocabularybook.wordcontract.Words;

import java.util.ArrayList;
import java.util.Map;

public class WordItemFragment extends ListFragment {
    private OnFragmentInteractionListener mListener;

    public void onAttach(Context context){
        super.onAttach(context);
        mListener = (OnFragmentInteractionListener) getActivity();
    }
    public void onDetach(){
        super.onDetach();
        mListener = null;
    }
    public interface OnFragmentInteractionListener{
        public void onWordItemClick(String id);
        public void onDeleteDialog(String strId);
        public void onUpdateDialog(String stId);
    }

    public void refreshWordsList(){
        WordsDB wordsDB = WordsDB.getWordsDB();
        if(wordsDB != null){
            ArrayList<Map<String,String>> item = wordsDB.getAllWords();
            SimpleAdapter adapter = new SimpleAdapter(getActivity(),item,R.layout.item,new String[]{Words.Word._ID, Words.Word.COLUMN_NAME_WORD},new int[]{R.id.textId,R.id.textViewWord});
            setListAdapter(adapter);
        }
    }

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        refreshWordsList();
    }

    public void refreshWordsList(String strWord){
        WordsDB wordsDB = WordsDB.getWordsDB();
        if(wordsDB != null){
            ArrayList<Map<String,String>> item = wordsDB.SearchUseSql(strWord);
            if(item.size() > 0) {
                SimpleAdapter adapter = new SimpleAdapter(getActivity(), item, R.layout.item, new String[]{Words.Word._ID, Words.Word.COLUMN_NAME_WORD}, new int[]{R.id.textId, R.id.textViewWord});
                setListAdapter(adapter);
            }
            else {
                Toast.makeText(getActivity(),"没有找到你需要的单词",Toast.LENGTH_LONG).show();
            }
        }
    }

    public void onListItemClick(ListView l, View v,int position,long id){
        super.onListItemClick(l,v,position,id);
        if(mListener != null){
            TextView textView = (TextView) v.findViewById(R.id.textId);
            if(textView != null){
                mListener.onWordItemClick(textView.getText().toString());
            }
        }
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState){
        View view = super.onCreateView(inflater,container,savedInstanceState);
        ListView mListView = (ListView) view.findViewById(android.R.id.list);
        registerForContextMenu(mListView);
        return view;
    }

    public void onCreateContextMenu(ContextMenu menu,View v,ContextMenu.ContextMenuInfo menuInfo){
        super.onCreateContextMenu(menu,v,menuInfo);
        getActivity().getMenuInflater().inflate(R.menu.contextmenu_wordslistview,menu);
    }

    public boolean onContextItemSelected(MenuItem item){
        TextView textId = null;
        TextView textWord = null;
        TextView textMeaning = null;
        TextView textSample = null;
        AdapterView.AdapterContextMenuInfo info = null;
        View itemView = null;

        switch (item.getItemId()){
            case R.id.action_delete:
                info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
                itemView = info.targetView;
                textId = (TextView)itemView.findViewById(R.id.textId);
                if(textId != null){
                    String strId = textId.getText().toString();
                    mListener.onDeleteDialog(strId);
                }
                break;
            case R.id.action_update:
                info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
                itemView =info.targetView;
                textId = (TextView) itemView.findViewById(R.id.textId);
                if(textId != null){
                    String strId = textId.getText().toString();
                    mListener.onUpdateDialog(strId);
                }
                break;
        }
        return true;
    }
}
