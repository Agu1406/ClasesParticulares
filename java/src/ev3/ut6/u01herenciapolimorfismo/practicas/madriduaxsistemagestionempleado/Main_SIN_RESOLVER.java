package ev3.ut6.u01herenciapolimorfismo.practicas.madriduaxsistemagestionempleado;

public class Main_SIN_RESOLVER {
    public static void main(String[] args) {
        // Crear fabricas
        EmpleadoFactory_SIN_RESOLVER asalariadoFactory = new EmpleadoAsalariadoFactory_SIN_RESOLVER();
        EmpleadoFactory_SIN_RESOLVER porHorasFactory = new EmpleadoPorHorasFactory_SIN_RESOLVER();

        // Crear empresa
        Empresa_SIN_RESOLVER empresa = new Empresa_SIN_RESOLVER();

        try {
            // Crear empleados usando las fabricas
            Empleado_SIN_RESOLVER juan = asalariadoFactory.crearEmpleado("Juan", 2500, 30000.0);
            empresa.agregarEmpleadoADepartamento("Ventas", juan);

            try {
                // Esto debe generar una excepcion
                Empleado_SIN_RESOLVER maria = asalariadoFactory.crearEmpleado("Maria", 2000, -30000.0);
                empresa.agregarEmpleadoADepartamento("TI", maria);
            } catch (SalarioInvalidoException_SIN_RESOLVER e) {
                System.out.println("Error al crear empleado Maria: " + e.getMessage());
            }

            Empleado_SIN_RESOLVER carlos = porHorasFactory.crearEmpleado("Carlos", 0, 35, 15.0);
            empresa.agregarEmpleadoADepartamento("TI", carlos);

            try {
                // Esto debe generar una excepcion
                Empleado_SIN_RESOLVER laura1 = porHorasFactory.crearEmpleado("Laura", 0, -15, 50.0);
                empresa.agregarEmpleadoADepartamento("Ventas", laura1);
            } catch (IllegalArgumentException e) {
                System.out.println("Error al crear empleado Laura: " + e.getMessage());
            }

            try {
                // Esto debe generar una excepcion por tarifa excesiva
                Empleado_SIN_RESOLVER laura2 = porHorasFactory.crearEmpleado("Laura", 0, 40, 100.0);
                empresa.agregarEmpleadoADepartamento("Ventas", laura2);
            } catch (TarifaExcesivaException_SIN_RESOLVER e) {
                System.out.println("Error al crear empleado Laura: " + e.getMessage());
            }

            // Mostrar salarios usando Iterator
            System.out.println("\nSalarios de todos los empleados:");
            for (Empleado_SIN_RESOLVER empleado : empresa) {
                System.out.printf("%s: %.2f?%n", empleado.getNombre(), empleado.calcularSalario());
            }

            // Mostrar salarios por departamento
            System.out.println("\nSalarios totales por departamento:");
            System.out.printf("Ventas: %.2f?%n", empresa.calcularSalarioTotalDepartamento("Ventas"));
            System.out.printf("TI: %.2f?%n", empresa.calcularSalarioTotalDepartamento("TI"));

            // Mostrar empleados ordenados por nombre en cada departamento
            System.out.println("\nEmpleados ordenados por nombre en TI:");
            for (Empleado_SIN_RESOLVER empleado : empresa.obtenerEmpleadosOrdenadosPorNombre("TI")) {
                System.out.println(empleado.getNombre());
            }

            // Guardar empresa en archivo
            PersistenciaEmpleados_SIN_RESOLVER.guardarEmpresa(empresa);
            System.out.println("\nEmpresa guardada en archivo.");

            // Cargar empresa desde archivo
            Empresa_SIN_RESOLVER empresaCargada = PersistenciaEmpleados_SIN_RESOLVER.cargarEmpresa();
            System.out.println("Empresa_SIN_RESOLVER cargada desde archivo.");

        } catch (Exception e) {
            System.out.println("Error inesperado: " + e.getMessage());
            e.printStackTrace();
        }
    }
} 
