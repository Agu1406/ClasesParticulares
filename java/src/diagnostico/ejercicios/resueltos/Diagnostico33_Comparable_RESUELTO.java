package diagnostico.ejercicios.resueltos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Ordenacion con Comparable
 *
 * <p><b>Instrucciones para el alumno:</b></p>
 * <ul>
 * <li>Crea un programa que ordene alumnos por nota de mayor a menor.</li>
 * <li>Define la clase Alumno(nombre, nota) que implemente Comparable<Alumno>.</li>
 * <li>En el main, lee alumnos en formato nombre,nota (linea vacia para terminar) con Scanner teclado.</li>
 * <li>Ordena la lista con Collections.sort e imprime el resultado.</li>
 * </ul>
 *
 * <p>Diagnostico 33 — EV3 · ut6_pooavanzadaestructuras · RA7.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 07/06/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Diagnostico33_Comparable_RESUELTO {

    static class Alumno implements Comparable<Alumno> {
        private final String nombre;
        private final int nota;

        public Alumno(String nombre, int nota) {
            this.nombre = nombre;
            this.nota = nota;
        }

        @Override
        public int compareTo(Alumno otro) {
            return Integer.compare(otro.nota, this.nota);
        }

        @Override
        public String toString() {
            return nombre + "(" + nota + ")";
        }
    }
    public static void main(String[] args) {
        Scanner teclado;
        List<Alumno> alumnos;
        String linea;
        String nombre;
        int nota;
        teclado = new Scanner(System.in);
        System.out.println("Alumnos nombre,nota (linea vacia para terminar):");
        linea = teclado.nextLine();
        alumnos = new ArrayList<>();
        while (!linea.isEmpty()) {
            nombre = linea.split(",")[0].trim();
            nota = Integer.parseInt(linea.split(",")[1].trim());
            alumnos.add(new Alumno(nombre, nota));
            linea = teclado.nextLine();
        }
        Collections.sort(alumnos);
        System.out.println(alumnos);
        teclado.close();
    }
}
