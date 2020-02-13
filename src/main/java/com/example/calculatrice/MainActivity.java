package com.example.calculatrice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    private Button button0;
    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;
    private Button button6;
    private Button button7;
    private Button button8;
    private Button button9;
    private Button buttonMoins;
    private Button buttonPlus;
    private Button buttonFois;
    private Button buttonEqual;
    private Button buttonPoint;
    private Button buttonDiv;
    private TextView textView;
    private String expression = "";
    private double result;
    private StringBuilder sb;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button0 = findViewById(R.id.button0);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        button6 = findViewById(R.id.button6);
        button7 = findViewById(R.id.button7);
        button8 = findViewById(R.id.button8);
        button9 = findViewById(R.id.button9);
        buttonMoins = findViewById(R.id.buttonMoins);
        buttonPlus = findViewById(R.id.buttonPlus);
        buttonFois = findViewById(R.id.buttonFois);
        buttonEqual = findViewById(R.id.buttonEqual);
        buttonPoint = findViewById(R.id.buttonPoint);
        buttonDiv = findViewById(R.id.buttonDiv);
        textView = findViewById(R.id.textView2);

        button0.setOnClickListener(getElement);
        button1.setOnClickListener(getElement);
        button2.setOnClickListener(getElement);
        button3.setOnClickListener(getElement);
        button4.setOnClickListener(getElement);
        button5.setOnClickListener(getElement);
        button6.setOnClickListener(getElement);
        button7.setOnClickListener(getElement);
        button8.setOnClickListener(getElement);
        button9.setOnClickListener(getElement);
        buttonMoins.setOnClickListener(getElement);
        buttonPlus.setOnClickListener(getElement);
        buttonFois.setOnClickListener(getElement);
        buttonPoint.setOnClickListener(getElement);
        buttonDiv.setOnClickListener(getElement);
        buttonEqual.setOnClickListener(getResult);

    }

    private View.OnClickListener getElement = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Button btn = (Button) v;
            if (result != 0){
                result = 0;
            }
            if (Character.isDigit(btn.getText().charAt(0))) {
                expression += btn.getText().toString();
                System.out.println(btn.getText().charAt(0));
            } else {
                System.out.println(btn.getText().charAt(0));

                expression += " " + btn.getText().toString() + " ";

            }
            textView.setText(expression);
        }
    };

    private View.OnClickListener getResult = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            System.out.println("expression " + expression);
            String[] expressionSplit = expression.split("\\s+");
            System.out.println("split " +expressionSplit.length);

            for (int i = 0; i < expressionSplit.length; i++) {
                    System.out.println(expressionSplit[i]);
                    if (expressionSplit[i].equals("+")) {
                        System.out.println("ahahahah");
                        System.out.println(expressionSplit[i-1]);
                        System.out.println(expressionSplit[i]);
                        System.out.println(expressionSplit[i+1]);
                        result += Integer.parseInt(expressionSplit[i - 1].toString()) + Integer.parseInt(expressionSplit[i + 1].toString());
                    }
                    textView.setText(Double.toString(result));
                    expression = "";
            }
        }
    };
}
