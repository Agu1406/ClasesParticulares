package general.funciones;

/**
 * Ejercicio 10: Función compleja combinada
 * Versión resuelta.
 *
 * @author Agustín. A. Marquez. Piña
 * @since 29/04/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Ejercicio10_Funciones_RESUELTO {

    public static String resumenNumero(int n) {
            String paridad = (n % 2 == 0) ? "par" : "impar";
            int suma = 0;
            for (int i = 1; i <= n; i++) {
                suma += i;
            }
            return "Número " + n + ", " + paridad + ", suma 1..n = " + suma;
        }

    public static void main(String[] args) {
        System.out.println(resumenNumero(8));
    }
}
