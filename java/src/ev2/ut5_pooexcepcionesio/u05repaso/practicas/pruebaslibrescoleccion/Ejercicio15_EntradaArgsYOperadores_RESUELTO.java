package ev2.ut5_pooexcepcionesio.u05repaso.practicas.pruebaslibrescoleccion;

public class Ejercicio15_EntradaArgsYOperadores_RESUELTO {

    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Uso: java ... <a> <b>");
            return;
        }

        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);

        if (b != 0 && a % b == 0) {
            System.out.println("Divisible");
        } else {
            System.out.println("No divisible");
        }

        System.out.println("XOR (a ^ b): " + (a ^ b));

        int x = a++ + --a;
        System.out.println("x = " + x);
        System.out.println("a final = " + a);
    }
}
