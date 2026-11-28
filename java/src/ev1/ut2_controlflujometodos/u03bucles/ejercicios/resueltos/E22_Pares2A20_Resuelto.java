package ev1.ut2_controlflujometodos.u03bucles.ejercicios.resueltos;

/**
 * <p><b>OBJETIVO:</b> Usa un do-while para mostrar los numeros pares del 2 al 20, uno por linea.</p>
 *
 * <br>
 *
 * <p><b>SOLUCIÓN:</b> numero empieza en 2, se imprime y suma 2. El bucle sigue mientras numero sea menor o igual que 20.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 29/04/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */

public class E22_Pares2A20_Resuelto {
    public static void main(String[] args) {
        int numero = 2;
        do {
            System.out.println(numero);
            numero += 2;
        } while (numero <= 20);
    }
}
