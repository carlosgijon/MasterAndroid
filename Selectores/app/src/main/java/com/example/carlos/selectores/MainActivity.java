package com.example.carlos.selectores;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Spinner spinner_planetas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Movidas para crear un Spinner

        ArrayAdapter<CharSequence> adaptador = ArrayAdapter.createFromResource(this,R.array.valores_array,android.R.layout.simple_spinner_item);
        spinner_planetas = (Spinner)findViewById(R.id.planetas);
        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_planetas.setAdapter(adaptador);

        TextView textoSpinner = findViewById(R.id.textoSpinner);

        spinner_planetas.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                textoSpinner.setText("Estas en el planeta " + parent.getItemAtPosition(position));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                textoSpinner.setText("¿En que planeta estas?");
            }
        });
    }

    public void onCheckboxClicked(View v) {
        TextView textoCheckbox = findViewById(R.id.textoCheckbox);
        String texto = "";
        boolean checado = ((CheckBox) v).isChecked();
        switch(v.getId()) {
            case R.id.checkbox_carne:
                if(checado) {
                    texto += " le pongo carne";
                }
                else {
                    texto += " no quiero carne";
                }
                break;
            case R.id.checkbox_queso:
                if(checado) {
                    texto += " le pongo queso";
                }
                else {
                    texto += " no quiero queso";
                }
                break;
        }

        textoCheckbox.setText(texto);
    }

    public void onRadioButtonClicked(View v) {
        TextView textoRadio = findViewById(R.id.textoRadio);
        String texto = "";
        boolean checado = ((RadioButton)v).isChecked();

        switch(v.getId()) {
            case R.id.radio_queso:
                if(checado) {
                    texto += "Quiero queso";
                }
                break;
            case R.id.radio_carne:
                if(checado) {
                    texto += "Quiero carne";
                }
                break;
        }

        textoRadio.setText(texto);
    }
}
