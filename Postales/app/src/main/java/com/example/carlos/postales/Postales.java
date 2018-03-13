package com.example.carlos.postales;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class Postales extends Activity {
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_postales);
        final TextView saludo = findViewById(R.id.textView);
        // recuperamos el string que hemos mandado con el bundle
        Bundle bund = getIntent().getExtras();
        saludo.setText(bund.getString("SALUDO"));
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }
}
