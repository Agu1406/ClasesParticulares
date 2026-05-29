package madrid.iescalderonbarca.ejercicios.nominasAL;

/**
 * Práctica nóminas - Interfaz base (VERSIÓN RESUELTA).
 * Define los métodos que deben implementar todas las clases de empleados.
 */
public interface Cobros {

    /**
     * Calcula el sueldo neto mensual del empleado.
     *
     * @return sueldo neto mensual.
     */
    double sueldo();

    /**
     * Calcula la indemnización por despido del empleado.
     *
     * @return indemnización por despido.
     */
    double indemnizacion();
}
