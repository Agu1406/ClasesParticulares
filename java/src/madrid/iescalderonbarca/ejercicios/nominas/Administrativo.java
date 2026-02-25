package madrid.iescalderonbarca.ejercicios.nominas;

/**
 * Práctica nóminas.
 *
 * Clase que representa al personal de administración.
 *
 * VERSIÓN SIN RESOLVER (PLANTILLA PARA EL ALUMNO)
 */
public class Administrativo extends Empleado {

    // Constantes sugeridas:
    public static final double BRUTO_BASE = 1600.0;
    public static final double RETENCION = 0.13;            // 13 %
    public static final double REVALORIZACION_ANUAL = 0.06; // 6 % por año completo

    public Administrativo(String nombre,
                          String apellido1,
                          String apellido2,
                          String dni,
                          int antiguedadDias) {
        super(nombre, apellido1, apellido2, dni, antiguedadDias);
    }

    @Override
    public double sueldo() {
        // TODO: implementar el cálculo del sueldo neto mensual
        // siguiendo las reglas de la práctica para administración.
        return 0.0;
    }

    @Override
    public double indemnizacion() {
        // TODO: implementar el cálculo de la indemnización por despido.
        return 0.0;
    }
}
