package com.example.carlos.probandomenus;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Hacer un menu contextual con la etiqueta hello world!!!

        // Declaramos el textView
        TextView texto = (TextView)findViewById(R.id.tv_hello);

        //Declaramos el método para hacer el menú contextual
        registerForContextMenu(texto);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        // Declaramos un menuInflater para que se vea el context menu
        MenuInflater inflater = getMenuInflater();

        // Mostrar el menu
        inflater.inflate(R.menu.contextual, menu);
    }
}
