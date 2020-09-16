package com.example.calculator;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatSpinner;
import androidx.fragment.app.Fragment;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class fragment_money extends Fragment {
    TextView show1;
    TextView show2;
    Button num1,num2,num3,num4,num5,num6,num7,num8,num9,num10,num11,num12;
    Button op1,op2;
    AppCompatSpinner sp1,sp2;
    int se1,se2;
    double h[][] = new double[][] {{0,0,0,0,0},{0,1,0.148,15.5614,0.1247},{0,6.7584,1,105.17,0.8426},{0,0.06426,0.00105,1,0.008012},{0,8.02010,1.1868,124.8158,1}};
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_money, container, false);
        return view;
    }
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        show1 = (TextView) getActivity().findViewById(R.id.getnum1);
        show2 = (TextView) getActivity().findViewById(R.id.getnum2);
        show1.setMovementMethod(ScrollingMovementMethod.getInstance());
        show2.setHint("这里输入");
        sp1 = (AppCompatSpinner) getActivity().findViewById(R.id.se1);
        sp1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int pos, long id) {
                String[] money = getResources().getStringArray(R.array.money);
                se1 = tr(money[pos]);
                String x = show2.getText().toString();
                if(x.length() != 0)
                        show1.setText(String.valueOf(transformit(x)));
            }
        public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        sp2 = (AppCompatSpinner) getActivity().findViewById(R.id.se2);
        sp2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int pos, long id) {
                String[] money = getResources().getStringArray(R.array.money);
                se2 = tr(money[pos]);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        num1 = (Button) getActivity().findViewById(R.id.num1);
        num1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String x = show2.getText().toString() + '1';
                if(x.length() > 10)
                    show1.setText("没有那么多钱啊，别按了");
                else {
                    show2.setText(x);
                    show1.setText(String.valueOf(transformit(x)));
                }
            }
        });
        num2 = (Button) getActivity().findViewById(R.id.num2);
        num2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String x = show2.getText().toString() + '2';
                if(x.length() > 10)
                    Toast.makeText(getActivity(),"没那么多钱啊,别按了",Toast.LENGTH_LONG);
                else {
                    show2.setText(x);
                    show1.setText(String.valueOf(transformit(x)));
                }
            }
        });
        num3 = (Button) getActivity().findViewById(R.id.num3);
        num3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String x = show2.getText().toString() + '3';
                if(x.length() > 10)
                    show1.setText("没有那么多钱啊，别按了");
                else {
                    show2.setText(x);
                    show1.setText(String.valueOf(transformit(x)));
                }
            }
        });
        num4 = (Button) getActivity().findViewById(R.id.num4);
        num4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String x = show2.getText().toString() + '4';
                if(x.length() > 10)
                    show1.setText("没有那么多钱啊，别按了");
                else {
                    show2.setText(x);
                    show1.setText(String.valueOf(transformit(x)));
                }
            }
        });
        num5 = (Button) getActivity().findViewById(R.id.num5);
        num5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String x = show2.getText().toString() + '5';
                if(x.length() > 10)
                    show1.setText("没有那么多钱啊，别按了");
                else {
                    show2.setText(x);
                    show1.setText(String.valueOf(transformit(x)));
                }
            }
        });
        num6 = (Button) getActivity().findViewById(R.id.num6);
        num6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String x = show2.getText().toString() + '6';
                if(x.length() > 10)
                    show1.setText("没有那么多钱啊，别按了");
                else {
                    show2.setText(x);
                    show1.setText(String.valueOf(transformit(x)));
                }
            }
        });
        num7 = (Button) getActivity().findViewById(R.id.num7);
        num7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String x = show2.getText().toString() + '7';
                if(x.length() > 10)
                    show1.setText("没有那么多钱啊，别按了");
                else {
                    show2.setText(x);
                    show1.setText(String.valueOf(transformit(x)));
                }
            }
        });
        num8 = (Button) getActivity().findViewById(R.id.num8);
        num8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String x = show2.getText().toString() + '8';
                if(x.length() > 10)
                    show1.setText("没有那么多钱啊，别按了");
                else {
                    show2.setText(x);
                    show1.setText(String.valueOf(transformit(x)));
                }
            }
        });
        num9 = (Button) getActivity().findViewById(R.id.num9);
        num9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String x = show2.getText().toString() + '9';
                if(x.length() > 10)
                    show1.setText("没有那么多钱啊，别按了");
                else {
                    show2.setText(x);
                    show1.setText(String.valueOf(transformit(x)));
                }
            }
        });
        num10 = (Button) getActivity().findViewById(R.id.num10);
        num10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String x = show2.getText().toString() + '.';
                if(x.length() > 10)
                    show1.setText("没有那么多钱啊，别按了");
                else {
                    show2.setText(x);
                    show1.setText(String.valueOf(transformit(x)));
                }
            }
        });
        num11 = (Button) getActivity().findViewById(R.id.num11);
        num11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String x = show2.getText().toString() + '0';
                if(x.length() > 10)
                    show1.setText("没有那么多钱啊，别按了");
                else {
                    show2.setText(x);
                    show1.setText(String.valueOf(transformit(x)));
                }
            }
        });
        num12 = (Button) getActivity().findViewById(R.id.num12);
        num12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String x = show2.getText().toString() + "00";
                if(x.length() > 10)
                    show1.setText("没有那么多钱啊，别按了");
                else {
                    show2.setText(x);
                    show1.setText(String.valueOf(transformit(x)));
                }
            }
        });
        op1 = (Button) getActivity().findViewById(R.id.op1);
        op1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                show1.setText(null);
                show2.setText(null);
            }
        });
        op2 = (Button) getActivity().findViewById(R.id.op2);
        op2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String x = show2.getText().toString();
                if (x.length() != 0) {
                    x = x.substring(0, x.length() - 1);
                }
                if(x.length() != 0)
                    show1.setText(String.valueOf(transformit(x)));
                else
                    show1.setText("");
                show2.setText(x);

            }
        });
    }
    private int tr(String x)
    {
        switch (x) {
            case "人民币":
                return 1;
            case "美元":
                return 2;
            case "日元":
                return 3;
            default:
                return 4;
        }
    }
    private BigDecimal transformit(String t1)
    {
        BigDecimal m = new BigDecimal(t1);
        return m.multiply(new BigDecimal(String.valueOf(h[se2][se1])));
    }
}
