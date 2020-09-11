package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

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
                show1.setText(x);
                x += '#';
                String y = evaluate(x).toString();
                show2.setText(y);
            }
        });
    }
    public int lp(char x)
    {
        switch(x)
        {
            case '+' :
            case '-' :
                return 3;
            case 'x' :
            case '÷' :
                return 5;
            case '(' : return 1;
            case ')' : return 6;
            case '#' : return 0;
            default :return -1;
        }
    }
    public int rp(char x)
    {
        switch(x)
        {
            case '+' :
            case '-' :
                return 2;
            case 'x' :
            case '÷' :
                return 4;
            case '(' : return 6;
            case ')' : return 1;
            case '#' : return 0;
            default :return -1;
        }
    }
    public BigDecimal operate(BigDecimal a,BigDecimal b,char c)
    {
        BigDecimal x = new BigDecimal("-1");
        switch(c)
        {
            case '+' : return a.add(b);
            case '-' : return a.subtract(b);
            case 'x' : return a.multiply(b);
            case '÷' : return a.divide(b,9,BigDecimal.ROUND_HALF_UP);
            default :return x;
        }
    }
    public String evaluate(String a)//计算器函数，传入一个需要计算的算式
    {
        Stack num = new Stack();//用与存储数字的栈
        Stack op = new Stack();//用于存储运算符的栈
        op.push('#');//把运算符的栈底放入‘#’这样知道在什么时候结束
        int l = 0,r = 0;
        for(int i = 0;i < a.length();i++)//循环读取传入的字符串然后进行分类，分为数字和运算符
        {
            if((a.charAt(i) >= 48 && a.charAt(i) <= 57) || a.charAt(i) == '.')//如果这个字符为数字或小数点
            {
                BigDecimal xi = new BigDecimal("0"),zh = new BigDecimal("0");//xi表示这段数字的小数部分，zh表示这段数的整数部分
                zh = new BigDecimal(String.valueOf(a.charAt(i) - 48));//字符具体代表的数字
                int j = i + 1,k = 0,x = 0;//j+1开始判断下一个字符，k用于存储这段数字当中小数点个数，x为小数的位数
                while(true)
                {
                    if(a.charAt(j) == '.')
                    {
                        k++;
                        x++;//有一个小数点，接下来为小数，小数位数为1
                        if(k > 1)//小数点个数大于1，输入错误，程序结束
                        {
                            return "输入错误";
                        }
                    }
                    if(a.charAt(j) >= 48 && a.charAt(j) <= 57 )
                    {
                        if(k == 0) {
                            BigDecimal m1 = new BigDecimal("10");
                            BigDecimal m2 = new BigDecimal(String.valueOf(a.charAt(j) - 48));
                            zh = zh.multiply(m1).add(m2);
                        }//k为0说明是整数部分，按整数来计算
                        if(k == 1)
                        {
                            BigDecimal m1 = new BigDecimal(String.valueOf(a.charAt(j) - 48));
                            BigDecimal m2 = new BigDecimal(String.valueOf(Math.pow(0.1,x)));
                            m1 = m1.multiply(m2);
                            xi = xi.add(m1);//k为1说明是小数部分，按小数来计算
                            x++;
                        }
                    }
                    if((a.charAt(j) < 48 || a.charAt(j) > 57) && a.charAt(j) != '.')//若该字符不为数字或‘.’，重新判断该字符
                    {
                        i = j - 1;
                        break;
                    }
                    j++;
                }
                num.push(xi.add(zh));//把小数和整数合并为这段数
            }
            else
            {
                if(a.charAt(i) == '(')
                    l++;
                if(a.charAt(i) == ')')
                {
                    r++;
                    if(r > l)//若右括号多于左括号，说明输入错误
                    {
                        return "输入错误";
                    }
                }
                if(op.empty())
                {
                    return num.peek().toString();//运算符栈空，直接输出结果
                }
                if(lp(a.charAt(i)) == 0 && l != r)
                {
                    return "输入错误";
                }
                while(true)
                {
                    if(lp((char)op.peek()) > rp(a.charAt(i)))//当前的符号右优先级如果小于栈顶的符号的左优先级，开始运算
                    {
                        if(num.empty())
                            return "输入错误";
                        BigDecimal first = (BigDecimal)num.peek();
                        num.pop();
                        if(num.empty())
                            return "输入错误";
                        BigDecimal sc = (BigDecimal)num.peek();
                        num.pop();
                        BigDecimal x = operate(sc,first,(char)op.peek());//运算
                        op.pop();//删除运算了后的符号
                        num.push(x);
                    }
				else
                    break;
                }
                if(!op.empty()) {
                    if (lp(a.charAt(i)) == rp((char)op.peek()))//消除左右括号以及#
                    {
                        op.pop();
                    }
                    else
                        op.push(a.charAt(i));
                }
                else
                    op.push(a.charAt(i));
            }
        }
        return num.peek().toString();
    }
}