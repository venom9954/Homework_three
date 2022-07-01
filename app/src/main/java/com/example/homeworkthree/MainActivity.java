package com.example.homeworkthree;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView text_output;
    private int firstArg;
    private int secondArg;

    StringBuilder inputStr = new StringBuilder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text_output = findViewById(R.id.text_output);

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
                R.id.button_9
        };

        int[] otherId = new int[]{
                R.id.button_plus,
                R.id.button_minus,
                R.id.button_multiply,
                R.id.button_divide,
                R.id.button_point,
                R.id.button_equals
        };

        for (int i = 0; i < numbersId.length; i++) {
            findViewById(numbersId[i]).setOnClickListener(listener);
        }

        for (int i = 0; i < otherId.length; i++) {
            findViewById(otherId[i]).setOnClickListener(listener);
        }

    }


    View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            onNumPressed(view.getId());
            text_output.setText(inputStr.toString());
        }
    };

    public void onNumPressed(int buttonsId) {


        if (inputStr.length() < 9) {
            switch (buttonsId) {
                case R.id.button_0:

                    inputStr.append("0");

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
                case R.id.button_4:
                    inputStr.append("4");
                    break;
                case R.id.button_5:
                    inputStr.append("5");
                    break;
                case R.id.button_6:
                    inputStr.append("6");
                    break;
                case R.id.button_7:
                    inputStr.append("7");
                    break;
                case R.id.button_8:
                    inputStr.append("8");
                    break;
                case R.id.button_9:
                    inputStr.append("9");
                    break;
            }
        }
    }
}
