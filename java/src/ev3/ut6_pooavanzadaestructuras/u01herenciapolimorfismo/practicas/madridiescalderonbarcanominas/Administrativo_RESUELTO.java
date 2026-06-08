package ev3.ut6_pooavanzadaestructuras.u01herenciapolimorfismo.practicas.madridiescalderonbarcanominas;

/**
 * Practica nominas.
 *
 * Clase que representa al personal de administracion.
 *
 * VERSION SIN RESOLVER (PLANTILLA PARA EL ALUMNO)
  *
 * * PLANTILLA DOCENTE: completar solucion docente.
 */
public class Administrativo_RESUELTO extends Empleado_SIN_RESOLVER {

    // Constantes sugeridas:
    public static final double BRUTO_BASE = 1600.0;
    public static final double RETENCION = 0.13;            // 13 %
    public static final double REVALORIZACION_ANUAL = 0.06; // 6 % por ano completo

    public Administrativo_RESUELTO(String nombre,
                          String apellido1,
                          String apellido2,
                          String dni,
                          int antiguedadDias) {
        super(nombre, apellido1, apellido2, dni, antiguedadDias);
    }

    @Override
    public double sueldo() {
        // TODO: implementar el calculo del sueldo neto mensual
        // siguiendo las reglas de la practica para administracion.
        return 0.0;
    }

    @Override
    public double indemnizacion() {
        // TODO: implementar el calculo de la indemnizacion por despido.
        return 0.0;
    }
}
