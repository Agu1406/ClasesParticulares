package madrid.iescalderonbarca.ejercicios.nominasAL;

/**
 * Personal de administración: bruto 1600€, retención 13%, revalorización 6%.
 */
public class PersonalAdministracion extends Empleado {

    public static final double BRUTO_BASE = 1600.0;
    public static final double RETENCION = 0.13;
    public static final double REVALORIZACION_ANUAL = 0.06;

    public PersonalAdministracion(String nombre, String apellido1, String apellido2, String dni, int antiguedadDias) {
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
