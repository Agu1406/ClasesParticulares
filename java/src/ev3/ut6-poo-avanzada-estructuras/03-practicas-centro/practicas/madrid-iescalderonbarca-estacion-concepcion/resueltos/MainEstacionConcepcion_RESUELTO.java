package madrid.iescalderonbarca.ejercicios.estacionconcepcion;

import java.util.Scanner;

/**
 * Menú principal de la práctica Estación Concepción — RESUELTO.
 *
 * <p>Enunciado en {@code estacion-concepcion--madrid-iescalderonbarca.pdf} (misma carpeta).</p>
 *
 * @author Agustín. A. Marquez. Piña
 * @since 29/05/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class MainEstacionConcepcion_RESUELTO {

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
        System.out.print("Nombre del pasajero: ");
        String nombre = TECLADO.nextLine().trim();
        System.out.print("Estación destino: ");
        String destino = TECLADO.nextLine().trim();
        if (nombre.isEmpty() || destino.isEmpty()) {
            System.out.println("Nombre y destino son obligatorios.");
            return;
        }
        ESTACION.registrarLlegadaPasajero(new Pasajero(nombre, destino));
        System.out.println("Pasajero registrado en el andén.");
    }

    private static void simularLlegadaTren() {
        int numero = leerEntero("Número de tren: ");
        int capacidad = leerEntero("Capacidad del tren: ");
        if (capacidad <= 0) {
            System.out.println("La capacidad debe ser positiva.");
            return;
        }
        System.out.print("Sentido (Circular/Moncloa): ");
        String sentido = TECLADO.nextLine().trim();
        if (sentido.isEmpty()) {
            sentido = "Circular";
        }

        Tren tren = new Tren(numero, capacidad, sentido);
        System.out.println("Llega " + tren);

        int bajan = leerEntero("¿Cuántos pasajeros bajan en Concepción? ");
        try {
            tren.bajarPasajeros(bajan);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }

        int embarcados = ESTACION.embarcarEnTren(tren);
        System.out.println("Embarcados: " + embarcados);
        System.out.println("Estado del tren: " + tren);
        if (ESTACION.getPasajerosEnAnden() > 0) {
            System.out.println("Quedan " + ESTACION.getPasajerosEnAnden()
                    + " pasajeros esperando el siguiente tren.");
        }
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
