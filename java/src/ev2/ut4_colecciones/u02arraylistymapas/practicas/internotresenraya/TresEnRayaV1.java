package ev2.ut4_colecciones.u02arraylistymapas.practicas.internotresenraya;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * <p><b>OBJETIVO:</b> Practica interna (V1 / WIP de clase) — esqueleto de tres en raya
 * con arrays y ArrayList, menu y {@code StringBuilder}. Completar logica de partida
 * en clase; ver {@link TresEnRayaV2} para mas avance.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 05/09/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class TresEnRayaV1 {

    public static int puntosJugador1 = 0;
    public static int puntosJugador2 = 0;
    public static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;
        do {
            menuPrograma();
            opcion = teclado.nextInt();
            switch (opcion) {
                case 1:
                    Random generador = new Random();
                    int primerTurno = generador.nextInt(2) + 1;
                    System.out.println("Empieza el jugador: " + primerTurno);
                    System.out.println("TODO: bucle de partida con arrays primitivos.");
                    break;
                case 2:
                    System.out.println("TODO: bucle de partida con ArrayList.");
                    break;
                case 3:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opcion no valida");
            }
        } while (opcion != 3);
    }

    public static void menuPrograma() {
        System.out.println("Escoje una opcion:");
        System.out.println("1. Jugar con arrays primitivos");
        System.out.println("2. Jugar con arraylists");
        System.out.println("3. Salir del programa");
    }

    public static char[][] crearTableroPrimitivo() {
        char[][] tablero = new char[3][3];
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                tablero[i][j] = ' ';
            }
        }
        return tablero;
    }

    public static ArrayList<String> crearTableroArrayList() {
        ArrayList<String> tablero = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            tablero.add("   ");
        }
        return tablero;
    }

    public static void posicionarFichaPrimitiva(char[][] tablero, char ficha) {
        System.out.print("Escoge una fila (0 a 2): ");
        int fila = teclado.nextInt();
        System.out.print("Escoge una columna (0 a 2): ");
        int columna = teclado.nextInt();
        if (tablero[fila][columna] == ' ') {
            tablero[fila][columna] = ficha;
        } else {
            System.out.println("Posicion ocupada, elige otra.");
        }
    }

    public static void posicionarFichaArrayList(ArrayList<String> tablero, char ficha) {
        System.out.print("Escoge una fila (0 a 2): ");
        int fila = teclado.nextInt();
        System.out.print("Escoge una columna (0 a 2): ");
        int columna = teclado.nextInt();
        if (tablero.get(fila).charAt(columna) == ' ') {
            StringBuilder filaModificada = new StringBuilder(tablero.get(fila));
            filaModificada.setCharAt(columna, ficha);
            tablero.set(fila, filaModificada.toString());
            System.out.println("Ficha colocada en (" + fila + ", " + columna + ")");
        } else {
            System.out.println("Posicion no valida, elige otra.");
        }
    }

    public static void posicionarFichaMaquinaPrimitiva(char[][] tablero, char ficha) {
        Random generador = new Random();
        int fila = generador.nextInt(3);
        int columna = generador.nextInt(3);
        if (tablero[fila][columna] == ' ') {
            tablero[fila][columna] = ficha;
        }
    }

    /** Comprueba filas; ampliar a columnas/diagonales en clase. */
    public static char verificarGanador(char[][] tablero) {
        for (int i = 0; i < 3; i++) {
            if (tablero[i][0] != ' '
                    && tablero[i][0] == tablero[i][1]
                    && tablero[i][1] == tablero[i][2]) {
                return tablero[i][0];
            }
        }
        return ' ';
    }
}
