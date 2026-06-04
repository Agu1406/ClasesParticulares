package ev3.ut7.u02basesdatos.practicas.proyectoexamenbibliotecaapi.examenapi.model;

public class Biblioteca {
    public int id;
    public String calle;
    public String localidad;
    public String provincia;

    public Biblioteca(int id, String calle, String localidad, String provincia) {
        this.id = id;
        this.calle = calle;
        this.localidad = localidad;
        this.provincia = provincia;
    }

    public String toString() {
        return "Biblioteca " + id + ": " + calle + ", " + localidad + " (" + provincia + ")";
    }
}
