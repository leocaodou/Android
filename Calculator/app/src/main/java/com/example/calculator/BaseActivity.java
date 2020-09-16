package com.example.calculator;

import android.os.Bundle;

import androidx.annotation.LayoutRes;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager.widget.ViewPager;

public abstract class BaseActivity extends FragmentActivity {
    protected BaseActivity act;
    protected final String TAG=getClass().getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        act=this;
        setContentView(getLayoutID());
        initView();
        initData();
        initListener();
    }
    @LayoutRes
    protected abstract int getLayoutID();
    protected abstract void initListener();
    protected abstract void initView();
    protected abstract void initData();

    @SuppressWarnings("unchecked")
    protected <E> E f(int id){
        return (E)findViewById(id);
    }
}
