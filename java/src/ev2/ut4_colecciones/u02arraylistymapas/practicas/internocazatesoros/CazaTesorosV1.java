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
 * se representaran con el siguiente caracter ("✟"). - Cuando el jugador
 * encuentre el tesoro el programa imprime una ultima vez las tumbas y en la
 * tumba donde se encontraba el tesoro se imprime una estrella ("★"). - El
 * jugador tiene una X cantidad de intentos limitados que tú decidiras al
 * principio del juego la cantidad, en cada ronda, después de mostrarse las
 * tumbas y antes de pedir la posicion de la tumba que desea explorar, se
 * mostraran los intentos con corazones ("♥").
 */
import java.util.*;

public class CazaTesorosV1 {

    public static void main(String[] args) {
        /**
         * Posiciones => [ 0][ 1][ 2][ 3][ 4][ 5][ 6][ 7][ 8][ 9] Valores =>
         * ['']['']['']['']['']['']['']['']['']['']
         */
        char[] arrayTumbas = new char[10];

        // Booleano que avisa si hemos ganado o no.
        boolean victoria = false;

        // Llenamos el array de tumbas con la cruz de la tumba (✟) usando un bucle for.
        for (int i = 0; i < arrayTumbas.length; i++) {
            arrayTumbas[i] = '+';
        }

        int intentos, opcion, posicionTesoro, posicionElegida = 0;
        // Crear/instancias un nuevo "Scanner".
        Scanner teclado = new Scanner(System.in);

        // Dependiendo de la opción elegida el switch hace una cosa u otra.
        do {
            // El usuario ve las opciones del programa y elige una.
            MostrarMenu();
            opcion = teclado.nextInt();
            System.out.println();

            switch (opcion) {

                case 1:
                    System.out.println("El usuario ha elegido empezar el juego");

                    // La cantidad de intentos (dificultad) la elige el usuario
                    System.out.println("Elije el numero de intentos:");
                    intentos = teclado.nextInt();

                    // La posición del tesoro la elige la maquina aleatoriamente.
                    posicionTesoro = AsignarTesoro();

                    // Dentro de otro bucle
                    while (intentos > 0 && victoria == false) {

                        // Se muestra todas las tumbas
                        for (int i = 0; i < arrayTumbas.length; i++) {
                            System.out.print("[" + i + "]");
                        }
                        System.out.println();
                        for (int i = 0; i < arrayTumbas.length; i++) {
                            System.out.print("[" + arrayTumbas[i] + "]");
                        }

                        System.out.println();

                        // Se muestran los intentos
                        System.out.print("\nIntentos restantes: ");
                        for (int iteracion = 0; iteracion < intentos; iteracion++) {
                            System.out.print("@ ");
                        }
                        System.out.println();

                        // Inicia el bucle del juego.
                        // El usuario escoge una posicion
                        do {
                            System.out.println("Elije una posicion (0-9):");
                            posicionElegida = teclado.nextInt();

                            if (posicionElegida < 0 || posicionElegida > 9) {
                                System.out.println("Error, la posicion no es valida");

                            }

                        } while (posicionElegida < 0 || posicionElegida > 9);

                        if (posicionElegida == posicionTesoro) {
                            System.out.println("Has acertado. El tesoro estaba en la posicion " + posicionTesoro);
                            // Cambiar la posicion del array con la estrella
                            arrayTumbas[posicionTesoro] = '★';
                            victoria = true;

                            // Se muestra todas las tumbas
                            for (int i = 0; i < arrayTumbas.length; i++) {
                                System.out.print("[" + i + "]");
                            }
                            System.out.println();
                            for (int i = 0; i < arrayTumbas.length; i++) {
                                System.out.print("[" + arrayTumbas[i] + "]");
                            }

                        } else {
                            System.out.println("Error, el tesoro no estaba en esa posicion");
                            intentos--;
                            System.out.println("Te quedan " + intentos + " intentos");
                            arrayTumbas[posicionElegida] = 'X';
                        }

                    } // Fin del bucle del juego.

                    if (intentos == 0) {
                        System.out.println("¡Fin del juego! Te has quedado sin intentos.");
                    }

                    break;

                case 2:

                    System.out.println("El usuario ha elegido salir del juego");

                    break;

                default:
                    System.out.println("Opcion no valida");
                    break;

            }
        } while (opcion != 2);
        teclado.close();

    }

    public static void MostrarMenu() {
        System.out.println("Elije una opcion:");

        System.out.println("1. Empezar juego.");
        System.out.println("2. Salir del programa.");
        System.out.print("Elige una opción -> ");

    }

    public static int AsignarTesoro() {
        Random random = new Random();
        // Genera un numero aleatorio entre "0" y "11".
        int posicionTesoro = random.nextInt(10);
        return posicionTesoro;
    }

}
