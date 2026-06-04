package general.arraylist.resueltos;

import java.util.ArrayList;

/**
 * Ejercicio 8 resuelto: Sumar elementos
 * 
 * @author Agustin. A. Marquez. Pina
 * @since 26/04/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Ejercicio8_ArrayListSumarElementos {
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

