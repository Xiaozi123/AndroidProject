package com.example.xiaozi.firstproject;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
/*
1、简单的IBM计算器


 */

public class FourthActivity extends AppCompatActivity {
    public TextView text41;

    public String ibmData;
    public double height;
    public double weight;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth);

        text41=(TextView) findViewById(R.id.text41);
        getData();//获取数据
        text41.setText("你的IBM指数为："+weight/(height*height)+"\n");

    }




    // 启动该活动
    public static void actionStart(Context context,String data1,String data2){
        Intent intent=new Intent(context,FourthActivity.class);
        intent.putExtra("param1",data1);
        intent.putExtra("param2",data2);
        context.startActivity(intent);

    }


    // 获取活动中传递的数据
    public void getData(){
        Intent intent2=getIntent();
        height=Double.valueOf(intent2.getStringExtra("param1"));
        weight=Double.valueOf(intent2.getStringExtra("param2"));
    }


}
