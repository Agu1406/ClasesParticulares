package ev1.ut2_controlflujometodos.u03bucles.ejercicios.resueltos;

/**
 * Ejercicio 5 (while): Tabla de multiplicar de 5
 * Version resuelta.
 *
 * @author Agustin. A. Marquez. Pina
 * @since 29/04/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Ejercicio5_WHILE_RESUELTO {
    public static void main(String[] args) {
        int i = 1;
                while (i <= 10) {
                    System.out.println("5 x " + i + " = " + (5 * i));
                    i++;
                }
    }
}
