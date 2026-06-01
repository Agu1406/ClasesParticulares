package madrid.iescalderonbarca.ejercicios.estacionconcepcion;

import java.util.Scanner;

/**
 * Menú principal de la práctica Estación Concepción (versión pendiente).
 *
 * <p>Enunciado: {@code estacion-concepcion--madrid-iescalderonbarca.pdf} (carpeta de la práctica).</p>
 *
 * <p><b>Objetivo:</b> simular pasajeros en el andén y embarque en trenes de la línea 6.</p>
 *
 * <p>Para ello, el programa debe:</p>
 * <ul>
 *   <li>Registrar llegadas de {@link Pasajero} al andén.</li>
 *   <li>Simular trenes ({@link Tren}) con capacidad, bajadas y embarque.</li>
 *   <li>Mostrar el estado de la estación ({@link EstacionConcepcion}).</li>
 * </ul>
 *
 * <p>Utiliza POO, {@link java.util.List} y {@link Scanner}. Solución en {@code MainEstacionConcepcion_RESUELTO.java}.</p>
 *
 * @author Agustín. A. Marquez. Piña
 * @since 29/05/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class MainEstacionConcepcion {

    private static final Scanner TECLADO = new Scanner(System.in);
    private static final EstacionConcepcion ESTACION = new EstacionConcepcion();

    public static void main(String[] args) {
        int opcion;
        do {
            mostrarMenu();
            opcion = leerEntero("Opción: ");
            System.out.println();
            switch (opcion) {
                case 1 -> registrarPasajero();
                case 2 -> simularLlegadaTren();
                case 3 -> ESTACION.mostrarEstado();
                case 4 -> System.out.println("Fin de la simulación.");
                default -> System.out.println("Opción no válida.");
            }
        } while (opcion != 4);
        TECLADO.close();
    }

    private static void mostrarMenu() {
        System.out.println();
        System.out.println("--- Metro Línea 6 · Estación Concepción ---");
        System.out.println("1. Registrar llegada de pasajero al andén");
        System.out.println("2. Simular llegada de tren y embarque");
        System.out.println("3. Mostrar estado de la estación");
        System.out.println("4. Salir");
    }

    private static void registrarPasajero() {
        // TODO: pedir nombre y destino; crear Pasajero y llamar a ESTACION.registrarLlegadaPasajero.
        System.out.println("TODO: implementar registro de pasajero.");
    }

    private static void simularLlegadaTren() {
        // TODO: pedir número, capacidad y sentido del tren; crear Tren y embarcar con ESTACION.
        System.out.println("TODO: implementar simulación de tren.");
    }

    private static int leerEntero(String mensaje) {
        System.out.print(mensaje);
        while (!TECLADO.hasNextInt()) {
            TECLADO.nextLine();
            System.out.print("Introduce un número entero: ");
        }
        int valor = TECLADO.nextInt();
        TECLADO.nextLine();
        return valor;
    }
}
