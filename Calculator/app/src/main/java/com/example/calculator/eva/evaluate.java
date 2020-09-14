package com.example.calculator.eva;

import java.math.BigDecimal;
import java.util.Stack;

public class evaluate {
    public static int lp(char x)
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
    public static int rp(char x)
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
    public static BigDecimal operate(BigDecimal a, BigDecimal b, char c)
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
    public static String evaluate(String a)//计算器函数，传入一个需要计算的算式
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
