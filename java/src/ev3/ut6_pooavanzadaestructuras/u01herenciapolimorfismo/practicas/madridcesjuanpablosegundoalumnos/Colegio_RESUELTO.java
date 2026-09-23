package ev3.ut6_pooavanzadaestructuras.u01herenciapolimorfismo.practicas.madridcesjuanpablosegundoalumnos;

import java.util.ArrayList;

public class Colegio_RESUELTO {
    private ArrayList<Alumno_RESUELTO> alumnos = new ArrayList<>();

    public void matricular(Alumno_RESUELTO alumno) {
        for (Alumno_RESUELTO a : alumnos) {
            if (a.getId() == alumno.getId()) {
                System.out.println("Ya existe un alumno con ese id");
                return;
            }
        }
        alumnos.add(alumno);
        System.out.println("Alumno matriculado");
        alumno.mostrarDatos();
    }

    public void listarAlumnos() {
        if (alumnos.isEmpty()) {
            System.out.println("No hay alumnos");
            return;
        }
        for (Alumno_RESUELTO a : alumnos) {
            a.mostrarDatos();
        }
    }

    public void listarMatriculados() {
        for (Alumno_RESUELTO a : alumnos) {
            if (a.isMatriculado()) {
                a.mostrarDatos();
            }
        }
    }

    public void mostrarPorId(int id) {
        for (Alumno_RESUELTO a : alumnos) {
            if (a.getId() == id) {
                a.mostrarDatos();
                return;
            }
        }
        System.out.println("No se ha encontrado el alumno");
    }

    public void desmatricular(int id) {
        for (Alumno_RESUELTO a : alumnos) {
            if (a.getId() == id) {
                a.desmatricular();
                return;
            }
        }
        System.out.println("No se ha encontrado el alumno");
    }

    public void calificar(int id, double nota) {
        for (Alumno_RESUELTO a : alumnos) {
            if (a.getId() == id) {
                a.calificar(nota);
                return;
            }
        }
        System.out.println("No se ha encontrado el alumno");
    }
}
