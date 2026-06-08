package ev2.ut5_pooexcepcionesio.u04repaso.practicas.pruebaslibrescoleccion;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Ejercicio06_ExcepcionesYFicheros_RESUELTO {

    public static void main(String[] args) {
        metodoConFinally();
        int codigo = leerArchivoSeguro("Data.txt");
        System.out.println("Codigo de retorno: " + codigo);

        float x = 10f;
        float y = 0f;
        System.out.println("10f / 0f = " + (x / y));
    }

    public static void metodoConFinally() {
        try {
            throw new IllegalArgumentException("Forzado");
        } catch (IllegalArgumentException ex) {
            System.out.println("Capturada IllegalArgumentException");
        } finally {
            System.out.println("Finally ejecutado");
        }
    }

    public static int leerArchivoSeguro(String ruta) {
        try {
            FileReader fr = new FileReader(ruta);
            fr.close();
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado");
            return -1;
        } catch (IOException e) {
            System.out.println("Error de E/S");
            return -1;
        } finally {
            System.out.println("Finally ejecutado");
        }
        return 0;
    }
}
