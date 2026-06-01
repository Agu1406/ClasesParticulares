package madrid.iescalderonbarca.ejercicios.nominas;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Gestión de nóminas de una empresa (IES Calderón Barca).
 *
 * <p>Enunciado: {@code nominas--madrid-iescalderonbarca.pdf} y
 * {@code practica-obligatoria-ra4--madrid-iescalderonbarca.pdf} (carpeta de la práctica).</p>
 *
 * <p><b>Objetivo:</b> administrar empleados de distintas categorías y calcular sueldos e indemnizaciones.</p>
 *
 * <p>Para ello, el programa debe:</p>
 * <ul>
 *   <li>Ofrecer un menú repetitivo: alta, baja, cálculo de sueldos e indemnizaciones.</li>
 *   <li>Modelar empleados con herencia ({@link Empleado} y subclases).</li>
 *   <li>Aplicar polimorfismo mediante la interfaz {@link Cobros}.</li>
 *   <li>Persistir la lista de empleados en memoria durante la sesión.</li>
 * </ul>
 *
 * <p>Utiliza POO (herencia, interfaces), {@link java.util.ArrayList} y {@link Scanner}.</p>
 *
 * @author Agustín. A. Marquez. Piña
 * @since 29/05/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class MainNominas {

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
        // TODO: pedir nombre, apellidos, DNI, antigüedad en días y categoría.
        // Crear el empleado con la clase correspondiente (MozoAlmacen, JefeSeccion, etc.)
        // y añadirlo a la lista empleados.
        System.out.println("TODO: implementar alta de empleado.");
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
        // TODO: recorrer la lista y mostrar el sueldo de cada empleado usando polimorfismo.
        System.out.println("TODO: listar sueldo neto mensual de cada empleado.");
    }

    private static void calcularIndemnizaciones() {
        if (empleados.isEmpty()) {
            System.out.println("No hay empleados en la empresa.");
            return;
        }
        // TODO: recorrer la lista y mostrar la indemnización de cada empleado usando polimorfismo.
        System.out.println("TODO: listar indemnización por despido de cada empleado.");
    }
}
