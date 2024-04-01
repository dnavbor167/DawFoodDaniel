/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw.productos;

import daw.Iva;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author danielnavasborjas
 */
public class MetodosProductos {
    //Hacemos un método donde estén todos los datos de comida cargados
    public static ListasProductos datosProductos() {
        //creamos la variable que vamos a devoler
        ListasProductos listaDeProductos = new ListasProductos();

        //guardamos en una lista de tipo String los productos del 
        //archivo csv llamando al método de lectura que devuelve una lista
        //de String
        List<String> lista = writeRead.writeRead.read("productos.csv");

        //con un for recorremos toda la lista 
        for (int i = 0; i < lista.size(); i++) {
            //guardamos en un array de String una línea temporal separado
            //por coma (esto quiere decir que en cada espacio del array
            //se va a guardar hasta que llegue a una coma)
            String[] linea = lista.get(i).split(",");
            
            //guardamos en un String la posición 2 del array en minúsculas
            //para poder comparalo luego
            String subComparar = linea[2].toLowerCase();

            //switch para saber que subcategoría es, y sabiendo la subcategoría
            //creamos y añadimos o un objeto comida o bebida o postre
            switch (subComparar) {
                case "pollo", "ternera", "pescado" -> {
                    listaDeProductos.añadirUnElemento(new Comida(Integer.parseInt(linea[0]),
                            linea[1], SubCategoriaComida.valueOf(subComparar.toUpperCase()),
                            Double.parseDouble(linea[3]), 
                            Iva.IVA_COMIDA_POSTRES_RESTOBEBIDAS,
                            Integer.parseInt(linea[5])));
                }
                case "cerveza", "agua", "zumonaranja" -> {
                    listaDeProductos.añadirUnElemento(new Bebida(Integer.parseInt(linea[0]),
                            linea[1], SubCategoriaBebida.valueOf(subComparar.toUpperCase()),
                            Double.parseDouble(linea[3]), 
                            Iva.IVA_ALCOHOL_REFRESCOS,
                            Integer.parseInt(linea[5])));
                }
                default -> {
                    listaDeProductos.añadirUnElemento(new Postres(
                            Integer.parseInt(linea[0]), linea[1], 
                            Double.parseDouble(linea[2]), 
                            Iva.IVA_COMIDA_POSTRES_RESTOBEBIDAS, 
                            Integer.parseInt(linea[4])));

                }
            }

        }
        return listaDeProductos;

    }
}
