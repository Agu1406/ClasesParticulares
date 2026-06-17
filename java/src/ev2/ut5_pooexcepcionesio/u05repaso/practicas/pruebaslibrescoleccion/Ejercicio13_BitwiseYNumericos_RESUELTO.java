package ev2.ut5_pooexcepcionesio.u05repaso.practicas.pruebaslibrescoleccion;

public class Ejercicio13_BitwiseYNumericos_RESUELTO {

    public static void main(String[] args) {
        System.out.println("2 | 1 = " + orBinario());
        System.out.println("5 ^ 3 = " + xorBinario());
        System.out.println("100 >> 4 = " + shiftDerecha());
    }

    public static int orBinario() {
        return 2 | 1;
    }

    public static int xorBinario() {
        return 5 ^ 3;
    }

    public static int shiftDerecha() {
        return 100 >> 4;
    }
}
