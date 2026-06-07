package ev3.ut7.u05repaso.practicas.examen3evbibliotecacomunidadjdbc.jdbc.model;

/**
 * POO: fila de la tabla {@code autores}.
 */
public class Autor {

    private Integer id;
    private String nombre;
    private String apellido;
    private String dni;

    public Autor() {
    }

    public Autor(String nombre, String apellido, String dni) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombreCompleto() {
        return nombre + " " + apellido;
    }

    @Override
    public String toString() {
        return getNombreCompleto() + " (DNI " + dni + ")";
    }
}
