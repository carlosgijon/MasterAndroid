package com.example.carlos.probandomenus;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    // Creamos una variable global para controlar cuando se bloquean las opciones
    private boolean contenido_bloqueado = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Hacer un menu contextual con la etiqueta hello world!!!

        // Declaramos el textView
        TextView texto = (TextView)findViewById(R.id.tv_hello);

        //Declaramos el método para hacer el menú contextual
        registerForContextMenu(texto);

        // Asignamos el listener para el boton
        final Button btn_desbloqueo = (Button)findViewById(R.id.btn_opciones);

        // Le añadimos el listener al boton y su funcionalidad
        btn_desbloqueo.setOnClickListener((view) -> {
            contenido_bloqueado = true;
            btn_desbloqueo.setEnabled(false);
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_agrupado, menu);
        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        menu.setGroupEnabled(R.id.grupo, false);
        // menu.setGroupVisible(R.id.grupo, false);

        if(contenido_bloqueado) {
            menu.add(0,5, Menu.NONE, "Opcion desbloqueada");
            contenido_bloqueado = false;
        }


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
