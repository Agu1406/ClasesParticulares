package ev2.ut4_colecciones.u02arraylistymapas.practicas.internopescalo;

/**
 * Vamos a crear nuestra propia versión de "pescalo" en Java, el juego va por
 * turnos, un jugador le pide al otro una carta, si el jugador tiene esa carta,
 * te la tiene que entregar, si no la tiene, tú tienes que coger una carta de la
 * baraja y pierdes el turno.
 *
 * Una baraja de poker tiene 13 cartas de cada palo, las cartas son:
 *
 * - A, 2, 3, 4, 5, 6, 7, 8, 9, 10, J, Q, K.
 *
 * Y los palos son:
 *
 * "P" de picas, "C" de corazones, "T" de trebol, "D" de diamantes.
 */
import java.util.*;

public class PescaloV1 {

    public static String ultimaCartaPedida = "";
    public static int puntosJugador1 = 0;
    public static int puntosJugador2 = 0;
    public static ArrayList<String> descarte = new ArrayList<>();

    public static void main(String[] args) {
        /**
         * Ejemplo de cartas dentro del ArrayList:
         *
         * "AP", "2P", "3P"... "10P", "JP", "QP", "KP". "AC", "2C"...
         */
        ArrayList<String> barajaCartas = new ArrayList<>();
        ArrayList<String> manoJugador1 = new ArrayList<>();
        ArrayList<String> manoJugador2 = new ArrayList<>();
        int opcion, turno;
        String cartaSolicitada;
        boolean continuar;
        Scanner teclado = new Scanner(System.in);

        // CONFIGURACIÓN PREVIA DEL JUEGO.
        // CREAR TODAS LAS CARTAS DE LA BARAJA.
        barajaCartas = crearBaraja();

        // MENU DEL PROGRAMA.
        do {

            mostrarMenu();
            opcion = teclado.nextInt();

            switch (opcion) {

                case 1:
                    // Ambos jugadores empiezan con cero puntos.
                    puntosJugador1 = 0;
                    puntosJugador2 = 0;

                    // Por defecto la variable continuar es "true" para jugar.
                    continuar = true;

                    // Se elige aleatoriamente cual jugador empieza.
                    turno = jugadorInicial();

                    // Se mezclan todas las cartas
                    mezclarBaraja(barajaCartas);

                    // Se reparten todas las cartas
                    repartirCartas(barajaCartas, manoJugador1, manoJugador2);

                    /**
                     * manoJugador1 = [][][][][][]... 6 cartas. manoJugador2 =
                     * [][][][][][]... 6 cartas. baraja = [][][][][][]... 40
                     * cartas.
                     */
                    while (continuar) {

                        /**
                         * Al principio de cada ejecución del bucle, cambia el
                         * turno.
                         */
                        if (turno == 1) {
                            turno = 2;
                        } else {
                            turno = 1;
                        }

                        // Si el turno es el "1" juega el humano contra la maquina.
                        if (turno == 1) {
                            /**
                             * Si pido una carta y el jugador si la tiene, el
                             * String será esa carta y si por otra parte le pido
                             * una carta que no tiene, el String será null.
                             */
                            cartaSolicitada = preguntaCartaJ(manoJugador2);

                            if (cartaSolicitada != null) {
                                manoJugador2.remove(cartaSolicitada);
                                manoJugador1.add(cartaSolicitada);
                            } else {
                                manoJugador1.add(barajaCartas.get(0));
                                barajaCartas.remove(0);
                            }
                        } // Si el turno es el "2" juega la maquina contra el humano.
                        else {
                            cartaSolicitada = preguntaCartaM(manoJugador1);

                            if (cartaSolicitada != null) {
                                manoJugador1.remove(cartaSolicitada);
                                manoJugador2.add(cartaSolicitada);
                            } else {
                                manoJugador2.add(barajaCartas.get(0));
                                barajaCartas.remove(0);
                            }
                        }

                        revisarMano(manoJugador1, 1);
                        revisarMano(manoJugador2, 2);

                        if (puntosJugador1 == 3 || puntosJugador2 == 3) {
                            continuar = false;

                            if (puntosJugador1 == 3) {
                                System.out.println("¡Fin del juego! Gano el jugador N.º1.");
                            } else {
                                System.out.println("¡Fin del juego! Gano el jugador N.º2.");
                            }
                        }
                    }
            }
        } while (opcion != 0);
    }

    public static void mostrarMenu() {
        System.out.println("1. Jugar");
        System.out.println("0. Salir");
    }

    public static int jugadorInicial() {
        Random generador = new Random();
        int jugadorQueEmpieza = generador.nextInt(2) + 1;

        if (jugadorQueEmpieza == 1) {
            System.out.println("Empieza el jugador: 2");
        } else {
            System.out.println("Empieza el jugador: 1");
        }
        return jugadorQueEmpieza;
    }

    // Crear baraja
    public static ArrayList<String> crearBaraja() {

        ArrayList<String> baraja = new ArrayList<>();

        char[] palos = { 'P', 'C', 'T', 'D' };
        String[] numeros = { "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K" };

        for (int palo = 0; palo < palos.length; palo++) {
            for (int numero = 0; numero < numeros.length; numero++) {
                String carta = numeros[numero] + palos[palo];
                baraja.add(carta);
            }
        }
        return baraja;
    }

    // Mezclar baraja
    public static ArrayList<String> mezclarBaraja(ArrayList<String> baraja) {
        // Collections.shuffle(baraja);

        Random generador = new Random();

        for (int posicionInicial = baraja.size() - 1; posicionInicial > 0; posicionInicial--) {

            String carta1 = baraja.get(posicionInicial);

            int posicionRandom = generador.nextInt(posicionInicial + 1);

            String carta2 = baraja.get(posicionRandom);

            baraja.set(posicionInicial, carta2);
            baraja.set(posicionRandom, carta1);
        }

        return baraja;

    }

    // Repartit cartas
    public static void repartirCartas(ArrayList<String> baraja, ArrayList<String> manoJugador1,
            ArrayList<String> manoJugador2) {
        // Cada jugador recibe 6 cartas
        for (int i = 0; i < 6; i++) {
            manoJugador1.add(baraja.remove(0));
            manoJugador2.add(baraja.remove(0));
        }

        System.out.println("Cada jugador ha recibido 6 cartas.");
    }

    // Preguntar si tiene la carta ....
    public static String preguntaCartaJ(ArrayList<String> manoJugador) {
        Scanner scanner = new Scanner(System.in);
        String cartaSolicitada;

        System.out.println("¿Qué carta quieres pedir? (ejemplo: 5P, 10C, KD)");
        cartaSolicitada = scanner.nextLine();

        if (manoJugador.contains(cartaSolicitada)) {
            System.out.println("La maquina tiene la carta: " + cartaSolicitada);
            return cartaSolicitada;
        } else {
            System.out.println("La maquina no tiene la carta: " + cartaSolicitada);
            return null;
        }

    }

    public static String preguntaCartaM(ArrayList<String> manoJugador) {
        String[] numeros = { "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K" };
        char[] palos = { 'P', 'C', 'T', 'D' };
        Random generador = new Random();
        String numeroAleatorio;
        char paloAleatorio;
        String cartaSolicitada = "";
        boolean continuar = true;

        while (continuar) {
            // Elige aleatoriamente un número y un palo cualquiera de la baraja.
            numeroAleatorio = numeros[generador.nextInt(numeros.length)];
            paloAleatorio = palos[generador.nextInt(palos.length)];

            // Une la dos piezas para crear la carta aleatoria que va a pedir.
            cartaSolicitada = numeroAleatorio + paloAleatorio;

            if (cartaSolicitada.equals(ultimaCartaPedida)) {
                continuar = true;
            } else {
                continuar = false;
            }
        }

        // Registro de la ultima carta que fue solicitada por la maquina.
        ultimaCartaPedida = cartaSolicitada;

        if (manoJugador.contains(cartaSolicitada)) {
            System.out.println("La maquina pide la carta: " + cartaSolicitada);
            return cartaSolicitada;
        } else {
            System.out.println("Tu no tienes la carta: " + cartaSolicitada);
            return null;
        }
    }

    public static void revisarMano(ArrayList<String> manoJugador, int jugador) {
        String[] numeros = { "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K" };
        char[] palos = { 'P', 'C', 'T', 'D' };
        int contador = 0;

        for (String numero : numeros) {
            contador = 0;

            for (char palo : palos) {
                if (manoJugador.contains(numero + palo)) {
                    contador++;
                }
            }

            if (contador == 4) {
                for (char palo : palos) {
                    manoJugador.remove(numero + palo);
                    descarte.add(numero + palo);
                }

                if (jugador == 1) {
                    puntosJugador1++;
                } else {
                    puntosJugador2++;
                }
            }
        }
    }
}
