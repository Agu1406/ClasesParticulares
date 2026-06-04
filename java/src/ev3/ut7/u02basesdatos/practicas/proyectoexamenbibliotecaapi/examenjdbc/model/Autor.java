package ev3.ut7.u02basesdatos.practicas.proyectoexamenbibliotecaapi.examenjdbc.model;

public record Autor(long id, String nombre, String apellido, String dni) {

    public String nombreCompleto() {
        return nombre + " " + apellido;
    }
}
