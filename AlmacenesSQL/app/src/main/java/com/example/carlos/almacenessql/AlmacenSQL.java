package com.example.carlos.almacenessql;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class AlmacenSQL extends SQLiteOpenHelper {
    // Creamos una copia de la BBDD
    private SQLiteDatabase db;

    // Guardamos el contexto
    Context contexto;

    // Creamos un constructor
    public AlmacenSQL(Context context, String nombre, SQLiteDatabase.CursorFactory factory, int version) {
        // Llamamos al constructor de la superclase
        super(context,nombre,factory, version);
        contexto = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Sentencia SQL de creacion de la tabla
        String sentenciaCreacion = "CREATE TABLE almacen (id INTEGER, nombre TEXT);";

        // Ejecutamos la sentencia en la BBDD
        db.execSQL(sentenciaCreacion);

        // Copiamos la referencia de la BBDD
        this.db = db;


        // MOSTRAR MENSAJE EN PANTALLA
        // Creamos un TOAST (mensaje en pantalla) para saber cuando se crea la BBDD
        CharSequence text = "Se ha creado la base de datos";

        // Fijamos el tiempo del mensaje en la pantalla
        int duracion = Toast.LENGTH_LONG;

        // Creamos el dialogo
        Toast toast = Toast.makeText(contexto,text,duracion);

        // Mostramos el mensaje en pantalla
        toast.show();

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        // Cuando actualizamos BBDD se crea una nueva y actualizarla con los datos de la anterior
        // Aqui se va a eliminar la antigua por simpleza y se crea la nueva desde cero
        String sentenciaDestruccion = "DROP TABLE IF EXISTS almacen";

        // Ejecutamos la sentencia
        db.execSQL(sentenciaDestruccion);
    }
}
