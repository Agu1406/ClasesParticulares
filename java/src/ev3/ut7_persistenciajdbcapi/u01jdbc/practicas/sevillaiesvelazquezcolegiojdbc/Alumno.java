package ev3.ut7_persistenciajdbcapi.u01jdbc.practicas.sevillaiesvelazquezcolegiojdbc;

/**
 * Modelo de dominio: un alumno del colegio.
 *
 * <p><b>Objetivo:</b> representar en memoria los datos que se guardan en la tabla {@code Alumnos}
 * sin depender de la API JDBC en la capa de presentacion o de negocio.</p>
 *
 * <p>Debe almacenar identificador, nombre, correo y telefono; el id puede ser {@code null}
 * antes del INSERT (clave autoincremental en MySQL).</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 29/05/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Alumno {
    private Integer idAlumno; // puede ser null antes de insertar (AUTO_INCREMENT)
    private String nombre;
    private String correo;
    private String telefono;

    public Alumno() {}

    public Alumno(Integer idAlumno, String nombre, String correo, String telefono) {
        this.idAlumno = idAlumno;
        this.nombre = nombre;
        this.correo = correo;
        this.telefono = telefono;
    }

    public Integer getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(Integer idAlumno) {
        this.idAlumno = idAlumno;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Alumno{" +
                "idAlumno=" + idAlumno +
                ", nombre='" + nombre + '\'' +
                ", correo='" + correo + '\'' +
                ", telefono='" + telefono + '\'' +
                '}';
    }
}


