package com.example.calculator;

import androidx.annotation.IdRes;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

import java.util.ArrayList;
import java.util.List;

public class transform extends BaseActivity {
    private ViewPager vp;
    private RadioGroup rg;
    private Button sc;
    private int[] rbs = {R.id.rb_money, R.id.rb_length, R.id.rb_volume};
    private List<Fragment> mFragments;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sc = (Button) findViewById(R.id.sc1);
        sc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
    //简化后的方法
    @Override
    protected int getLayoutID() {
        return R.layout.activity_transform;
    }

    @Override
    protected void initView() {
        vp = f(R.id.vp);
        rg = f(R.id.rg);
    }
    @Override
    protected void initData() {

        mFragments=new ArrayList<>();
        fragment_money one=new fragment_money();
        fragment_length two=new fragment_length();
        fragment_volume three=new fragment_volume();
        mFragments.add(one);
        mFragments.add(two);
        mFragments.add(three);

        // 设置填充器
        vp.setAdapter(new PaperMainAdapter(getSupportFragmentManager(),mFragments));
        // 设置缓存页面数
        vp.setOffscreenPageLimit(2);

    }

    @Override
    protected void initListener() {
        //radioGroup的点击事件
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                for (int i = 0; i < rbs.length; i++) {
                    if (rbs[i] != checkedId) continue;
                    //加载滑动
                    vp.setCurrentItem(i);
                }
            }
        });
        //ViewPager的点击事件 vp-rg互相监听：vp
        vp.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                rg.check(rbs[position]);
            }
        });
        //设置一个默认页
        rg.check(rbs[0]);
    }
}
