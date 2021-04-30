package com.example.todo_9;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static final String TAG=MainActivity.class.getSimpleName();
    public Calculator mCalculator;
    private EditText editText1;
    private EditText editText2;
    private TextView Result;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mCalculator = new Calculator();
        setContentView(R.layout.activity_main);
        editText1 = findViewById(R.id.edt1);
        editText2 = findViewById(R.id.edt2);
        Result = findViewById(R.id.result);

    }

    public void add(View view) {
        String operand1 = editText1.getText().toString();
        String operand2 = editText2.getText().toString();
        double value = mCalculator.add(Double.valueOf(operand1), Double.valueOf(operand2));
        Result.setText(String.valueOf(value));

    }

    public void sub(View view) {
        String operand1 = editText1.getText().toString();
        String operand2 = editText2.getText().toString();
        double value = mCalculator.sub(Double.valueOf(operand1), Double.valueOf(operand2));
        Result.setText(String.valueOf(value));
    }

    public void div(View view) {
        String operand1 = editText1.getText().toString();
        String operand2 = editText2.getText().toString();
        double value = mCalculator.div(Double.valueOf(operand1), Double.valueOf(operand2));
        Result.setText(String.valueOf(value));
    }

    public void Multiply(View view) {
        String operand1 = editText1.getText().toString();
        String operand2 = editText2.getText().toString();
        double value = mCalculator.Mul(Double.valueOf(operand1), Double.valueOf(operand2));
        Result.setText(String.valueOf(value));
    }
}