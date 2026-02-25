package madrid.iescalderonbarca.ejercicios.nominas;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Práctica nóminas.
 *
 * Clase principal con un menú muy sencillo que el alumno puede
 * ampliar y completar según el enunciado.
 *
 * VERSIÓN SIN RESOLVER (PLANTILLA PARA EL ALUMNO)
 */
public class NominasApp {

    private static final Scanner SC = new Scanner(System.in);

    // Lista de empleados de la empresa (polimorfismo sobre la superclase Empleado)
    private static final List<Empleado> EMPLEADOS = new ArrayList<>();

    public static void main(String[] args) {
        int opcion;
        do {
            mostrarMenu();
            opcion = leerEntero("Elige una opción: ");
            switch (opcion) {
                case 1 -> altaEmpleado();
                case 2 -> bajaEmpleado();
                case 3 -> listarSueldos();
                case 4 -> mostrarIndemnizaciones();
                case 0 -> System.out.println("Saliendo de la aplicación de nóminas...");
                default -> System.out.println("Opción no válida.");
            }
        } while (opcion != 0);
    }

    private static void mostrarMenu() {
        System.out.println("=====================================");
        System.out.println("        MENÚ PRÁCTICA NÓMINAS        ");
        System.out.println("=====================================");
        System.out.println("1. Dar de alta un empleado");
        System.out.println("2. Dar de baja un empleado");
        System.out.println("3. Listar sueldos netos");
        System.out.println("4. Mostrar indemnizaciones por despido");
        System.out.println("0. Salir");
        System.out.println("=====================================");
    }

    /**
     * TODO: completar la lógica de alta de empleados.
     */
    private static void altaEmpleado() {
        System.out.println("[ALTA EMPLEADO] (por completar por el alumno)");
    }

    /**
     * TODO: completar la lógica de baja de empleados.
     */
    private static void bajaEmpleado() {
        System.out.println("[BAJA EMPLEADO] (por completar por el alumno)");
    }

    /**
     * TODO: recorrer la lista EMPLEADOS y, usando polimorfismo, invocar sueldo().
     */
    private static void listarSueldos() {
        System.out.println("[LISTAR SUELDOS] (por completar por el alumno)");
    }

    /**
     * TODO: recorrer la lista EMPLEADOS y mostrar indemnización con indemnizacion().
     */
    private static void mostrarIndemnizaciones() {
        System.out.println("[MOSTRAR INDEMNIZACIONES] (por completar por el alumno)");
    }

    private static int leerEntero(String mensaje) {
        System.out.print(mensaje);
        while (!SC.hasNextInt()) {
            System.out.print("Introduce un número entero válido: ");
            SC.next();
        }
        int valor = SC.nextInt();
        SC.nextLine();
        return valor;
    }
}
