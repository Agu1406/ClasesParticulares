package ev1.ut2_controlflujometodos.u03bucles.ejercicios.resueltos;

/**
 * <p><b>OBJETIVO:</b> Usa un while para sumar los numeros del 1 al 100 y muestra Suma: con el resultado.</p>
 *
 * <br>
 *
 * <p><b>SOLUCIÓN:</b> Un acumulador suma i y luego i avanza. El total es 5050.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 29/04/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */

public class E14_Suma1A100_Resuelto {
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
