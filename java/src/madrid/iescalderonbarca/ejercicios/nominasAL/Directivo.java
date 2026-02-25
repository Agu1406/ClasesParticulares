package madrid.iescalderonbarca.ejercicios.nominasAL;

import java.util.Random;

/**
 * Directivo: bruto 2800€, retención 23%, plus 35% si cumple objetivos (50% prob), revalorización 10%.
 */
public class Directivo extends Empleado {

    public static final double BRUTO_BASE = 2800.0;
    public static final double RETENCION = 0.23;
    public static final double REVALORIZACION_ANUAL = 0.10;
    public static final double PLUS_OBJETIVOS = 0.35; // 35% del salario

    private static final Random rnd = new Random();

    public Directivo(String nombre, String apellido1, String apellido2, String dni, int antiguedadDias) {
        super(nombre, apellido1, apellido2, dni, antiguedadDias);
    }

    /**
     * Cumplimiento de objetivos: 50% de probabilidad.
     */
    public boolean cumpleObjetivos() {
        return rnd.nextBoolean();
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
        double baseNeto = bruto - retencion;
        double plus = cumpleObjetivos() ? bruto * PLUS_OBJETIVOS : 0.0;
        return baseNeto + plus;
    }
}
