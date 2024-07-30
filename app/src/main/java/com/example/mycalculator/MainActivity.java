package com.example.mycalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.mycalculator.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText include;
    double result=0;
    //    boolean isOpenBracket = true;
    TextView viewe;
    private String operand1 = "";
    private String operand2 = "";
    private char operator = ' ';
    private boolean isOperand1Completed = false;
    double firstnum=0;
    double secondnum=0;
    String operation="";
    int len;
    double ans;
    Button bt_C, bt7, bt1, bt2, bt3, bt4, bt5, bt6, bt8, bt9, bt0, bt_d, bt_p_m, bt_e, bt_pls, bt_mins, bt_mul, bt_div, bt_bkt, bt_percent, bt_root, bt_pi, bt_exp, bt_pow, bt_fact, bt_sin, bt_cos, bt_tan, bt_cosec, bt_sec, bt_cot, bt_pow10, bt_powe, bt_log, bt_ln;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        include = findViewById(R.id.Edit);
        viewe = findViewById(R.id.textView);
        bt_C = findViewById(R.id.C_button);
        bt1 = findViewById(R.id.one_button);
        bt2 = findViewById(R.id.two_button);
        bt3 = findViewById(R.id.three_button);
        bt4 = findViewById(R.id.four_button);
        bt5 = findViewById(R.id.five_button);
        bt6 = findViewById(R.id.six_button);
        bt7 = findViewById(R.id.seven_button);
        bt8 = findViewById(R.id.eight_button);
        bt9 = findViewById(R.id.nine_button);
        bt0 = findViewById(R.id.zero_button);
        bt_d = findViewById(R.id.dot_button);
        bt_p_m = findViewById(R.id.plus_minus_button);
        bt_e = findViewById(R.id.equal_button);
        bt_pls = findViewById(R.id.plus_button);
        bt_mins = findViewById(R.id.minus_button);
        bt_mul = findViewById(R.id.multiply_button);
        bt_div = findViewById(R.id.divison_button);
        bt_bkt = findViewById(R.id.bracket_button);
        bt_percent = findViewById(R.id.percentage_button);

        ArrayList<Button> number = new ArrayList<>();
        number.add(bt0);
        number.add(bt1);
        number.add(bt2);
        number.add(bt3);
        number.add(bt4);
        number.add(bt5);
        number.add(bt6);
        number.add(bt7);
        number.add(bt8);
        number.add(bt9);
        for (Button b : number) {
            b.setOnClickListener(view -> {
                if (!viewe.getText().toString().equals("0")) {
                    viewe.setText(viewe.getText().toString() + b.getText().toString());
                } else {
                    viewe.setText(b.getText().toString());
                }
            });
        }
        //opers
        ArrayList<Button> opers = new ArrayList<>();
        opers.add(bt_pls);
        opers.add(bt_mins);
        opers.add(bt_mul);
        opers.add(bt_div);
        for (Button b : opers) {
            b.setOnClickListener(view -> {
                firstnum = Double.parseDouble(viewe.getText().toString());
                len=viewe.getText().length();
                operation = b.getText().toString();
                viewe.setText(viewe.getText().toString() + b.getText().toString());
            });
        }

        //for clear bt
        bt_bkt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                removeLastCharacter();
            }

            private void removeLastCharacter() {
                String currentText = viewe.getText().toString();
                if (!currentText.isEmpty()) {
                    String newText = currentText.substring(0, currentText.length() - 1);
                    viewe.setText(newText);
                }
            }
        });
        //for all clear bt
        bt_C.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clearInput();
            }

            private void clearInput() {
                operand1 = "";
                operand2 = "";
                operator = ' ';
                isOperand1Completed = false;
                viewe.setText("0");

            }
        });
        //for equal button
        bt_e.setOnClickListener(view -> {
            String current=viewe.getText().toString();
            //System.out.println(current.substring(len));
            secondnum = Double.parseDouble(current.substring(++len));

            switch (operation) {
                case "/":
                    System.out.println("div");
                    result = firstnum / secondnum;
                    break;
                case "+":
                    System.out.println("pluse");
                    result = firstnum + secondnum;
                    break;
                case "*":
                    System.out.println("multi");
                    result = firstnum * secondnum;
                    break;
                case "-":
                    System.out.println("minus");
                    System.out.println(firstnum);
                    System.out.println(secondnum);
                    result = firstnum - secondnum;
                    break;

            }
            viewe.setText(String.valueOf(result));
            firstnum = result;
        });
    }
}