package com.example.listeplanetes;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;


class PlaneteAdapter extends BaseAdapter {

    private ArrayList<String> planetes;
    private LayoutInflater layoutInflater;
    private Context context;
    private Data data;
    private int n;

    public PlaneteAdapter(LayoutInflater layoutInflater, Context context){
        this.layoutInflater = layoutInflater;
        this.context = context;
        this.data = new Data();
        this.planetes = this.data.getNom();
    }
    @Override
    public int getCount() {
        return planetes.size();
    }

    @Override
    public Object getItem(int arg0) {
        return planetes.get(arg0);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View itemView = convertView;
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater)   this.layoutInflater;
            itemView = inflater.inflate(R.layout.listitem, null);
        }


        TextView nomPlanete = (TextView) itemView.findViewById(R.id.textView);
        final CheckBox checkBox = (CheckBox) itemView.findViewById(R.id.checkbox);
        final Spinner spinner = (Spinner) itemView.findViewById(R.id.spinner);

        nomPlanete.setText(planetes.get(position));


        final ArrayAdapter<String> spinadapter = new ArrayAdapter<String>(this.context, android.R.layout.simple_spinner_item, data.getTaillePlanetes());
        spinadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinadapter);

        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                CheckBox checkBox = (CheckBox) compoundButton.findViewById(R.id.checkbox);

                spinner.setEnabled(!checkBox.isChecked());
                spinadapter.notifyDataSetChanged();
                if (checkBox.isChecked()) {
                    n++;
                }
                else if(!checkBox.isChecked()){
                    n--;
                }


            }
        });

        return itemView;
    }

    public boolean isVerif(){
        if(n== planetes.size()){
            return true;
        } else{
            return false;
        }
    }
}