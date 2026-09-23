package ev3.ut6_pooavanzadaestructuras.u01herenciapolimorfismo.practicas.madridcesjuanpablosegundotrabajadores;

import java.util.Scanner;

public class Entrada_RESUELTO {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Empresa_RESUELTO empresa = new Empresa_RESUELTO();
        int opcion = 0;
        do {
            System.out.println("1. Registrar asalariado");
            System.out.println("2. Registrar autonomo");
            System.out.println("3. Registrar jefe");
            System.out.println("4. Listar todos");
            System.out.println("5. Listar asalariados");
            System.out.println("6. Listar autonomos");
            System.out.println("7. Mostrar por DNI");
            System.out.println("8. Despedir trabajador");
            System.out.println("9. Salir");
            System.out.println("Introduce la opcion");
            opcion = Integer.parseInt(sc.nextLine());
            switch (opcion) {
                case 1: {
                    System.out.println("Nombre");
                    String nombre = sc.nextLine();
                    System.out.println("Apellido");
                    String apellido = sc.nextLine();
                    System.out.println("DNI");
                    String dni = sc.nextLine();
                    System.out.println("Sueldo");
                    double sueldo = Double.parseDouble(sc.nextLine());
                    System.out.println("Numero de pagas");
                    int pagas = Integer.parseInt(sc.nextLine());
                    System.out.println("Cuota SS");
                    double cuota = Double.parseDouble(sc.nextLine());
                    empresa.registrarTrabajador(new Asalariado_RESUELTO(nombre, apellido, dni, sueldo, pagas, true, cuota));
                    break;
                }
                case 2: {
                    System.out.println("Nombre");
                    String nombre = sc.nextLine();
                    System.out.println("Apellido");
                    String apellido = sc.nextLine();
                    System.out.println("DNI");
                    String dni = sc.nextLine();
                    System.out.println("Sueldo");
                    double sueldo = Double.parseDouble(sc.nextLine());
                    System.out.println("Cuota SS");
                    double cuota = Double.parseDouble(sc.nextLine());
                    empresa.registrarTrabajador(new Autonomo_RESUELTO(nombre, apellido, dni, sueldo, true, cuota));
                    break;
                }
                case 3: {
                    System.out.println("Nombre");
                    String nombre = sc.nextLine();
                    System.out.println("Apellido");
                    String apellido = sc.nextLine();
                    System.out.println("DNI");
                    String dni = sc.nextLine();
                    System.out.println("Sueldo");
                    double sueldo = Double.parseDouble(sc.nextLine());
                    System.out.println("Acciones");
                    int acciones = Integer.parseInt(sc.nextLine());
                    System.out.println("Beneficio");
                    double beneficio = Double.parseDouble(sc.nextLine());
                    empresa.registrarTrabajador(new Jefe_RESUELTO(nombre, apellido, dni, sueldo, acciones, beneficio));
                    break;
                }
                case 4: empresa.listarTodos(); break;
                case 5: empresa.listarAsalariados(); break;
                case 6: empresa.listarAutonomos(); break;
                case 7:
                    System.out.println("DNI");
                    empresa.mostrarPorDni(sc.nextLine());
                    break;
                case 8: {
                    System.out.println("DNI del jefe");
                    String dniJefe = sc.nextLine();
                    System.out.println("DNI del trabajador a despedir");
                    String dniTrabajador = sc.nextLine();
                    empresa.despedirTrabajador(dniJefe, dniTrabajador);
                    break;
                }
                case 9: System.out.println("Saliendo"); break;
                default: System.out.println("Opcion no valida");
            }
        } while (opcion != 9);
        sc.close();
    }
}
