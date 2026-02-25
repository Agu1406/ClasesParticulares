package andalucia.sevilla.iesvelazquez.DAM1.alquiler.fase1;

import java.util.Scanner;

public class ES {
    private static final Scanner scanner = new Scanner(System.in);

    public static int leerEntero(String mensaje, int minimo) {
        int valor;
        boolean valido = false;
        do {
            System.out.print(mensaje);
            if (scanner.hasNextInt()) {
                valor = scanner.nextInt();
                scanner.nextLine();
                if (valor >= minimo) {
                    valido = true;
                } else {
                    System.out.println("El valor debe ser mayor o igual que " + minimo);
                }
            } else {
                System.out.println("Debe introducir un numero entero");
                scanner.nextLine();
                valor = minimo;
            }
        } while (!valido);
        return valor;
    }

    public static double leerReal(String mensaje, double minimo) {
        double valor;
        boolean valido = false;
        do {
            System.out.print(mensaje);
            if (scanner.hasNextDouble()) {
                valor = scanner.nextDouble();
                scanner.nextLine();
                if (valor >= minimo) {
                    valido = true;
                } else {
                    System.out.println("El valor debe ser mayor o igual que " + minimo);
                }
            } else {
                System.out.println("Debe introducir un numero real");
                scanner.nextLine();
                valor = minimo;
            }
        } while (!valido);
        return valor;
    }

    public static String leerCadena(String mensaje) {
        System.out.print(mensaje);
        return scanner.nextLine();
    }
}

