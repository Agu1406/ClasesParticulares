package ev2.ut4_colecciones.u01arrays.practicas.internobatallanaval;

import java.util.Random;
import java.util.Scanner;

/**
 * Practica interna: Batalla naval — RESUELTO.
 *
 * <p>Dos jugadores (hotseat). Cada uno: flota ({@code boolean[][]}), ataque y
 * propio ({@code char[][]}). Tablero 10×10; al pintar se ve 11×11: letras A–J
 * arriba (columnas) y números 0–9 a la izquierda (filas). Ataque tipo {@code A7}
 * = columna A, fila 7.</p>
 *
 * <p>Colocacion: H/V al azar + casilla al azar; si no cabe o solapa, reintenta.
 * Agua = {@code ' '}, fallo = {@code 'F'}, tocado = {@code 'X'}.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 03/10/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class BatallaNaval_RESUELTO {

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
        int opcion;
        do {
            opcion = imprimirMenu();
            switch (opcion) {
                case 1:
                    jugarPartida();
                    break;
                case 2:
                    mostrarObjetivo();
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        } while (opcion != 0);
    }

    public static int imprimirMenu() {
        System.out.println();
        System.out.println("¡Menú del programa!");
        System.out.println("[1] - Jugar partida (dos jugadores).");
        System.out.println("[2] - Ver objetivo.");
        System.out.println("[0] - Salir.");
        System.out.print("Introduce una opción => ");
        return teclado.nextInt();
    }

    public static void mostrarObjetivo() {
        System.out.println("Dos jugadores en el mismo PC. Cada uno: flota (boolean), ataque y propio (char).");
        System.out.println("Tablero 10×10 (al pintar 11×11: letras A–J arriba, números 0–9 a la izquierda).");
        System.out.println("Barcos al azar: 5, 4, 3 y 2. H/V y casilla aleatoria; si no cabe o solapa, reintenta.");
        System.out.println("Cada turno: enemigo arriba (solo F/X) y propio abajo (B + impactos).");
        System.out.println("Ataca con una casilla tipo A7 (letra = columna, número = fila).");
        System.out.println("Espacio = agua, F = fallo, X = tocado. Casilla inválida: se reintenta.");
        System.out.println("Gana quien hunde toda la flota rival.");
    }

    public static void jugarPartida() {
        System.out.println("¡Batalla naval a dos jugadores!");

        boolean[][] flotaJ1 = new boolean[TAMANO][TAMANO];
        boolean[][] flotaJ2 = new boolean[TAMANO][TAMANO];
        char[][] propioJ1 = crearTableroChar();
        char[][] propioJ2 = crearTableroChar();
        char[][] ataqueJ1 = crearTableroChar();
        char[][] ataqueJ2 = crearTableroChar();

        colocarBarcos(flotaJ1, propioJ1);
        colocarBarcos(flotaJ2, propioJ2);

        int turno = 1;
        boolean terminada = false;

        while (!terminada) {
            int estado;
            if (turno == 1) {
                estado = jugarTurno(1, ataqueJ1, propioJ1, flotaJ2, propioJ2);
            } else {
                estado = jugarTurno(2, ataqueJ2, propioJ2, flotaJ1, propioJ1);
            }

            if (estado == DISPARO_REINTENTAR) {
                continue;
            }
            if (estado == TURNO_GANADA) {
                terminada = true;
            } else {
                turno = cambiarTurno(turno);
            }
        }
    }

    /**
     * @return {@link #DISPARO_REINTENTAR}, {@link #TURNO_SEGUIR} o {@link #TURNO_GANADA}
     */
    public static int jugarTurno(int jugador, char[][] ataque, char[][] propio,
            boolean[][] flotaRival, char[][] propioRival) {
        System.out.println();
        System.out.println("Turno del jugador " + jugador + ".");
        pintarTurno(ataque, propio);

        int resultado = intentarDisparo(ataque, flotaRival, propioRival);
        if (resultado == DISPARO_REINTENTAR) {
            return DISPARO_REINTENTAR;
        }

        if (resultado == DISPARO_TOCADO) {
            System.out.println("¡Tocado!");
            if (contarCasillas(ataque, TOCADO) == contarCeldasBarco()) {
                pintarTurno(ataque, propio);
                System.out.println("¡Gana el jugador " + jugador + "!");
                return TURNO_GANADA;
            }
        }

        return TURNO_SEGUIR;
    }

    public static int cambiarTurno(int turno) {
        if (turno == 1) {
            return 2;
        }
        return 1;
    }

    public static int contarCeldasBarco() {
        int total = 0;
        for (int longitud : LONGITUDES) {
            total += longitud;
        }
        return total;
    }

    /** Cuenta cuántas veces aparece {@code valor} en el tablero (recorrido 2D). */
    public static int contarCasillas(char[][] tablero, char valor) {
        int total = 0;
        for (int fila = 0; fila < TAMANO; fila++) {
            for (int col = 0; col < TAMANO; col++) {
                if (tablero[fila][col] == valor) {
                    total++;
                }
            }
        }
        return total;
    }

    public static char[][] crearTableroChar() {
        char[][] tablero = new char[TAMANO][TAMANO];
        for (int fila = 0; fila < TAMANO; fila++) {
            for (int col = 0; col < TAMANO; col++) {
                tablero[fila][col] = VACIO;
            }
        }
        return tablero;
    }

    public static void colocarBarcos(boolean[][] flota, char[][] propio) {
        for (int longitud : LONGITUDES) {
            colocarUnBarco(flota, propio, longitud);
        }
    }

    public static void colocarUnBarco(boolean[][] flota, char[][] propio, int longitud) {
        boolean colocado = false;
        while (!colocado) {
            boolean horizontal = generador.nextBoolean();
            int fila = generador.nextInt(TAMANO);
            int col = generador.nextInt(TAMANO);

            if (cabeBarco(flota, fila, col, longitud, horizontal)) {
                for (int i = 0; i < longitud; i++) {
                    int f = fila;
                    int c = col;
                    if (horizontal) {
                        c = col + i;
                    } else {
                        f = fila + i;
                    }
                    flota[f][c] = true;
                    propio[f][c] = BARCO;
                }
                colocado = true;
            }
        }
    }

    public static boolean cabeBarco(boolean[][] flota, int fila, int col, int longitud, boolean horizontal) {
        for (int i = 0; i < longitud; i++) {
            int f = fila;
            int c = col;
            if (horizontal) {
                c = col + i;
            } else {
                f = fila + i;
            }
            if (!esPosicionValida(f, c)) {
                return false;
            }
            if (flota[f][c]) {
                return false;
            }
        }
        return true;
    }

    public static void pintarTurno(char[][] ataque, char[][] propio) {
        System.out.println("¡TABLERO ENEMIGO!");
        pintarTablero(ataque);
        System.out.println("¡TABLERO PROPIO!");
        pintarTablero(propio);
    }

    /** Cabecera A–J (columnas) y filas 0–9; todas las cajas de un carácter. */
    public static void pintarTablero(char[][] tablero) {
        pintarCaja(" ");
        for (int col = 0; col < TAMANO; col++) {
            pintarCaja(String.valueOf((char) ('A' + col)));
        }
        System.out.println();

        for (int fila = 0; fila < TAMANO; fila++) {
            pintarCaja(String.valueOf(fila));
            for (int col = 0; col < TAMANO; col++) {
                pintarCaja(String.valueOf(tablero[fila][col]));
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void pintarCaja(String texto) {
        System.out.print("[" + texto + "]");
    }

    public static int intentarDisparo(char[][] ataque, boolean[][] flotaRival, char[][] propioRival) {
        System.out.print("Ataca => ");
        String casilla = teclado.next().trim();

        int[] coords = interpretarCasilla(casilla);
        if (coords == null) {
            System.out.println("Casilla no válida. Ejemplo: A7");
            return DISPARO_REINTENTAR;
        }
        int fila = coords[0];
        int col = coords[1];

        if (ataque[fila][col] != VACIO) {
            System.out.println("Ya disparaste ahí.");
            return DISPARO_REINTENTAR;
        }

        if (flotaRival[fila][col]) {
            ataque[fila][col] = TOCADO;
            propioRival[fila][col] = TOCADO;
            return DISPARO_TOCADO;
        }

        ataque[fila][col] = FALLO;
        propioRival[fila][col] = FALLO;
        System.out.println("Fallo.");
        return DISPARO_AGUA;
    }

    /**
     * Interpreta {@code A7}: letra = columna (A–J), cifra = fila (0–9).
     *
     * @return {@code int[]{fila, col}} o {@code null}
     */
    public static int[] interpretarCasilla(String texto) {
        if (texto == null || texto.length() != 2) {
            return null;
        }
        char letra = Character.toUpperCase(texto.charAt(0));
        char cifra = texto.charAt(1);
        char ultimaLetra = (char) ('A' + TAMANO - 1);

        if (letra < 'A' || letra > ultimaLetra) {
            return null;
        }
        if (cifra < '0' || cifra > '9') {
            return null;
        }

        int col = letra - 'A';
        int fila = cifra - '0';
        if (!esPosicionValida(fila, col)) {
            return null;
        }
        return new int[] {fila, col};
    }

    public static boolean esPosicionValida(int fila, int col) {
        return fila >= 0 && fila < TAMANO && col >= 0 && col < TAMANO;
    }
}
