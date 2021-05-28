package com.example.examqustions;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Presentation;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.util.Log;


public class MainActivity extends AppCompatActivity {
    EditText editText;
    Button sendmessage;
    TextView message;
    TextView replyM;
    public static final String Extra_Message = "com.example.examqustions";
    public static final int Text_Request = 1;
    public static final String LOG_TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(LOG_TAG, "--------");
        Log.d(LOG_TAG, "onCreate");

        editText = (EditText)findViewById(R.id.Etext1);
        sendmessage = (Button)findViewById(R.id.send);

        message = (TextView)findViewById(R.id.head1);
        replyM = (TextView)findViewById(R.id.message);

        if(savedInstanceState != null){
            Boolean reply = savedInstanceState.getBoolean("head_visible");
            if(reply){
                message.setVisibility(View.VISIBLE);
                replyM.setText(savedInstanceState.getString("reply_visible"));
                replyM.setVisibility(View.VISIBLE);
            }
        }
    }

    @Override
    public void onStart(){
        super.onStart();
        Log.d(LOG_TAG,"onStart");
    }

    @Override
    public void onResume(){
        super.onResume();
        Log.d(LOG_TAG, "onResume");
    }

    @Override
    public void onPause(){
        super.onPause();
        Log.d(LOG_TAG, "onPause");
    }

    @Override
    public void onStop(){
        super.onStop();
        Log.d(LOG_TAG, "onStop");
    }

    @Override
    public void onRestart(){
        super.onRestart();
        Log.d(LOG_TAG, "onRestart");
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        Log.d(LOG_TAG, "onDestroy");
    }


    public void send(View view) {
        Intent obj = new Intent(MainActivity.this, Activity2.class);
        String str = editText.getText().toString();
        obj.putExtra(Extra_Message, str);
        startActivityForResult(obj, Text_Request);
    }



    /*inbuilt onActivityResult*/
    public void onActivityResult(int requestCode, int resultCode, Intent obj)
    {
        super.onActivityResult(requestCode, resultCode, obj);

        if(requestCode == Text_Request){

            if(resultCode == RESULT_OK){
                message.setVisibility(View.VISIBLE);
                String str = obj.getStringExtra(Activity2.Reply_Message);
                replyM.setText(str);
            }
        }

    }
    @Override
    public void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        if(message.getVisibility() == View.VISIBLE){
            outState.putBoolean("head_visible", true);
            outState.putString("reply_visible", replyM.getText().toString());
        }
    }
}