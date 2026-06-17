package ev2.ut5_pooexcepcionesio.u05repaso.practicas.pruebaslibres2024;

import java.io.FileReader;
import java.io.IOException;

public class Ejercicio03_ExcepcionesYArchivos_SIN_RESOLVER {

    public static void main(String[] args) {
        // TODO: invocar leerArchivo("Data.txt") y mostrar retorno.
    }

    public static int leerArchivo(String ruta) {
        try {
            FileReader fr = new FileReader(ruta);
            fr.close();
        } catch (IOException ex) {
            // TODO
        } finally {
            System.out.println("Finally ejecutado");
        }
        return 0;
    }
}

