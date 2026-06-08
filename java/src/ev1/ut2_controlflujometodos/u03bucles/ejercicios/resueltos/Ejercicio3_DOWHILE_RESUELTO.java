package ev1.ut2_controlflujometodos.u03bucles.ejercicios.resueltos;

/**
 * Ejercicio 3 (dowhile): Contar hacia atras del 10 al 1
 * Version resuelta.
 *
 * @author Agustin. A. Marquez. Pina
 * @since 29/04/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Ejercicio3_DOWHILE_RESUELTO {
    public static void main(String[] args) {
        int i = 10;
                do {
                    System.out.println(i);
                    i--;
                } while (i >= 1);
    }
}
