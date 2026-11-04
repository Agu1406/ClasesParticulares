package ev1.ut2_controlflujometodos.u03bucles.ejercicios.resueltos;

/**
 * <p><b>OBJETIVO:</b> Usa un while para sumar 1, 2, 3... hasta que la suma supere 100. Muestra Suma final: con el resultado.</p>
 *
 * <br>
 *
 * <p><b>SOLUCIÓN:</b> El bucle sigue mientras la suma sea menor o igual que 100. El numero que la supera si cuenta.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 29/04/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */

public class E20_SumaHasta100_Resuelto {
    public static void main(String[] args) {
        int suma = 0;
        int i = 1;
        while (suma <= 100) {
            suma += i;
            i++;
        }
        System.out.println("Suma final: " + suma);
    }
}
