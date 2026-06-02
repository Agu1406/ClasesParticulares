package pruebaslibres.practica.coleccion.sin_resolver;

import java.io.FileReader;
import java.io.IOException;

/**
 * Ejercicio 06 - Excepciones y ficheros.
 */
public class Ejercicio06_ExcepcionesYFicheros_SIN_RESOLVER {

    public static void main(String[] args) {
        // TODO: invocar metodoConFinally() y leerArchivoSeguro("Data.txt").
    }

    // TODO: reproducir comportamiento de try/catch/finally.
    public static void metodoConFinally() {
    }

    // TODO: retornar -1 si no existe, 0 si todo va bien.
    public static int leerArchivoSeguro(String ruta) {
        try {
            FileReader fr = new FileReader(ruta);
            fr.close();
        } catch (IOException e) {
            // TODO
        } finally {
            System.out.println("Finally ejecutado");
        }
        return 0;
    }
}
