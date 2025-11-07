package Practica2;

import java.util.Scanner;

/*
 *author Alvaro Medina
 */
public class Practica2 {
    public static void main(String[] args) {
        // Scanner para introducir datos desde el teclado.
        Scanner teclado = new Scanner(System.in);
        // Cantidad de palabras (contadas a mano) del String de palabras.
        int cantidadPalabras = 3;
        // String para guardar la palabra que elijamos aleatoriamente.
        String palabraAleatoria;
        // String para crear un clon de la palabra aleatoría pero con guiones bajos.
        String palabraOculta;
        // Cantidad de fallos que el usuario ha cometido hasta el momento.
        int intentosHechos = 0;
        // Cantidad de fallos que aún le quedan al jugador.
        int fallosRestantes = 5;
        // Letra que introduce el usuario para intentar adivinar.
        char letraUsuario;

        String palabras = "alvaro alvaro alvaro";
        // String dado por el profesor con todas las palabras usabels en el juego.
        /*String palabras = "golondrina avetoro codorniz garcilla alcotan abubilla " +
                "perdiz abejaruco vencejo gavilan papamoscas petirrojo colirrojo " +
                "pechiazul lavandera mosquitero milano aguila roquero estornino  " +
                "treparriscos halcon buitre canastera picapinos gorrion verderon " +
                "verdecillo buitron bigotudo"; */

        // Utilizamos esta función para seleccionar una palabra al azar del String.
        palabraAleatoria = seleccionarPalabraAleatoria(palabras, cantidadPalabras);

        /*
         * La consola no muestra la palabra secreta si no un monton de "_ _ _ _ _"
         * que representan la cantidad de letras que tiene la palabra que tenemos
         * que elegir, vamos a llamarlo "palabraOculta" y lo generamos con la
         * siguiente función.
         */
        palabraOculta = generarPalabraOculta(palabraAleatoria);

        // Mostramos el saludo inicial del juego y la situación inicial del juego.
        System.out.println("Trata de adivinar la palabra misteriosa");
        mostrarSituacionDelJuegoActual(palabraOculta, intentosHechos, fallosRestantes);

        /*
         * Bucle que seguira mostrando el estado del juego y seguira
         * permitiendo que el jugador juegue siempre y cuando aún
         * tenga más de "0" fallos restantes Y la palabra aún no
         * este completa (esto ultimo lo verificamos con una función
         * boolean que compara la palabra oculta y la aleatoria y
         * devuelve false hasta que no sean iguales.
         */
        while (fallosRestantes > 0 && !palabraCompleta(palabraOculta)) {
            // Pido por pantalla y por teclado una letra.
            System.out.print("Introduce una letra: ");
            letraUsuario = teclado.nextLine().charAt(0);
            // Correcto o no, cuenta como un intento (no como un fallo).
            intentosHechos++;

            // Si la palabra contiene la letra dada por el usuario ejecuta el if.
            if (contieneLetra(palabraAleatoria, letraUsuario)) {
                // Remplaza en la palabra oculta los guiones por la letra dada coincidente.
                palabraOculta = remaplazarGuionesPorLetra(palabraOculta, palabraAleatoria, letraUsuario);
            } else {
                // Si se ejecuta el "else" la letra era incorrecta, un fallo menos restante.
                fallosRestantes--;
            }

            // Indiferentemnte de si sale bien o sale mal muestro el estado actual del juego.
            mostrarSituacionDelJuegoActual(palabraOculta, intentosHechos, fallosRestantes);
        }

        // Si el bucle termina es que el juego se acabo, muestro el estado final del juego.
        System.out.println("La palabra misteriosa era: " + palabraAleatoria);
        if (palabraCompleta(palabraOculta)) {
            System.out.println("ENHORABUENA, has acertado con " + intentosHechos + " intentos");
        } else {
            System.out.println("Lo siento, has fallado tras " + intentosHechos + " intentos");
        }
    }

    /**
     * Función encargada de remplazar los guiones de la palabra oculta que coincidan
     * con la letra dada por el usuario con esa misma letra.
     * @return
     */
    private static String remaplazarGuionesPorLetra(String palabraOculta, String palabraAleatoria, char letraUsuario) {
        String palabraOcultaNueva = "";
        /*
         * Recorre una por una todas las letras de la palabra secreta, si la letra
         * de "X" posición es igual a la letra dada por el usuario, agrega la letra,
         * si no, mantiene el carácter que ya estaba en la palabra oculta (letra o guion).
         */
        for (int posicion = 0; posicion < palabraAleatoria.length(); posicion++) {
            if (palabraAleatoria.charAt(posicion) == letraUsuario) {
                palabraOcultaNueva = palabraOcultaNueva + letraUsuario;
            } else {
                palabraOcultaNueva = palabraOcultaNueva + palabraOculta.charAt(posicion);
            }
        }

        // Devuelve la nueva palabra oculta.
        return palabraOcultaNueva;
    }

    /**
     * Función que revisa una por una todas las letras de la palabra y si la letra
     * que ha dado el usuario aparece en cualquier lugar de la palabra, devuelve
     * true, si no, false.
     */
    private static boolean contieneLetra(String palabra, char letraUsuario) {
        boolean contieneLetra = false;

        for (int posicion = 0; posicion < palabra.length(); posicion++) {
            if (palabra.charAt(posicion) == letraUsuario) {
                contieneLetra = true;
            }
        }

        // Devuelve "false" si no contiene la letra dada, "true" si lo hace.
        return contieneLetra;
    }


    public static boolean palabraCompleta(String palabraOculta) {
        // Por defecto esta completa hasta que se demuestre lo contrario.
        boolean estaCompleta = true;

        // Si cualquier carácter es un "_" entonces la palabra sigue imcompleta.
        for (int posicion = 0; posicion < palabraOculta.length(); posicion++) {
            if (palabraOculta.charAt(posicion) == '_') {
                estaCompleta = false;
            }
        }

        // Devuelve "true" si no se encontraron guiones en la palabra.
        return estaCompleta;

    }

    /**
     * Función creada con el unico proposito de mostrarle en cada intento un mensaje
     * al jugador que le diga en que situación se encuentra actualmente su partida.
     */
    public static void mostrarSituacionDelJuegoActual(String palabraOculta, int intentosHechos, int fallosRestantes) {
        // La palabra oculta es algo así "_____" pero queremos separar los guiones con espacios en blanco.
        for (int posicion = 0; posicion < palabraOculta.length(); posicion++) {
            // Imprimimos un guíon de la palabra.
            System.out.print(palabraOculta.charAt(posicion));
            // Si no es la ultima letra imprimimos un espacio en blanco entre cada guíon.
            if (posicion < palabraOculta.length() - 1) {
                // Entre cada guíon imprimimos un espacio en blanco.
                System.out.print(" ");
            }
        }
        // Salto de linea al terminar de imprimir toda la palabra.
        System.out.println("");

        // Intentos usados y fallos restantes del jugador.
        System.out.println("Intentos hechos: " + intentosHechos + " Fallos restantes: " + fallosRestantes);
    }

    /**
     * Función que recibe la palabra secreta y crea un String con la misma cantidad
     * de carácteres pero unicamente siendo guiones bajos para le juego de
     * adivinanza.
     */
    public static String generarPalabraOculta(String palabraAleatoria) {
        String palabraOculta = "";

        // Este bucle usa "lenght" para crear un "_" por cada letra que tenga la palabra.
        for (int posicion = 0; posicion < palabraAleatoria.length(); posicion++) {
            // "sumamos" al String un guíon bajo por cada letra de la palabra.
            palabraOculta = palabraOculta + "_";
        }

        // Devuelve la palabra secretra transformada en guiones bajos para adivinarla.
        return palabraOculta;
    }

    /**
     * Función encargada de elegir una palabra aleatoría de un conjunto dado, en este
     * caso, previamente, por el profesor.
     */
    public static String seleccionarPalabraAleatoria(String palabras, int cantidadPalabras) {
        // Creamos un número aleatorio entre "0" y "29" (la cantidad total de palabras).
        int numeroAleatorio = (int) (Math.random() * cantidadPalabras);
        // Variable que va contando cuantas palabras me he encontrado a través del bucle.
        int contadorPalabras = 0;
        // Variable que indicia el inicio del corte/substracción de la palabra (subString).
        int inicioCorte = 0;
        // Variable para guardar la palabra extraida.
        String palabraExtraida = "";

        // Bucle utilizado para recorrar una por una todas las letras de un String con 30 palabras.
        for (int posicion = 0; posicion < palabras.length(); posicion++) {
            // Si recorriendo una por una las letras encuentro un espacio en blanco ejecuta el if.
            if (palabras.charAt(posicion) == ' ') {
                /*
                 * Voy contando todas las palabras, si el número aleatorio ha
                 * elgegido por ejemplo la palabra "15", cuando el contador
                 * sea "15" significa que el bucle ya llego a la palabra que
                 * necesito "extraer".
                 */
                if (contadorPalabras == numeroAleatorio) {
                    // Corto el String desde el inicio del corte hasta la posición actual del bucle.
                    palabraExtraida= palabras.substring(inicioCorte, posicion);
                    return palabraExtraida;
                }
                /*
                 * Todas las letras tienen una posición diferente dentro de un
                 * String, la "0", la "1", etc, cada vez que detecte un espacio
                 * en blanco singifica que he llegado al inicio/final de una
                 * palabra, permitiendome contar cuantas palabras me he encontrado
                 * por el camino.
                 *
                 * Ejemplo de posiciones:
                 *
                 * [0][1][2][3][4][5][6][7][8][9][10][11][12][13][14][15][16][17]
                 * [g][o][l][o][n][d][r][i][n][a][  ][ a][ v][ e][ t][ o][ r][ o]
                 */
                contadorPalabras++;
                /*
                 * El inicio del corte siempre será el ultimo espacio en blanco encontrado
                 * hasta que el bucle llegue a la palabra deseada, garantizando que cuando
                 * la encuentre empieze a cortar despues el espacio anterior (+1) hasta el
                 * final de la palabra.
                 */
                inicioCorte = posicion + 1;

            }
        }

        /*
         * Este if solo se ejecuta si casualmente la ultima palabra del String
         * de palabras es precisamente la palabra elegida.
         */
        if (contadorPalabras == numeroAleatorio) {
            palabraExtraida = palabras.substring(inicioCorte);
            return palabraExtraida;
        }

        // Return por defecto si nada de lo anterior funciona, devuelve ("").
        return palabraExtraida;
    }
}

