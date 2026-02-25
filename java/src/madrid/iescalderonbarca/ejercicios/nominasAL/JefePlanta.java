package madrid.iescalderonbarca.ejercicios.nominasAL;

import java.util.Random;

/**
 * Jefe de planta: bruto 1800€, retención 19%, comisión 6% ventas planta, revalorización 9%.
 */
public class JefePlanta extends Empleado {

    public static final double BRUTO_BASE = 1800.0;
    public static final double RETENCION = 0.19;
    public static final double REVALORIZACION_ANUAL = 0.09;
    public static final double PORCENTAJE_COMISION = 0.06;

    private static final Random rnd = new Random();

    public JefePlanta(String nombre, String apellido1, String apellido2, String dni, int antiguedadDias) {
        super(nombre, apellido1, apellido2, dni, antiguedadDias);
    }

    public double getVentasPlanta() {
        return rnd.nextDouble() * 15000.0;
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
        double comision = getVentasPlanta() * PORCENTAJE_COMISION;
        return (bruto - retencion) + comision;
    }
}
