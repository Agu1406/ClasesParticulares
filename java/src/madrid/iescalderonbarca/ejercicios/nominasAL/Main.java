package madrid.iescalderonbarca.ejercicios.nominasAL;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Menú principal de la aplicación de nóminas (VERSIÓN RESUELTA).
 * Cuatro opciones: alta, baja, sueldo, indemnización. Menú repetido indefinidamente.
 */
public class Main {

    private static final List<Empleado> empleados = new ArrayList<>();
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            mostrarMenu();
            int opcion = leerOpcion();
            switch (opcion) {
                case 1 -> altaEmpleado();
                case 2 -> bajaEmpleado();
                case 3 -> calcularSueldos();
                case 4 -> calcularIndemnizaciones();
                default -> System.out.println("Opción no válida.");
            }
        }
    }

    private static void mostrarMenu() {
        System.out.println();
        System.out.println("--- NÓMINAS ---");
        System.out.println("1. Alta de empleado");
        System.out.println("2. Baja de empleado");
        System.out.println("3. Calcular sueldo de empleados");
        System.out.println("4. Calcular indemnización por despido");
        System.out.print("Elija opción (1-4): ");
    }

    private static int leerOpcion() {
        try {
            return Integer.parseInt(sc.nextLine().trim());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private static void altaEmpleado() {
        System.out.print("Nombre: ");
        String nombre = sc.nextLine().trim();
        System.out.print("Primer apellido: ");
        String ap1 = sc.nextLine().trim();
        System.out.print("Segundo apellido: ");
        String ap2 = sc.nextLine().trim();
        System.out.print("DNI: ");
        String dni = sc.nextLine().trim();
        System.out.print("Antigüedad en días: ");
        int dias;
        try {
            dias = Integer.parseInt(sc.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Días no válidos. No se dio de alta.");
            return;
        }
        System.out.println("Categoría: 1=Mozo almacén, 2=Jefe sección, 3=Jefe planta, 4=Administración, 5=Directivo");
        System.out.print("Elija categoría (1-5): ");
        int cat;
        try {
            cat = Integer.parseInt(sc.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Categoría no válida.");
            return;
        }
        Empleado e = crearEmpleado(cat, nombre, ap1, ap2, dni, dias);
        if (e != null) {
            empleados.add(e);
            System.out.println("Empleado dado de alta correctamente.");
        } else {
            System.out.println("Categoría no válida. No se dio de alta.");
        }
    }

    private static Empleado crearEmpleado(int categoria, String nombre, String ap1, String ap2, String dni, int dias) {
        return switch (categoria) {
            case 1 -> new MozoAlmacen(nombre, ap1, ap2, dni, dias);
            case 2 -> new JefeSeccion(nombre, ap1, ap2, dni, dias);
            case 3 -> new JefePlanta(nombre, ap1, ap2, dni, dias);
            case 4 -> new PersonalAdministracion(nombre, ap1, ap2, dni, dias);
            case 5 -> new Directivo(nombre, ap1, ap2, dni, dias);
            default -> null;
        };
    }

    private static void bajaEmpleado() {
        System.out.print("DNI del empleado a dar de baja: ");
        String dni = sc.nextLine().trim();
        boolean quitado = empleados.removeIf(emp -> emp.getDni().equalsIgnoreCase(dni));
        if (quitado) {
            System.out.println("Empleado dado de baja.");
        } else {
            System.out.println("No se encontró ningún empleado con ese DNI.");
        }
    }

    private static void calcularSueldos() {
        if (empleados.isEmpty()) {
            System.out.println("No hay empleados en la empresa.");
            return;
        }
        System.out.println("Sueldo neto mensual por empleado (polimorfismo: Cobros.sueldo()):");
        for (Empleado e : empleados) {
            double s = e.sueldo();
            System.out.printf("  %s (%s): %.2f €%n", e.getNombreCompleto(), e.getDni(), s);
        }
    }

    private static void calcularIndemnizaciones() {
        if (empleados.isEmpty()) {
            System.out.println("No hay empleados en la empresa.");
            return;
        }
        System.out.println("Indemnización por despido por empleado (polimorfismo: Cobros.indemnizacion()):");
        for (Empleado e : empleados) {
            double ind = e.indemnizacion();
            System.out.printf("  %s (%s): %.2f €%n", e.getNombreCompleto(), e.getDni(), ind);
        }
    }
}
