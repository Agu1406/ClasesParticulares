package ev3.ut6_pooavanzadaestructuras.u01herenciapolimorfismo.practicas.madridiescalderonbarcanominas;

/**
 * Practica nominas.
 *
 * Clase que representa a un Jefe de planta.
 *
 * VERSION SIN RESOLVER (PLANTILLA PARA EL ALUMNO)
 */
public class JefePlanta_SIN_RESOLVER extends Empleado_SIN_RESOLVER {

    // Constantes sugeridas:
    public static final double BRUTO_BASE = 1800.0;
    public static final double RETENCION = 0.19;             // 19 %
    public static final double REVALORIZACION_ANUAL = 0.09;  // 9 % por ano completo
    public static final double PORCENTAJE_COMISION = 0.06;   // 6 % sobre ventas de la planta

    // Ventas de la planta: generar aleatoriamente (cifra en euros)
    // private double ventasPlanta;

    public JefePlanta_SIN_RESOLVER(String nombre,
                      String apellido1,
                      String apellido2,
                      String dni,
                      int antiguedadDias) {
        super(nombre, apellido1, apellido2, dni, antiguedadDias);
    }

    @Override
    public double sueldo() {
        // TODO: implementar el calculo del sueldo neto mensual
        // (revalorizacion, retencion y comision sobre ventas de la planta).
        return 0.0;
    }

    @Override
    public double indemnizacion() {
        // TODO: implementar el calculo de la indemnizacion por despido.
        return 0.0;
    }
}
