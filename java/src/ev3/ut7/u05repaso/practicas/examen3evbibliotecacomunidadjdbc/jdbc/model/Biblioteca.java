package ev3.ut7.u05repaso.practicas.examen3evbibliotecacomunidadjdbc.jdbc.model;

/**
 * POO: fila de la tabla {@code bibliotecas}.
 */
public class Biblioteca {

    private Integer id;
    private String calle;
    private String localidad;
    private String provincia;

    public Biblioteca() {
    }

    public Biblioteca(String calle, String localidad, String provincia) {
        this.calle = calle;
        this.localidad = localidad;
        this.provincia = provincia;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    @Override
    public String toString() {
        return calle + ", " + localidad + " (" + provincia + ")";
    }
}
