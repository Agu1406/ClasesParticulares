package ev3.ut6.u01herenciapolimorfismo.practicas.madriduaxsistemagestionempleado;

public class EmpleadoAsalariadoFactory_RESUELTO implements EmpleadoFactory_SIN_RESOLVER {
    @Override
    public Empleado_SIN_RESOLVER crearEmpleado(String nombre, double salarioBase, Object... params) {
        if (params.length < 1) {
            throw new IllegalArgumentException("Se requiere el salario anual");
        }
        double salarioAnual = (double) params[0];
        return new EmpleadoAsalariado_RESUELTO(nombre, salarioBase, salarioAnual);
    }
} 
