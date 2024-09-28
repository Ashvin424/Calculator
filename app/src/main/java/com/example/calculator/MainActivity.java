package com.example.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.button.MaterialButton;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

public class MainActivity extends AppCompatActivity{
    TextView result, solution;
    MaterialButton buttonC, buttonBrackOpen, buttonBrackClose;
    MaterialButton buttonDevide, buttonMultiply, buttonSubtract, buttonAdd, buttonEquals;
    MaterialButton button4, button5, button6, button1, button2, button3, button7, button8, button9, button0;
    MaterialButton buttonAC, buttonDot;
    String data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        result = findViewById(R.id.result);
        solution = findViewById(R.id.solution);
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        result = findViewById(R.id.result);
        solution = findViewById(R.id.solution);
        button0 = findViewById(R.id.button_0);
        button1 = findViewById(R.id.button_1);
        button2 = findViewById(R.id.button_2);
        button3 = findViewById(R.id.button_3);
        button4 = findViewById(R.id.button_4);
        button5 = findViewById(R.id.button_5);
        button6 = findViewById(R.id.button_6);
        button7 = findViewById(R.id.button_7);
        button8 = findViewById(R.id.button_8);
        button9 = findViewById(R.id.button_9);
        buttonAC = findViewById(R.id.button_ac);
        buttonDot = findViewById(R.id.button_dot);
        buttonEquals = findViewById(R.id.button_equals);
        buttonC = findViewById(R.id.button_C);
        buttonBrackOpen = findViewById(R.id.button_open_bracket);
        buttonBrackClose = findViewById(R.id.button_close_bracket);
        buttonDevide = findViewById(R.id.button_devide);
        buttonMultiply = findViewById(R.id.button_multiply);
        buttonAdd = findViewById(R.id.button_add);
        buttonSubtract = findViewById(R.id.button_subtract);


        buttonBrackOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = solution.getText().toString();
                solution.setText(data+"(");
            }
        });
        buttonBrackClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = solution.getText().toString();
                solution.setText(data+")");
            }
        });
        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = solution.getText().toString();
                solution.setText(data+"0");
            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = solution.getText().toString();
                solution.setText(data+"1");
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = solution.getText().toString();
                solution.setText(data+"2");
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = solution.getText().toString();
                solution.setText(data+"3");
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = solution.getText().toString();
                solution.setText(data+"4");
            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = solution.getText().toString();
                solution.setText(data+"5");
            }
        });
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = solution.getText().toString();
                solution.setText(data+"6");
            }
        });
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = solution.getText().toString();
                solution.setText(data+"7");
            }
        });
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = solution.getText().toString();
                solution.setText(data+"8");
            }
        });
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = solution.getText().toString();
                solution.setText(data+"9");
            }
        });
        buttonDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = solution.getText().toString();
                solution.setText(data+".");
            }
        });
        buttonAC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                solution.setText("");
                result.setText("0");
            }
        });
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = solution.getText().toString();
                solution.setText(data+"+");
            }
        });
        buttonSubtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = solution.getText().toString();
                solution.setText(data+"-");
            }
        });
        buttonMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = solution.getText().toString();
                solution.setText(data+"*");
            }
        });
        buttonDevide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = solution.getText().toString();
                solution.setText(data+"/");
            }
        });
        buttonBrackOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = solution.getText().toString();
                solution.setText(data+"(");
            }
        });
        buttonBrackClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = solution.getText().toString();
                solution.setText(data+")");
            }
        });
        buttonEquals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = solution.getText().toString();

                try {
                    Context rhino = Context.enter();
                    rhino.setOptimizationLevel(-1);
                    String finalResult = "";
                    Scriptable scriptable = rhino.initStandardObjects();
                    finalResult = rhino.evaluateString(scriptable, data, "Javascript", 1, null).toString();

                    result.setText(finalResult);
                    if(data == ""){
                        result.setText("");
                    }
                }
                catch(Exception e){
                    result.setText("ERROR");
                }
            }
        });
        buttonC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = solution.getText().toString();
//                solution.setText(data+"%");
                try {
                    if (data == "") {
                        solution.setText("");
                    } else {
                        String string = solution.getText().toString();
                        StringBuffer sb = new StringBuffer(string);
                        sb.deleteCharAt(sb.length() - 1);
                        data = sb.toString();
                        solution.setText(data);
                    }
                }
                catch(Exception e){
                    solution.setText("");
                }
            }
        });

    }

}