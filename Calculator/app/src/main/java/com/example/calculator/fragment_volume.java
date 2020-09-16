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

public class fragment_volume extends Fragment {
    TextView show1;
    TextView show2;
    Button num31,num32,num33,num34,num35,num36,num37,num38,num39,num310,num311,num312;
    Button op1,op2;
    AppCompatSpinner sp1,sp2;
    int se1,se2;
    double h[][] = new double[][] {{0,0,0,0,0,0},{0,1,1000,1000000,1000,1000000},{0,0.001,1,1000,1,1000},{0,0.000001,0.001,1,0.001,1},{0,0.001,1,1000,1,1000},{0,0.000001,0.001,1,0.001,1}};
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_volume, container, false);
        return view;
    }
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        show1 = (TextView) getActivity().findViewById(R.id.getnum31);
        show2 = (TextView) getActivity().findViewById(R.id.getnum32);
        show1.setMovementMethod(ScrollingMovementMethod.getInstance());
        show2.setHint("这里输入");
        sp1 = (AppCompatSpinner) getActivity().findViewById(R.id.se5);
        sp1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int pos, long id) {
                String[] volume = getResources().getStringArray(R.array.volume);
                se1 = tr(volume[pos]);
                String x = show2.getText().toString();
                if(x.length() != 0)
                    show1.setText(String.valueOf(transformit(x)));
            }
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        sp2 = (AppCompatSpinner) getActivity().findViewById(R.id.se6);
        sp2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int pos, long id) {
                String[] volume = getResources().getStringArray(R.array.volume);
                se2 = tr(volume[pos]);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        num31 = (Button) getActivity().findViewById(R.id.num31);
        num31.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String x = show2.getText().toString() + '1';
                if(x.length() > 10)
                    show1.setText("没那么大，别按了");
                else {
                    show2.setText(x);
                    show1.setText(String.valueOf(transformit(x)));
                }
            }
        });
        num32 = (Button) getActivity().findViewById(R.id.num32);
        num32.setOnClickListener(new View.OnClickListener() {
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
        num33 = (Button) getActivity().findViewById(R.id.num33);
        num33.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String x = show2.getText().toString() + '3';
                if(x.length() > 10)
                    show1.setText("没那么大，别按了");
                else {
                    show2.setText(x);
                    show1.setText(String.valueOf(transformit(x)));
                }
            }
        });
        num34 = (Button) getActivity().findViewById(R.id.num34);
        num34.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String x = show2.getText().toString() + '4';
                if(x.length() > 10)
                    show1.setText("没那么大，别按了");
                else {
                    show2.setText(x);
                    show1.setText(String.valueOf(transformit(x)));
                }
            }
        });
        num35 = (Button) getActivity().findViewById(R.id.num35);
        num35.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String x = show2.getText().toString() + '5';
                if(x.length() > 10)
                    show1.setText("没那么大，别按了");
                else {
                    show2.setText(x);
                    show1.setText(String.valueOf(transformit(x)));
                }
            }
        });
        num36 = (Button) getActivity().findViewById(R.id.num36);
        num36.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String x = show2.getText().toString() + '6';
                if(x.length() > 10)
                    show1.setText("没那么大，别按了");
                else {
                    show2.setText(x);
                    show1.setText(String.valueOf(transformit(x)));
                }
            }
        });
        num37 = (Button) getActivity().findViewById(R.id.num37);
        num37.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String x = show2.getText().toString() + '7';
                if(x.length() > 10)
                    show1.setText("没那么大，别按了");
                else {
                    show2.setText(x);
                    show1.setText(String.valueOf(transformit(x)));
                }
            }
        });
        num38 = (Button) getActivity().findViewById(R.id.num38);
        num38.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String x = show2.getText().toString() + '8';
                if(x.length() > 10)
                    show1.setText("没那么大，别按了");
                else {
                    show2.setText(x);
                    show1.setText(String.valueOf(transformit(x)));
                }
            }
        });
        num39 = (Button) getActivity().findViewById(R.id.num39);
        num39.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String x = show2.getText().toString() + '9';
                if(x.length() > 10)
                    show1.setText("没那么大，别按了");
                else {
                    show2.setText(x);
                    show1.setText(String.valueOf(transformit(x)));
                }
            }
        });
        num310 = (Button) getActivity().findViewById(R.id.num310);
        num310.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String x = show2.getText().toString() + '.';
                if(x.length() > 10)
                    show1.setText("没那么大，别按了");
                else {
                    show2.setText(x);
                    show1.setText(String.valueOf(transformit(x)));
                }
            }
        });
        num311 = (Button) getActivity().findViewById(R.id.num311);
        num311.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String x = show2.getText().toString() + '0';
                if(x.length() > 10)
                    show1.setText("没那么大，别按了");
                else {
                    show2.setText(x);
                    show1.setText(String.valueOf(transformit(x)));
                }
            }
        });
        num312 = (Button) getActivity().findViewById(R.id.num312);
        num312.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String x = show2.getText().toString() + "00";
                if(x.length() > 10)
                    show1.setText("没那么大，别按了");
                else {
                    show2.setText(x);
                    show1.setText(String.valueOf(transformit(x)));
                }
            }
        });
        op1 = (Button) getActivity().findViewById(R.id.op31);
        op1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                show1.setText(null);
                show2.setText(null);
            }
        });
        op2 = (Button) getActivity().findViewById(R.id.op32);
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
            case "立方米":
                return 1;
            case "立方分米":
                return 2;
            case "立法厘米":
                return 3;
            case "升":
                return 4;
            default :
                return 5;
        }
    }
    private BigDecimal transformit(String t1)
    {
        BigDecimal m = new BigDecimal(t1);
        return m.multiply(new BigDecimal(String.valueOf(h[se2][se1])));
    }
}
