package com.example.carlos.postales;

import android.content.Intent;
import android.support.v4.app.BundleCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Localizando el boton llamado "button"
        Button but = findViewById(R.id.button);

        // Localizando el boton llamado "editText"
        final EditText edt = findViewById(R.id.editText);

        but.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(MainActivity.this, Postales.class);
                        Bundle bundle = new Bundle();
                        bundle.putString("SALUDO", edt.getText().toString());
                        intent.putExtras(bundle);
                    }
                }
        );
    }
}
