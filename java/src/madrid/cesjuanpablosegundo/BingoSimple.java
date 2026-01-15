package madrid.cesjuanpablosegundo;

/**
 * Practica que simula un juego de bingo con Arrays de una dimensión y
 * dos dimensiones, genera números aleatorios y tiene un espacio en el
 * medio con dos equis ("XX")
 *
 * @author Billy
 * @since 18/11/2025
 */
public class BingoSimple {
    public static void main(String[] args) {
        /*
         * Representación "grafica" del Array que acabamos de crear.
         *  0  1  2  3  4
         * [ ][ ][ ][ ][ ]
         * [ ][ ][ ][ ][ ]
         * [ ][ ][ ][ ][ ]
         * [ ][ ][ ][ ][ ]
         * [ ][ ][ ][ ][ ]
         */
        int[][] numerosCarton = new int[5][5];
        /*
         * Representación "grafica" del Array que acabamos de crear.
         *   0  1   2   3    4
         * [""][""][""][""][""]
         * [""][""][""][""][""]
         * [""][""][""][""][""]
         * [""][""][""][""][""]
         * [""][""][""][""][""]
         */
        String[][] numerosTachados = new String[5][5];
        /*
         * Creo un Array de una sola dimensión donde puedo ir guardando
         * los números que ya he cantado a lo largo del juego.
         */
        int[] numerosYaCantados = new int[75];
        // El número "0" ya está cantado porque es el número del centro del cartón.
        numerosYaCantados[0] = 0;

        // La posición del medio por defecto es "valida" con dos equis ("XX").
        numerosTachados[2][2] = "XX";

        // Mensaje de bienvenida al programa/juego del Bingo.
        System.out.println("¡Bienvenido al bingo de Billy!");

        // Función encargada de llenar el cartón de numeros aleatorios.
        llenarCartonDeNumeros(numerosCarton);

        // Mostrar el carton.
        mostrarCarton(numerosCarton, numerosTachados);

        // Función encargada de cantar números aleatorios no repetidos del "1" al "75".
        cantarNumero(numerosYaCantados);








    }

    private static void mostrarCarton(int[][] numerosCarton, String[][] numerosTachados) {

        System.out.println("¡Cartón de Bingo!");

        // Bucle que recorre una por una todas las columnas del cartón.
        for (int columna = 0; columna < 5; columna++) {
            // Bucle que recorre una por una todas las filas de las columnas.
            for (int fila = 0; fila < 5; fila++) {

                if (columna == 2 && fila == 2) {
                    System.out.print("XX");
                } else {

                    if (numerosCarton[columna][fila] <= 9) {
                        System.out.print(numerosCarton[columna][fila] + " ");
                    } else {
                        System.out.println(numerosCarton[columna][fila]);
                    }
                }

            }

        }

    }

    public static void cantarNumero(int[] numerosYaCantados) {
        // Variable para guardar los números que voy cantando.
        int numeroAleatorio;

        boolean numeroCantado;

        do {
            // El bucle nada más empezar cree que el número no ha sido cantado antes.
            numeroCantado = false;

            // Creo un número aleatorio para cantarlo.
            numeroAleatorio = (int) (Math.random() * 75) + 1;

            // Verifico si ese número ya fue cantado anteriormente.
            for (int posicion = 0; posicion < 75; posicion++) {
                /*
                 * Si encuentro ese número dentro del Array de números ya cantados
                 * significa que no sirve, ya fue cantado, debo crear un número
                 * nuevo y volver a verificar.
                 */
                if (numerosYaCantados[posicion] == numeroAleatorio) {
                    numeroCantado = true;
                }
            }
        } while (numeroCantado);

        // Canto el número mostrandolo en pantalla.
        System.out.println("¡Numero " + numeroAleatorio + " !");
    }

    private static void llenarCartonDeNumeros(int[][] numerosCarton) {
        // Creamos una variable para guardar un número entero.
        int numero;

        // Variable booleana que me dice si un número esta repetido o no.
        boolean numeroRepetido;

        // El primer bucle dice cual columna estamos llenado de números actualmente.
        for (int columna = 0; columna < 5; columna++) {

            // El segundo bucle llena todas las filas de esa columna de números.
            for (int fila = 0; fila < 5; fila++) {

                // El número está repetido
                numeroRepetido = true;

                /*
                 * Este bucle genera un número aleatorio, luego
                 * revisa si ese número ya se ha usado anteriormente,
                 * si se ha usado significa que esta repetido, entonces
                 * crea un número nuevo diferente hasta que consiga un
                 * número que no este repetido.
                 */
                do { // Do (haz) un número aleatorio...

                    // Creo un número aleatorio entre "1" y "75".
                    numero = (int) (Math.random() * 75) + 1;

                    // Función que devuelve "true" si el número esta repetido y "false" si no.
                    numeroRepetido = verificarNumeroRepetido(numero, numerosCarton);

                } while (numeroRepetido); // Si esta repetido, vuelve a empezar...

                // Guardo el número aleatorio que acabo de crear en el carton.
                numerosCarton[columna][fila] = numero;

            }
        }


    }

    public static boolean verificarNumeroRepetido(int numero, int[][] numerosCarton) {
        // El número no esta repetido hasta que se demuestre lo contrario.
        boolean repetido = false;

        // Reviso una por una todas las columnas
        for (int columna = 0; columna < 5; columna++) {
            // Reviso una por una todas las filas de las columnas.
            for (int fila = 0; fila < 5; fila++) {
                /*
                 * Si en cualquier posición del cartón consigo que el número
                 * ya existe, está repetido.
                 */
                if (numerosCarton[columna][fila] == numero) {
                    repetido = true;
                }
            }
        }

        // Devuelve "false" si no encuentra el número, si está repetido devuelve "true".
        return repetido;
    }
}

