package ev2.ut4_colecciones.u02arraylistymapas.ejercicios.resueltos;

import java.util.ArrayList;

/**
 * <p><b>OBJETIVO:</b> Suma los enteros 3, 8, 2 y 7 de un ArrayList.</p>
 *
 * <br>
 *
 * <p><b>SOLUCIÓN:</b> Un acumulador recorre la lista y suma cada elemento.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 26/04/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class E08_ArrayListSumarElementos_Resuelto {
    public static void main(String[] args) {
        ArrayList<Integer> numeros = new ArrayList<>();
        numeros.add(3);
        numeros.add(8);
        numeros.add(2);
        numeros.add(7);

        int suma = 0;
        for (int n : numeros) {
            suma += n;
        }

        System.out.println("Suma total: " + suma);
    }
}
