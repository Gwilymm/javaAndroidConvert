package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class NewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultat);


        // A listener that is called when the button is clicked.
        View.OnClickListener btnQuit = new View.OnClickListener(){
            @Override
            public void onClick(View v){
                finish();
            }
        };
        Button quitter = (Button) findViewById(R.id.quitter);
        quitter.setOnClickListener(btnQuit);

    converT();

    }

    private void converT(){

        Intent malikcqueEstDaccord = getIntent();
        String montant = malikcqueEstDaccord.getExtras().getString("Montant");
        String deviseDep = malikcqueEstDaccord.getStringExtra("Devisedepart");
        String deviseArr = malikcqueEstDaccord.getStringExtra("Devisearrive");


        Double convertion = (Double) Convert.convertir(deviseDep, deviseArr, Double.parseDouble(montant));

        String resultConvert = (String) convertion.toString();

        Intent result = new Intent();
        result.putExtra("retour",resultConvert+" "+deviseArr);
        setResult(1,result);

        finish();



    }

}
