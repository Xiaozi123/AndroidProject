package com.example.xiaozi.firstproject;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
/*
1、简单的IBM计算器


 */

public class SecondActivity extends AppCompatActivity {
    public Button button21;

    public String data21;
    public String data22;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        button21=(Button) findViewById(R.id.button_21);
        getData();//获取数据


    }




    // 启动该活动
    public static void actionStart(Context context,String data1,String data2){
        Intent intent=new Intent(context,SecondActivity.class);
        intent.putExtra("param1",data1);
        intent.putExtra("param2",data2);
        context.startActivity(intent);

    }


    // 获取活动中传递的数据
    public void getData(){
        Intent intent2=getIntent();
        data21=intent2.getStringExtra("param1");
        data22=intent2.getStringExtra("param2");
        Toast.makeText(this,"数据传送成功"+data21+data22,Toast.LENGTH_LONG).show();
    }

    public void doClick(View v){
        switch (v.getId()){
            case R.id.button_21:
                Intent intent3=new Intent(this,ThirdActivity.class);
                startActivity(intent3);
                break;

        }

    }

}
