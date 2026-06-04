package ev3.ut6.u04repaso.practicas.madridcesjuanpablosegundoext5;

/**
 * Clase que representa a un cliente del restaurante
 */
public class Cliente_RESUELTO {
    private String dni;
    private String nombre;

    /**
     * Constructor de la clase Cliente_RESUELTO
     * @param dni DNI del cliente
     * @param nombre Nombre del cliente
     */
    public Cliente_RESUELTO(String dni, String nombre) {
        this.dni = dni;
        this.nombre = nombre;
    }

    /**
     * Obtiene el DNI del cliente
     * @return DNI del cliente
     */
    public String getDni() {
        return dni;
    }

    /**
     * Establece el DNI del cliente
     * @param dni DNI del cliente
     */
    public void setDni(String dni) {
        this.dni = dni;
    }

    /**
     * Obtiene el nombre del cliente
     * @return Nombre del cliente
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del cliente
     * @param nombre Nombre del cliente
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Cliente_RESUELTO{" +
                "dni='" + dni + '\'' +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}



