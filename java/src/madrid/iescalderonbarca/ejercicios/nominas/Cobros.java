package madrid.iescalderonbarca.ejercicios.nominas;

/**
 * Práctica nóminas - interfaz base.
 *
 * Define los métodos mínimos que deben implementar todas las clases
 * que representen empleados de la práctica de nóminas.
 *
 * VERSIÓN SIN RESOLVER (PLANTILLA PARA EL ALUMNO)
 */
public interface Cobros {

    /**
     * Calcula el sueldo neto mensual del empleado según las reglas
     * de la práctica (revalorización, retenciones, comisiones, etc.).
     *
     * @return sueldo neto mensual.
     */
    double sueldo();

    /**
     * Calcula la indemnización por despido del empleado según las
     * reglas de la práctica (antigüedad, días por año, etc.).
     *
     * @return indemnización por despido.
     */
    double indemnizacion();
}
