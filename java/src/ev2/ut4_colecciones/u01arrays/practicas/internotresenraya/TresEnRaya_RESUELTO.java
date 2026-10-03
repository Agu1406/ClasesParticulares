package ev2.ut4_colecciones.u01arrays.practicas.internotresenraya;

import java.util.Scanner;

/**
 * Practica interna: Tres en raya — RESUELTO.
 *
 * <p>Tablero {@code char[3][3]}. Dos jugadores (1 = X, 2 = O). Pintar el tablero
 * al inicio de cada turno y luego pedir la casilla. Menú {@code do-while},
 * opción 0 para salir. DRY: menú, cajas y cambio de turno en funciones.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 05/09/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class TresEnRaya_RESUELTO {

    private static final int LADO = 3;
    private static final char VACIO = ' ';

    private static final Scanner teclado = new Scanner(System.in);

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
        System.out.println("Tablero char[3][3]. Hueco = espacio, jugador 1 = X, jugador 2 = O.");
        System.out.println("Cada turno se pinta el tablero y el jugador elige fila y columna (0-2).");
        System.out.println("Gana 3 en raya (fila, columna o diagonal). Si no quedan huecos: empate.");
    }

    public static char fichaDelTurno(int turno) {
        if (turno == 1) {
            return 'X';
        }
        return 'O';
    }

    public static int cambiarTurno(int turno) {
        if (turno == 1) {
            return 2;
        }
        return 1;
    }

    public static void inicializarTablero(char[][] tablero) {
        for (int fila = 0; fila < LADO; fila++) {
            for (int col = 0; col < LADO; col++) {
                tablero[fila][col] = VACIO;
            }
        }
    }

    public static void pintarCaja(String texto) {
        System.out.print("[" + texto + "]");
    }

    public static void pintarTablero(char[][] tablero) {
        System.out.println("¡TABLERO DE JUEGO ACTUAL!");
        for (int col = 0; col < LADO; col++) {
            pintarCaja(String.valueOf(col));
        }
        System.out.println();

        for (int fila = 0; fila < LADO; fila++) {
            pintarCaja(String.valueOf(fila));
            for (int col = 0; col < LADO; col++) {
                pintarCaja(String.valueOf(tablero[fila][col]));
            }
            System.out.println();
        }
    }

    public static boolean hayGanador(char[][] tablero, char ficha) {
        for (int i = 0; i < LADO; i++) {
            if (tablero[i][0] == ficha && tablero[i][1] == ficha && tablero[i][2] == ficha) {
                return true;
            }
            if (tablero[0][i] == ficha && tablero[1][i] == ficha && tablero[2][i] == ficha) {
                return true;
            }
        }
        if (tablero[0][0] == ficha && tablero[1][1] == ficha && tablero[2][2] == ficha) {
            return true;
        }
        if (tablero[0][2] == ficha && tablero[1][1] == ficha && tablero[2][0] == ficha) {
            return true;
        }
        return false;
    }

    public static boolean tableroLleno(char[][] tablero) {
        for (int fila = 0; fila < LADO; fila++) {
            for (int col = 0; col < LADO; col++) {
                if (tablero[fila][col] == VACIO) {
                    return false;
                }
            }
        }
        return true;
    }

    public static int pedirIndice(String mensaje) {
        System.out.print(mensaje);
        return teclado.nextInt();
    }

    public static void jugarPartida() {
        System.out.println("¡Partida a dos jugadores!");
        char[][] tablero = new char[LADO][LADO];
        inicializarTablero(tablero);

        int turno = 1;
        boolean terminada = false;
        while (!terminada) {
            pintarTablero(tablero);
            System.out.println("Turno del jugador " + turno + " (" + fichaDelTurno(turno) + ").");

            int fila = pedirIndice("Introduce una fila => ");
            int col = pedirIndice("Introduce una columna => ");

            if (fila < 0 || fila >= LADO || col < 0 || col >= LADO) {
                System.out.println("Índice fuera de rango.");
                continue;
            }
            if (tablero[fila][col] != VACIO) {
                System.out.println("Casilla ocupada.");
                continue;
            }

            char ficha = fichaDelTurno(turno);
            tablero[fila][col] = ficha;

            if (hayGanador(tablero, ficha)) {
                pintarTablero(tablero);
                System.out.println("¡Gana el jugador " + turno + "!");
                terminada = true;
            } else if (tableroLleno(tablero)) {
                pintarTablero(tablero);
                System.out.println("Empate.");
                terminada = true;
            } else {
                turno = cambiarTurno(turno);
            }
        }
    }
}
