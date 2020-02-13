package com.example.listeplanetes;

import java.util.ArrayList;

public class Data {
    private ArrayList<String> nom;
    private final String[] taillePlanetes = {"4900", "12000", "12800", "6800", "144000", "120000", "52000", "50000", "2300"};

    public Data(){
        nom = new ArrayList<String>();
        nom.add("Mercure");
        nom.add("Venus");
        nom.add("Terre");
        nom.add("Mars");
        nom.add("Jupiter");
        nom.add("Saturne");
        nom.add("Uranus");
        nom.add("Neptune");
        nom.add("Pluton");

    }

    public ArrayList<String> getNom() {
        return nom;
    }

    public String[] getTaillePlanetes() {
        return taillePlanetes;
    }
}
