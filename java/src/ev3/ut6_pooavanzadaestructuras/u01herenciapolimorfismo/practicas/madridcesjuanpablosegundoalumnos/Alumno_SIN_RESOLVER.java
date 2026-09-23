package ev3.ut6_pooavanzadaestructuras.u01herenciapolimorfismo.practicas.madridcesjuanpablosegundoalumnos;

public class Alumno_SIN_RESOLVER {
    private final int id;
    private String nombre;
    private String apellido;
    private String telefono;
    private String correo;
    private double calificacion = 0;
    private boolean matriculado = true;

    public Alumno_SIN_RESOLVER(int id, String nombre, String apellido) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public Alumno_SIN_RESOLVER(int id, String nombre, String apellido, String telefono, String correo) {
        this(id, nombre, apellido);
        this.telefono = telefono;
        this.correo = correo;
    }

    public void mostrarDatos() { /* TODO: "dato no disponible" si falta telefono/correo */ }
    public void desmatricular() { /* TODO */ }
    public void calificar(double nota) { /* TODO */ }
    public int getId() { return id; }
    public boolean isMatriculado() { return matriculado; }
}
