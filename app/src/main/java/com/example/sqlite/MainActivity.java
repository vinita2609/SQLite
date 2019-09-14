package com.example.sqlite;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn_save;
    EditText Id,Name,Email;
    ContactDBHelper contactDbHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        contactDbHelper = new ContactDBHelper(this);

        btn_save = findViewById(R.id.btn_save);
        Id = findViewById(R.id.Contact_Id);
        Name = findViewById(R.id.Name);
        Email = findViewById(R.id.Email);

        btn_save.setOnClickListener(   new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String id = Id.getText().toString();
                String name = Name.getText().toString();
                String email = Email.getText().toString();

                ContactDBHelper contactDbHelper = new ContactDBHelper(MainActivity.this);
                SQLiteDatabase database = contactDbHelper.getWritableDatabase();
                contactDbHelper.addContact(Integer.parseInt(id),name,email,database);
                contactDbHelper.close();
                Id.setText("");
                Name.setText("");
                Email.setText("");

                Toast.makeText(MainActivity.this,"information save succesfully", Toast.LENGTH_SHORT).show();



            }
        });


    }


    @Override
    public void onClick(View v) {


    }
}
