package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.calculator.eva.evaluate;

import java.math.BigDecimal;
import java.util.Stack;

public class MainActivity extends AppCompatActivity {
    TextView show1;
    TextView show2;
    Button num1,num2,num3,num4,num5,num6,num7,num8,num9,num10,num11,num12;
    Button op1,op2,op3,op4,op5,op6,op7,op8,op9;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        show1 = findViewById(R.id.text1);
        show2 = findViewById(R.id.text2);
        show1.setMovementMethod(new ScrollingMovementMethod());
        show1.setHorizontallyScrolling(true);
        show2.setMovementMethod(new ScrollingMovementMethod());
        show2.setHorizontallyScrolling(true);
        int line = show1.getLineCount();
        if (line > 9) {
            int offset = show1.getLineCount() * show1.getLineHeight();
            show1.scrollTo(0, offset - show1.getHeight() + show1.getLineHeight());
        }
        int line2 = show2.getLineCount();
        if (line2 > 9) {
            int offset = show2.getLineCount() * show2.getLineHeight();
            show2.scrollTo(0, offset - show2.getHeight() + show2.getLineHeight());
        }
        if(savedInstanceState != null) {
            show1.setText(savedInstanceState.getString("show1"));
            show2.setText(savedInstanceState.getString("show2"));
        }
        num1 = (Button) findViewById(R.id.num1);
        num1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                String x= show2.getText().toString() + '1';
                show2.setText(x);
            }
        });
        num2 = (Button) findViewById(R.id.num2);
        num2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                String x= show2.getText().toString() + '2';
                show2.setText(x);
            }
        });
        num3 = (Button) findViewById(R.id.num3);
        num3.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                String x= show2.getText().toString() + '3';
                show2.setText(x);
            }
        });
        num4 = (Button) findViewById(R.id.num4);
        num4.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                String x= show2.getText().toString() + '4';
                show2.setText(x);
            }
        });
        num5 = (Button) findViewById(R.id.num5);
        num5.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                String x= show2.getText().toString() + '5';
                show2.setText(x);
            }
        });
        num6 = (Button) findViewById(R.id.num6);
        num6.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                String x= show2.getText().toString() + '6';
                show2.setText(x);
            }
        });
        num7 = (Button) findViewById(R.id.num7);
        num7.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                String x= show2.getText().toString() + '7';
                show2.setText(x);
            }
        });
        num8 = (Button) findViewById(R.id.num8);
        num8.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                String x= show2.getText().toString() + '8';
                show2.setText(x);
            }
        });
        num9 = (Button) findViewById(R.id.num9);
        num9.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                String x= show2.getText().toString() + '9';
                show2.setText(x);
            }
        });
        num10 = (Button) findViewById(R.id.num10);
        num10.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                String x= show2.getText().toString() + '.';
                show2.setText(x);
            }
        });
        num11 = (Button) findViewById(R.id.num11);
        num11.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                String x= show2.getText().toString() + '0';
                show2.setText(x);
            }
        });
        num12 = (Button) findViewById(R.id.num12);
        num12.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                String x= show2.getText().toString() + "00";
                show2.setText(x);
            }
        });
        op1 = (Button) findViewById(R.id.op1);
        op1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                String x= null;
                show1.setText(x);
                show2.setText(x);
            }
        });
        op2 = (Button) findViewById(R.id.op2);
        op2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                String x= show2.getText().toString();
                if(x.length()!=0)
                    x=x.substring(0,x.length()-1);
                show2.setText(x);
            }
        });
        op3 = (Button) findViewById(R.id.op3);
        op3.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                String x= show2.getText().toString() + '(';
                show2.setText(x);
            }
        });
        op4 = (Button) findViewById(R.id.op4);
        op4.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                String x= show2.getText().toString() + ')';
                show2.setText(x);
            }
        });
        op5 = (Button) findViewById(R.id.op5);
        op5.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                String x= show2.getText().toString() + '+';
                show2.setText(x);
            }
        });
        op6 = (Button) findViewById(R.id.op6);
        op6.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                String x= show2.getText().toString() + '-';
                show2.setText(x);
            }
        });
        op7 = (Button) findViewById(R.id.op7);
        op7.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                String x= show2.getText().toString() + 'x';
                show2.setText(x);
            }
        });
        op8 = (Button) findViewById(R.id.op8);
        op8.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                String x= show2.getText().toString() + '÷';
                show2.setText(x);
            }
        });
        op9 = (Button) findViewById(R.id.op9);
        op9.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                String x = show2.getText().toString();
                show1.setText(x + '=');
                x += '#';
                String y = evaluate.evaluate(x).toString();
                show2.setText(y);
            }
        });
    }
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState){
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putString("show1",show1.getText().toString());
        savedInstanceState.putString("show2",show2.getText().toString());
    }

}