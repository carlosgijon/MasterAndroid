package com.example.carlos.botones;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.ToggleButton;

public class BotonActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boton);

        // Localizar el boton
        Button botoncete = findViewById(R.id.BtnBotoncete);

        // Localizar el texto editable
        final EditText editar_texto = findViewById(R.id.TxtEditable);

        // Recuperamos el texto y lo mostramos en el Textview
        final TextView texto_cambia_con_botoncete = findViewById(R.id.TxtBotoncete);

        // Recuperamos el boton con image para borrar el texto que se escriba
        final ImageButton borrar_texto_con_imageButton = findViewById(R.id.BtnConImagen);

        // Voy a hacer otra prueba con otro boton

        final TextView texto_cambia_con_togglebutton = findViewById(R.id.textViewMetodo2);
        final ToggleButton toggleMetodo2 = findViewById(R.id.toggleMetodo2);

        // Crear el Listener para botoncete
        botoncete.setOnClickListener(
                (v) -> {
                    texto_cambia_con_botoncete.setText(editar_texto.getText());
                }
        );

        // Creaar el listerner para imageButton
        borrar_texto_con_imageButton.setOnClickListener(
                (v) -> {
                    texto_cambia_con_botoncete.setText(R.string.Texto_borrado);
                }

        );

        // Crear el listener para el toggle método dos
        toggleMetodo2.setOnClickListener(
                (v) -> {
                    boolean encendido = toggleMetodo2.isChecked();

                    if(encendido) {
                        texto_cambia_con_togglebutton.setText("El togglebutton metodo 2 esta activado");
                    }
                    else {
                        texto_cambia_con_togglebutton.setText("El togglebutton metodo 2 esta apagado");
                    }
                }
        );

    }

    public void onToggleClicked(View vista) {
        // ¿Esta On?
        boolean encendido = ((ToggleButton)vista).isChecked();
        if(encendido) {
            // vibracion ON
        }
        else {
            // vibracion OFF
        }
    }
}
