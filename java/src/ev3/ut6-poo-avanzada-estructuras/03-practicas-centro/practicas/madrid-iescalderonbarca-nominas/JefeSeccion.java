package madrid.iescalderonbarca.ejercicios.nominas;

/**
 * Práctica nóminas.
 *
 * Clase que representa a un Jefe de sección.
 *
 * VERSIÓN SIN RESOLVER (PLANTILLA PARA EL ALUMNO)
 */
public class JefeSeccion extends Empleado {

    // Constantes sugeridas:
    public static final double BRUTO_BASE = 1700.0;
    public static final double RETENCION = 0.17;            // 17 %
    public static final double REVALORIZACION_ANUAL = 0.07; // 7 % por año completo
    public static final double PORCENTAJE_COMISION = 0.12;  // 12 % sobre ventas

    // Podrías guardar aquí las ventas de la sección si lo deseas:
    // private double ventasSeccion;

    public JefeSeccion(String nombre,
                       String apellido1,
                       String apellido2,
                       String dni,
                       int antiguedadDias) {
        super(nombre, apellido1, apellido2, dni, antiguedadDias);
    }

    @Override
    public double sueldo() {
        // TODO: implementar el cálculo del sueldo neto mensual
        // (revalorización, retención y comisiones sobre ventas).
        return 0.0;
    }

    @Override
    public double indemnizacion() {
        // TODO: implementar el cálculo de la indemnización por despido.
        return 0.0;
    }
}
