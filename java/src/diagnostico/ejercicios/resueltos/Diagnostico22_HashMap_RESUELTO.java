package diagnostico.ejercicios.resueltos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * Frecuencia de palabras con HashMap
 *
 * <p><b>Instrucciones para el alumno:</b></p>
 * <ul>
 * <li>Crea un programa que cuente cuantas veces aparece cada palabra.</li>
 * <li>Completa el metodo contarPalabras(List<String> palabras) usando HashMap.</li>
 * <li>En el main, lee palabras (una por linea, linea vacia para terminar) con Scanner teclado.</li>
 * <li>Imprime el mapa de frecuencias.</li>
 * </ul>
 *
 * <p>Diagnostico 22 — EV2 · ut4_colecciones · RA6.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 07/06/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Diagnostico22_HashMap_RESUELTO {

    public static Map<String, Integer> contarPalabras(List<String> palabras) {
        Map<String, Integer> frecuencias;
        int indice;
        String palabra;
        frecuencias = new HashMap<>();
        for (indice = 0; indice < palabras.size(); indice++) {
            palabra = palabras.get(indice);
            frecuencias.put(palabra, frecuencias.getOrDefault(palabra, 0) + 1);
        }
        return frecuencias;
    }
    public static void main(String[] args) {
        Scanner teclado;
        List<String> palabras;
        String linea;
        Map<String, Integer> frecuencias;
        teclado = new Scanner(System.in);
        System.out.println("Palabras (linea vacia para terminar):");
        linea = teclado.nextLine();
        palabras = new ArrayList<>();
        while (!linea.isEmpty()) {
            palabras.add(linea);
            linea = teclado.nextLine();
        }
        frecuencias = contarPalabras(palabras);
        System.out.println("Frecuencias: " + frecuencias);
        teclado.close();
    }
}
