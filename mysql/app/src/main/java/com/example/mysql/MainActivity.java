package com.example.mysql;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText e1 , e2 , e3;
    DBhandler db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        e1 = (EditText) findViewById(R.id.idv);
        e2 = (EditText) findViewById(R.id.event);
        e3 = (EditText) findViewById(R.id.desc);

        db = new DBhandler(this);
    }

    public void add(View v){
        int i = Integer.parseInt(e1.getText().toString());
        db.addContact(new Contact(i , e2.getText().toString() , e3.getText().toString()));
    }

    public void update(View v){
        int i = Integer.parseInt(e1.getText().toString());
        db.updateContact(new Contact(i , e2.getText().toString() , e3.getText().toString()));
    }

    public void delete(View v){
        int i = Integer.parseInt(e1.getText().toString());
        db.deleteContact(new Contact(i , "" , "" ));
    }

    public void get(View v){
        int i = Integer.parseInt(e1.getText().toString());
        Contact c = db.getContact(i);
        e2.setText(c.getName());
        e3.setText(c.getPhoneNumber());
    }
}