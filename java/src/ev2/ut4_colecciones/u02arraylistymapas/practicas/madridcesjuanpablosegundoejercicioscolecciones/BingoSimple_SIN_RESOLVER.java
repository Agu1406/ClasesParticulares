package ev2.ut4_colecciones.u02arraylistymapas.practicas.madridcesjuanpablosegundoejercicioscolecciones;

/**
 * Practica que simula un juego de bingo con Arrays de una dimension y
 * dos dimensiones, genera numeros aleatorios y tiene un espacio en el
 * medio con dos equis ("XX")
 *
 * @author Billy
 * @since 18/11/2025
 */
public class BingoSimple_SIN_RESOLVER {
    public static void main(String[] args) {
        /*
         * Representacion "grafica" del Array que acabamos de crear.
         *  0  1  2  3  4
         * [ ][ ][ ][ ][ ]
         * [ ][ ][ ][ ][ ]
         * [ ][ ][ ][ ][ ]
         * [ ][ ][ ][ ][ ]
         * [ ][ ][ ][ ][ ]
         */
        int[][] numerosCarton = new int[5][5];
        /*
         * Representacion "grafica" del Array que acabamos de crear.
         *   0  1   2   3    4
         * [""][""][""][""][""]
         * [""][""][""][""][""]
         * [""][""][""][""][""]
         * [""][""][""][""][""]
         * [""][""][""][""][""]
         */
        String[][] numerosTachados = new String[5][5];
        /*
         * Creo un Array de una sola dimension donde puedo ir guardando
         * los numeros que ya he cantado a lo largo del juego.
         */
        int[] numerosYaCantados = new int[75];
        // El numero "0" ya esta cantado porque es el numero del centro del carton.
        numerosYaCantados[0] = 0;

        // La posicion del medio por defecto es "valida" con dos equis ("XX").
        numerosTachados[2][2] = "XX";

        // Mensaje de bienvenida al programa/juego del Bingo_SIN_RESOLVER.
        System.out.println("!Bienvenido al bingo de Billy!");

        // Funcion encargada de llenar el carton de numeros aleatorios.
        llenarCartonDeNumeros(numerosCarton);

        // Mostrar el carton.
        mostrarCarton(numerosCarton, numerosTachados);

        // Funcion encargada de cantar numeros aleatorios no repetidos del "1" al "75".
        cantarNumero(numerosYaCantados);








    }

    private static void mostrarCarton(int[][] numerosCarton, String[][] numerosTachados) {

        System.out.println("!Carton de Bingo_SIN_RESOLVER!");

        // Bucle que recorre una por una todas las columnas del carton.
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
        // Variable para guardar los numeros que voy cantando.
        int numeroAleatorio;

        boolean numeroCantado;

        do {
            // El bucle nada mas empezar cree que el numero no ha sido cantado antes.
            numeroCantado = false;

            // Creo un numero aleatorio para cantarlo.
            numeroAleatorio = (int) (Math.random() * 75) + 1;

            // Verifico si ese numero ya fue cantado anteriormente.
            for (int posicion = 0; posicion < 75; posicion++) {
                /*
                 * Si encuentro ese numero dentro del Array de numeros ya cantados
                 * significa que no sirve, ya fue cantado, debo crear un numero
                 * nuevo y volver a verificar.
                 */
                if (numerosYaCantados[posicion] == numeroAleatorio) {
                    numeroCantado = true;
                }
            }
        } while (numeroCantado);

        // Canto el numero mostrandolo en pantalla.
        System.out.println("!Numero " + numeroAleatorio + " !");
    }

    private static void llenarCartonDeNumeros(int[][] numerosCarton) {
        // Creamos una variable para guardar un numero entero.
        int numero;

        // Variable booleana que me dice si un numero esta repetido o no.
        boolean numeroRepetido;

        // El primer bucle dice cual columna estamos llenado de numeros actualmente.
        for (int columna = 0; columna < 5; columna++) {

            // El segundo bucle llena todas las filas de esa columna de numeros.
            for (int fila = 0; fila < 5; fila++) {

                // El numero esta repetido
                numeroRepetido = true;

                /*
                 * Este bucle genera un numero aleatorio, luego
                 * revisa si ese numero ya se ha usado anteriormente,
                 * si se ha usado significa que esta repetido, entonces
                 * crea un numero nuevo diferente hasta que consiga un
                 * numero que no este repetido.
                 */
                do { // Do (haz) un numero aleatorio...

                    // Creo un numero aleatorio entre "1" y "75".
                    numero = (int) (Math.random() * 75) + 1;

                    // Funcion que devuelve "true" si el numero esta repetido y "false" si no.
                    numeroRepetido = verificarNumeroRepetido(numero, numerosCarton);

                } while (numeroRepetido); // Si esta repetido, vuelve a empezar...

                // Guardo el numero aleatorio que acabo de crear en el carton.
                numerosCarton[columna][fila] = numero;

            }
        }


    }

    public static boolean verificarNumeroRepetido(int numero, int[][] numerosCarton) {
        // El numero no esta repetido hasta que se demuestre lo contrario.
        boolean repetido = false;

        // Reviso una por una todas las columnas
        for (int columna = 0; columna < 5; columna++) {
            // Reviso una por una todas las filas de las columnas.
            for (int fila = 0; fila < 5; fila++) {
                /*
                 * Si en cualquier posicion del carton consigo que el numero
                 * ya existe, esta repetido.
                 */
                if (numerosCarton[columna][fila] == numero) {
                    repetido = true;
                }
            }
        }

        // Devuelve "false" si no encuentra el numero, si esta repetido devuelve "true".
        return repetido;
    }
}

