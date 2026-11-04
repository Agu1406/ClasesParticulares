package ev2.ut4_colecciones.u02arraylistymapas.ejercicios.resueltos;

import java.util.ArrayList;

/**
 * <p><b>OBJETIVO:</b> En la lista 10, 20, 30, 40 y 50 sustituye la posicion 3 por 99 con set.</p>
 *
 * <br>
 *
 * <p><b>SOLUCIÓN:</b> set(3, 99) cambia el 40 y no cambia el tamano de la lista.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 26/04/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class E07_ArrayListActualizarElemento_Resuelto {
    public static void main(String[] args) {
        ArrayList<Integer> numeros = new ArrayList<>();
        numeros.add(10);
        numeros.add(20);
        numeros.add(30);
        numeros.add(40);
        numeros.add(50);

        numeros.set(3, 99);
        System.out.println(numeros);
    }
}
