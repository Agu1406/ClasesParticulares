package ev3.ut6_pooavanzadaestructuras.u01herenciapolimorfismo.practicas.madridcesjuanpablosegundoalumnos;

public class Alumno_RESUELTO {
    private final int id;
    private String nombre;
    private String apellido;
    private String telefono;
    private String correo;
    private double calificacion = 0;
    private boolean matriculado = true;

    public Alumno_RESUELTO(int id, String nombre, String apellido) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public Alumno_RESUELTO(int id, String nombre, String apellido, String telefono, String correo) {
        this(id, nombre, apellido);
        this.telefono = telefono;
        this.correo = correo;
    }

    public void mostrarDatos() {
        System.out.println("id = " + id);
        System.out.println("nombre = " + nombre);
        System.out.println("apellido = " + apellido);
        System.out.println("telefono = " + (telefono == null || telefono.isBlank() ? "dato no disponible" : telefono));
        System.out.println("correo = " + (correo == null || correo.isBlank() ? "dato no disponible" : correo));
        System.out.println("calificacion = " + calificacion);
        System.out.println("matriculado = " + matriculado);
    }

    public void desmatricular() {
        matriculado = false;
        System.out.println("Alumno desmatriculado");
    }

    public void calificar(double nota) {
        calificacion = nota;
        System.out.println("Alumno calificado con " + nota);
    }

    public int getId() { return id; }
    public boolean isMatriculado() { return matriculado; }
}
