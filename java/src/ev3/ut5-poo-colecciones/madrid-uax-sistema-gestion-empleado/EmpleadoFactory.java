package madrid.uax.tecnicasprogramacion.sistema_gestion_empleado;

public interface EmpleadoFactory {
    Empleado crearEmpleado(String nombre, double salarioBase, Object... params);
} 
