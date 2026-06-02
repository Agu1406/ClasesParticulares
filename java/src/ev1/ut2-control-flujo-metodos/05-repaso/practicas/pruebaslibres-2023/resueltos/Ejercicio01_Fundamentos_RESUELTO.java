package pruebaslibres.practica.y2023.resueltos;

public class Ejercicio01_Fundamentos_RESUELTO {

    public static void main(String[] args) {
        System.out.println("Do-while => " + salidaDoWhile());
        System.out.println("Traza incremento => " + trazaIncremento());
        System.out.println("Error indice => " + hayErrorIndice());
    }

    public static int salidaDoWhile() {
        int i = 0;
        do {
            i++;
        } while (i < 0);
        return i;
    }

    public static String trazaIncremento() {
        int i, j;
        i = j = 3 % 1;
        int n = 7 * ++i;
        return i + " " + j + " " + n;
    }

    public static boolean hayErrorIndice() {
        int[] a = new int[0];
        try {
            int x = a[0];
            return x == -1;
        } catch (ArrayIndexOutOfBoundsException ex) {
            return true;
        }
    }
}
