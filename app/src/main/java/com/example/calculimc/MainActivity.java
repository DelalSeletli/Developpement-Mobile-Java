package com.example.calculimc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button envoyer = null;
    Button reset = null;
    EditText taille = null;
    EditText poids = null;
    CheckBox commentaire = null;
    RadioGroup group = null;
    TextView result = null;
    private String texteInit = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        texteInit = getString(R.string.texteInit);
        envoyer = (Button)findViewById(R.id.calcul);
        reset = (Button)findViewById(R.id.reset);
        taille = (EditText)findViewById(R.id.taille);
        poids = (EditText)findViewById(R.id.poids);
        commentaire = (CheckBox)findViewById(R.id.commentaire);
        group = (RadioGroup)findViewById(R.id.group);
        result = (TextView)findViewById(R.id.result);

        // On attribue un listener adapté aux vues qui en ont besoin
        envoyer.setOnClickListener(envoyerListener);
        reset.setOnClickListener(resetListener);
        commentaire.setOnClickListener(checkedListener);
        taille.setOnKeyListener(modificationListener);
        poids.setOnKeyListener(modificationListener);

    }



    private View.OnClickListener envoyerListener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            //  on récupère la taille
            String t = taille.getText().toString();
            // On récupère le poids
            String p = poids.getText().toString();
            try{
                float tValue = Float.valueOf(t);

                // Puis on vérifie que la taille est cohérente
                if(tValue <= 0)
                    Toast.makeText(MainActivity.this, getString(R.string.Positive), Toast.LENGTH_SHORT).show();
                else {
                    float pValue = Float.valueOf(p);
                    if(pValue <= 0)
                        Toast.makeText(MainActivity.this, getString(R.string.Positive),Toast.LENGTH_SHORT).show();
                    else {
                        // Si l'utilisateur a indiqué que la taille était en centimètres
                        // On vérifie que la Checkbox sélectionnée est la deuxième à l'aide de son identifiant
                        if (group.getCheckedRadioButtonId() == R.id.radio_centimetre) tValue = tValue / 100;
                        float imc = pValue / (tValue * tValue);

                        String resultat=getString(R.string.imc) + imc+" . ";
                        if(commentaire.isChecked()) resultat += interpreteIMC(imc);
                        result.setText(resultat);
                    }
                }
            } catch(Exception e){
                Toast.makeText(MainActivity.this,getString(R.string.EnterValue),Toast.LENGTH_SHORT).show();
            }

        }
    };

    private View.OnClickListener resetListener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            poids.getText().clear();
            taille.getText().clear();
            result.setText(texteInit);
        }
    };

    private View.OnClickListener checkedListener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            if(((CheckBox)v).isChecked()) {
                result.setText(texteInit);
            }
        }
    };

    // Se lance à chaque fois qu'on appuie sur une touche en étant sur un EditText
    private View.OnKeyListener modificationListener = new View.OnKeyListener() {
        @Override
        public boolean onKey(View v, int keyCode, KeyEvent event) {

            result.setText(texteInit);
            if(taille.getText().toString().contains(".")){
                group.check(R.id.radio_metre);
            }
            return false;
        }
    };


    public String interpreteIMC(float imc){
        if(imc <= 16.5){
            return getString(R.string.famine);
        }
        if(imc > 16.5 && imc <= 18.5){
            return getString(R.string.maigreur);
        }
        if(imc > 18.5 && imc <= 25){
            return getString(R.string.normal);
        }
        if(imc > 25 && imc <= 30){
            return getString(R.string.surpoids);
        }
        if(imc > 30 && imc <= 35){
            return getString(R.string.obesiveM);
        }
        if(imc > 35 && imc <= 40){
            return getString(R.string.obesiteS);
        }
        if(imc > 40){
            return getString(R.string.obesiteMM);
        }
        return null;
    }
            }

