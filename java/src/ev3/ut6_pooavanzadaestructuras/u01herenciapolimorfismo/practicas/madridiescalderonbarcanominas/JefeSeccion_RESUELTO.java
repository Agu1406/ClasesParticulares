package ev3.ut6_pooavanzadaestructuras.u01herenciapolimorfismo.practicas.madridiescalderonbarcanominas;

/**
 * Practica nominas.
 *
 * Clase que representa a un Jefe de seccion.
 *
 * VERSION SIN RESOLVER (PLANTILLA PARA EL ALUMNO)
  *
 * * PLANTILLA DOCENTE: completar solucion docente.
 */
public class JefeSeccion_RESUELTO extends Empleado_SIN_RESOLVER {

    // Constantes sugeridas:
    public static final double BRUTO_BASE = 1700.0;
    public static final double RETENCION = 0.17;            // 17 %
    public static final double REVALORIZACION_ANUAL = 0.07; // 7 % por ano completo
    public static final double PORCENTAJE_COMISION = 0.12;  // 12 % sobre ventas

    // Podrias guardar aqui las ventas de la seccion si lo deseas:
    // private double ventasSeccion;

    public JefeSeccion_RESUELTO(String nombre,
                       String apellido1,
                       String apellido2,
                       String dni,
                       int antiguedadDias) {
        super(nombre, apellido1, apellido2, dni, antiguedadDias);
    }

    @Override
    public double sueldo() {
        // TODO: implementar el calculo del sueldo neto mensual
        // (revalorizacion, retencion y comisiones sobre ventas).
        return 0.0;
    }

    @Override
    public double indemnizacion() {
        // TODO: implementar el calculo de la indemnizacion por despido.
        return 0.0;
    }
}
