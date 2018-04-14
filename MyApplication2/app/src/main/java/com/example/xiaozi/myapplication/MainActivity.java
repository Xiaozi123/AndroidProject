package com.example.xiaozi.myapplication;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import android.text.Editable;
import android.text.Selection;

public class MainActivity extends Activity {

    Button button1,button2;
    Toast toast;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
      //  button1=(Button)findViewById(R.id.button1);
       // button2=(Button)findViewById(R.id.button2);
        editText=(EditText)findViewById(R.id.editText);
    }

    public void doClick(View v){


        switch (v.getId()){

            case R.id.button1:
                toast=Toast.makeText(this,"你点击了确认按钮",Toast.LENGTH_SHORT);
                toast.show();
                break;

            case R.id.button2:
                toast=Toast.makeText(this,"你点击了取消按钮",Toast.LENGTH_LONG);
                toast.show();
            break;

            case R.id.button3:
                toast=Toast.makeText(this,"方法一"+editText.getText().toString(),Toast.LENGTH_LONG);// 方法一
                toast.show();
                break;

            case R.id.button4://方法二有问题 没找到
                int start=editText.getSelectionStart();
                int end=editText.getSelectionEnd();
                CharSequence selectText=editText.getText().subSequence(start,end);
                Toast.makeText(this,selectText,Toast.LENGTH_LONG).show();
                //  ---方法二
                /*
                int start=editText.getSelectionStart();
                int end=editText.getSelectionEnd();
                CharSequence selectText=editText.getText().subSequence(start, end);
                Log.d("d","----------------\n");
                Log.d(selectText.toString(),"d");
                Log.d("d","--------------\n");
                toast=Toast.makeText(this,"方法二"+selectText.toString(),Toast.LENGTH_LONG);
                toast.show();
                */
                break;
            default:break;
        }
    }
}
