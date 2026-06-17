package ev2.ut5_pooexcepcionesio.u05repaso.practicas.pruebaslibrescoleccion;

public class Ejercicio09_ArraysYRecursion_RESUELTO {

    public static void main(String[] args) {
        System.out.println("Suma 1..10 = " + sumaRecursiva(10));

        int[] arr = {1, 2, 3, 4};
        modificarArray(arr);
        System.out.println("arr[0]=" + arr[0] + ", arr[1]=" + arr[1]);
    }

    public static int sumaRecursiva(int n) {
        if (n == 1) {
            return 1;
        }
        return n + sumaRecursiva(n - 1);
    }

    public static void modificarArray(int[] arr) {
        arr[1] = 6;
    }
}
