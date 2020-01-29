package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class Main4Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        Intent intent = getIntent();
        String user = intent.getStringExtra("user");
        String password = intent.getStringExtra("password");
        System.out.println("ahahahaah");
        System.out.println(intent.getStringExtra("user"));
        System.out.println(intent.getStringExtra("password"));
        String result = user + " " + password;
        System.out.println(result);
        TextView afficher = findViewById(R.id.afficher);
        afficher.setText(result);
    }


}
