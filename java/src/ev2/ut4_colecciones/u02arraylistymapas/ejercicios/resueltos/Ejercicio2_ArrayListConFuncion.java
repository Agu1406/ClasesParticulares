package ev2.ut4_colecciones.u02arraylistymapas.ejercicios.resueltos;

import java.util.ArrayList;

/**
 * Ejercicio 2 resuelto: ArrayList con funcion
 * 
 * @author Agustin. A. Marquez. Pina
 * @since 26/04/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Ejercicio2_ArrayListConFuncion {
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

