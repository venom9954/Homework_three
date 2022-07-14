package com.example.homeworkthree;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView text_output;
    private String firstArg;
    private String secondArg;
    private Double result;
    private String operator;
    Button choose_theme_button;

    int[] numbersId = new int[]{
            R.id.button_0,
            R.id.button_1,
            R.id.button_2,
            R.id.button_3,
            R.id.button_4,
            R.id.button_5,
            R.id.button_6,
            R.id.button_7,
            R.id.button_8,
            R.id.button_9,
            R.id.button_point,
            R.id.button_plusOrMinus
    };

    int[] otherId = new int[]{
            R.id.button_plus,
            R.id.button_minus,
            R.id.button_multiply,
            R.id.button_divide
    };


    private StringBuilder inputStr = new StringBuilder();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
     //   setTheme(R.style.MyStyle);
        setContentView(R.layout.activity_main);
        themes();


        text_output = findViewById(R.id.text_output);


        View.OnClickListener ButtonClickListener = new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                for (int i=0; i<numbersId.length; i++) {
                    if (view.getId() == numbersId[i]) {
                        switch (view.getId()) {
                            case R.id.button_7:
                                inputStr.append("7");
                                break;
                            case R.id.button_8:
                                inputStr.append("8");
                                break;
                            case R.id.button_9:
                                inputStr.append("9");
                                break;
                            case R.id.button_4:
                                inputStr.append("4");
                                break;
                            case R.id.button_5:
                                inputStr.append("5");
                                break;
                            case R.id.button_6:
                                inputStr.append("6");
                                break;
                            case R.id.button_1:
                                inputStr.append("1");
                                break;
                            case R.id.button_2:
                                inputStr.append("2");
                                break;
                            case R.id.button_3:
                                inputStr.append("3");
                                break;
                            case R.id.button_0:
                                inputStr.append("0");
                                break;
                            case R.id.button_point:
                                if (dotIsPresent(inputStr)) {
                                } else {
                                    inputStr.append(".");
                                }
                                break;
                            case R.id.button_plusOrMinus:
                                if (minusIsPresent(inputStr)) {
                                } else {
                                    inputStr.append("-");
                                }
                                break;
                        }
                        text_output.setText(inputStr);

                    }


                }
                    firstArg = inputStr.toString();

                    for(int i=0; i<otherId.length; i++){
                        if (view.getId() == otherId[i]){
                            switch (view.getId()) {
                                case R.id.button_divide:
                                    operator = "/";
                                    inputStr.setLength(0);
                                    break;
                                case R.id.button_minus:
                                    operator = "-";
                                    inputStr.setLength(0);
                                    break;
                                case R.id.button_plus:
                                    operator = "+";
                                    inputStr.setLength(0);
                                    break;
                                case R.id.button_multiply:
                                    operator = "*";
                                    inputStr.setLength(0);
                                    break;
                            }
                            text_output.setText(operator);
                        }

                }

            }
        };



        for (int i = 0; i < numbersId.length; i++) {
            findViewById(numbersId[i]).setOnClickListener(ButtonClickListener);
        }

        for (int i = 0; i < otherId.length; i++) {
            findViewById(otherId[i]).setOnClickListener(ButtonClickListener);
        }


        findViewById(R.id.button_equals).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                secondArg = text_output.getText().toString();

                if (operator == "/") {
                    result = Double.parseDouble(firstArg) / Double.parseDouble(secondArg);
                } else if (operator == "-") {
                    result = Double.parseDouble(firstArg) - Double.parseDouble(secondArg);
                } else if (operator == "+") {
                    result = Double.parseDouble(firstArg) + Double.parseDouble(secondArg);
                } else if (operator == "*") {
                    result = Double.parseDouble(firstArg) * Double.parseDouble(secondArg);
                }
                text_output.setText(result.toString());
                inputStr.setLength(0);
            }

        });

        findViewById(R.id.button_AC).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text_output.setText("");
                inputStr.setLength(0);
            }
        });
    }

    public void themes(){
        choose_theme_button = findViewById(R.id.choose_theme_button);
        choose_theme_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });
    }

    public boolean dotIsPresent(StringBuilder inputStr) {
        if (inputStr.indexOf(".") == -1) {
            return false;
        } else {
            return true;
        }
    }

    public boolean minusIsPresent(StringBuilder inputStr) {
        if (inputStr.indexOf("-") == -1) {
            return false;
        } else {
            return true;
        }
    }
}
