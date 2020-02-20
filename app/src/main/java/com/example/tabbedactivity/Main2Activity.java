package com.example.tabbedactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ImageView printemps = findViewById(R.id.imageView17);
        ImageView ete = findViewById(R.id.imageView18);
        ImageView automne = findViewById(R.id.imageView19);
        ImageView hiver = findViewById(R.id.imageView20);
        printemps.setOnClickListener(onClickListenerPrintemps);
        ete.setOnClickListener(onClickListenerEte);
        automne.setOnClickListener(onClickListenerAutomne);
        hiver.setOnClickListener(onClickListenerHiver);
    }

    View.OnClickListener onClickListenerPrintemps = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(getBaseContext(), MainActivity.class);
            intent.putExtra("saison", 0);
            startActivity(intent);
        }
    };

    View.OnClickListener onClickListenerEte = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(getBaseContext(), MainActivity.class);
            intent.putExtra("saison", 1);
            startActivity(intent);
        }
    };

    View.OnClickListener onClickListenerAutomne = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(getBaseContext(), MainActivity.class);
            intent.putExtra("saison", 2);
            startActivity(intent);
        }
    };

    View.OnClickListener onClickListenerHiver = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(getBaseContext(), MainActivity.class);
            intent.putExtra("saison", 3);
            startActivity(intent);
        }
    };
}
