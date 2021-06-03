package com.example.todo_25;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.android.myapplication.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    DbHelper myDb;
    EditText editName,editSurname,editMarks,editTextId;
    Button btnAddBtn;
    Button viewAllBtn;
    Button update;
    Button delete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myDb = new DbHelper(this);

        editName = findViewById(R.id.firstName);
        editSurname = findViewById(R.id.lastName);
        editMarks = findViewById(R.id.itwmarks);
        editTextId = findViewById(R.id.ID);
        btnAddBtn = findViewById(R.id.add);
        viewAllBtn = findViewById(R.id.view);
        update = findViewById(R.id.update);
        delete = findViewById(R.id.delete);

        viewAllBtn.setOnClickListener(this);


    }
    public void AddData(View view) {

                boolean isInserted = myDb.insertData(editTextId.getText().toString(),
                        editName.getText().toString(),
                        editSurname.getText().toString(),
                        editMarks.getText().toString() );
                if(isInserted == true)
                    Toast.makeText(MainActivity.this, "Data Inserted", Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(MainActivity.this, "Data not Inserted", Toast.LENGTH_LONG).show();
    }
    @Override
    public void onClick(View v){
        Cursor res = myDb.getAllData();

        if(res.getCount() == 0){
            //show message
            showMessage("Error", "Nothing found");
            return;
        }

        StringBuffer buffer = new StringBuffer();
        while(res.moveToNext()){
            buffer.append("ID: "+ res.getString(0)+"\n");
            buffer.append("firstName: "+ res.getString(1)+"\n");
            buffer.append("lastName: "+ res.getString(2)+"\n");
            buffer.append("ITW marks: "+ res.getString(3)+"\n");
        }
        showMessage("list of students: ", buffer.toString());

    }
    private void showMessage(String title, String Message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }

    public void UpdateData(View view){
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                boolean isUpdate = myDb.updateData(editTextId.getText().toString(),
                        editName.getText().toString(),
                        editSurname.getText().toString(),
                        editMarks.getText().toString());
                if(isUpdate == true)
                    Toast.makeText(MainActivity.this, "Data Updated", Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(MainActivity.this, "Data not Updated", Toast.LENGTH_LONG).show();


            }
        });
        public void DeleteData(){
            delete.setOnClickListener(
                    View.OnClickListener();
        }
    }

}