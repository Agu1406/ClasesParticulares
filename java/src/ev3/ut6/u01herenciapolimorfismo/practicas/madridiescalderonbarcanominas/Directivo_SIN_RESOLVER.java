package ev3.ut6.u01herenciapolimorfismo.practicas.madridiescalderonbarcanominas;

/**
 * Practica nominas.
 *
 * Clase que representa a un Directivo_SIN_RESOLVER.
 *
 * VERSION SIN RESOLVER (PLANTILLA PARA EL ALUMNO)
 */
public class Directivo_SIN_RESOLVER extends Empleado_SIN_RESOLVER {

    // Constantes sugeridas:
    public static final double BRUTO_BASE = 2800.0;
    public static final double RETENCION = 0.23;            // 23 %
    public static final double REVALORIZACION_ANUAL = 0.10; // 10 % por ano completo
    public static final double PLUS_OBJETIVOS = 0.35;       // 35 % del salario si cumple objetivos

    // Cumplimiento de objetivos: aleatorio con probabilidad 50 %

    public Directivo_SIN_RESOLVER(String nombre,
                     String apellido1,
                     String apellido2,
                     String dni,
                     int antiguedadDias) {
        super(nombre, apellido1, apellido2, dni, antiguedadDias);
    }

    @Override
    public double sueldo() {
        // TODO: implementar el calculo del sueldo neto mensual
        // (revalorizacion, retencion y plus por objetivos si se cumplen, 50 % aleatorio).
        return 0.0;
    }

    @Override
    public double indemnizacion() {
        // TODO: implementar el calculo de la indemnizacion por despido.
        return 0.0;
    }
}
