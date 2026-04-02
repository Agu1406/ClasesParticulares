package pruebaslibres.practica.coleccion.resueltos;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Ejercicio14_SerializacionYStreams_RESUELTO {

    public static void main(String[] args) {
        String ruta = "alumno_simple.obj";
        AlumnoSimpleR original = new AlumnoSimpleR("Ana", 3);
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ruta));
            oos.writeObject(original);
            oos.close();

            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ruta));
            AlumnoSimpleR copia = (AlumnoSimpleR) ois.readObject();
            ois.close();

            System.out.println("Nombre: " + copia.nombre);
            System.out.println("Intentos (transient): " + copia.intentos);
        } catch (Exception ex) {
            System.out.println("Error serializacion: " + ex.getMessage());
        }
    }
}

class AlumnoSimpleR implements Serializable {
    private static final long serialVersionUID = 1L;
    String nombre;
    transient int intentos;

    AlumnoSimpleR(String nombre, int intentos) {
        this.nombre = nombre;
        this.intentos = intentos;
    }
}
