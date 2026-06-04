package ev1.ut2.u03bucles.ejercicios.resueltos;

/**
 * Ejercicio 4 (while): Sumar numeros del 1 al 100
 * Version resuelta.
 *
 * @author Agustin. A. Marquez. Pina
 * @since 29/04/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Ejercicio4_WHILE_RESUELTO {
    public static void main(String[] args) {
        int i = 1;
                int suma = 0;
                while (i <= 100) {
                    suma += i;
                    i++;
                }
                System.out.println("Suma: " + suma);
    }
}
