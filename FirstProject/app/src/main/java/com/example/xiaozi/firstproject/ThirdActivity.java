package com.example.xiaozi.firstproject;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
/*
1、简单的IBM计算器


 */

public class ThirdActivity extends AppCompatActivity {
    public Button button31;
    public Button button32;
    public EditText edit31;
    public EditText edit32;

    public Button button33;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        button31=(Button) findViewById(R.id.button31);
        button32=(Button) findViewById(R.id.button32);
        button33=(Button) findViewById(R.id.button33);

        edit31=(EditText) findViewById(R.id.editText31);
        edit32=(EditText) findViewById(R.id.editText32);
    }

    public void doClick(View v){
        switch (v.getId()){
            case R.id.button33:
                FourthActivity.actionStart(this,edit31.getText().toString(),edit32.getText().toString());
                break;
        }

    }

}
