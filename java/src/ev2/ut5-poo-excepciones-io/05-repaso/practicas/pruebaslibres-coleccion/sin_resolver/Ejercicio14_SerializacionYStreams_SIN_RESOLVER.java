package pruebaslibres.practica.coleccion.sin_resolver;

import java.io.Serializable;

public class Ejercicio14_SerializacionYStreams_SIN_RESOLVER {

    public static void main(String[] args) {
        // TODO: serializar y deserializar un objeto AlumnoSimple.
    }
}

class AlumnoSimple implements Serializable {
    private static final long serialVersionUID = 1L;
    String nombre;
    transient int intentos;

    AlumnoSimple(String nombre, int intentos) {
        this.nombre = nombre;
        this.intentos = intentos;
    }
}
