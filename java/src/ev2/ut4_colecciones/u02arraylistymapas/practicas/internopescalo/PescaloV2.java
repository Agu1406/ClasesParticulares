package ev2.ut4_colecciones.u02arraylistymapas.practicas.internopescalo;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * <p><b>OBJETIVO:</b> Practica interna (V2 / WIP de clase) — menu, crear baraja,
 * mezclar y repartir cartas con {@code ArrayList}. El bucle de turnos queda
 * como TODO de la sesion. Ver {@link PescaloV1} para la logica de pedir cartas.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 05/09/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class PescaloV2 {

    public static void main(String[] args) {
        ArrayList<String> barajaCartas;
        ArrayList<String> manoJugador1 = new ArrayList<>();
        ArrayList<String> manoJugador2 = new ArrayList<>();
        Random generador = new Random();
        int puntosJugador1;
        int puntosJugador2;
        int cantidadReparto = 6;
        int turno;
        int opcion;
        Scanner teclado = new Scanner(System.in);

        do {
            mostrarMenu();
            opcion = teclado.nextInt();

            switch (opcion) {
                case 1:
                    barajaCartas = crearBaraja();
                    barajaCartas = mezclarBaraja(barajaCartas);
                    puntosJugador1 = 0;
                    puntosJugador2 = 0;
                    manoJugador1.clear();
                    manoJugador2.clear();
                    turno = generador.nextInt(2) + 1;

                    for (int iteracion = 0; iteracion < cantidadReparto; iteracion++) {
                        int ultima = barajaCartas.size() - 1;
                        manoJugador1.add(barajaCartas.remove(ultima));
                        ultima = barajaCartas.size() - 1;
                        manoJugador2.add(barajaCartas.remove(ultima));
                    }

                    System.out.println(
                            "\n¡Bienvenido a PESCALO!\n"
                                    + "¡El primer jugador sera el jugador N.º" + turno + "!\n"
                                    + "¡Se han repartido " + cantidadReparto + " cartas a cada jugador!\n"
                                    + "¡Ambos empiezan con " + puntosJugador1 + "/" + puntosJugador2 + " puntos!\n"
                                    + "TODO: bucle de turnos (pedir carta / pescar) — ver PescaloV1.\n");
                    break;
                case 2:
                    System.out.println("¡Fin del programa!");
                    break;
                default:
                    System.out.println("¡Error! Opcion no valida.");
            }
        } while (opcion != 2);

        teclado.close();
    }

    public static ArrayList<String> mezclarBaraja(ArrayList<String> baraja) {
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

    public static void mostrarMenu() {
        System.out.print(
                "\n¡MENU DE OPCIONES!\n"
                        + "[1] - Iniciar nueva partida.\n"
                        + "[2] - Salir del programa.\n"
                        + "\nElige una opcion -> ");
    }

    public static ArrayList<String> crearBaraja() {
        ArrayList<String> baraja = new ArrayList<>();
        char[] palos = {'P', 'C', 'D', 'T'};
        String[] numeros = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
        for (int palo = 0; palo < palos.length; palo++) {
            for (int numero = 0; numero < numeros.length; numero++) {
                baraja.add(numeros[numero] + palos[palo]);
            }
        }
        return baraja;
    }
}
