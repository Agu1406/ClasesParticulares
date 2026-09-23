package ev3.ut6_pooavanzadaestructuras.u01herenciapolimorfismo.practicas.madridcesjuanpablosegundocentralita;

import java.util.Scanner;

public class Entrada_RESUELTO {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Centralita_RESUELTO centralita = new Centralita_RESUELTO();
        int opcion;
        do {
            System.out.println("1. Local  2. Provincial  3. Nacional  4. Mostrar  5. Costes  6. Salir");
            opcion = Integer.parseInt(sc.nextLine());
            switch (opcion) {
                case 1 -> {
                    System.out.println("Origen"); String o = sc.nextLine();
                    System.out.println("Destino"); String d = sc.nextLine();
                    System.out.println("Duracion"); int dur = Integer.parseInt(sc.nextLine());
                    centralita.registrarLlamada(new LlamadaLocal_RESUELTO(o, d, dur));
                }
                case 2 -> {
                    System.out.println("Origen"); String o = sc.nextLine();
                    System.out.println("Destino"); String d = sc.nextLine();
                    System.out.println("Duracion"); int dur = Integer.parseInt(sc.nextLine());
                    centralita.registrarLlamada(new LlamadaProvincial_RESUELTO(o, d, dur));
                }
                case 3 -> {
                    System.out.println("Origen"); String o = sc.nextLine();
                    System.out.println("Destino"); String d = sc.nextLine();
                    System.out.println("Duracion"); int dur = Integer.parseInt(sc.nextLine());
                    System.out.println("Franja"); int fr = Integer.parseInt(sc.nextLine());
                    centralita.registrarLlamada(new LlamadaNacional_RESUELTO(o, d, dur, fr));
                }
                case 4 -> centralita.mostrarLlamadas();
                case 5 -> centralita.mostrarCostesTotales();
                case 6 -> System.out.println("Saliendo");
                default -> System.out.println("Opcion no valida");
            }
        } while (opcion != 6);
    }
}
