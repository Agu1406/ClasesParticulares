package pruebaslibres.practica.ruta_real_232425.resueltos;

public class EjercicioRR01_FundamentosYControl_RESUELTO {

    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Uso: java ... <a> <b>");
            return;
        }

        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
        if (b == 0) {
            System.out.println("No se puede dividir entre cero.");
            return;
        }

        int cociente = a / b;
        System.out.println("Cociente -> " + cociente);
        System.out.println(a % b == 0 ? "Divisible" : "No divisible");

        int x = 2;
        String letra = "";
        switch (x) {
            case 1:
                letra += "A";
                break;
            case 2:
                letra += "B";
            case 3:
                letra += "C";
                break;
            default:
                letra += "D";
        }
        System.out.println("switch -> " + letra);

        int i = 0;
        do {
            i++;
        } while (i < 0);
        System.out.println("do-while -> " + i);
    }
}
