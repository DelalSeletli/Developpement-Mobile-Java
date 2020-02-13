package com.example.listeplanetes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Button bouton;
    private PlaneteAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //installePlanetes();
        ListView listview;
        listview = findViewById(R.id.listView);
        adapter = new PlaneteAdapter(MainActivity.this.getLayoutInflater(),MainActivity.this.getApplicationContext());
        listview.setAdapter(adapter);
        bouton = (Button) findViewById(R.id.button6);
        bouton.setOnClickListener(envoyer);
    }

    private View.OnClickListener envoyer = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(adapter.isVerif()){

            }
        }
    };

}

