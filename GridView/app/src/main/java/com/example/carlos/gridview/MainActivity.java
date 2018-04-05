package com.example.carlos.gridview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.GridView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String[] datos = new String[50];

        // Creamos los datos para el array
        for(int i = 1; i <= 50; i++) {
            datos[i - 1] = "Dato " + i;
        }

        // Creamos el adaptador
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,datos);

        GridView grdOpciones = (GridView)findViewById(R.id.grid_opciones);
        grdOpciones.setAdapter(adaptador);

    }
}
