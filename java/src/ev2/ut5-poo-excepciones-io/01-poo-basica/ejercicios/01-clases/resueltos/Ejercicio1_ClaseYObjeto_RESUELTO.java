package general.poobasico.clases;

/**
 * Ejercicio POO Basico - Clases (Resuelto)
 *
 * @author Agustin. A. Marquez. Pina
 * @since 05/05/2026
 */
public class Ejercicio1_ClaseYObjeto_RESUELTO {

    public static void main(String[] args) {
        CocheResuelto coche = new CocheResuelto();
        coche.marca = "Toyota";
        coche.velocidad = 120;

        System.out.println("Marca: " + coche.marca);
        System.out.println("Velocidad: " + coche.velocidad + " km/h");
    }
}

class CocheResuelto {
    String marca;
    int velocidad;
}
