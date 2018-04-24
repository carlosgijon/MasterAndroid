package com.example.carlos.lector_noticias_2;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;


public class ManejadorSAX extends DefaultHandler {
    // Lista de items
    private ArrayList<Item> items;
    // Item con el que trabajamos actualmente
    private Item itemTemporal;
    // Lector del XML
    private StringBuilder texto;

    @Override
    public void startDocument() throws SAXException {

        // LLamamos al método de la superclase
        super.startDocument();
        texto = new StringBuilder();
        items = new ArrayList<Item>();
    }

    @Override
    public void startElement(String uri, String nombreLocal, String nombre, Attributes atributos) throws SAXException{
        // Se llama al método de la superclase
        super.startElement(uri, nombreLocal, nombre, atributos);

        if(nombreLocal.equals("item")) {
            // Hay que añadir a la clase Item un constructor sin parametros para crear un Item sin parametros
            itemTemporal = new Item();
        }
    }

    @Override
    public void endElement(String uri, String nombreLocal, String nombre) throws SAXException{

        // Se llama al método de la superclase
        super.endElement(uri, nombreLocal, nombre);

        if(this.itemTemporal != null) {
            if(nombreLocal.equals("title")) {
                itemTemporal.setTitle(texto.toString());
            }
            else if(nombreLocal.equals("link")) {
                itemTemporal.setLink(texto.toString());
            }
            else if(nombreLocal.equals("pubDate")) {
                itemTemporal.setPubDate(texto.toString());
            }
            else if(nombreLocal.equals("category")) {
                itemTemporal.setCategory(texto.toString());
            }
            else if(nombreLocal.equals("guid")) {
                itemTemporal.setGuid(texto.toString());
            }
            else if(nombreLocal.equals("item")) {
                items.add(itemTemporal);
            }

            // Vaciar el buffer de texto
            texto.setLength(0);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException{
        super.characters(ch, start, length);

        if(this.itemTemporal != null) {
            texto.append(ch, start, length);
        }
    }

    public ArrayList<Item> getItems() {
        return items;
    }
}
