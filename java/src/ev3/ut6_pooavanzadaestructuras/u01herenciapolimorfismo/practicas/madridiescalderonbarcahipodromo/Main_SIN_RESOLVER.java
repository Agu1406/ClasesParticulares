package ev3.ut6_pooavanzadaestructuras.u01herenciapolimorfismo.practicas.madridiescalderonbarcahipodromo;

import java.util.Random;
import java.util.Scanner;

/**
 * Simulacion de carrera de caballos con apuestas (IES Calderon Barca).
 *
 * <p>Enunciado: {@code madrid-iescalderonbarca-hipodromo.pdf} (carpeta de la practica).</p>
 *
 * <p><b>Objetivo:</b> modelar una carrera con varios caballos, caidas aleatorias y apuesta del usuario.</p>
 *
 * <p>Para ello, el programa debe:</p>
 * <ul>
 *   <li>Representar cada caballo con {@link Caballo_SIN_RESOLVER} (nombre, dorsal, distancia, estado).</li>
 *   <li>Registrar la apuesta del jugador y avanzar la carrera por tramos hasta la meta.</li>
 *   <li>Simular caidas y metros recorridos con {@link Random}.</li>
 *   <li>Mostrar el ranking por distancia e indicar si la apuesta gana o pierde.</li>
 * </ul>
 *
 * <p>Utiliza POO, {@link Scanner} y {@link Random}.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 29/05/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Main_SIN_RESOLVER {

    private static final int META = 700;
    private static final int[] METROS = { 50, 60, 70, 80 };

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        Random azar = new Random();

        Caballo_SIN_RESOLVER[] establo = new Caballo_SIN_RESOLVER[5];
        establo[0] = new Caballo_SIN_RESOLVER("Rocinante", 1);
        establo[1] = new Caballo_SIN_RESOLVER("Babieca", 2);
        establo[2] = new Caballo_SIN_RESOLVER("Rufio", 3);
        establo[3] = new Caballo_SIN_RESOLVER("Alvaro", 4);
        establo[4] = new Caballo_SIN_RESOLVER("Rosado", 5);

        int apuesta = 0;
        while (apuesta < 1 || apuesta > 5) {
            System.out.println("?Por cual caballo vas a apostar? Indica su dorsal (1-5):");
            apuesta = teclado.nextInt();
            if (apuesta < 1 || apuesta > 5) System.out.println("Error. Introduce un numero del 1 al 5.");
        }
        System.out.println("!Gracias por apostar! La carrera empieza pronto...");

        System.out.println("\nCOMIENZA LA CARRERA\nPosicion en la carrera de los caballos de primero al ultimo");
        for (Caballo_SIN_RESOLVER caballoActual : establo) caballoActual.imprimirInformacion();
        System.out.println("Pulse ENTER para continuar");
        teclado.nextLine();
        teclado.nextLine();

        Caballo_SIN_RESOLVER ganador = null;
        while (ganador == null) {
            String[] mensajesCaidaEsteTramo = new String[5];
            int cuantasCaidasEsteTramo = 0;

            for (Caballo_SIN_RESOLVER caballoActual : establo) {
                if (caballoActual.isCaballoCaido()) continue;
                if (azar.nextInt(15) + 1 == 1) {
                    caballoActual.caerse();
                    mensajesCaidaEsteTramo[cuantasCaidasEsteTramo++] = caballoActual.getNombre() + " con el dorsal " + caballoActual.getPosicion();
                } else {
                    caballoActual.correr(METROS[azar.nextInt(4)]);
                }
            }

            for (Caballo_SIN_RESOLVER caballoActual : establo) {
                if (!caballoActual.isCaballoCaido() && caballoActual.getDistanciaRecorrida() >= META) {
                    ganador = caballoActual;
                    break;
                }
            }
            if (ganador == null) {
                int cuantosSiguenEnPie = 0;
                for (Caballo_SIN_RESOLVER caballoActual : establo) if (!caballoActual.isCaballoCaido()) cuantosSiguenEnPie++;
                if (cuantosSiguenEnPie == 0) {
                    System.out.println("\nFIN DE LA CARRERA\nTodos los caballos se han caido. No hay ganador.");
                    teclado.close();
                    return;
                }
            }

            System.out.println("\nPosicion en la carrera de los caballos de primero al ultimo");
            for (int indiceCaida = 0; indiceCaida < cuantasCaidasEsteTramo; indiceCaida++)
                System.out.println("ATENCION CAIDA: " + mensajesCaidaEsteTramo[indiceCaida] + " se ha caido.");
            int mayorDistanciaRecorrida = 0;
            for (Caballo_SIN_RESOLVER caballoActual : establo)
                if (!caballoActual.isCaballoCaido() && caballoActual.getDistanciaRecorrida() > mayorDistanciaRecorrida)
                    mayorDistanciaRecorrida = caballoActual.getDistanciaRecorrida();
            for (int metros = mayorDistanciaRecorrida; metros >= 0; metros--)
                for (Caballo_SIN_RESOLVER caballoActual : establo)
                    if (!caballoActual.isCaballoCaido() && caballoActual.getDistanciaRecorrida() == metros)
                        caballoActual.imprimirInformacion();

            if (ganador != null) {
                System.out.println("\nFIN DE LA CARRERA\nEl ganador es " + ganador.getNombre() + " con el dorsal " + ganador.getPosicion());
                System.out.println(ganador.getPosicion() == apuesta ? "!Enhorabuena, ha ganado su apuesta!" : "Lo sentimos, no ha ganado su apuesta. Vuelva a intentarlo.");
                break;
            }
            System.out.println("Pulse ENTER para continuar");
            teclado.nextLine();
        }
        teclado.close();
    }
}
