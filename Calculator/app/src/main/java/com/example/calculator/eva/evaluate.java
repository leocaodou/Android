package com.example.calculator.eva;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Stack;

public class evaluate {
    public static BigDecimal standardDeviation(BigDecimal a, int scale) {
        BigDecimal _2=BigDecimal.valueOf(2.0);
        int precision=scale;
        MathContext mc = new MathContext(precision, RoundingMode.HALF_UP); 			//某个操作使用的数字个数；结果舍入到此精度
        if(a.compareTo(BigDecimal.ZERO)==0)
            return new BigDecimal("0");
        else{
            BigDecimal x=a;
            int cnt=0;
            while(cnt<100){
                x=(x.add(a.divide(x,mc))).divide(_2,mc);
                cnt++;
            }
            return x;
        }
    }
    public static int lp(String x)
    {
        switch(x)
        {
            case "+" :
            case "-" :
                return 3;
            case "x" :
            case "÷" :
            case "^" :
                return 5;
            case "(" : return 1;
            case ")" : return 6;
            case "#" : return 0;
            default :return -1;
        }
    }
    public static int rp(String x)
    {
        switch(x)
        {
            case "+" :
            case "-" :
                return 2;
            case "x" :
            case "÷" :
            case "^" :
                return 4;
            case "(" : return 6;
            case ")" : return 1;
            case "#" : return 0;
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
            case '^' : return new BigDecimal(Math.pow(a.doubleValue(),b.doubleValue()));
            default :return x;
        }
    }
    public static String evaluate(String a)//计算器函数，传入一个需要计算的算式
    {
        Stack num = new Stack<BigDecimal>();//用与存储数字的栈
        Stack op = new Stack();//用于存储运算符的栈
        op.push('#');//把运算符的栈底放入‘#’这样知道在什么时候结束
        int l = 0,r = 0;
        for(int i = 0;i < a.length();i++)//循环读取传入的字符串然后进行分类，分为数字和运算符
        {
            if((a.charAt(i) >= 48 && a.charAt(i) <= 57) || a.charAt(i) == '.' || a.charAt(i) == 'π')//如果这个字符为数字或小数点
            {
                if(a.charAt(i) == 'π')
                    num.push(new BigDecimal(Math.PI));
                else {
                    BigDecimal xi = new BigDecimal("0"), zh;//xi表示这段数字的小数部分，zh表示这段数的整数部分
                    zh = new BigDecimal(String.valueOf(a.charAt(i) - 48));//字符具体代表的数字
                    int j = i + 1, k = 0, x = 0;//j+1开始判断下一个字符，k用于存储这段数字当中小数点个数，x为小数的位数
                    while (true) {
                        if (a.charAt(j) == '.') {
                            k++;
                            x++;//有一个小数点，接下来为小数，小数位数为1
                            if (k > 1)//小数点个数大于1，输入错误，程序结束
                            {
                                return "输入错误";
                            }
                        }
                        if (a.charAt(j) >= 48 && a.charAt(j) <= 57) {
                            if (k == 0) {
                                BigDecimal m1 = new BigDecimal("10");
                                BigDecimal m2 = new BigDecimal(String.valueOf(a.charAt(j) - 48));
                                zh = zh.multiply(m1).add(m2);
                            }//k为0说明是整数部分，按整数来计算
                            if (k == 1) {
                                BigDecimal m1 = new BigDecimal(String.valueOf(a.charAt(j) - 48));
                                BigDecimal m2 = new BigDecimal(String.valueOf(Math.pow(0.1, x)));
                                m1 = m1.multiply(m2);
                                xi = xi.add(m1);//k为1说明是小数部分，按小数来计算
                                x++;
                            }
                        }
                        if ((a.charAt(j) < 48 || a.charAt(j) > 57) && a.charAt(j) != '.')//若该字符不为数字或‘.’，重新判断该字符
                        {
                            i = j - 1;
                            break;
                        }
                        j++;
                    }
                    num.push(xi.add(zh));//把小数和整数合并为这段数
                }
                if(String.valueOf(op.peek()).equals("sin") || String.valueOf(op.peek()).equals("cos") || String.valueOf(op.peek()).equals("tan") || String.valueOf(op.peek()).equals("ln") || String.valueOf(op.peek()).equals("√"))
                {
                    BigDecimal x = (BigDecimal)num.peek();
                    double y = x.doubleValue();
                    double f = Math.toRadians(y);
                    switch(op.peek().toString())
                    {
                        case "sin" :
                            double g = Math.sin(f);
                            g = Math.round(g*100);
                            String z = String.valueOf(g/100);
                            x = new BigDecimal(z);
                            break;
                        case "cos" :
                            g = Math.cos(f);
                            g = Math.round(g*100);
                            z = String.valueOf(g/100);
                            x = new BigDecimal(z);
                            break;
                        case "tan" :
                            g = Math.tan(f);
                            g = Math.round(g*100);
                            z = String.valueOf(g/100);
                            x = new BigDecimal(z);
                            break;
                        case "ln" :
                            if(((BigDecimal)num.peek()).doubleValue() > 0)
                                x = new BigDecimal(Math.log(((BigDecimal)num.peek()).doubleValue()));
                            else
                                return "不能求负数或0的对数";
                            break;
                        case "√" :
                            x = standardDeviation((BigDecimal)num.peek(),9);
                            break;
                    }
                    num.pop();
                    op.pop();
                    num.push(x);
                }
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
                if(lp(String.valueOf(a.charAt(i))) == 0 && l != r)
                {
                    return "输入错误";
                }
                if(a.charAt(i) == 's' || a.charAt(i) == 'c' || a.charAt(i) == 't' || a.charAt(i) == 'l' || a.charAt(i) == '√')
                {
                    switch(a.charAt(i))
                    {
                        case 's' :
                            op.push("sin");
                            i+=2;
                            break;
                        case 'c' :
                            op.push("cos");
                            i+=2;
                            break;
                        case 't' :
                            op.push("tan");
                            i+=2;
                            break;
                        case 'l' :
                            op.push("ln");
                            i++;
                            break;
                        case '√' :
                            op.push("√");
                            break;
                    }
                }
                else {
                    while (true) {
                        if (lp(String.valueOf(op.peek())) > rp(String.valueOf(a.charAt(i))))//当前的符号右优先级如果小于栈顶的符号的左优先级，开始运算
                        {
                            if (num.empty())
                                return "输入错误";
                            BigDecimal first = (BigDecimal) num.peek();
                            num.pop();
                            if (num.empty())
                                return "输入错误";
                            BigDecimal sc = (BigDecimal) num.peek();
                            num.pop();
                            if(op.peek().toString().equals("÷") && first.equals(new BigDecimal("0")))
                                return "错误！除数为0";
                            BigDecimal x = operate(sc, first, (char) op.peek());//运算
                            op.pop();//删除运算了后的符号
                            num.push(x);
                        } else
                            break;
                    }

                if(!op.empty()) {
                    if (lp(String.valueOf(a.charAt(i))) == rp(String.valueOf( op.peek())))//消除左右括号以及#
                    {
                        op.pop();
                        if(!op.empty())
                        if(String.valueOf(op.peek()).equals("sin") || String.valueOf(op.peek()).equals("cos") || String.valueOf(op.peek()).equals("tan") || String.valueOf(op.peek()).equals("ln") || String.valueOf(op.peek()).equals("√"))
                        {
                            BigDecimal x = (BigDecimal)num.peek();
                            double y = x.doubleValue();
                            double f = Math.toRadians(y);
                            switch(op.peek().toString())
                            {
                                case "sin" :
                                    double g = Math.sin(f);
                                    g = Math.round(g*100);
                                    String z = String.valueOf(g/100);
                                    x = new BigDecimal(z);
                                    break;
                                case "cos" :
                                    g = Math.cos(f);
                                    g = Math.round(g*100);
                                    z = String.valueOf(g/100);
                                    x = new BigDecimal(z);
                                    break;
                                case "tan" :
                                    g = Math.tan(f);
                                    g = Math.round(g*100);
                                    z = String.valueOf(g/100);
                                    x = new BigDecimal(z);
                                    break;
                                case "ln" :
                                    if(((BigDecimal)num.peek()).doubleValue() > 0)
                                        x = new BigDecimal(Math.log(((BigDecimal)num.peek()).doubleValue()));
                                    else
                                        return "不能求负数或0的对数";
                                    break;
                                case "√" :
                                    x = standardDeviation((BigDecimal)num.peek(),9);
                                    break;
                            }
                            num.pop();
                            op.pop();
                            num.push(x);
                        }
                    }
                    else
                        op.push(a.charAt(i));
                }
                else
                    op.push(a.charAt(i));
                }
            }
        }
        if(op.empty())
            return num.peek().toString();
        else
            return "输入错误";
    }
}
