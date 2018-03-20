package com.example.carlos.botones;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ToggleButton;

public class BotonActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boton);
    }

    public void onToggleClicked(View vista) {
        // ¿Esta On?
        boolean encendido = ((ToggleButton)vista).isChecked();
        if(encendido) {
            // Vibrar ON
        }
        else {
            // Vibrar OFF
        }
    }
}
