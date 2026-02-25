package madrid.iescalderonbarca.ejercicios.nominasAL;

import java.util.Random;

/**
 * Jefe de sección: bruto 1700€, retención 17%, comisión 12% ventas, revalorización 7%.
 */
public class JefeSeccion extends Empleado {

    public static final double BRUTO_BASE = 1700.0;
    public static final double RETENCION = 0.17;
    public static final double REVALORIZACION_ANUAL = 0.07;
    public static final double PORCENTAJE_COMISION = 0.12;

    private static final Random rnd = new Random();

    public JefeSeccion(String nombre, String apellido1, String apellido2, String dni, int antiguedadDias) {
        super(nombre, apellido1, apellido2, dni, antiguedadDias);
    }

    /**
     * Ventas de la sección generadas aleatoriamente (cifra en euros).
     */
    public double getVentasSeccion() {
        return rnd.nextDouble() * 10000.0; // Ejemplo: entre 0 y 10000
    }

    @Override
    protected double getBrutoActualizado() {
        int anos = calcularAniosAntiguedad();
        return BRUTO_BASE * Math.pow(1.0 + REVALORIZACION_ANUAL, anos);
    }

    @Override
    public double sueldo() {
        double bruto = getBrutoActualizado();
        double retencion = bruto * RETENCION;
        double comision = getVentasSeccion() * PORCENTAJE_COMISION;
        return (bruto - retencion) + comision;
    }
}
