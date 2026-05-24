package model;

public class Autor {
    public int id;
    public String nombre;
    public String apellido;
    public String dni;

    public Autor(int id, String nombre, String apellido, String dni) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
    }

    public String toString() {
        return "Autor: " + nombre + " " + apellido + " (DNI: " + dni + ")";
    }
}
