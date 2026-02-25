package madrid.iescalderonbarca.ejercicios.nominasAL;

/**
 * Práctica nóminas - Clase abstracta Empleado (VERSIÓN RESUELTA).
 * Datos comunes y método auxiliar para años de antigüedad.
 */
public abstract class Empleado implements Cobros {

    protected String nombre;
    protected String apellido1;
    protected String apellido2;
    protected String dni;
    protected int antiguedadDias;

    public Empleado(String nombre, String apellido1, String apellido2, String dni, int antiguedadDias) {
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.dni = dni;
        this.antiguedadDias = antiguedadDias;
    }

    public String getNombreCompleto() {
        return nombre + " " + apellido1 + " " + apellido2;
    }

    public String getDni() {
        return dni;
    }

    public int getAntiguedadDias() {
        return antiguedadDias;
    }

    /**
     * Años enteros de antigüedad (no parciales).
     */
    protected int calcularAniosAntiguedad() {
        return antiguedadDias / 365;
    }

    /**
     * Sueldo bruto mensual actualizado por revalorización según años.
     * Cada categoría define su bruto base y su % de revalorización anual.
     */
    protected abstract double getBrutoActualizado();

    /**
     * Indemnización: por cada 365 días, 20 días de sueldo bruto (mes = 30 días).
     * Antes del primer año no hay indemnización. Sin comisiones.
     */
    @Override
    public double indemnizacion() {
        if (antiguedadDias < 365) {
            return 0.0;
        }
        int anos = calcularAniosAntiguedad();
        double bruto = getBrutoActualizado();
        // 20 días de sueldo por año; día = bruto/30
        return anos * (bruto * 20.0 / 30.0);
    }
}
