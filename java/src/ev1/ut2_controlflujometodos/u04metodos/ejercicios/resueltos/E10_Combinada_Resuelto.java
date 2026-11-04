package ev1.ut2_controlflujometodos.u04metodos.ejercicios.resueltos;

/**
 * <p><b>OBJETIVO:</b> Crea el metodo String resumenNumero, que diga si n es par o impar y la suma del 1 a n. En main imprime resumenNumero(8).</p>
 *
 * <br>
 *
 * <p><b>SOLUCIÓN:</b> La paridad sale con el operador ternario y la suma con un for. Con 8 el texto incluye par y la suma.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 29/04/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */

public class E10_Combinada_Resuelto {
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
