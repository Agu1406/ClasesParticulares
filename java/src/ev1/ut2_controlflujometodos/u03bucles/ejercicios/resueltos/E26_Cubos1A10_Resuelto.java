package ev1.ut2_controlflujometodos.u03bucles.ejercicios.resueltos;

/**
 * <p><b>OBJETIVO:</b> Usa un do-while para mostrar el cubo de cada numero del 1 al 10, con el formato numero^3 = resultado.</p>
 *
 * <br>
 *
 * <p><b>SOLUCIÓN:</b> Cada vuelta imprime numero * numero * numero.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 29/04/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */

public class E26_Cubos1A10_Resuelto {
    public static void main(String[] args) {
        int numero = 1;
        do {
            System.out.println(numero + "^3 = " + (numero * numero * numero));
            numero++;
        } while (numero <= 10);
    }
}
