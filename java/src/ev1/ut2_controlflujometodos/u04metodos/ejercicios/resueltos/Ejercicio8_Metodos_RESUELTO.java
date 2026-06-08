package ev1.ut2_controlflujometodos.u04metodos.ejercicios.resueltos;

/**
 * Ejercicio 8: Funcion con bucle for
 * Version resuelta.
 *
 * @author Agustin. A. Marquez. Pina
 * @since 29/04/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Ejercicio8_Metodos_RESUELTO {

    public static int sumarDel1AlN(int n) {
            int suma = 0;
            for (int i = 1; i <= n; i++) {
                suma += i;
            }
            return suma;
        }

    public static void main(String[] args) {
        System.out.println("Suma 1..10: " + sumarDel1AlN(10));
    }
}
