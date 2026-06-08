package ev1.ut2_controlflujometodos.u05repaso.practicas.pruebaslibres2023;

import java.util.HashSet;
import java.util.Set;

public class Ejercicio03_ExcepcionesYColecciones_RESUELTO {

    public static void main(String[] args) {
        System.out.println("Tamano set = " + tamanoSet());
        System.out.println("Try/catch/finally => " + salidaTryCatchFinally());
    }

    public static int tamanoSet() {
        Set<String> datos = new HashSet<>();
        datos.add("JAVA");
        datos.add("SQL");
        datos.add("JAVA");
        return datos.size();
    }

    public static String salidaTryCatchFinally() {
        StringBuilder sb = new StringBuilder();
        try {
            int[] a = new int[0];
            sb.append(a[1]);
        } catch (Exception ex) {
            sb.append("CATCH");
        } finally {
            sb.append("-FINALLY");
        }
        return sb.toString();
    }
}
