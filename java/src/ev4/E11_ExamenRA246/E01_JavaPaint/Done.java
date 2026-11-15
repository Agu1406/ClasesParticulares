package ev4.E11_ExamenRA246.E01_JavaPaint;

import java.util.Scanner;

/**
 * <p>Enunciado: {@code enunciado.md}.</p>
 *
 * <p><b>OBJETIVO:</b> RA6.1 — JavaPaint: matriz 11x11, cabezal, modos
 * pintar/borrar/mover, rotacion antihoraria, espejo horizontal y limpiar.</p>
 *
 * <br>
 *
 * <p><b>SOLUCIÓN:</b> el cabezal va en variables aparte; al mover, primero
 * aplica pintar/borrar en la casilla actual; bordes con {@code *} son muro;
 * {@code q} termina el bucle.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 15/11/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Done {

    static final int TAMANO = 11;

    public static void main(String[] args) {
        /* --- Variables al principio del metodo --- */
        Scanner teclado;
        char[][] tablero;
        int filaCabezal, columnaCabezal;
        char opcion, modo;
        boolean continuar;

        teclado = new Scanner(System.in);
        tablero = new char[TAMANO][TAMANO];
        limpiarTablero(tablero);
        filaCabezal = TAMANO / 2;
        columnaCabezal = TAMANO / 2;
        modo = 'M';
        continuar = true;

        do {
            imprimirTablero(tablero, filaCabezal, columnaCabezal, modo);
            imprimirMenu();
            opcion = teclado.next().charAt(0);

            if (opcion == 'q') {
                continuar = false;
            } else if (opcion == 'a') {
                aplicarModoAntesDeMover(tablero, filaCabezal, columnaCabezal, modo);
                if (columnaCabezal > 1) {
                    columnaCabezal--;
                }
            } else if (opcion == 'd') {
                aplicarModoAntesDeMover(tablero, filaCabezal, columnaCabezal, modo);
                if (columnaCabezal < TAMANO - 2) {
                    columnaCabezal++;
                }
            } else if (opcion == 'w') {
                aplicarModoAntesDeMover(tablero, filaCabezal, columnaCabezal, modo);
                if (filaCabezal > 1) {
                    filaCabezal--;
                }
            } else if (opcion == 's') {
                aplicarModoAntesDeMover(tablero, filaCabezal, columnaCabezal, modo);
                if (filaCabezal < TAMANO - 2) {
                    filaCabezal++;
                }
            } else if (opcion == 'p') {
                modo = 'P';
            } else if (opcion == 'b') {
                modo = 'B';
            } else if (opcion == 'm') {
                modo = 'M';
            } else if (opcion == 'r') {
                rotarAntihorario(tablero);
            } else if (opcion == 'e') {
                espejoHorizontal(tablero);
            } else if (opcion == 'l') {
                limpiarTablero(tablero);
            }
        } while (continuar);

        teclado.close();
    }

    static void limpiarTablero(char[][] tablero) {
        int fila, columna;

        for (fila = 0; fila < TAMANO; fila++) {
            for (columna = 0; columna < TAMANO; columna++) {
                if (fila == 0 || fila == TAMANO - 1
                        || columna == 0 || columna == TAMANO - 1) {
                    tablero[fila][columna] = '*';
                } else {
                    tablero[fila][columna] = ' ';
                }
            }
        }
    }

    static void aplicarModoAntesDeMover(char[][] tablero, int fila, int columna, char modo) {
        if (modo == 'P') {
            tablero[fila][columna] = 'x';
        } else if (modo == 'B') {
            tablero[fila][columna] = ' ';
        }
    }

    static void rotarAntihorario(char[][] tablero) {
        char[][] auxiliar;
        int fila, columna;

        auxiliar = new char[TAMANO][TAMANO];
        for (fila = 0; fila < TAMANO; fila++) {
            for (columna = 0; columna < TAMANO; columna++) {
                // 90 grados a la izquierda
                auxiliar[fila][columna] = tablero[columna][TAMANO - 1 - fila];
            }
        }
        for (fila = 0; fila < TAMANO; fila++) {
            for (columna = 0; columna < TAMANO; columna++) {
                tablero[fila][columna] = auxiliar[fila][columna];
            }
        }
    }

    static void espejoHorizontal(char[][] tablero) {
        char[][] auxiliar;
        int fila, columna;

        auxiliar = new char[TAMANO][TAMANO];
        for (fila = 0; fila < TAMANO; fila++) {
            for (columna = 0; columna < TAMANO; columna++) {
                auxiliar[fila][columna] = tablero[fila][TAMANO - 1 - columna];
            }
        }
        for (fila = 0; fila < TAMANO; fila++) {
            for (columna = 0; columna < TAMANO; columna++) {
                tablero[fila][columna] = auxiliar[fila][columna];
            }
        }
    }

    static void imprimirTablero(char[][] tablero, int filaCabezal, int columnaCabezal, char modo) {
        int fila, columna;

        for (fila = 0; fila < TAMANO; fila++) {
            for (columna = 0; columna < TAMANO; columna++) {
                if (fila == filaCabezal && columna == columnaCabezal) {
                    System.out.print(modo + " ");
                } else {
                    System.out.print(tablero[fila][columna] + " ");
                }
            }
            System.out.println();
        }
    }

    static void imprimirMenu() {
        System.out.println("a. Izquierda");
        System.out.println("d. Derecha");
        System.out.println("s. Abajo");
        System.out.println("w. Arriba");
        System.out.println("p. Pintar");
        System.out.println("b. Borrar");
        System.out.println("m. Mover");
        System.out.println("r. Rotar sentido antihorario");
        System.out.println("e. Espejo horizontal");
        System.out.println("l. Limpiar tablero");
        System.out.println("q. Salir");
    }
}
