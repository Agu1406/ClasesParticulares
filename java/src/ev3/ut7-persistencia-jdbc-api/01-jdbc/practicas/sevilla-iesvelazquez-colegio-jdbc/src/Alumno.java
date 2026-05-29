package andalucia.sevilla.iesvelazquez.colegiojdbc.src;

/**
 * POJO que representa un alumno (id, nombre, correo, telefono).
 * {@code idAlumno} puede ser null antes del INSERT (AUTO_INCREMENT en MySQL).
 *
 * @author Agustín. A. Marquez. Piña
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


