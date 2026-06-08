package ev1.ut2_controlflujometodos.u04metodos.ejercicios.resueltos;

/**
 * Ejercicio 10: Funcion compleja combinada
 * Version resuelta.
 *
 * @author Agustin. A. Marquez. Pina
 * @since 29/04/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Ejercicio10_Metodos_RESUELTO {

    public static String resumenNumero(int n) {
            String paridad = (n % 2 == 0) ? "par" : "impar";
            int suma = 0;
            for (int i = 1; i <= n; i++) {
                suma += i;
            }
            return "Numero " + n + ", " + paridad + ", suma 1..n = " + suma;
        }

    public static void main(String[] args) {
        System.out.println(resumenNumero(8));
    }
}
