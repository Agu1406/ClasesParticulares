package ev3.ut6_pooavanzadaestructuras.u01herenciapolimorfismo.practicas.madridcesjuanpablosegundotrabajadores;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

abstract class TrabajadorR {
    String nombre, apellido, dni; double sueldo;
    TrabajadorR(String nombre, String apellido, String dni, double sueldo) {
        this.nombre = nombre; this.apellido = apellido; this.dni = dni; this.sueldo = sueldo;
    }
    abstract double calcularSalarioMensual();
    void mostrarDatos() {
        System.out.println("nombre = " + nombre); System.out.println("apellido = " + apellido);
        System.out.println("dni = " + dni); System.out.println("sueldo = " + sueldo);
        System.out.println("salario mensual = " + calcularSalarioMensual());
    }
}
class AsalariadoR extends TrabajadorR {
    int numeroPagas; boolean contratado; double cuotaSS;
    AsalariadoR(String n, String a, String d, double s, int p, boolean c, double q) {
        super(n, a, d, s); numeroPagas = p; contratado = c; cuotaSS = q;
    }
    double calcularSalarioMensual() { return (sueldo * 0.79) / numeroPagas; }
    void mostrarDatos() { System.out.println("Tipo = Asalariado"); super.mostrarDatos(); }
}
class AutonomoR extends TrabajadorR {
    boolean contratado; double cuotaSS;
    AutonomoR(String n, String a, String d, double s, boolean c, double q) {
        super(n, a, d, s); contratado = c; cuotaSS = q;
    }
    double calcularSalarioMensual() { return (sueldo - 12 * cuotaSS) / 12; }
    void mostrarDatos() { System.out.println("Tipo = Autonomo"); super.mostrarDatos(); }
}
class JefeR extends TrabajadorR {
    int acciones; double beneficio;
    JefeR(String n, String a, String d, double s, int ac, double b) {
        super(n, a, d, s); acciones = ac; beneficio = b;
    }
    double calcularSalarioMensual() { return sueldo / 12; }
    void mostrarDatos() { System.out.println("Tipo = Jefe"); super.mostrarDatos(); }
}
public class TrabajadoresApp_RESUELTO {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<TrabajadorR> lista = new ArrayList<>();
        int op;
        do {
            System.out.println("1 Asalariado 2 Autonomo 3 Jefe 4 Listar 5 PorDNI 6 Despedir 7 Salir");
            op = Integer.parseInt(sc.nextLine());
            switch (op) {
                case 1 -> {
                    System.out.println("nombre"); String n = sc.nextLine();
                    System.out.println("apellido"); String a = sc.nextLine();
                    System.out.println("dni"); String d = sc.nextLine();
                    System.out.println("sueldo"); double s = Double.parseDouble(sc.nextLine());
                    System.out.println("pagas"); int p = Integer.parseInt(sc.nextLine());
                    System.out.println("cuota"); double q = Double.parseDouble(sc.nextLine());
                    lista.add(new AsalariadoR(n, a, d, s, p, true, q));
                }
                case 2 -> {
                    System.out.println("nombre"); String n = sc.nextLine();
                    System.out.println("apellido"); String a = sc.nextLine();
                    System.out.println("dni"); String d = sc.nextLine();
                    System.out.println("sueldo"); double s = Double.parseDouble(sc.nextLine());
                    System.out.println("cuota"); double q = Double.parseDouble(sc.nextLine());
                    lista.add(new AutonomoR(n, a, d, s, true, q));
                }
                case 3 -> {
                    System.out.println("nombre"); String n = sc.nextLine();
                    System.out.println("apellido"); String a = sc.nextLine();
                    System.out.println("dni"); String d = sc.nextLine();
                    System.out.println("sueldo"); double s = Double.parseDouble(sc.nextLine());
                    System.out.println("acciones"); int ac = Integer.parseInt(sc.nextLine());
                    System.out.println("beneficio"); double b = Double.parseDouble(sc.nextLine());
                    lista.add(new JefeR(n, a, d, s, ac, b));
                }
                case 4 -> { for (TrabajadorR t : lista) t.mostrarDatos(); }
                case 5 -> {
                    System.out.println("DNI"); String dni = sc.nextLine();
                    for (TrabajadorR t : lista) if (t.dni.equalsIgnoreCase(dni)) t.mostrarDatos();
                }
                case 6 -> {
                    System.out.println("DNI jefe"); String dj = sc.nextLine();
                    System.out.println("DNI trabajador"); String dt = sc.nextLine();
                    boolean jefeOk = false;
                    for (TrabajadorR t : lista) if (t.dni.equalsIgnoreCase(dj) && t instanceof JefeR) jefeOk = true;
                    if (!jefeOk) { System.out.println("El DNI del jefe no es correcto"); break; }
                    Iterator<TrabajadorR> it = lista.iterator();
                    while (it.hasNext()) {
                        TrabajadorR t = it.next();
                        if (t.dni.equalsIgnoreCase(dt) && !(t instanceof JefeR)) {
                            it.remove();
                            System.out.println("Trabajador despedido");
                        }
                    }
                }
                case 7 -> System.out.println("Saliendo");
                default -> System.out.println("Opcion no valida");
            }
        } while (op != 7);
    }
}
