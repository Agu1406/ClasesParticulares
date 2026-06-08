package diagnostico.ejercicios.pendientes;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Gestion de nombres con ArrayList
 *
 * <p><b>Instrucciones para el alumno:</b></p>
 * <ul>
 * <li>Crea un programa que gestione una lista de nombres con ArrayList.</li>
 * <li>Completa el metodo gestionarNombres(Scanner teclado): lee nombres hasta linea vacia, elimina uno indicado por el usuario y devuelve la lista.</li>
 * <li>En el main, llama al metodo con Scanner teclado e imprime la lista final.</li>
 * </ul>
 *
 * <p>Diagnostico 21 — EV2 · ut4_colecciones · RA6.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 07/06/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Diagnostico21_ArrayList_SIN_RESOLVER {

    public static List<String> gestionarNombres(Scanner teclado) {
        // TODO: ArrayList; leer nombres de teclado hasta linea vacia; eliminar uno indicado
        return null;
    }
    public static void main(String[] args) {
        Scanner teclado;
        List<String> nombres;
        teclado = new Scanner(System.in);
        // TODO: llamar a gestionarNombres(teclado)
        nombres = gestionarNombres(teclado);
        System.out.println("Lista final: " + nombres);
        teclado.close();
    }
}
