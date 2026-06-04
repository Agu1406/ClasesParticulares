package ev3.ut6.u01herenciapolimorfismo.practicas.madriduaxsistemagestionempleado;

/**
 * Clase que representa a un empleado asalariado.
 * Hereda de la clase Empleado_SIN_RESOLVER y implementa la interfaz Calculable_SIN_RESOLVER.
  *
 * * PLANTILLA DOCENTE: completar solucion docente.
 */     
public class EmpleadoAsalariado_RESUELTO extends Empleado_SIN_RESOLVER {
    // variable que guarda el salario anual 
    private double salarioAnual;

    /**
     * Constructor de la clase EmpleadoAsalariado_RESUELTO.
     * @param nombre El nombre del empleado.
     * @param salarioBase El salario base del empleado.
     * @param salarioAnual El salario anual del empleado.
     */
    public EmpleadoAsalariado_RESUELTO(String nombre, double salarioBase, double salarioAnual) {
        // Llamamos al constructor de la clase padre
        super(nombre, salarioBase);
        // Comprobamos que el salario anual no es negativo
        if (salarioAnual < 0) {
            // Si el salario anual es negativo, lanzamos una excepcion
            throw new SalarioInvalidoException_RESUELTO("El salario anual no puede ser negativo");
        }
        // Asignamos el salario anual al atributo
        this.salarioAnual = salarioAnual;
    }
    /**
     * Calcula el salario mensual del empleado.
     * @return El salario mensual del empleado.
     */
    @Override
    public double calcularSalario() {
        return salarioAnual / 12;
    }
} 
