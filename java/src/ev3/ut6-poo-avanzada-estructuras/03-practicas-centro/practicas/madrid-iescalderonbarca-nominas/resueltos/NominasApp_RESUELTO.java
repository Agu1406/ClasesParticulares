package madrid.iescalderonbarca.ejercicios.resueltos;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * Práctica nóminas – VERSIÓN RESUELTA.
 *
 * Implementa la solución completa usando:
 *  - Interfaz Cobros_RESUELTO con sueldo() e indemnizacion().
 *  - Clase abstracta Empleado_RESUELTO.
 *  - Subclases para cada tipo de empleado.
 *  - Uso de polimorfismo en un menú sencillo.
 */
public class NominasApp_RESUELTO {

    private static final Scanner SC = new Scanner(System.in);
    private static final Random RANDOM = new Random();

    private static final List<Empleado_RESUELTO> EMPLEADOS = new ArrayList<>();

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
                case 0 -> System.out.println("Saliendo de la aplicación de nóminas (versión resuelta)...");
                default -> System.out.println("Opción no válida.");
            }
        } while (opcion != 0);
    }

    private static void mostrarMenu() {
        System.out.println("=====================================");
        System.out.println("      MENÚ PRÁCTICA NÓMINAS (OK)     ");
        System.out.println("=====================================");
        System.out.println("1. Dar de alta un empleado");
        System.out.println("2. Dar de baja un empleado");
        System.out.println("3. Listar sueldos netos");
        System.out.println("4. Mostrar indemnizaciones por despido");
        System.out.println("0. Salir");
        System.out.println("=====================================");
    }

    private static void altaEmpleado() {
        System.out.println("--- ALTA EMPLEADO ---");
        System.out.println("Tipos disponibles:");
        System.out.println("1. Mozo de almacén");
        System.out.println("2. Jefe de sección");
        System.out.println("3. Jefe de planta");
        System.out.println("4. Personal de administración");
        System.out.println("5. Directivo");

        int tipo = leerEntero("Elige tipo de empleado: ");

        System.out.print("Nombre: ");
        String nombre = SC.nextLine().trim();
        System.out.print("Primer apellido: ");
        String apellido1 = SC.nextLine().trim();
        System.out.print("Segundo apellido: ");
        String apellido2 = SC.nextLine().trim();
        System.out.print("DNI: ");
        String dni = SC.nextLine().trim();
        int antiguedadDias = leerEntero("Antigüedad en días: ");

        Empleado_RESUELTO nuevo = switch (tipo) {
            case 1 -> new MozoAlmacen_RESUELTO(nombre, apellido1, apellido2, dni, antiguedadDias);
            case 2 -> new JefeSeccion_RESUELTO(nombre, apellido1, apellido2, dni, antiguedadDias);
            case 3 -> new JefePlanta_RESUELTO(nombre, apellido1, apellido2, dni, antiguedadDias);
            case 4 -> new Administrativo_RESUELTO(nombre, apellido1, apellido2, dni, antiguedadDias);
            case 5 -> new Directivo_RESUELTO(nombre, apellido1, apellido2, dni, antiguedadDias);
            default -> null;
        };

        if (nuevo != null) {
            EMPLEADOS.add(nuevo);
            System.out.println("Empleado dado de alta correctamente.\n");
        } else {
            System.out.println("Tipo de empleado no válido, alta cancelada.\n");
        }
    }

    private static void bajaEmpleado() {
        System.out.println("--- BAJA EMPLEADO ---");
        System.out.print("Introduce el DNI del empleado a dar de baja: ");
        String dni = SC.nextLine().trim();

        Empleado_RESUELTO encontrado = null;
        for (Empleado_RESUELTO e : EMPLEADOS) {
            if (e.getDni().equalsIgnoreCase(dni)) {
                encontrado = e;
                break;
            }
        }

        if (encontrado != null) {
            EMPLEADOS.remove(encontrado);
            System.out.println("Empleado " + encontrado.getNombreCompleto() + " dado de baja.\n");
        } else {
            System.out.println("No se encontró ningún empleado con ese DNI.\n");
        }
    }

    private static void listarSueldos() {
        System.out.println("--- LISTADO DE SUELDOS NETOS ---");
        if (EMPLEADOS.isEmpty()) {
            System.out.println("No hay empleados dados de alta.\n");
            return;
        }
        for (Empleado_RESUELTO e : EMPLEADOS) {
            double sueldo = e.sueldo();
            System.out.printf("%-30s (%s): %.2f €%n",
                              e.getNombreCompleto(),
                              e.getClass().getSimpleName(),
                              sueldo);
        }
        System.out.println();
    }

    private static void mostrarIndemnizaciones() {
        System.out.println("--- INDEMNIZACIONES POR DESPIDO (TEÓRICAS) ---");
        if (EMPLEADOS.isEmpty()) {
            System.out.println("No hay empleados dados de alta.\n");
            return;
        }
        for (Empleado_RESUELTO e : EMPLEADOS) {
            double ind = e.indemnizacion();
            System.out.printf("%-30s (%s): %.2f €%n",
                              e.getNombreCompleto(),
                              e.getClass().getSimpleName(),
                              ind);
        }
        System.out.println();
    }

    private static int leerEntero(String mensaje) {
        System.out.print(mensaje);
        while (!SC.hasNextInt()) {
            System.out.print("Introduce un número entero válido: ");
            SC.next();
        }
        int valor = SC.nextInt();
        SC.nextLine(); // limpiar salto de línea pendiente
        return valor;
    }

    // ============================================================
    //  CLASES / INTERFAZ DE LA SOLUCIÓN (NO PÚBLICAS)
    // ============================================================

    interface Cobros_RESUELTO {
        double sueldo();
        double indemnizacion();
    }

    /**
     * Clase abstracta común a todos los empleados.
     */
    static abstract class Empleado_RESUELTO implements Cobros_RESUELTO {
        protected String nombre;
        protected String apellido1;
        protected String apellido2;
        protected String dni;
        protected int antiguedadDias;

        protected double salarioBaseMensual;
        protected double porcentajeRetencion; // ej: 0.15 = 15 %

        public Empleado_RESUELTO(String nombre,
                                 String apellido1,
                                 String apellido2,
                                 String dni,
                                 int antiguedadDias,
                                 double salarioBaseMensual,
                                 double porcentajeRetencion) {
            this.nombre = nombre;
            this.apellido1 = apellido1;
            this.apellido2 = apellido2;
            this.dni = dni;
            this.antiguedadDias = Math.max(0, antiguedadDias);
            this.salarioBaseMensual = salarioBaseMensual;
            this.porcentajeRetencion = porcentajeRetencion;
        }

        public String getNombreCompleto() {
            return nombre + " " + apellido1 + " " + apellido2;
        }

        public String getDni() {
            return dni;
        }

        protected int getAniosAntiguedad() {
            return antiguedadDias / 365;
        }

        /**
         * Cada subclase define su porcentaje de revalorización anual.
         */
        protected abstract double getPorcentajeRevalorizacionAnual();

        /**
         * Salario bruto mensual actualizado por antigüedad.
         */
        protected double calcularSalarioBrutoActualizado() {
            int anios = getAniosAntiguedad();
            double factor = Math.pow(1.0 + getPorcentajeRevalorizacionAnual(), anios);
            return salarioBaseMensual * factor;
        }

        /**
         * Salario neto mensual sin extras (solo revalorización + retención).
         */
        protected double calcularSueldoNetoBaseSinExtras() {
            double bruto = calcularSalarioBrutoActualizado();
            double retencion = bruto * porcentajeRetencion;
            return bruto - retencion;
        }

        /**
         * Indemnización común para todas las categorías.
         */
        @Override
        public double indemnizacion() {
            int anios = getAniosAntiguedad();
            if (anios < 1) {
                return 0.0; // menos de un año, sin indemnización
            }

            double bruto = calcularSalarioBrutoActualizado();
            double salarioDiario = bruto / 30.0;
            double indemnizacionPorAnio = salarioDiario * 20.0; // 20 días por año

            // Máximo un sueldo bruto por año (aquí 20 días < 30, así que no se supera).
            if (indemnizacionPorAnio > bruto) {
                indemnizacionPorAnio = bruto;
            }

            return indemnizacionPorAnio * anios;
        }
    }

    // ===========================
    //  Tipos concretos de empleado
    // ===========================

    static class MozoAlmacen_RESUELTO extends Empleado_RESUELTO {

        public MozoAlmacen_RESUELTO(String nombre,
                                    String apellido1,
                                    String apellido2,
                                    String dni,
                                    int antiguedadDias) {
            super(nombre, apellido1, apellido2, dni, antiguedadDias,
                  1200.0, 0.15);
        }

        @Override
        protected double getPorcentajeRevalorizacionAnual() {
            return 0.05; // 5 %
        }

        @Override
        public double sueldo() {
            return calcularSueldoNetoBaseSinExtras();
        }
    }

    static class JefeSeccion_RESUELTO extends Empleado_RESUELTO {

        public JefeSeccion_RESUELTO(String nombre,
                                    String apellido1,
                                    String apellido2,
                                    String dni,
                                    int antiguedadDias) {
            super(nombre, apellido1, apellido2, dni, antiguedadDias,
                  1700.0, 0.17);
        }

        @Override
        protected double getPorcentajeRevalorizacionAnual() {
            return 0.07; // 7 %
        }

        @Override
        public double sueldo() {
            double netoBase = calcularSueldoNetoBaseSinExtras();
            // Ventas de la sección generadas aleatoriamente
            double ventas = generarVentasAleatorias();
            double comision = ventas * 0.12; // 12 %
            return netoBase + comision; // comisiones sin retención
        }
    }

    static class JefePlanta_RESUELTO extends Empleado_RESUELTO {

        public JefePlanta_RESUELTO(String nombre,
                                   String apellido1,
                                   String apellido2,
                                   String dni,
                                   int antiguedadDias) {
            super(nombre, apellido1, apellido2, dni, antiguedadDias,
                  1800.0, 0.19);
        }

        @Override
        protected double getPorcentajeRevalorizacionAnual() {
            return 0.09; // 9 %
        }

        @Override
        public double sueldo() {
            double netoBase = calcularSueldoNetoBaseSinExtras();
            double ventas = generarVentasAleatorias();
            double comision = ventas * 0.06; // 6 %
            return netoBase + comision;
        }
    }

    static class Administrativo_RESUELTO extends Empleado_RESUELTO {

        public Administrativo_RESUELTO(String nombre,
                                       String apellido1,
                                       String apellido2,
                                       String dni,
                                       int antiguedadDias) {
            super(nombre, apellido1, apellido2, dni, antiguedadDias,
                  1600.0, 0.13);
        }

        @Override
        protected double getPorcentajeRevalorizacionAnual() {
            return 0.06; // 6 %
        }

        @Override
        public double sueldo() {
            return calcularSueldoNetoBaseSinExtras();
        }
    }

    static class Directivo_RESUELTO extends Empleado_RESUELTO {

        public Directivo_RESUELTO(String nombre,
                                  String apellido1,
                                  String apellido2,
                                  String dni,
                                  int antiguedadDias) {
            super(nombre, apellido1, apellido2, dni, antiguedadDias,
                  2800.0, 0.23);
        }

        @Override
        protected double getPorcentajeRevalorizacionAnual() {
            return 0.10; // 10 %
        }

        @Override
        public double sueldo() {
            double brutoActualizado = calcularSalarioBrutoActualizado();
            double netoBase = brutoActualizado - brutoActualizado * porcentajeRetencion;

            boolean cumpleObjetivos = RANDOM.nextBoolean(); // 50 %
            double plus = 0.0;
            if (cumpleObjetivos) {
                plus = brutoActualizado * 0.35; // 35 % de su salario bruto
            }

            // El plus no está sujeto a retención, se suma al neto.
            return netoBase + plus;
        }
    }

    // Método auxiliar para generar ventas aleatorias (sección/planta).
    private static double generarVentasAleatorias() {
        // Por ejemplo, entre 0 y 100.000 €
        return RANDOM.nextDouble() * 100_000.0;
    }
}

