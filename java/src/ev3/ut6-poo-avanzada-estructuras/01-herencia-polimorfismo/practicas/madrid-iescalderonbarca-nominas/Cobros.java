package madrid.iescalderonbarca.ejercicios.nominas;

/**
 * Practica nominas - interfaz base.
 *
 * Define los metodos minimos que deben implementar todas las clases
 * que representen empleados de la practica de nominas.
 *
 * VERSION SIN RESOLVER (PLANTILLA PARA EL ALUMNO)
 */
public interface Cobros {

    /**
     * Calcula el sueldo neto mensual del empleado segun las reglas
     * de la practica (revalorizacion, retenciones, comisiones, etc.).
     *
     * @return sueldo neto mensual.
     */
    double sueldo();

    /**
     * Calcula la indemnizacion por despido del empleado segun las
     * reglas de la practica (antiguedad, dias por ano, etc.).
     *
     * @return indemnizacion por despido.
     */
    double indemnizacion();
}
