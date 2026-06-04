package ev2.ut5.u04repaso.practicas.pruebaslibres2024;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Ejercicio03_ExcepcionesYArchivos_RESUELTO {

    public static void main(String[] args) {
        System.out.println("Retorno: " + leerArchivo("Data.txt"));
    }

    public static int leerArchivo(String ruta) {
        try {
            FileReader fr = new FileReader(ruta);
            fr.close();
        } catch (FileNotFoundException ex) {
            System.out.println("File not found");
            return -1;
        } catch (IOException ex) {
            System.out.println("IOException occurred");
            return -1;
        } finally {
            System.out.println("Finally ejecutado");
        }
        return 0;
    }
}

