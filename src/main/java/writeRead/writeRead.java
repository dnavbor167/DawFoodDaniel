/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package writeRead;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author danielnavasborjas
 */
public class writeRead {

    //metodo para escribir en un fichero dado el nombre del fichero y dado
    //una palabra o conjunto de palabras
    public static void write(String file, String word) {
        try (BufferedWriter flujo = new BufferedWriter(new FileWriter(file))) {
            //escribimos en el fichero la palabra pasada por parámetro del método
            flujo.write(word);
            //guardamos los cambios en el disco
            flujo.flush();
        } catch (IOException w) {
            System.out.println(w.getMessage());
        }
    }


    //método para leer el fichero de la raíz
    public static List<String> leerFichero(String fichero) {
        List<String> lineas = new ArrayList<>();

        try {
            lineas = Files.readAllLines(Paths.get(fichero),
                    StandardCharsets.UTF_8);
        } catch (IOException ex) {
            System.out.println("Error leyendo el fichero " + fichero);
        }
        //eliminamos la posición 0 
        lineas.remove(0);

        return lineas;

    }
}
