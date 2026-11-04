package ev2.ut4_colecciones.u02arraylistymapas.ejercicios.resueltos;

import java.util.ArrayList;

/**
 * <p><b>OBJETIVO:</b> Crea un ArrayList con Java, SQL, HTML y CSS, y una funcion mostrarLista que reciba la lista y la imprima.</p>
 *
 * <br>
 *
 * <p><b>SOLUCIÓN:</b> mostrarLista recorre la lista con un for-each. main solo la rellena y la llama.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 26/04/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class E02_ArrayListConFuncion_Resuelto {
    public static void main(String[] args) {
        ArrayList<String> lista = new ArrayList<>();
        lista.add("Java");
        lista.add("SQL");
        lista.add("HTML");
        lista.add("CSS");
        mostrarLista(lista);
    }

    public static void mostrarLista(ArrayList<String> lista) {
        System.out.println("Contenido de la lista:");
        for (String elemento : lista) {
            System.out.println(elemento);
        }
    }
}
