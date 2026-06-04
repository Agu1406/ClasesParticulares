package ev3.ut7.u02basesdatos.practicas.proyectoexamenbibliotecaapi.bili.model;

public class Usuario {
    private final int idUsuario;
    private final String nombre;
    private final String apellido;
    private final String pass;
    private final String perfil;

    public Usuario(int idUsuario, String nombre, String apellido, String pass, String perfil) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.pass = pass;
        this.perfil = perfil;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getPass() {
        return pass;
    }

    public String getPerfil() {
        return perfil;
    }
}
