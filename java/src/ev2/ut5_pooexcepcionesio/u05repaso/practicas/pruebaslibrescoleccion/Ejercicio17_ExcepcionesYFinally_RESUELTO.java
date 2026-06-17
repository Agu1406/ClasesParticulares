package ev2.ut5_pooexcepcionesio.u05repaso.practicas.pruebaslibrescoleccion;

public class Ejercicio17_ExcepcionesYFinally_RESUELTO {

    public static void main(String[] args) {
        try {
            System.out.println("convertirEntero('abc') = " + convertirEntero("abc"));
            System.out.println("X");
        } catch (NumberFormatException ex) {
            System.out.println("NumberFormatException capturada");
        } finally {
            System.out.println("finally 1 ejecutado");
        }

        try {
            System.out.println(accesoArray(3));
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println("ArrayIndexOutOfBoundsException capturada");
        } finally {
            System.out.println("finally 2 ejecutado");
        }
    }

    static int convertirEntero(String texto) {
        return Integer.parseInt(texto);
    }

    static String accesoArray(int tam) {
        String[] valores = new String[tam];
        valores[3] = "OK";
        return valores[3];
    }
}
