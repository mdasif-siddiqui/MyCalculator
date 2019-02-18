package com.example.mdasif.mycalculator;

import  android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.regex.Pattern;

public class Calculator extends AppCompatActivity {
    private TextView _screen;
    private String display="";
    private String currentOperator="";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        _screen=(TextView) findViewById(R.id.textView);
        _screen.setText(display);
    }

    private void updateScreen(){     //for Rendering Output screen
        _screen.setText(display);
    }

    public void onClickOpenBracket(View v){  //Bracket not work
        Button b= (Button) v;
        display+=b.getText();
        currentOperator=b.getText().toString();
        updateScreen();
    }

    public void onClickCloseBracket(View v){    //Bracket not work
        Button b= (Button) v;
        display+=b.getText();
        currentOperator=b.getText().toString();
        updateScreen();
    }

    public void onClickNumber(View v){     //to take input no. from view
        Button b= (Button) v;
        display+=b.getText();
        updateScreen();
    }

    public void onClickOperator(View v){       //to take input operator from view
        Button b= (Button) v;
        display+=b.getText();
        currentOperator=b.getText().toString();
        updateScreen();
    }

    private double operateArithmetic(String a, String b, String op){
        switch (op){
            case "+": return (Double.valueOf(a) + Double.valueOf(b));
            case "-": return (Double.valueOf(a) - Double.valueOf(b));
            case "*": return (Double.valueOf(a) * Double.valueOf(b));
            case "/": return (Double.valueOf(a) / Double.valueOf(b));
            case "%": try{
                return (Double.valueOf(a) % Double.valueOf(b));
            } catch(Exception e){
                Log.d("Calc", e.getMessage());
            }
            default: return -1;
        }
    }

    public void onClickEqual(View v){    //after clicking "=" sign
        String[] operation=display.split(Pattern.quote(currentOperator));
        Double result;
        if(operation.length<2) return;

        result=operateArithmetic(operation[0],operation[1],currentOperator);
        _screen.setText(display + "\n" + String.valueOf(result));
    }



    private void clear(){
        display="";
        currentOperator="";
    }

    public void onClickClear(View v){
        clear();
        updateScreen();
    }
}
