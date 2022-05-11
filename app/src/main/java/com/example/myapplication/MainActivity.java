package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       Spinner spinner = (Spinner) findViewById(R.id.spinner);
       Spinner spinner2 = (Spinner) findViewById(R.id.spinner2);
       spinner.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) this);
       spinner2.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) this);


       @Override
        public void onItemSelected() {

            if (spinner.equals(spinner2)){
                Toast.makeText(getApplicationContext(),"Devises identique",Toast.LENGTH_SHORT).show();
            }
        }
    }
}




