package ev1.ut2_controlflujometodos.u03bucles.ejercicios.resueltos;

/**
 * <p><b>OBJETIVO:</b> Usa un while para mostrar los numeros del 1 al 10, uno por linea.</p>
 *
 * <br>
 *
 * <p><b>SOLUCIÓN:</b> numero empieza en 1. El bucle imprime numero y luego lo incrementa mientras numero sea menor o igual que 10.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 29/04/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */

public class E11_Numeros1A10_Resuelto {
    public static void main(String[] args) {
        int numero = 1;
        while (numero <= 10) {
            System.out.println(numero);
            numero++;
        }
    }
}
