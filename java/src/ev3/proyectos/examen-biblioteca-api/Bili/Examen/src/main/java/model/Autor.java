package model;

public class Autor {
    public int ID;
    public String nombre;
    public String apellido;
    public String dni;

    public Autor(int ID, String nombre, String apellido, String dni) {
        this.ID = ID;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String toString() {
        return "Autor: " + nombre + " " + apellido + " (DNI: " + dni + ")";
    }
}
