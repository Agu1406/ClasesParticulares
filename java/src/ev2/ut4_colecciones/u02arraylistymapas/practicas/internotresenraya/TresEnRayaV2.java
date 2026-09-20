package ev2.ut4_colecciones.u02arraylistymapas.practicas.internotresenraya;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * <p><b>OBJETIVO:</b> Practica interna (V2) — tres en raya con array 2D,
 * menu, turnos y {@code StringBuilder}. Modo ArrayList pendiente (TODO de clase).</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 05/09/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class TresEnRayaV2 {

    public static Scanner teclado = new Scanner(System.in);
    public static int puntosJugador1;
    public static int puntosJugador2;
    public static String[][] tableroArray = new String[3][3];
    public static ArrayList<String> tableroArrayList = new ArrayList<>();

    public static void main(String[] args) {
        iniciarPrograma();
    }

    public static void iniciarPrograma() {
        boolean continuar;
        do {
            int opcion = imprimirMenu();
            continuar = ejecutarMenu(opcion);
        } while (continuar);
    }

    public static int imprimirMenu() {
        System.out.print(
                "\n¡OPCIONES DEL PROGRAMA!\n"
                        + "[1] - Jugar tres en raya (array).\n"
                        + "[2] - Jugar tres en raya (arraylist).\n"
                        + "[3] - Salir del programa.\n"
                        + "\nIntroduce una opcion -> ");
        return teclado.nextInt();
    }

    public static boolean ejecutarMenu(int opcion) {
        switch (opcion) {
            case 1:
                iniciarPartidaArray();
                break;
            case 2:
                iniciarPartidaArrayList();
                break;
            case 3:
                System.out.println("¡Hasta luego! (Fin del programa)");
                return false;
            default:
                System.out.println("¡Error! Opcion no valida.");
                break;
        }
        return true;
    }

    public static void iniciarPartidaArray() {
        boolean continuar = true;
        int rondas = 0;
        puntosJugador1 = 0;
        puntosJugador2 = 0;
        int turno = elegirPrimerTurno();
        prepararTableroArray();

        while (continuar && rondas < 9) {
            jugarRonda(turno);
            turno = cambiaTurno(turno);
            rondas++;
            if (rondas >= 9) {
                System.out.println("Tablero lleno o limite de rondas demo.");
                continuar = false;
            }
        }
    }

    public static void jugarRonda(int turno) {
        boolean jugadaValida = false;
        while (!jugadaValida) {
            imprimirTablero();
            solicitarJugada(turno);
            jugadaValida = intentarJugada(turno);
        }
    }

    public static boolean intentarJugada(int turno) {
        System.out.print("Introduce la fila a jugar -> ");
        int fila = teclado.nextInt();
        System.out.print("Introduce la columna a jugar -> ");
        int columna = teclado.nextInt();

        boolean jugadaValida = verificarJugada(fila, columna);
        if (jugadaValida && turno == 1) {
            tableroArray[fila][columna] = "X";
        } else if (jugadaValida && turno == 2) {
            tableroArray[fila][columna] = "O";
        }
        return jugadaValida;
    }

    public static boolean verificarJugada(int fila, int columna) {
        if (fila < 0 || fila > 2 || columna < 0 || columna > 2) {
            System.out.println("Posicion fuera de rango.");
            return false;
        }
        if (!" ".equals(tableroArray[fila][columna])) {
            System.out.println("¡Alguien ya jugo ahi! Elige otra posicion");
            return false;
        }
        return true;
    }

    public static void solicitarJugada(int turno) {
        StringBuilder constructor = new StringBuilder();
        constructor.append("¡Jugador ");
        constructor.append(turno);
        constructor.append(" es tu turno! Elige donde jugar.");
        System.out.println(constructor);
    }

    public static void imprimirTablero() {
        StringBuilder constructor = new StringBuilder();
        for (int fila = 0; fila < tableroArray.length; fila++) {
            for (int columna = 0; columna < tableroArray[fila].length; columna++) {
                constructor.append('[');
                constructor.append(tableroArray[fila][columna]);
                constructor.append(']');
            }
            constructor.append('\n');
        }
        System.out.println(constructor);
    }

    public static void prepararTableroArray() {
        for (int fila = 0; fila < tableroArray.length; fila++) {
            for (int columna = 0; columna < tableroArray[fila].length; columna++) {
                tableroArray[fila][columna] = " ";
            }
        }
    }

    public static int elegirPrimerTurno() {
        Random generador = new Random();
        int primerTurno = generador.nextInt(2) + 1;
        StringBuilder constructor = new StringBuilder();
        constructor.append("¡Empieza el jugador N.º");
        constructor.append(primerTurno);
        constructor.append('!');
        System.out.println(constructor);
        return primerTurno;
    }

    public static int cambiaTurno(int turno) {
        return turno == 1 ? 2 : 1;
    }

    public static void iniciarPartidaArrayList() {
        System.out.println("¡Por hacer! (TODO ArrayList) — tablero size=" + tableroArrayList.size());
    }
}
