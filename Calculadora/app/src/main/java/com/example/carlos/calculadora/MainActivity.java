package com.example.carlos.calculadora;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    // Creamos variables para saber si n1 y n2 están vacios
    boolean n1_vacio = true;
    boolean n2_vacio = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Variables de los ids de la vista
        final Button _ejecucion = (Button)findViewById(R.id.boton_calcular);
        final EditText _n1 = (EditText)findViewById(R.id.text_operador1);
        final EditText _n2 = (EditText)findViewById(R.id.text_operador2);
        final TextView _resultado = (TextView) findViewById(R.id.text_resultado);
        final Spinner _opciones = (Spinner)findViewById(R.id.spinner_operaciones);

        // Vamos a deshabilitar el boton mientras no haya ningun valor en n1 y n2
        _ejecucion.setEnabled(false);

        // Primero para n1
        _n1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(_n1.getText().length() > 0) {
                    n1_vacio = false;
                }
                else {
                    n1_vacio = true;
                }

                if(!n1_vacio && !n2_vacio) {
                    _ejecucion.setEnabled(true);
                }
                else {
                    _ejecucion.setEnabled(false);
                }
            }
        });

        // Ahora para n2
        _n2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(_n2.getText().length() > 0) {
                    n2_vacio = false;
                }
                else {
                    n2_vacio = true;
                }

                if(!n2_vacio && !n1_vacio) {
                    _ejecucion.setEnabled(true);
                }
                else {
                    _ejecucion.setEnabled(false);
                }
            }
        });

        // Creando un adaptador para un spinner

        final String[] datos = new String[] {"sumar", "restar", "multiplicar", "dividir"};
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, datos);

        // Enlazando el adaptador para el spinner

        final Spinner opciones = (Spinner)findViewById(R.id.spinner_operaciones);
        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_item);
        opciones.setAdapter(adaptador);

        _ejecucion.setOnClickListener(
                v -> {
                    int a,b;

                    // Convertimos a Integer el valor (que es un String) de _nx. Para ello hacemos .getText de cada uno
                    a = new Integer(_n1.getText().toString());
                    b = new Integer(_n2.getText().toString());

                    if(opciones.getSelectedItem().equals("sumar")) {
                        _resultado.setText(String.valueOf(suma(a,b)));
                    }
                    else if(opciones.getSelectedItem().equals("restar")) {
                        _resultado.setText(String.valueOf(resta(a,b)));
                    }
                    else if(opciones.getSelectedItem().equals("multiplicar")) {
                        _resultado.setText(String.valueOf(multiplicacion(a,b)));
                    }
                    else if(opciones.getSelectedItem().equals("dividir")) {
                        _resultado.setText(String.valueOf(division(a,b)));
                    }
                    else {
                        _resultado.setText("Error en la aplicación");
                    }
                }
        );

    }

    public int suma(int a, int b) {
        int res = a + b;
        return res;
    }

    public int resta(int a, int b) {
        int res = a - b;
        return res;
    }

    public int multiplicacion(int a, int b) {
        int res = a * b;
        return res;
    }

    public double division(int a, int b) {
        double res = a / b;
        return res;
    }

}
