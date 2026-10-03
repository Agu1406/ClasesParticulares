package ev2.ut4_colecciones.u01arrays.practicas.internobatallanaval;

import java.util.Random;
import java.util.Scanner;

/**
 * Practica interna: Batalla naval — SIN RESOLVER.
 *
 * <p>Hotseat 10×10 (al pintar 11×11: letras A–J arriba = columnas, números 0–9
 * a la izquierda = filas). Ataque tipo {@code A7}. Flota boolean; ataque y
 * propio char. Barcos 5, 4, 3 y 2. Victoria: mismos {@code X} en el radar que
 * celdas de barco (recorrido 2D), sin contadores por referencia.</p>
 *
 * <p>Solución en {@link BatallaNaval_RESUELTO}.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 03/10/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class BatallaNaval_SIN_RESOLVER {

    private static final int TAMANO = 10;
    private static final char VACIO = ' ';
    private static final char BARCO = 'B';
    private static final char FALLO = 'F';
    private static final char TOCADO = 'X';
    private static final int[] LONGITUDES = {5, 4, 3, 2};

    private static final int DISPARO_REINTENTAR = -1;
    private static final int DISPARO_AGUA = 0;
    private static final int DISPARO_TOCADO = 1;
    private static final int TURNO_SEGUIR = 0;
    private static final int TURNO_GANADA = 1;

    private static final Scanner teclado = new Scanner(System.in);
    private static final Random generador = new Random();

    public static void main(String[] args) {
        // TODO: do-while; imprimirMenu(); 1 jugar, 2 objetivo, 0 salir.
    }

    public static int imprimirMenu() {
        // TODO: ¡Menú del programa! + [1]/[2]/[0] + "Introduce una opción => " y return.
        return 0;
    }

    public static void mostrarObjetivo() {
        // TODO: ejes A–J / 0–9, barcos 5-4-3-2, turno con dos tableros, victoria.
    }

    public static void jugarPartida() {
        // TODO: crear tableros, colocarBarcos, bucle con jugarTurno(1/2, ...).
        // TODO: REINTENTAR → continue; GANADA → fin; si no, cambiarTurno.
    }

    public static int jugarTurno(int jugador, char[][] ataque, char[][] propio,
            boolean[][] flotaRival, char[][] propioRival) {
        // TODO: pintarTurno → intentarDisparo.
        // TODO: si TOCADO y contarCasillas(ataque, TOCADO) == contarCeldasBarco() → GANADA.
        return TURNO_SEGUIR;
    }

    public static int cambiarTurno(int turno) {
        // TODO: 1 ↔ 2.
        return 0;
    }

    public static int contarCeldasBarco() {
        // TODO: sumar LONGITUDES.
        return 0;
    }

    public static int contarCasillas(char[][] tablero, char valor) {
        // TODO: recorrer el tablero y contar coincidencias.
        return 0;
    }

    public static char[][] crearTableroChar() {
        // TODO: char[TAMANO][TAMANO] con VACIO.
        return null;
    }

    public static void colocarBarcos(boolean[][] flota, char[][] propio) {
        // TODO: para cada longitud, colocarUnBarco.
    }

    public static void colocarUnBarco(boolean[][] flota, char[][] propio, int longitud) {
        // TODO: H/V al azar; fila y col al azar en todo el array; si cabeBarco, colocar.
    }

    public static boolean cabeBarco(boolean[][] flota, int fila, int col, int longitud, boolean horizontal) {
        // TODO: false si se sale del tablero o si alguna celda ya tiene barco.
        return false;
    }

    public static void pintarTurno(char[][] ataque, char[][] propio) {
        // TODO: enemigo arriba, propio abajo.
    }

    public static void pintarTablero(char[][] tablero) {
        // TODO: esquina + letras A–J; cada fila: número 0–9 + celdas.
    }

    public static void pintarCaja(String texto) {
        // TODO: System.out.print("[" + texto + "]");
    }

    public static int intentarDisparo(char[][] ataque, boolean[][] flotaRival, char[][] propioRival) {
        // TODO: "Ataca => "; interpretarCasilla; REINTENTAR / AGUA / TOCADO. Mensaje "Fallo."
        return DISPARO_REINTENTAR;
    }

    /**
     * @return {@code int[]{fila, col}} o {@code null} (letra = columna, cifra = fila)
     */
    public static int[] interpretarCasilla(String texto) {
        // TODO: length == 2; col = letra-'A'; fila = cifra-'0'; sin try/catch.
        return null;
    }

    public static boolean esPosicionValida(int fila, int col) {
        // TODO: 0 .. TAMANO-1.
        return false;
    }
}
