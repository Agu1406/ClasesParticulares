package general.funciones;

/**
 * Ejercicio 8: Función con bucle for
 * Versión resuelta.
 *
 * @author Agustín. A. Marquez. Piña
 * @since 29/04/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Ejercicio8_Funciones_RESUELTO {

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
