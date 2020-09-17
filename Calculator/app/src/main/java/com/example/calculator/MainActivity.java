package com.example.calculator;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.example.calculator.eva.evaluate;

import java.math.BigDecimal;
import java.util.Stack;

public class MainActivity extends AppCompatActivity {
    TextView show1;
    TextView show2;
    Button num1,num2,num3,num4,num5,num6,num7,num8,num9,num10,num11,num12;
    Button op1,op2,op3,op4,op5,op6,op7,op8,op9,op10,opnum,op12,op13,op14,op15,op16,op17;
    Button sc1,sc2;
    Button help;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        show1 = findViewById(R.id.text1);
        show2 = findViewById(R.id.text2);
        Configuration mConfiguration = this.getResources().getConfiguration();
        int ori = mConfiguration.orientation;
        int num = 11;
        if (ori == mConfiguration.ORIENTATION_LANDSCAPE) {
            num = 18;
        }
        final float textsize = 65;


        final int[] d = {0};
        show1.setHorizontallyScrolling(true);
        show1.setMovementMethod(ScrollingMovementMethod.getInstance());
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
        final int finalNum = num;
        num1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                String x= show2.getText().toString() + '1';
                if(x.length() > finalNum * Math.pow(1.3, d[0])) {
                    d[0]++;
                    show2.setTextSize(textsize / (float)Math.pow(1.3, d[0]) );
                }
                show2.setText(x);
            }
        });
        num2 = (Button) findViewById(R.id.num2);
        num2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                String x= show2.getText().toString() + '2';
                if(x.length() > finalNum * Math.pow(1.3, d[0])) {
                    d[0]++;
                    show2.setTextSize(textsize / (float)Math.pow(1.3, d[0]) );
                }
                show2.setText(x);
            }
        });
        num3 = (Button) findViewById(R.id.num3);
        num3.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                String x= show2.getText().toString() + '3';
                if(x.length() > finalNum * Math.pow(1.3, d[0])) {
                    d[0]++;
                    show2.setTextSize(textsize / (float)Math.pow(1.3, d[0]) );
                }
                show2.setText(x);
            }
        });
        num4 = (Button) findViewById(R.id.num4);
        num4.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                String x= show2.getText().toString() + '4';
                if(x.length() > finalNum * Math.pow(1.3, d[0])) {
                    d[0]++;
                    show2.setTextSize(textsize / (float)Math.pow(1.3, d[0]) );
                }
                show2.setText(x);
            }
        });
        num5 = (Button) findViewById(R.id.num5);
        num5.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                String x= show2.getText().toString() + '5';
                if(x.length() > finalNum * Math.pow(1.3, d[0])) {
                    d[0]++;
                    show2.setTextSize(textsize / (float)Math.pow(1.3, d[0]) );
                }
                show2.setText(x);
            }
        });
        num6 = (Button) findViewById(R.id.num6);
        num6.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                String x= show2.getText().toString() + '6';
                if(x.length() > finalNum * Math.pow(1.3, d[0])) {
                    d[0]++;
                    show2.setTextSize(textsize / (float)Math.pow(1.3, d[0]) );
                }
                show2.setText(x);
            }
        });
        num7 = (Button) findViewById(R.id.num7);
        num7.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                String x= show2.getText().toString() + '7';
                if(x.length() > finalNum * Math.pow(1.3, d[0])) {
                    d[0]++;
                    show2.setTextSize(textsize / (float)Math.pow(1.3, d[0]) );
                }
                show2.setText(x);
            }
        });
        num8 = (Button) findViewById(R.id.num8);
        num8.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                String x= show2.getText().toString() + '8';
                if(x.length() > finalNum * Math.pow(1.3, d[0])) {
                    d[0]++;
                    show2.setTextSize(textsize / (float)Math.pow(1.3, d[0]) );
                }
                show2.setText(x);
            }
        });
        num9 = (Button) findViewById(R.id.num9);
        num9.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                String x= show2.getText().toString() + '9';
                if(x.length() > finalNum * Math.pow(1.3, d[0])) {
                    d[0]++;
                    show2.setTextSize(textsize / (float)Math.pow(1.3, d[0]) );
                }
                show2.setText(x);
            }
        });
        num10 = (Button) findViewById(R.id.num10);
        num10.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                String x= show2.getText().toString() + '.';
                if(x.length() > finalNum * Math.pow(1.3, d[0])) {
                    d[0]++;
                    show2.setTextSize(textsize / (float)Math.pow(1.3, d[0]) );
                }
                show2.setText(x);
            }
        });
        num11 = (Button) findViewById(R.id.num11);
        num11.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                String x= show2.getText().toString() + '0';
                if(x.length() > finalNum * Math.pow(1.3, d[0])) {
                    d[0]++;
                    show2.setTextSize(textsize / (float)Math.pow(1.3, d[0]) );
                }
                show2.setText(x);
            }
        });
        num12 = (Button) findViewById(R.id.num12);
        num12.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                String x= show2.getText().toString() + "00";
                if(x.length() > finalNum * Math.pow(1.3, d[0])) {
                    d[0]++;
                    show2.setTextSize(textsize / (float)Math.pow(1.3, d[0]) );
                }
                show2.setText(x);
            }
        });
        op1 = (Button) findViewById(R.id.op1);
        op1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                show1.setText(null);
                show2.setText(null);
                d[0] = 0;
                show2.setTextSize(textsize);
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
                if(x.length() < finalNum * Math.pow(1.3, d[0]-1) && d[0] != 0) {
                    d[0]--;
                    show2.setTextSize(textsize / (float)Math.pow(1.3, d[0]) );
                }
            }
        });
        op3 = (Button) findViewById(R.id.op3);
        op3.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                String x= show2.getText().toString() + '(';
                if(x.length() > finalNum * Math.pow(1.3, d[0])) {
                    d[0]++;
                    show2.setTextSize(textsize / (float)Math.pow(1.3, d[0]) );
                }
                show2.setText(x);
            }
        });
        op4 = (Button) findViewById(R.id.op4);
        op4.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                String x= show2.getText().toString() + ')';
                if(x.length() > finalNum * Math.pow(1.3, d[0])) {
                    d[0]++;
                    show2.setTextSize(textsize / (float)Math.pow(1.3, d[0]) );
                }
                show2.setText(x);
            }
        });
        op5 = (Button) findViewById(R.id.op5);
        op5.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                String x= show2.getText().toString() + '+';
                if(x.length() > finalNum * Math.pow(1.3, d[0])) {
                    d[0]++;
                    show2.setTextSize(textsize / (float)Math.pow(1.3, d[0]) );
                }
                show2.setText(x);
            }
        });
        op6 = (Button) findViewById(R.id.op6);
        op6.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                String x= show2.getText().toString() + '-';
                if(x.length() > finalNum * Math.pow(1.3, d[0])) {
                    d[0]++;
                    show2.setTextSize(textsize / (float)Math.pow(1.3, d[0]) );
                }
                show2.setText(x);
            }
        });
        op7 = (Button) findViewById(R.id.op7);
        op7.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                String x= show2.getText().toString() + 'x';
                if(x.length() > finalNum * Math.pow(1.3, d[0])) {
                    d[0]++;
                    show2.setTextSize(textsize / (float)Math.pow(1.3, d[0]) );
                }
                show2.setText(x);
            }
        });
        op8 = (Button) findViewById(R.id.op8);
        op8.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                String x= show2.getText().toString() + '÷';
                if(x.length() > finalNum * Math.pow(1.3, d[0])) {
                    d[0]++;
                    show2.setTextSize(textsize / (float)Math.pow(1.3, d[0]) );
                }
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

        if (ori == mConfiguration.ORIENTATION_LANDSCAPE) {
            op10 = (Button) findViewById(R.id.op10);
            op10.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String x = show2.getText().toString() + "sin";
                    if(x.length() > finalNum * Math.pow(1.3, d[0])) {
                        d[0]++;
                        show2.setTextSize(textsize / (float)Math.pow(1.3, d[0]) );
                    }
                    show2.setText(x);
                }
            });
            opnum = (Button) findViewById(R.id.op11);
            opnum.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String x = show2.getText().toString() + "cos";
                    if(x.length() > finalNum * Math.pow(1.3, d[0])) {
                        d[0]++;
                        show2.setTextSize(textsize / (float)Math.pow(1.3, d[0]) );
                    }
                    show2.setText(x);
                }
            });
            op12 = (Button) findViewById(R.id.op12);
            op12.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String x = show2.getText().toString() + "tan";
                    if(x.length() > finalNum * Math.pow(1.3, d[0])) {
                        d[0]++;
                        show2.setTextSize(textsize / (float)Math.pow(1.3, d[0]) );
                    }
                    show2.setText(x);
                }
            });
            op13 = (Button) findViewById(R.id.op13);
            op13.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String x = show2.getText().toString() + "ln";
                    if(x.length() > finalNum * Math.pow(1.3, d[0])) {
                        d[0]++;
                        show2.setTextSize(textsize / (float)Math.pow(1.3, d[0]) );
                    }
                    show2.setText(x);
                }
            });
            op14 = (Button) findViewById(R.id.op14);
            op14.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String x = show2.getText().toString() + "^";
                    if(x.length() > finalNum * Math.pow(1.3, d[0])) {
                        d[0]++;
                        show2.setTextSize(textsize / (float)Math.pow(1.3, d[0]) );
                    }
                    show2.setText(x);
                }
            });
            op15 = (Button) findViewById(R.id.op15);
            op15.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String x = show2.getText().toString() + "π";
                    if(x.length() > finalNum * Math.pow(1.3, d[0])) {
                        d[0]++;
                        show2.setTextSize(textsize / (float)Math.pow(1.3, d[0]) );
                    }
                    show2.setText(x);
                }
            });
            op16 = (Button) findViewById(R.id.op16);
            op16.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String x = show2.getText().toString() + "√";
                    if(x.length() > finalNum * Math.pow(1.3, d[0])) {
                        d[0]++;
                        show2.setTextSize(textsize / (float)Math.pow(1.3, d[0]) );
                    }
                    show2.setText(x);
                }
            });
            op17 = (Button) findViewById(R.id.op17);
            op17.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(MainActivity.this,transform.class);
                    startActivityForResult(intent,0);
                }
            });
        }
        else {
            sc1 = (Button) findViewById(R.id.sc1);
            sc1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {

                }
            });
            sc2 = (Button) findViewById(R.id.sc2);
            sc2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(MainActivity.this,transform.class);
                    startActivityForResult(intent,0);
                }
            });
            help = (Button) findViewById(R.id.help);
            help.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View view) {
                    AlertDialog.Builder builder=
                            new AlertDialog.Builder(MainActivity.this);
                    final View viewDialog = LayoutInflater.from(MainActivity.this).inflate(R.layout.dialog,null,false);
                    builder.setTitle("帮助")
                            .setView(viewDialog)
                            .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                }
                            });
                    builder.create().show();
                }
            });
        }
    }
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState){
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putString("show1",show1.getText().toString());
        savedInstanceState.putString("show2",show2.getText().toString());
    }

//    private void showPopupMenu(View view) {           //菜单
//        PopupMenu popupMenu = new PopupMenu(this, view);
//        popupMenu.getMenuInflater().inflate(R.menu.popupmenu, popupMenu.getMenu());
//        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
//            @Override
//            public boolean onMenuItemClick(MenuItem item) {
//                Toast.makeText(getApplicationContext(), item.getTitle(), Toast.LENGTH_SHORT).show();
//                return false;
//            }
//        });
//        popupMenu.setOnDismissListener(new PopupMenu.OnDismissListener() {
//            @Override
//            public void onDismiss(PopupMenu menu) {
//                Toast.makeText(getApplicationContext(), "关闭PopupMenu", Toast.LENGTH_SHORT).show();
//            }
//        });
//        popupMenu.show();
//    }
}
