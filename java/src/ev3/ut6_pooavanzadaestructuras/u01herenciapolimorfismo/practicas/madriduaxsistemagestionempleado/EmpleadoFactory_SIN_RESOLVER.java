package ev3.ut6_pooavanzadaestructuras.u01herenciapolimorfismo.practicas.madriduaxsistemagestionempleado;

public interface EmpleadoFactory_SIN_RESOLVER {
    Empleado_SIN_RESOLVER crearEmpleado(String nombre, double salarioBase, Object... params);
} 
