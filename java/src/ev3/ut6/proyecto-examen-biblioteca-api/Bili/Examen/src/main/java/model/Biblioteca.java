package model;

public class Biblioteca {
    public int ID;
    public String calle;
    public String localidad;
    public String provincia;

    public Biblioteca(int ID, String calle, String localidad, String provincia) {
        this.ID = ID;
        this.calle = calle;
        this.localidad = localidad;
        this.provincia = provincia;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String toString() {
        return "Biblioteca " + ID + ": " + calle + ", " + localidad + " (" + provincia + ")";
    }
}
