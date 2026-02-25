package madrid.iescalderonbarca.ejercicios.nominas;

/**
 * Práctica nóminas.
 *
 * Clase que representa a un Jefe de planta.
 *
 * VERSIÓN SIN RESOLVER (PLANTILLA PARA EL ALUMNO)
 */
public class JefePlanta extends Empleado {

    // Constantes sugeridas:
    public static final double BRUTO_BASE = 1800.0;
    public static final double RETENCION = 0.19;             // 19 %
    public static final double REVALORIZACION_ANUAL = 0.09;  // 9 % por año completo
    public static final double PORCENTAJE_COMISION = 0.06;   // 6 % sobre ventas de la planta

    // Ventas de la planta: generar aleatoriamente (cifra en euros)
    // private double ventasPlanta;

    public JefePlanta(String nombre,
                      String apellido1,
                      String apellido2,
                      String dni,
                      int antiguedadDias) {
        super(nombre, apellido1, apellido2, dni, antiguedadDias);
    }

    @Override
    public double sueldo() {
        // TODO: implementar el cálculo del sueldo neto mensual
        // (revalorización, retención y comisión sobre ventas de la planta).
        return 0.0;
    }

    @Override
    public double indemnizacion() {
        // TODO: implementar el cálculo de la indemnización por despido.
        return 0.0;
    }
}
