package pruebaslibres.practica.coleccion.resueltos;

public class Ejercicio19_ArraysRecursionYWrappers_RESUELTO {

    public static void main(String[] args) {
        System.out.println("compararWrappers = " + compararWrappers());
        System.out.println("factorial(5) = " + factorialRecursivo(5));

        try {
            String[] frutas = { "Apple", "Banana", "Orange" };
            System.out.println(mostrarCuartoElemento(frutas));
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println("ArrayIndexOutOfBoundsException capturada");
        }
    }

    static int compararWrappers() {
        Integer a = Integer.valueOf(1000);
        Integer b = Integer.valueOf("1000");
        int resultado = 0;
        if (a.equals(b)) {
            resultado += 10;
        }
        if (a == b) {
            resultado += 100;
        }
        return resultado;
    }

    static int factorialRecursivo(int n) {
        if (n <= 1) {
            return 1;
        }
        return n * factorialRecursivo(n - 1);
    }

    static String mostrarCuartoElemento(String[] datos) {
        return datos[3];
    }
}
