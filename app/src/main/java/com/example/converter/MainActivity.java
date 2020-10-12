package com.example.converter;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private String[] massa = {"", "Тонны", "Килограммы", "Граммы"};
    private TextView textTon;
    private EditText editText;
    private TextView textKg;
    private TextView textGr;
    double c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textTon = (TextView) findViewById(R.id.text_tn);
        textKg = (TextView) findViewById(R.id.text_kg);
        textGr = (TextView) findViewById(R.id.text_gr);
        editText = (EditText) findViewById(R.id.editTextNumber);


        ArrayAdapter<String> massaAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, massa);
        massaAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        Spinner spMassa = (Spinner) findViewById(R.id.spinner);

        spMassa.setAdapter(massaAdapter);

        spMassa.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String a = String.valueOf(editText.getText());

                if (position == 1) {
                    double b = Integer.parseInt(a);
                    textGr.setText(String.valueOf(b * 100000));
                    textTon.setText(a);
                    textKg.setText(String.valueOf(b * 1000));
                } else if (position == 2) {
                    double b = Integer.parseInt(a);
                    textGr.setText(String.valueOf(b * 1000));
                    textTon.setText(String.valueOf(b / 1000));
                    textKg.setText(a);
                } else if (position == 3) {
                    double b = Integer.parseInt(a);
                    textGr.setText(a);
                    textTon.setText(String.valueOf(b / 1000000));
                    textKg.setText(String.valueOf(b / 1000));
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }
}