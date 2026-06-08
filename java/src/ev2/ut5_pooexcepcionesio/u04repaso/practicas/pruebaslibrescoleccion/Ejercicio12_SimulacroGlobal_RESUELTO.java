package ev2.ut5_pooexcepcionesio.u04repaso.practicas.pruebaslibrescoleccion;

import java.util.HashSet;
import java.util.Set;

public class Ejercicio12_SimulacroGlobal_RESUELTO {

    public static void main(String[] args) {
        int x = 2;
        int y = 2;
        int z = x++ + y;
        System.out.println("x++ + y = " + z);

        Set<String> set = new HashSet<>();
        set.add("JAVA");
        set.add("JAVA");
        set.add("SQL");
        System.out.println("Set sin duplicados: " + set);

        try {
            throw new IllegalArgumentException("error controlado");
        } catch (IllegalArgumentException e) {
            System.out.println("Capturada: " + e.getMessage());
        } finally {
            System.out.println("Finally siempre ejecuta");
        }

        Integer a = 100;
        Integer b = Integer.valueOf("100");
        Integer c = Integer.valueOf(100);
        String s1 = "java";
        String s2 = new String("java");
        System.out.println("a==b: " + (a == b));
        System.out.println("a==c: " + (a == c));
        System.out.println("a.equals(c): " + a.equals(c));
        System.out.println("s1==s2: " + (s1 == s2));
        System.out.println("s1.equals(s2): " + s1.equals(s2));
    }
}
