package com.example.carlos.lector_noticias_2;

import android.app.ListActivity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;


import java.util.ArrayList;

public class MainActivity extends ListActivity {

    ArrayList<Item> data = null;
    ItemAdapter adapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        class CargaXMLAsincrona extends AsyncTask<String,Integer,Boolean> {
            @Override
            protected Boolean doInBackground(String... arg0) {
                ParserSAX parserSAX = new ParserSAX();

                data = parserSAX.parsear(arg0[0].toString());
                return true;
            }

            protected void onPostExecute(Boolean result) {
                Log.v("SAX", "Se ha completado el proceso de parseo");
                adapter = new ItemAdapter(MainActivity.this, data);
                setListAdapter(adapter);
            }
        }

        data = new ArrayList<Item>();
        CargaXMLAsincrona hilo = new CargaXMLAsincrona();
        hilo.execute("https://www.efe.com/efe/espana/1/rss");


    }

}

