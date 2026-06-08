package ev1.ut2_controlflujometodos.u03bucles.ejercicios.resueltos;

/**
 * Ejercicio 10 (dowhile): Sumar hasta superar 50
 * Version resuelta.
 *
 * @author Agustin. A. Marquez. Pina
 * @since 29/04/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Ejercicio10_DOWHILE_RESUELTO {
    public static void main(String[] args) {
        int suma = 0;
                int i = 1;
                do {
                    suma += i;
                    i++;
                } while (suma <= 50);
                System.out.println("Suma final: " + suma);
    }
}
