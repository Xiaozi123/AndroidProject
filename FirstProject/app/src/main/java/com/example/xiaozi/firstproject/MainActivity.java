package com.example.xiaozi.firstproject;


import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
/*
1、简单的计算器


 */

public class MainActivity extends AppCompatActivity {
    public Button button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button1=(Button) findViewById(R.id.button_11);
    }
    public void doClick(View v){
        switch (v.getId()){
            case R.id.button_11:

                SecondActivity.actionStart(MainActivity.this,"数据一","数据二");
                break;

        }

    }

}
