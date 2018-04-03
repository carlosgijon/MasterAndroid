package com.example.carlos.selectores;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
