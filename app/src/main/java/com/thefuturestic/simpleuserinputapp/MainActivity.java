package com.thefuturestic.simpleuserinputapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //declaring variables
    private EditText firstValue, secondValue;
    private TextView result;
    private Button add, clear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //creating link between UI and code
        firstValue = (EditText)findViewById(R.id.first_value);
        secondValue = (EditText)findViewById(R.id.second_value);
        result = (TextView)findViewById(R.id.result);
        add = (Button)findViewById(R.id.add_btn);
        clear = (Button)findViewById(R.id.clear_btn);

        //adding action listener on add button
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //checking edit text fields
                if(firstValue.getText().toString().trim().length() > 0 &&
                        secondValue.getText().toString().trim().length() > 0){

                    //calling method
                    addValues();

                }else{
                    Toast.makeText(MainActivity.this,"Please enter both values",Toast.LENGTH_LONG).show();
                }
            }
        });


        //adding action listener on clear button
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(firstValue.getText().toString().trim().length() > 0 &&
                        secondValue.getText().toString().trim().length() > 0){

                    //calling method
                    clearValues();

                }else{
                    Toast.makeText(MainActivity.this,"Nothing to clear",Toast.LENGTH_LONG).show();
                }


            }
        });
    }

    //value addition method
    private void addValues(){
        //parsing string values to integer
        int a = Integer.parseInt(firstValue.getText().toString());
        int b = Integer.parseInt(secondValue.getText().toString());
        //adding up int values
        int sum = a+b;
        //displaying result
        result.setText("Result : "+sum);
    }

    private  void clearValues(){
        firstValue.setText("");
        secondValue.setText("");
        result.setText("Result : ");
    }
}