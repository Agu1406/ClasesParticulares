package ev3.ut6.u01herenciapolimorfismo.practicas.madridiescalderonbarcanominas;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Practica nominas.
 *
 * Clase principal con un menu muy sencillo que el alumno puede
 * ampliar y completar segun el enunciado.
 *
 * VERSION SIN RESOLVER (PLANTILLA PARA EL ALUMNO)
 */
public class NominasApp_SIN_RESOLVER {

    private static final Scanner SC = new Scanner(System.in);

    // Lista de empleados de la empresa (polimorfismo sobre la superclase Empleado_SIN_RESOLVER)
    private static final List<Empleado_SIN_RESOLVER> EMPLEADOS = new ArrayList<>();

    public static void main(String[] args) {
        int opcion;
        do {
            mostrarMenu();
            opcion = leerEntero("Elige una opcion: ");
            switch (opcion) {
                case 1 -> altaEmpleado();
                case 2 -> bajaEmpleado();
                case 3 -> listarSueldos();
                case 4 -> mostrarIndemnizaciones();
                case 0 -> System.out.println("Saliendo de la aplicacion de nominas...");
                default -> System.out.println("Opcion no valida.");
            }
        } while (opcion != 0);
    }

    private static void mostrarMenu() {
        System.out.println("=====================================");
        System.out.println("        MENU PRACTICA NOMINAS        ");
        System.out.println("=====================================");
        System.out.println("1. Dar de alta un empleado");
        System.out.println("2. Dar de baja un empleado");
        System.out.println("3. Listar sueldos netos");
        System.out.println("4. Mostrar indemnizaciones por despido");
        System.out.println("0. Salir");
        System.out.println("=====================================");
    }

    /**
     * TODO: completar la logica de alta de empleados.
     */
    private static void altaEmpleado() {
        System.out.println("[ALTA EMPLEADO] (por completar por el alumno)");
    }

    /**
     * TODO: completar la logica de baja de empleados.
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
     * TODO: recorrer la lista EMPLEADOS y mostrar indemnizacion con indemnizacion().
     */
    private static void mostrarIndemnizaciones() {
        System.out.println("[MOSTRAR INDEMNIZACIONES] (por completar por el alumno)");
    }

    private static int leerEntero(String mensaje) {
        System.out.print(mensaje);
        while (!SC.hasNextInt()) {
            System.out.print("Introduce un numero entero valido: ");
            SC.next();
        }
        int valor = SC.nextInt();
        SC.nextLine();
        return valor;
    }
}
