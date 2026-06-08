package ev2.ut5_pooexcepcionesio.u04repaso.practicas.pruebaslibrescoleccion;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Ejercicio07_InterfacesYComparacion_RESUELTO {

    public static void main(String[] args) {
        List<AlumnoComparableResuelto> alumnos = new ArrayList<>();
        alumnos.add(new AlumnoComparableResuelto("Maria", 7));
        alumnos.add(new AlumnoComparableResuelto("Pedro", 9));
        alumnos.add(new AlumnoComparableResuelto("Ana", 8));

        alumnos.sort(null);
        System.out.println("Orden por nota:");
        for (AlumnoComparableResuelto a : alumnos) {
            a.imprimir();
        }

        AlumnoComparableResuelto.ordenarPorNombre(alumnos);
        System.out.println("Orden por nombre:");
        for (AlumnoComparableResuelto a : alumnos) {
            a.imprimir();
        }
    }
}

interface ImprimibleResuelto {
    void imprimir();
}

class AlumnoComparableResuelto implements ImprimibleResuelto, Comparable<AlumnoComparableResuelto> {
    private String nombre;
    private int nota;

    public AlumnoComparableResuelto(String nombre, int nota) {
        this.nombre = nombre;
        this.nota = nota;
    }

    @Override
    public void imprimir() {
        System.out.println(nombre + " -> " + nota);
    }

    @Override
    public int compareTo(AlumnoComparableResuelto otro) {
        return Integer.compare(this.nota, otro.nota);
    }

    public static void ordenarPorNombre(List<AlumnoComparableResuelto> lista) {
        lista.sort(Comparator.comparing(a -> a.nombre));
    }
}
