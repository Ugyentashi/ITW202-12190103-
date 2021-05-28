 package com.example.examqustions;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Activity2 extends AppCompatActivity {

    public static final String Reply_Message = "com.example.examqustions";
    TextView message;
    EditText Etext2;
    Button send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        Etext2 = (EditText)findViewById(R.id.etext);
        send = (Button)findViewById(R.id.reply);

        message = (TextView)findViewById(R.id.message);

        Intent obj = getIntent();
        String str = obj.getStringExtra(MainActivity.Extra_Message);
        message.setText(str);
    }

    public void reply(View view) {
        Intent obj = new Intent(this, MainActivity.class);
        String str = Etext2.getText().toString();
        obj.putExtra(Reply_Message, str);
        setResult(RESULT_OK, obj);  /*inbuilt RESULT_OK*/
        finish();

    }
}