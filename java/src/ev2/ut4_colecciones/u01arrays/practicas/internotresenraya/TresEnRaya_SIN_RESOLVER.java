package ev2.ut4_colecciones.u01arrays.practicas.internotresenraya;

import java.util.Scanner;

/**
 * Practica interna: Tres en raya — SIN RESOLVER.
 *
 * <p><b>Objetivo:</b> tres en raya en {@code char[3][3]}. Dos jugadores (1 = X, 2 = O).
 * Pintar el tablero al inicio de cada turno y luego pedir la casilla.
 * Menú {@code do-while}, opción 0 para salir. DRY: menú, E/S y cambio de turno
 * en funciones.</p>
 *
 * <p>Solución en {@link TresEnRaya_RESUELTO}.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 05/09/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class TresEnRaya_SIN_RESOLVER {

    private static final int LADO = 3;
    private static final char VACIO = ' ';

    private static final Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) {
        // TODO: do-while; imprimirMenu(); 1 jugar, 2 objetivo, 0 salir.
    }

    public static int imprimirMenu() {
        // TODO: ¡Menú del programa! + [1]/[2]/[0] + "Introduce una opción => " y return.
        return 0;
    }

    public static void mostrarObjetivo() {
        // TODO: explicar tablero, fichas, victoria y empate.
    }

    public static char fichaDelTurno(int turno) {
        // TODO: 1 → 'X', 2 → 'O'.
        return VACIO;
    }

    public static int cambiarTurno(int turno) {
        // TODO: 1 ↔ 2.
        return 0;
    }

    public static void inicializarTablero(char[][] tablero) {
        // TODO: rellenar con VACIO.
    }

    public static void pintarCaja(String texto) {
        // TODO: System.out.print("[" + texto + "]");
    }

    public static void pintarTablero(char[][] tablero) {
        // TODO: cabecera de columnas y filas con índice + casillas.
    }

    public static boolean hayGanador(char[][] tablero, char ficha) {
        // TODO: filas, columnas y diagonales.
        return false;
    }

    public static boolean tableroLleno(char[][] tablero) {
        // TODO: true si no queda VACIO.
        return false;
    }

    public static int pedirIndice(String mensaje) {
        // TODO: print(mensaje) + nextInt().
        return 0;
    }

    public static void jugarPartida() {
        // TODO: bucle de turnos; pintar → pedir casilla → colocar → ganar/empate/cambiarTurno.
    }
}
