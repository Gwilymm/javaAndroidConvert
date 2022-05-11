package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        Spinner spinner2 = (Spinner) findViewById(R.id.spinner2);
        EditText montant =(EditText) findViewById(R.id.montant);



        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            // A method that is called when an item is selected in the spinner.
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String spinnerText = (String) spinner.getSelectedItem().toString();
                String spinner2Text = (String) spinner2.getSelectedItem().toString();


                if (!spinnerText.isEmpty()) {
                    if (spinner2Text.equals(spinnerText)) {


                        Toast.makeText(getApplicationContext(), R.string.identicDevise, Toast.LENGTH_SHORT).show();
                        boolean flag = false;

                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String spinnerText = (String) spinner.getSelectedItem().toString();
                String spinner2Text = (String) spinner2.getSelectedItem().toString();


                if (!spinner2Text.isEmpty()) {
                    if (spinner2Text.equals(spinnerText)) {


                        Toast.makeText(getApplicationContext(), R.string.identicDevise, Toast.LENGTH_SHORT).show();


                    }
                }
            }


            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }

        });


        // A listener that is called when the button is clicked.
        View.OnClickListener btnQuit = new View.OnClickListener(){
            @Override
            public void onClick(View v){
                System.exit(0);
            }
        };
        Button quitter = (Button) findViewById(R.id.quitter);
        quitter.setOnClickListener(btnQuit);


        View.OnClickListener btnConvert = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String spinnerText = (String) spinner.getSelectedItem().toString();
                String spinner2Text = (String) spinner2.getSelectedItem().toString();
                String montantText = (String)  montant.getText().toString();

            if(spinnerText.isEmpty()){
                Toast.makeText(getApplicationContext(), R.string.msg_Dev_Dep_Empty,Toast.LENGTH_SHORT).show();

            }
            if(spinner2Text.isEmpty()){
                Toast.makeText(getApplicationContext(), R.string.msg_Dev_Arr_Empty,Toast.LENGTH_SHORT).show();
                Log.d("MainActivity",getString(R.string.msg_Dev_Arr_Empty));

            }
            try {

                if (montantText.isEmpty() || montantText.equals(".")) {
                    Toast.makeText(getApplicationContext(), R.string.msg_Montant_Empty, Toast.LENGTH_SHORT).show();
                } else {

                    Double convertion = (Double) Convert.convertir(spinnerText, spinner2Text, Double.valueOf(montantText));

                    String resultConvert = (String) convertion.toString();
                    Toast.makeText(getApplicationContext(), resultConvert, Toast.LENGTH_SHORT).show();
                }
            }catch (NumberFormatException e){
                Toast.makeText(getApplicationContext(),R.string.msg_Montant_Empty,Toast.LENGTH_SHORT).show();
            }
            }
        };
        Button convert = (Button) findViewById(R.id.convertir);
        convert.setOnClickListener(btnConvert);


    }
}




