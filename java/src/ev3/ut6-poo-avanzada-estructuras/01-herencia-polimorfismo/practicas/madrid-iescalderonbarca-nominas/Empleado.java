package madrid.iescalderonbarca.ejercicios.nominas;

/**
 * Practica nominas.
 *
 * Clase abstracta que representa a un empleado generico de la empresa.
 * Aqui solo se definen los atributos comunes y la estructura basica.
 *
 * VERSION SIN RESOLVER (PLANTILLA PARA EL ALUMNO)
 */
public abstract class Empleado implements Cobros {

    // Datos comunes a todos los empleados
    protected String nombre;
    protected String apellido1;
    protected String apellido2;
    protected String dni;
    protected int antiguedadDias; // antiguedad medida en dias

    // Constructor basico
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

    // Getters sencillos por si se necesitan en el main/menu
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
     * Metodo de ayuda sugerido: calcula los anos completos
     * de antiguedad a partir de los dias trabajados.
     *
     * @return anos de antiguedad (solo anos completos).
     */
    protected int calcularAniosAntiguedad() {
        return antiguedadDias / 365;
    }

    // LOS METODOS sueldo() E indemnizacion() SE DEJAN
    // SIN IMPLEMENTAR AQUI (al ser abstracta) para que
    // los complete el alumno en las subclases concretas.
}
