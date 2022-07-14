package com.example.homeworkthree;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(MyApp.currentTheme);
        setContentView(R.layout.activity_second);

        ((RadioButton)findViewById(R.id.theme_default_button)).setOnClickListener(this);
        ((RadioButton)findViewById(R.id.theme_one_button)).setOnClickListener(this);
        ((RadioButton)findViewById(R.id.theme_two_button)).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.theme_default_button:{
                MyApp.currentTheme = R.style.Theme_HomeworkThree;
                break;
            }
            case R.id.theme_one_button:{
                MyApp.currentTheme = R.style.myTheme1;
                break;
            }
            case R.id.theme_two_button:{
                MyApp.currentTheme = R.style.myTheme2;
                break;
            }
        }
        recreate();
    }
}