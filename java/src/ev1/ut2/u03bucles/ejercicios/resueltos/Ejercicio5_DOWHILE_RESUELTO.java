package ev1.ut2.u03bucles.ejercicios.resueltos;

/**
 * Ejercicio 5 (dowhile): Tabla de multiplicar de 9
 * Version resuelta.
 *
 * @author Agustin. A. Marquez. Pina
 * @since 29/04/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Ejercicio5_DOWHILE_RESUELTO {
    public static void main(String[] args) {
        int i = 1;
                do {
                    System.out.println("9 x " + i + " = " + (9 * i));
                    i++;
                } while (i <= 10);
    }
}
