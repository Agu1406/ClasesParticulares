package ev3.ut7.u02basesdatos.practicas.proyectoexamenbibliotecaapi.examenjdbc.model;

public record Biblioteca(long id, String calle, String localidad, String provincia) {

    @Override
    public String toString() {
        return calle + ", " + localidad + " (" + provincia + ")";
    }
}
