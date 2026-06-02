package pruebaslibres.practica.ruta_real_232425.resueltos;

public class EjercicioRR03_ExcepcionesYArrays_RESUELTO {

    public static void main(String[] args) {
        try {
            int x = Integer.parseInt("abc");
            System.out.println(x);
        } catch (NumberFormatException ex) {
            System.out.println("NumberFormatException capturada");
        } finally {
            System.out.println("finally conversion");
        }

        try {
            String[] datos = { "A", "B", "C" };
            System.out.println(datos[3]);
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println("ArrayIndexOutOfBoundsException capturada");
        } finally {
            System.out.println("finally array");
        }
    }
}
