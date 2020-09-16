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

public class fragment_length extends Fragment {
    TextView show1;
    TextView show2;
    Button num21,num22,num23,num24,num25,num26,num27,num28,num29,num210,num211,num212;
    Button op1,op2;
    AppCompatSpinner sp1,sp2;
    int se1,se2;
    double h[][] = new double[][] {{0,0,0,0,0,0,0},{0,1,0.001,100,1000,1000000,1000000000},{0,1000,1,100000,1000000,1000000000,1000000000000.0},{0,0.001,0.00001,1,10,10000,10000000},{0,0.0001,0.000001,0.1,1,1000,1000000},{0,0.0000001,0.000000001,0.0001,0.001,1,1000},{0,0.0000000001,0.000000000001,0.0000001,0.000001,0.001,1}};
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_length, container, false);
        return view;
    }
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        show1 = (TextView) getActivity().findViewById(R.id.getnum21);
        show2 = (TextView) getActivity().findViewById(R.id.getnum22);
        show1.setMovementMethod(ScrollingMovementMethod.getInstance());
        show2.setHint("这里输入");
        sp1 = (AppCompatSpinner) getActivity().findViewById(R.id.se3);
        sp1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int pos, long id) {
                String[] length = getResources().getStringArray(R.array.length);
                se1 = tr(length[pos]);
                String x = show2.getText().toString();
                if(x.length() != 0)
                    show1.setText(String.valueOf(transformit(x)));
            }
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        sp2 = (AppCompatSpinner) getActivity().findViewById(R.id.se4);
        sp2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int pos, long id) {
                String[] length = getResources().getStringArray(R.array.length);
                se2 = tr(length[pos]);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        num21 = (Button) getActivity().findViewById(R.id.num21);
        num21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String x = show2.getText().toString() + '1';
                if(x.length() > 10)
                    show1.setText("没那么长，别按了");
                else {
                    show2.setText(x);
                    show1.setText(String.valueOf(transformit(x)));
                }
            }
        });
        num22 = (Button) getActivity().findViewById(R.id.num22);
        num22.setOnClickListener(new View.OnClickListener() {
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
        num23 = (Button) getActivity().findViewById(R.id.num23);
        num23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String x = show2.getText().toString() + '3';
                if(x.length() > 10)
                    show1.setText("没那么长，别按了");
                else {
                    show2.setText(x);
                    show1.setText(String.valueOf(transformit(x)));
                }
            }
        });
        num24 = (Button) getActivity().findViewById(R.id.num24);
        num24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String x = show2.getText().toString() + '4';
                if(x.length() > 10)
                    show1.setText("没那么长，别按了");
                else {
                    show2.setText(x);
                    show1.setText(String.valueOf(transformit(x)));
                }
            }
        });
        num25 = (Button) getActivity().findViewById(R.id.num25);
        num25.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String x = show2.getText().toString() + '5';
                if(x.length() > 10)
                    show1.setText("没那么长，别按了");
                else {
                    show2.setText(x);
                    show1.setText(String.valueOf(transformit(x)));
                }
            }
        });
        num26 = (Button) getActivity().findViewById(R.id.num26);
        num26.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String x = show2.getText().toString() + '6';
                if(x.length() > 10)
                    show1.setText("没那么长，别按了");
                else {
                    show2.setText(x);
                    show1.setText(String.valueOf(transformit(x)));
                }
            }
        });
        num27 = (Button) getActivity().findViewById(R.id.num27);
        num27.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String x = show2.getText().toString() + '7';
                if(x.length() > 10)
                    show1.setText("没那么长，别按了");
                else {
                    show2.setText(x);
                    show1.setText(String.valueOf(transformit(x)));
                }
            }
        });
        num28 = (Button) getActivity().findViewById(R.id.num28);
        num28.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String x = show2.getText().toString() + '8';
                if(x.length() > 10)
                    show1.setText("没那么长，别按了");
                else {
                    show2.setText(x);
                    show1.setText(String.valueOf(transformit(x)));
                }
            }
        });
        num29 = (Button) getActivity().findViewById(R.id.num29);
        num29.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String x = show2.getText().toString() + '9';
                if(x.length() > 10)
                    show1.setText("没那么长，别按了");
                else {
                    show2.setText(x);
                    show1.setText(String.valueOf(transformit(x)));
                }
            }
        });
        num210 = (Button) getActivity().findViewById(R.id.num210);
        num210.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String x = show2.getText().toString() + '.';
                if(x.length() > 10)
                    show1.setText("没那么长，别按了");
                else {
                    show2.setText(x);
                    show1.setText(String.valueOf(transformit(x)));
                }
            }
        });
        num211 = (Button) getActivity().findViewById(R.id.num211);
        num211.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String x = show2.getText().toString() + '0';
                if(x.length() > 10)
                    show1.setText("没那么长，别按了");
                else {
                    show2.setText(x);
                    show1.setText(String.valueOf(transformit(x)));
                }
            }
        });
        num212 = (Button) getActivity().findViewById(R.id.num212);
        num212.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String x = show2.getText().toString() + "00";
                if(x.length() > 10)
                    show1.setText("没那么长，别按了");
                else {
                    show2.setText(x);
                    show1.setText(String.valueOf(transformit(x)));
                }
            }
        });
        op1 = (Button) getActivity().findViewById(R.id.op21);
        op1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                show1.setText(null);
                show2.setText(null);
            }
        });
        op2 = (Button) getActivity().findViewById(R.id.op22);
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
            case "米":
                return 1;
            case "千米":
                return 2;
            case "厘米":
                return 3;
            case "毫米":
                return 4;
            case "纳米":
                return 5;
            default :
                return 6;
        }
    }
    private BigDecimal transformit(String t1)
    {
        BigDecimal m = new BigDecimal(t1);
        return m.multiply(new BigDecimal(String.valueOf(h[se2][se1])));
    }
}
