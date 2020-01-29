package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnQuitter = (Button) findViewById(R.id.btnQuitter);
        btnQuitter.setOnClickListener(btnQuitterOnClickListener);
       // popUp("onCreate()");
        Button btnEnvoyer = (Button) findViewById(R.id.btnEnvoyer);
        btnEnvoyer.setOnClickListener(btnEnvoyerOnClickListener);
        Button btnsecActivity = (Button) findViewById(R.id.secActivity);
        btnsecActivity.setOnClickListener(btnsecActivityOnClickListenenr);
        Button btntrActivity = (Button) findViewById(R.id.trActivity);
        btntrActivity.setOnClickListener(btntreActivityOnClickListener);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
       // popUp("onDestroy()");
    }

    @Override
    public void finish() {
        super.finish();
       // popUp("Finish()");
    }


    @Override
    public void onStart() {
        super.onStart();
       // popUp("onStart()");
        SharedPreferences settings = getSharedPreferences("cycle_vie_prefs", Context.MODE_PRIVATE);
        setTxTValeur(settings.getString("valeur", ""));
    }

    @Override
    public void onResume(){
        super.onResume();
      //  popUp("onResume()");
    }
    public void popUp(String text){
        Toast.makeText(this,text,Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onRestart(){
        super.onRestart();
      //  popUp("onRestart()");
    }

    @Override
    protected void onPause() {
        super.onPause();
      //  popUp("onPause()");
        SharedPreferences settings = getSharedPreferences("cycle_vie_prefs", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        editor.putString("valeur", getTxtValeur());
        editor.commit();
    }

    View.OnClickListener btnQuitterOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
                finish();
        }
    };

    View.OnClickListener btnEnvoyerOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            popUp("valeur saisie = " + getTxtValeur());
        }
    };

    View.OnClickListener btnsecActivityOnClickListenenr = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(v.getContext(), Main2Activity.class);
            startActivity(intent);

        }
    };

    View.OnClickListener btntreActivityOnClickListener = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            Intent intent = new Intent(v.getContext(),Main3Activity.class);
            startActivity(intent);
        }
    };
    public String getTxtValeur() {
        EditText zoneValeur = (EditText) findViewById(R.id.editTxtValeur);
        return zoneValeur.getText().toString();
    }

    public void setTxTValeur(String valeur) {
        EditText zoneValeur = (EditText) findViewById(R.id.editTxtValeur);
        zoneValeur.setText(valeur);
    }
}
