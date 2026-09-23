package ev3.ut6_pooavanzadaestructuras.u01herenciapolimorfismo.practicas.madridcesjuanpablosegundoalumnos;

import java.util.Scanner;

public class Entrada_RESUELTO {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Colegio_RESUELTO colegio = new Colegio_RESUELTO();
        int opcion = 0;
        int nextId = 1;
        do {
            System.out.println("1. Matricular alumno");
            System.out.println("2. Listar alumnos");
            System.out.println("3. Listar matriculados");
            System.out.println("4. Mostrar por id");
            System.out.println("5. Desmatricular");
            System.out.println("6. Calificar");
            System.out.println("7. Salir");
            System.out.println("Introduce la opcion");
            opcion = Integer.parseInt(sc.nextLine());
            switch (opcion) {
                case 1: {
                    System.out.println("Nombre");
                    String nombre = sc.nextLine();
                    System.out.println("Apellido");
                    String apellido = sc.nextLine();
                    System.out.println("Telefono (enter si no tiene)");
                    String telefonoRaw = sc.nextLine();
                    String telefono = telefonoRaw.isBlank() ? null : telefonoRaw;
                    System.out.println("Correo (enter si no tiene)");
                    String correoRaw = sc.nextLine();
                    String correo = correoRaw.isBlank() ? null : correoRaw;
                    colegio.matricular(new Alumno_RESUELTO(nextId, nombre, apellido, telefono, correo));
                    nextId++;
                    break;
                }
                case 2: colegio.listarAlumnos(); break;
                case 3: colegio.listarMatriculados(); break;
                case 4:
                    System.out.println("Id");
                    colegio.mostrarPorId(Integer.parseInt(sc.nextLine()));
                    break;
                case 5:
                    System.out.println("Id");
                    colegio.desmatricular(Integer.parseInt(sc.nextLine()));
                    break;
                case 6: {
                    System.out.println("Id");
                    int id = Integer.parseInt(sc.nextLine());
                    System.out.println("Nota");
                    double nota = Double.parseDouble(sc.nextLine());
                    colegio.calificar(id, nota);
                    break;
                }
                case 7: System.out.println("Saliendo"); break;
                default: System.out.println("Opcion no valida");
            }
        } while (opcion != 7);
        sc.close();
    }
}
