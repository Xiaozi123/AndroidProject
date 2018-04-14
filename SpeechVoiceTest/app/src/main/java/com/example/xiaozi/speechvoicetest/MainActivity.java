package com.example.xiaozi.speechvoicetest;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.iflytek.cloud.SpeechConstant;
import com.iflytek.cloud.SpeechUtility;

public class MainActivity extends Activity {
    EditText editText;
    Button button;
    KqSpeechCompound kqSpeechCompound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SpeechUtility.createUtility(MainActivity.this, SpeechConstant.APPID + "=5959e3ed"); //初始化

        editText=(EditText)findViewById(R.id.editText);
        button=(Button)findViewById(R.id.button1);
        kqSpeechCompound=new KqSpeechCompound(this);
        //  开始文字语音转换


    }

    public void doClick(View v){
        switch (v.getId()){
            case R.id.button1:// 有问题

                /*
                * 简直奇怪了
                * 一起出错
                * 单个调试不出错
                *
                * */
             //   Toast.makeText(this,"进行文字转换...",Toast.LENGTH_SHORT).show();
                String content=editText.getText().toString().trim();
                Toast.makeText(this,editText.getText().toString().trim(),Toast.LENGTH_SHORT).show();
                //  开始文字语音转换
             //   SpeechUtility.createUtility(MainActivity.this, SpeechConstant.APPID + "=5959e3ed"); //初始化

                kqSpeechCompound.speaking(content);
                break;
            default:break;
        }


    }
}
