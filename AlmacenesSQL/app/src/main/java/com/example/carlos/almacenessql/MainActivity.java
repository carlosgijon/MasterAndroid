package com.example.carlos.almacenessql;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    // Base de datos en la que vamos a operar
    private SQLiteDatabase db;

    // Objeto SQLiteOpenHelper
    private AlmacenSQL almacen;

    // Indice para insertar los elementos en el almacen
    private int indice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Declaramos nuestra BBDD
        almacen = new AlmacenSQL(this,"BaseDatos", null, 1);

        // Inicializamos el indice
        indice = obtener_ultimo_indice();

        // Consultamos la BBDD para obtener las tuplas previas
        consulta_BD();

        // Obtenemos acceso al campo de texto del usuario
        final EditText txt_consulta = (EditText) findViewById(R.id.CuadroEntrada);

        // IMPLEMENTAR FUNCIONALIDAD DE LOS BOTONES
        // Insertar
        Button btn_insertar = (Button)findViewById(R.id.Insertar);
        btn_insertar.setOnClickListener(v -> {
            // Vamos a mostrar un toast para que sepamos cuando se pulsa el boton
            // Fijamos el texto para el toast
            CharSequence texto = "Se ha pulsado insertar";
            int duracion = Toast.LENGTH_LONG;
            // Creamos el toast
            Toast toast = Toast.makeText(MainActivity.this, texto, duracion);
            toast.show();

            // INSERTAR EL TEXTO QUE HAYA EN EL EDITTEXT consulta
            String nombre_producto = txt_consulta.getText().toString();
            insertar_producto(nombre_producto);
            consulta_BD();
            txt_consulta.setText("");
        });

        // Borrar
        Button btn_borrar = (Button)findViewById(R.id.Borrar);
        btn_borrar.setOnClickListener(v -> {
            // Vamos a mostrar un toast para que sepamos cuando hemos pulsado el boton de borrar
            // Fijamos el texto
            CharSequence texto = "Se ha pulsado borrar";
            int duraccion = Toast.LENGTH_LONG;
            Toast toast = Toast.makeText(MainActivity.this, texto, duraccion);
            toast.show();

            String nombre_producto = txt_consulta.getText().toString();
            borrar_producto(nombre_producto);
            consulta_BD();
            txt_consulta.setText("");

        });


    }

    public void insertar_producto(String nombre_producto) {
        String sentenciaCreacion = "INSERT INTO almacen (id, nombre) VALUES (" +indice+ ", '" +nombre_producto + "');";

        // Comprobar si se ha introducido un nombre, si no, no se insertará la tupla
        if(!nombre_producto.equals("")) {
            db = almacen.getWritableDatabase();

            db.execSQL(sentenciaCreacion);

            // Cerramos la conexion con la BBDD
            db.close();
            indice++;
        }
    }

    public void borrar_producto(String nombre_producto) {
        String sentenciaBorrado = "DELETE FROM almacen WHERE (nombre = '" +nombre_producto+ "');";

        // Pedimos acceso de lectura-escritura a la BBDD
        db = almacen.getWritableDatabase();

        db.execSQL(sentenciaBorrado);
        db.close();
    }

    public ArrayList<ArrayList<String>> getListadoCompletoAlmacen() {
        // Pedimos acceso de lectura-escritura a la BBDD
        db = almacen.getWritableDatabase();

        // Definimos los campos que queremos consultar de nuestra tabla
        String[] CAMPOS = {"id", "nombre"};

        // Definimos la variable donde almacenar el resultado. Al tener dos campos
        // creamos un Map{clave, valor}
        ArrayList<ArrayList<String>> resultado_consulta = new ArrayList<ArrayList<String>>();

        // Cursor es un objeto que se utiliza para guardar los resultados de las consultas
        Cursor cursor = db.query("almacen", CAMPOS, null, null, null, null, null, null);

        // Mientras haya resultados seguimos recorriendo los resultados de la consulta
        int i = 0;

        if(cursor.getCount() > 0) {
            while(cursor.moveToNext()) {
                // Inicializa el array interno de Strings
                ArrayList<String> temp = new ArrayList<String>();

                // Añado a mi ArrayList temporal los resultados
                temp.add(cursor.getString(0));
                temp.add(cursor.getString(1));

                // Cargar el ArrayList principal con el resultado actual
                resultado_consulta.add(temp);
            }
        }

        // Cerramos la conexion con la BBDD
        db.close();

        // Devolver resultados
        return resultado_consulta;
    }

    public int obtener_ultimo_indice() {
        db = almacen.getWritableDatabase();

        // definimos los campos que queremos consultar
        String[] CAMPOS = {"id", "nombre"};

        // Definimos una variable donde almacenar el resultado
        int indice_devuelto = -1;

        // Se crea un cursor para moverse por los datos
        Cursor cursor = db.query("almacen", null, "id=(SELECT id from almacen order by id desc limit 1)", null, null, null, null);

        // Mientras haya resultados seguimos recorriendo los resultados de la consulta
        int i = 0;

        if(cursor.getCount() > 0) {
            while(cursor.moveToNext()) {
                indice_devuelto = cursor.getInt(0);
            }
        }

        db.close();

        // Mostramos un toast (popup) para saber cual es el ultimo indice en la BD
        // primero fijamos el texto para el toast
        CharSequence text = "El último indice es: " + indice_devuelto;

        // Fijamos la duracion del mensaje
        int duration = Toast.LENGTH_LONG;

        // Creamos el Toast
        Toast toast = Toast.makeText(MainActivity.this, text, duration);

        // Lo mostramos
        toast.show();

        // devolvemos los resultados
        return indice_devuelto + 1;
    }

    public void consulta_BD() {
        db = almacen.getWritableDatabase();

        // Rellenamos el cuadro de texto con el contenido de nuestra tabla almacen

        // traemos la referencia al EditText
        EditText txt_multiline = (EditText) findViewById(R.id.CuadroSalidas);

        // Deshabilitamos el EditText para que el usuario no modifique el texto
        txt_multiline.setFocusable(false);

        // Creamos una variable temporal para traernos los resultados
        ArrayList<ArrayList<String>> resultados = new ArrayList<ArrayList<String>>();

        resultados = getListadoCompletoAlmacen();

        // Primero borramos lo que haya escrito para tener la ultima versión de la tabla
        txt_multiline.setText("");

        for(int i = 0; i < resultados.size();i++) {
            txt_multiline.append("id: " +resultados.get(i).get(0) + ", nombre: "
                +resultados.get(i).get(1) + "\n");
        }

        db.close();
    }
}
