package com.example.carlos.textviews;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button BtnHaceCambios = findViewById(R.id.btnHacerCambios);
        final EditText TxtEditable = findViewById(R.id.txtEditable);

        BtnHaceCambios.setOnClickListener(
                (v) -> {
                    // Se referencia el TextView
                    final TextView lblEtiqueta = findViewById(R.id.LblEtiqueta);

                    // almacenara el texto que haya en lblEtiqueta
                    String texto = TxtEditable.getText().toString();

                    // En lblEtiqueta se va a poner el String que contenga la variable texto
                    lblEtiqueta.setText(texto);

                    // Se va a cambiar el color de fondo de lblEtiqueta
                    lblEtiqueta.setBackgroundColor(Color.BLUE);
                }
        );

    }
}
