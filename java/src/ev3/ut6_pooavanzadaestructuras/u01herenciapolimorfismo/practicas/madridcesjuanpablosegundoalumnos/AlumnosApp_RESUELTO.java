package ev3.ut6_pooavanzadaestructuras.u01herenciapolimorfismo.practicas.madridcesjuanpablosegundoalumnos;

import java.util.ArrayList;
import java.util.Scanner;

class AlumnoR {
    int id; String nombre, apellido, telefono, correo;
    double calificacion; boolean matriculado = true;
    AlumnoR(int id, String nombre, String apellido, String telefono, String correo) {
        this.id = id; this.nombre = nombre; this.apellido = apellido;
        this.telefono = telefono; this.correo = correo;
    }
    void mostrarDatos() {
        System.out.println("id = " + id);
        System.out.println("nombre = " + nombre);
        System.out.println("apellido = " + apellido);
        System.out.println("telefono = " + (telefono == null ? "dato no disponible" : telefono));
        System.out.println("correo = " + (correo == null ? "dato no disponible" : correo));
        System.out.println("calificacion = " + calificacion);
        System.out.println("matriculado = " + matriculado);
    }
    void desmatricular() { matriculado = false; }
    void calificar(double n) { calificacion = n; }
}
public class AlumnosApp_RESUELTO {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<AlumnoR> alumnos = new ArrayList<>();
        int nextId = 1, op;
        do {
            System.out.println("1 Matricular 2 Listar 3 Mostrar 4 Desmatricular 5 Calificar 6 Salir");
            op = Integer.parseInt(sc.nextLine());
            switch (op) {
                case 1 -> {
                    System.out.println("Nombre"); String n = sc.nextLine();
                    System.out.println("Apellido"); String a = sc.nextLine();
                    System.out.println("Telefono (vacio=null)"); String t = sc.nextLine(); if (t.isBlank()) t = null;
                    System.out.println("Correo (vacio=null)"); String c = sc.nextLine(); if (c.isBlank()) c = null;
                    AlumnoR al = new AlumnoR(nextId++, n, a, t, c);
                    alumnos.add(al); al.mostrarDatos();
                }
                case 2 -> { for (AlumnoR al : alumnos) al.mostrarDatos(); }
                case 3 -> {
                    System.out.println("Id"); int id = Integer.parseInt(sc.nextLine());
                    for (AlumnoR al : alumnos) if (al.id == id) al.mostrarDatos();
                }
                case 4 -> {
                    System.out.println("Id"); int id = Integer.parseInt(sc.nextLine());
                    for (AlumnoR al : alumnos) if (al.id == id) al.desmatricular();
                }
                case 5 -> {
                    System.out.println("Id"); int id = Integer.parseInt(sc.nextLine());
                    System.out.println("Nota"); double nota = Double.parseDouble(sc.nextLine());
                    for (AlumnoR al : alumnos) if (al.id == id) al.calificar(nota);
                }
                case 6 -> System.out.println("Saliendo");
                default -> System.out.println("Opcion no valida");
            }
        } while (op != 6);
    }
}
