package ev2.ut4_colecciones.u02arraylistymapas.practicas.internocazatesoros;

/**
 * Vamos a hacer un pequeño videojuego llamado cazatesoros, el juego consiste de
 * la siguiente logica:
 *
 * Se muestra por pantalla un total de 10 tumbas/espacios y el jugador puede
 * elegir una para verificar si se encuentra en ella o no el tesoro que está
 * buscando, el ordenador elige aleatoriamente la ubicación del tesoro usando
 * "Random".
 *
 * El juego tiene las siguientes caracteristicas:
 *
 * - Menu interactivo (bucle do-while). - Condicionales varios (if, if-else,
 * switch). - Bucles (donde los veas necesarios, for, foreach, while). - En cada
 * ronda se mostrara en la consola todas las tumbas y sus posiciones, las tumbas
 * se representaran con el siguiente caracter ("✝"). - Cuando el jugador
 * encuentre el tesoro el programa imprime una ultima vez las tumbas y en la
 * tumba donde se encontraba el tesoro se imprime una estrella ("★"). - El
 * jugador tiene una X cantidad de intentos limitados que tú decidiras al
 * principio del juego la cantidad, en cada ronda, después de mostrarse las
 * tumbas y antes de pedir la posicion de la tumba que desea explorar, se
 * mostraran los intentos con corazones ("♥").
 */
import java.util.*;

public class CazaTesorosV2 {

    public static void main(String[] args) {
        /**
         * Posiciones => [0][1][2][3][4][5][6][7][8][9]
         * Valores => [✝][✝][✝][✝][✝][✝][✝][✝][✝][✝]
         */
        char[] tumbas = new char[10];
        int intentos, opcion, posicionTesoro, posicionUsuario;
        Random generador = new Random();
        Scanner teclado = new Scanner(System.in);
        boolean victoria = false;

        /**
         * CONFIGURACIÓN PREVIA AL JUEGO - El array viene vacio por defecto y lo
         * llenamos de cruces (tumbas) para prepararlo para el juego.
         */
        for (int posicion = 0; posicion < tumbas.length; posicion++) {
            tumbas[posicion] = 'T';
        }

        do {
            // El usuario ve las opciones y elige una.
            ImprimirMenu();
            opcion = teclado.nextInt();
            System.out.println();

            // Dependiendo de la opción el programa hace una cosa u otra.
            switch (opcion) {

                case 1:
                    intentos = ElegirDificultad();
                    posicionTesoro = AsignarTesoro();

                    // El bucle dentro del que vive el juego termina si se queda sin intentos.
                    while (intentos > 0 && !victoria) {
                        // Mostramos las tumbas y sus posiciones.
                        MostrarTablero(tumbas);

                        // Mostramos los intentos restantes.
                        MostrarIntentos(intentos);

                        // El jugador elige la posible ubicación del tesoro.
                        posicionUsuario = IntentoUsuario();

                        // Si el jugador adivina la posición del tesoro se ejecuta el if.
                        if (posicionUsuario == posicionTesoro) {
                            // Remplazamos la tumba con el simbolo ganador de la estrella.
                            tumbas[posicionUsuario] = 'V';

                            // Mostramos una ultima vez el tablero.
                            MostrarTablero(tumbas);

                            // Mensaje que confirma la victoria.
                            System.out.println("¡Enhorabuena, has conseguido el tesoro!");

                            // Modificamos la variable para matar el bucle del juego.
                            victoria = true;
                        }
                        // Si la ubicación es incorrecta se ejecuta el else.
                        else {
                            // Remplazamos la tumba por una X indicando que ahí no era.
                            tumbas[posicionUsuario] = 'X';

                            // Disminuye la cantidad de intentos del usuario.
                            intentos--;

                            if (intentos == 0) {
                                System.out.println("¡Fin del juego, te has quedado sin intentos!");
                            } else {
                                // Mensaje que confirma el fracaso
                                System.out.println("¡Ubicación incorrecta, intentalo de nuevo!");
                            }

                        }
                    }
                    break;

                case 2:
                    System.out.println("¡Fin del programa!");
                    break;

                default:
                    System.out.println("¡Error! Opción no valida, intentalo de nuevo.");
                    break;
            }

        } while (opcion != 2);
    }

    public static int IntentoUsuario() {
        Scanner teclado = new Scanner(System.in);
        int posicionUsuario;

        do {
            System.out.print("Elige una tumba para excavar (0-9) -> ");
            posicionUsuario = teclado.nextInt();

            if (posicionUsuario < 0 || posicionUsuario > 9) {
                System.out.println("¡Error! Posición no valida, elige un número entre cero y nueve");
            }

        } while (posicionUsuario < 0 || posicionUsuario > 9);

        return posicionUsuario;
    }

    /**
     * Función que imprime los intentos restantes en una sola linea en forma de
     * corazones.
     */
    public static void MostrarIntentos(int intentos) {
        System.out.print("Intentos restantes: ");
        for (int posicion = 0; posicion < intentos; posicion++) {
            System.out.print("@ ");
        }
        System.out.println();
    }

    /**
     * Función que imprime todas las tumbas y sus posiciones, en la linea de
     * arriba las posiciones y en la linea de abajo las tumbas.
     */
    public static void MostrarTablero(char[] tumbas) {

        // Este bucle imprime encima de las tumbas sus posiciones en cajitas.
        for (int posicion = 0; posicion < tumbas.length; posicion++) {
            System.out.print("[" + posicion + "]");
        }

        // Salto de linea entre las posiciones y las tumbas.
        System.out.println();

        // Este bucle imprime las tumbas como tal (las cruces) dentro de cajitas.
        for (int posicion = 0; posicion < tumbas.length; posicion++) {
            System.out.print("[" + tumbas[posicion] + "]");
        }

        // Salto de linea entre las posiciones y las tumbas.
        System.out.println();
    }

    /**
     * Función que usa una instancia de la clase "Scanner" para que el usuario
     * pueda elegir la cantidad de intentos (int) que tendra su partida en el
     * juego.
     */
    public static int ElegirDificultad() {
        Scanner teclado = new Scanner(System.in);
        System.out.print("Elige la cantidad de intentos que tendras -> ");
        int intentos = teclado.nextInt();
        return intentos;
    }

    public static int AsignarTesoro() {
        Random generadorAleatorio = new Random();
        // Genera un número aleatorio entre "0" y "9" (el 10 es exclusivo).
        int posicionTesoro = generadorAleatorio.nextInt(10);

        return posicionTesoro;
    }

    public static void ImprimirMenu() {
        System.out.print(
                "\n¡OPCIONES DEL PROGRAMA!\n"
                        + "[1] - Iniciar nueva partida.\n"
                        + "[2] - Salir del programa.\n"
                        + "Introduce una opción -> ");
    }
}
