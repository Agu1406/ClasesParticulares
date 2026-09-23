package ev3.ut6_pooavanzadaestructuras.u01herenciapolimorfismo.practicas.madridcesjuanpablosegundofiguras;

import java.util.Scanner;

public class Entrada_RESUELTO {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GestorFiguras_RESUELTO gestor = new GestorFiguras_RESUELTO();
        int opcion = 0;
        do {
            System.out.println("1. Registrar circulo");
            System.out.println("2. Registrar rectangulo");
            System.out.println("3. Registrar triangulo");
            System.out.println("4. Listar figuras");
            System.out.println("5. Area total");
            System.out.println("6. Salir");
            System.out.println("Introduce la opcion");
            opcion = Integer.parseInt(sc.nextLine());
            switch (opcion) {
                case 1:
                    System.out.println("Radio");
                    gestor.registrarFigura(new Circulo_RESUELTO(Double.parseDouble(sc.nextLine())));
                    break;
                case 2: {
                    System.out.println("Base");
                    double base = Double.parseDouble(sc.nextLine());
                    System.out.println("Altura");
                    double altura = Double.parseDouble(sc.nextLine());
                    gestor.registrarFigura(new Rectangulo_RESUELTO(base, altura));
                    break;
                }
                case 3: {
                    System.out.println("Base");
                    double base = Double.parseDouble(sc.nextLine());
                    System.out.println("Altura");
                    double altura = Double.parseDouble(sc.nextLine());
                    gestor.registrarFigura(new Triangulo_RESUELTO(base, altura));
                    break;
                }
                case 4:
                    gestor.listarFiguras();
                    break;
                case 5:
                    System.out.println("Area total = " + gestor.areaTotal());
                    break;
                case 6:
                    System.out.println("Saliendo");
                    break;
                default:
                    System.out.println("Opcion no valida");
            }
        } while (opcion != 6);
        sc.close();
    }
}
