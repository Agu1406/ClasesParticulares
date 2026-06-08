package ev3.ut6_pooavanzadaestructuras.u01herenciapolimorfismo.practicas.madriduaxsistemagestionempleado;

public class EmpleadoPorHorasFactory_SIN_RESOLVER implements EmpleadoFactory_SIN_RESOLVER {
    @Override
    public Empleado_SIN_RESOLVER crearEmpleado(String nombre, double salarioBase, Object... params) {
        if (params.length < 2) {
            throw new IllegalArgumentException("Se requieren horas trabajadas y tarifa por hora");
        }
        int horasTrabajadas = (int) params[0];
        double tarifaPorHora = (double) params[1];
        return new EmpleadoPorHoras_SIN_RESOLVER(nombre, salarioBase, horasTrabajadas, tarifaPorHora);
    }
} 
