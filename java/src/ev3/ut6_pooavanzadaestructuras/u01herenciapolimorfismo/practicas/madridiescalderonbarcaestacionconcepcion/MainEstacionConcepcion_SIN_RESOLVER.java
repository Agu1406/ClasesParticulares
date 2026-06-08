package ev3.ut6_pooavanzadaestructuras.u01herenciapolimorfismo.practicas.madridiescalderonbarcaestacionconcepcion;

import java.util.Scanner;

/**
 * Menu principal de la practica Estacion Concepcion (version pendiente).
 *
 * <p>Enunciado: {@code madrid-iescalderonbarca-estacion-concepcion.pdf} (carpeta de la practica).</p>
 *
 * <p><b>Objetivo:</b> simular pasajeros en el anden y embarque en trenes de la linea 6.</p>
 *
 * <p>Para ello, el programa debe:</p>
 * <ul>
 *   <li>Registrar llegadas de {@link Pasajero_SIN_RESOLVER} al anden.</li>
 *   <li>Simular trenes ({@link Tren_SIN_RESOLVER}) con capacidad, bajadas y embarque.</li>
 *   <li>Mostrar el estado de la estacion ({@link EstacionConcepcion_SIN_RESOLVER}).</li>
 * </ul>
 *
 * <p>Utiliza POO, {@link java.util.List} y {@link Scanner}. Solucion en {@code MainEstacionConcepcion_SIN_RESOLVER.java}.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 29/05/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class MainEstacionConcepcion_SIN_RESOLVER {

    private static final Scanner TECLADO = new Scanner(System.in);
    private static final EstacionConcepcion_SIN_RESOLVER ESTACION = new EstacionConcepcion_SIN_RESOLVER();

    public static void main(String[] args) {
        int opcion;
        do {
            mostrarMenu();
            opcion = leerEntero("Opcion: ");
            System.out.println();
            switch (opcion) {
                case 1 -> registrarPasajero();
                case 2 -> simularLlegadaTren();
                case 3 -> ESTACION.mostrarEstado();
                case 4 -> System.out.println("Fin de la simulacion.");
                default -> System.out.println("Opcion no valida.");
            }
        } while (opcion != 4);
        TECLADO.close();
    }

    private static void mostrarMenu() {
        System.out.println();
        System.out.println("--- Metro Linea 6 ? Estacion Concepcion ---");
        System.out.println("1. Registrar llegada de pasajero al anden");
        System.out.println("2. Simular llegada de tren y embarque");
        System.out.println("3. Mostrar estado de la estacion");
        System.out.println("4. Salir");
    }

    private static void registrarPasajero() {
        // TODO: pedir nombre y destino; crear Pasajero_SIN_RESOLVER y llamar a ESTACION.registrarLlegadaPasajero.
        System.out.println("TODO: implementar registro de pasajero.");
    }

    private static void simularLlegadaTren() {
        // TODO: pedir numero, capacidad y sentido del tren; crear Tren_SIN_RESOLVER y embarcar con ESTACION.
        System.out.println("TODO: implementar simulacion de tren.");
    }

    private static int leerEntero(String mensaje) {
        System.out.print(mensaje);
        while (!TECLADO.hasNextInt()) {
            TECLADO.nextLine();
            System.out.print("Introduce un numero entero: ");
        }
        int valor = TECLADO.nextInt();
        TECLADO.nextLine();
        return valor;
    }
}
