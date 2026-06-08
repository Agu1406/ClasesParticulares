package ev2.ut5_pooexcepcionesio.u04repaso.practicas.pruebaslibrescoleccion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Ejercicio 07 - Interfaces, Comparable y Comparator.
 */
public class Ejercicio07_InterfacesYComparacion_SIN_RESOLVER {

    public static void main(String[] args) {
        // TODO: Crear una lista de Alumno y ordenarla por nota y por nombre.
    }
}

interface Imprimible {
    void imprimir();
}

class AlumnoComparable implements Imprimible, Comparable<AlumnoComparable> {
    private String nombre;
    private int nota;

    public AlumnoComparable(String nombre, int nota) {
        this.nombre = nombre;
        this.nota = nota;
    }

    public String getNombre() {
        return nombre;
    }

    public int getNota() {
        return nota;
    }

    @Override
    public void imprimir() {
        // TODO: imprimir nombre y nota.
    }

    @Override
    public int compareTo(AlumnoComparable otro) {
        // TODO: ordenar por nota ascendente.
        return 0;
    }

    public static void ordenarPorNombre(List<AlumnoComparable> lista) {
        // TODO: usar Comparator para ordenar por nombre ascendente.
    }
}
