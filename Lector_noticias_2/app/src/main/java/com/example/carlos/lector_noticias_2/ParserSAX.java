package com.example.carlos.lector_noticias_2;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class ParserSAX {
    // Direccion URL de la fuente de noticias
    private URL url;
    // Flujo de lectura del fichero
    private InputStream is;

    // CONSTRUCTOR
    public ArrayList<Item> parsear(String urlFuente) {

        // Creacion del objeto URL
        try {
            url = new URL(urlFuente);
        }
        catch (MalformedURLException mal_exc) {
            // La URL esta en un formato incorrecto
            throw new  RuntimeException(mal_exc);
        }

        // PATRON-FACTOR es un patrón de diseño
        SAXParserFactory fabrica = SAXParserFactory.newInstance();

        try {
            is = url.openConnection().getInputStream();
        }
        catch(IOException iex) {
            // No se ha podido realizar la conexion
            throw new RuntimeException(iex);
        }

        // Creación del objeto parser haciendo uso del patrón factor
        try {
            SAXParser parser = fabrica.newSAXParser();
            // Creamos un nuevo objeto manejador
            ManejadorSAX manejador = new ManejadorSAX();
            // Parseamos el documento XML
            parser.parse(is, manejador);
            // Devolvemos los items que hemos leido en el archivo
            return manejador.getItems();
        }
        catch (Exception exc) {
            // Error en el proceso de parseo
            throw new RuntimeException(exc);
        }


    }







}
