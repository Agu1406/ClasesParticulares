package ev2.ut5_pooexcepcionesio.u05repaso.practicas.pruebaslibres2024;

public class Ejercicio02_StringsWrappers_RESUELTO {

    public static void main(String[] args) {
        System.out.println(igualdadStrings());
        System.out.println("Resultado wrappers: " + resultadoWrappers());
    }

    public static String igualdadStrings() {
        String str1 = "java";
        String str2 = new String("java");
        return "==:" + (str1 == str2) + ", equals:" + str1.equals(str2);
    }

    public static int resultadoWrappers() {
        int result = 0;
        Integer a = Integer.valueOf(100);
        Integer b = Integer.valueOf("100");
        Integer c = Integer.valueOf("100");
        Integer d = 100;
        if (a == b) {
            result = 1;
        }
        if (a.equals(b)) {
            result += 10;
        }
        if (a == c) {
            result += 100;
        }
        if (a.equals(d)) {
            result += 1000;
        }
        if (b.equals(c)) {
            result += 10000;
        }
        return result;
    }
}

