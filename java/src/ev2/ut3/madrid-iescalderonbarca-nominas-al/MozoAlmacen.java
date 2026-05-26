package madrid.iescalderonbarca.ejercicios.nominasAL;

/**
 * Mozo de almacén: bruto 1200€, retención 15%, revalorización 5% por año.
 */
public class MozoAlmacen extends Empleado {

    public static final double BRUTO_BASE = 1200.0;
    public static final double RETENCION = 0.15;
    public static final double REVALORIZACION_ANUAL = 0.05;

    public MozoAlmacen(String nombre, String apellido1, String apellido2, String dni, int antiguedadDias) {
        super(nombre, apellido1, apellido2, dni, antiguedadDias);
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
        return bruto - retencion;
    }
}
