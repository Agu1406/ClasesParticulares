package madrid.iescalderonbarca.ejercicios.nominas;

/**
 * Práctica nóminas.
 *
 * Clase abstracta que representa a un empleado genérico de la empresa.
 * Aquí solo se definen los atributos comunes y la estructura básica.
 *
 * VERSIÓN SIN RESOLVER (PLANTILLA PARA EL ALUMNO)
 */
public abstract class Empleado implements Cobros {

    // Datos comunes a todos los empleados
    protected String nombre;
    protected String apellido1;
    protected String apellido2;
    protected String dni;
    protected int antiguedadDias; // antigüedad medida en días

    // Constructor básico
    public Empleado(String nombre,
                    String apellido1,
                    String apellido2,
                    String dni,
                    int antiguedadDias) {
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.dni = dni;
        this.antiguedadDias = antiguedadDias;
    }

    // Getters sencillos por si se necesitan en el main/menú
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
     * Método de ayuda sugerido: calcula los años completos
     * de antigüedad a partir de los días trabajados.
     *
     * @return años de antigüedad (solo años completos).
     */
    protected int calcularAniosAntiguedad() {
        return antiguedadDias / 365;
    }

    // LOS MÉTODOS sueldo() E indemnizacion() SE DEJAN
    // SIN IMPLEMENTAR AQUÍ (al ser abstracta) para que
    // los complete el alumno en las subclases concretas.
}
