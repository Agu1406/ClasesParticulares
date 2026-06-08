package ev3.ut6_pooavanzadaestructuras.u01herenciapolimorfismo.practicas.madridiescalderonbarcanominas;

/**
 * Practica nominas.
 *
 * Clase que representa a un Mozo de almacen.
 *
 * VERSION SIN RESOLVER (PLANTILLA PARA EL ALUMNO)
  *
 * * PLANTILLA DOCENTE: completar solucion docente.
 */
public class MozoAlmacen_RESUELTO extends Empleado_SIN_RESOLVER {

    // Constantes sugeridas (puedes usarlas o modificarlas):
    public static final double BRUTO_BASE = 1200.0;
    public static final double RETENCION = 0.15;            // 15 %
    public static final double REVALORIZACION_ANUAL = 0.05; // 5 % por ano completo

    public MozoAlmacen_RESUELTO(String nombre,
                       String apellido1,
                       String apellido2,
                       String dni,
                       int antiguedadDias) {
        super(nombre, apellido1, apellido2, dni, antiguedadDias);
    }

    @Override
    public double sueldo() {
        // TODO: implementar el calculo del sueldo neto mensual
        // siguiendo las reglas de la practica para Mozos de almacen.
        return 0.0;
    }

    @Override
    public double indemnizacion() {
        // TODO: implementar el calculo de la indemnizacion por despido
        // siguiendo las reglas comunes de la practica.
        return 0.0;
    }
}
